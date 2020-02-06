package com.software.ddk.coloredfire.common.block;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.dimension.TheEndDimension;

import java.util.Random;

public class GenericFireBlock extends FireBlock {
    private StatusEffect statusEffect;
    private int fireTime;
    private int effectTime;
    private int effectLevel;
    private int colorInt;
    private boolean effect = true;
    private VoxelShape SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 0.1D, 16.0D);
    private final Object2IntMap<Block> burnChances = new Object2IntOpenHashMap();
    private final Object2IntMap<Block> spreadChances = new Object2IntOpenHashMap();

    public GenericFireBlock(StatusEffect statusEffect, int colorInt, int fireTime, int effectTime, int effectLevel) {
        super(FabricBlockSettings.of(Material.FIRE)
                .noCollision()
                .ticksRandomly()
                .breakInstantly()
                .lightLevel(15)
                .sounds(BlockSoundGroup.WOOL)
                .dropsNothing()
                .build());
        this.fireTime = fireTime;
        this.statusEffect = statusEffect;
        this.effectTime = effectTime;
        this.effectLevel = effectLevel;
        this.colorInt = colorInt;
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        //disable particles
    }

    public void setEffect(boolean bool){
        this.effect = bool;
    }

    public boolean isEffect(){
        return this.effect;
    }

    public int getColorInt() {
        return colorInt;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        entity.setOnFireFor(fireTime);
        if (!(entity instanceof ItemEntity) && (isEffect() && entity.isAlive())){
            ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(statusEffect, effectTime, effectLevel));
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, EntityContext ePos) {
        return SHAPE;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext ePos) {
        return SHAPE;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getGameRules().getBoolean(GameRules.DO_FIRE_TICK)) {
            if (!state.canPlaceAt(world, pos)) {
                world.removeBlock(pos, false);
            }

            Block block = world.getBlockState(pos.down()).getBlock();
            boolean bl = world.dimension instanceof TheEndDimension && block == Blocks.BEDROCK || block == Blocks.NETHERRACK || block == Blocks.MAGMA_BLOCK;
            int i = (Integer)state.get(AGE);
            if (!bl && world.isRaining() && this.isRainingAround(world, pos) && random.nextFloat() < 0.2F + (float)i * 0.03F) {
                world.removeBlock(pos, false);
            } else {
                int j = Math.min(15, i + random.nextInt(3) / 2);
                if (i != j) {
                    state = (BlockState)state.with(AGE, j);
                    world.setBlockState(pos, state, 4);
                }

                if (!bl) {
                    world.getBlockTickScheduler().schedule(pos, this, this.getTickRate(world) + random.nextInt(10));
                    if (!this.areBlocksAroundFlammable(world, pos)) {
                        BlockPos blockPos = pos.down();
                        if (!world.getBlockState(blockPos).isSideSolidFullSquare(world, blockPos, Direction.UP) || i > 3) {
                            world.removeBlock(pos, false);
                        }

                        return;
                    }

                    if (i == 15 && random.nextInt(4) == 0 && !this.isFlammable(world.getBlockState(pos.down()))) {
                        world.removeBlock(pos, false);
                        return;
                    }
                }

                boolean bl2 = world.hasHighHumidity(pos);
                int k = bl2 ? -50 : 0;
                this.trySpreadingFire(world, pos.east(), 300 + k, random, i);
                this.trySpreadingFire(world, pos.west(), 300 + k, random, i);
                this.trySpreadingFire(world, pos.down(), 250 + k, random, i);
                this.trySpreadingFire(world, pos.up(), 250 + k, random, i);
                this.trySpreadingFire(world, pos.north(), 300 + k, random, i);
                this.trySpreadingFire(world, pos.south(), 300 + k, random, i);
                BlockPos.Mutable mutable = new BlockPos.Mutable();

                for(int l = -1; l <= 1; ++l) {
                    for(int m = -1; m <= 1; ++m) {
                        for(int n = -1; n <= 4; ++n) {
                            if (l != 0 || n != 0 || m != 0) {
                                int o = 100;
                                if (n > 1) {
                                    o += (n - 1) * 100;
                                }

                                mutable.set((Vec3i)pos).setOffset(l, n, m);
                                int p = this.getBurnChance(world, mutable);
                                if (p > 0) {
                                    int q = (p + 40 + world.getDifficulty().getId() * 7) / (i + 30);
                                    if (bl2) {
                                        q /= 2;
                                    }

                                    if (q > 0 && random.nextInt(o) <= q && (!world.isRaining() || !this.isRainingAround(world, mutable))) {
                                        int r = Math.min(15, i + random.nextInt(5) / 4);
                                        world.setBlockState(mutable, (BlockState)this.getStateForPosition(world, mutable).with(AGE, r), 3);
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    private int getBurnChance(BlockState state) {
        return state.contains(Properties.WATERLOGGED) && (Boolean)state.get(Properties.WATERLOGGED) ? 0 : this.burnChances.getInt(state.getBlock());
    }

    private int getBurnChance(WorldView worldView, BlockPos pos) {
        if (!worldView.isAir(pos)) {
            return 0;
        } else {
            int i = 0;
            Direction[] var4 = Direction.values();
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                Direction direction = var4[var6];
                BlockState blockState = worldView.getBlockState(pos.offset(direction));
                i = Math.max(this.getBurnChance(blockState), i);
            }

            return i;
        }
    }

    private int getSpreadChance(BlockState state) {
        return state.contains(Properties.WATERLOGGED) && (Boolean)state.get(Properties.WATERLOGGED) ? 0 : this.spreadChances.getInt(state.getBlock());
    }

    private void trySpreadingFire(World world, BlockPos pos, int spreadFactor, Random rand, int currentAge) {
        int i = this.getSpreadChance(world.getBlockState(pos));
        if (rand.nextInt(spreadFactor) < i) {
            BlockState blockState = world.getBlockState(pos);
            if (rand.nextInt(currentAge + 10) < 5 && !world.hasRain(pos)) {
                int j = Math.min(currentAge + rand.nextInt(5) / 4, 15);
                world.setBlockState(pos, (BlockState)this.getStateForPosition(world, pos).with(AGE, j), 3);
            } else {
                world.removeBlock(pos, false);
            }

            Block block = blockState.getBlock();
            if (block instanceof TntBlock) {
                TntBlock var10000 = (TntBlock)block;
                TntBlock.primeTnt(world, pos);
            }
        }

    }

    @Override
    protected boolean isFlammable(BlockState blockState) {
        return this.getBurnChance(blockState) > 0;
    }

    private boolean areBlocksAroundFlammable(BlockView world, BlockPos pos) {
        Direction[] var3 = Direction.values();
        int var4 = var3.length;

        for (Direction direction : var3) {
            if (this.isFlammable(world.getBlockState(pos.offset(direction)))) {
                return true;
            }
        }

        return false;
    }

    public void registerFlammableBlock(Block block, int burnChance, int spreadChance) {
        this.burnChances.put(block, burnChance);
        this.spreadChances.put(block, spreadChance);
    }
}
