package com.software.ddk.coloredfire.common.block.torch;

import com.software.ddk.coloredfire.ModContent;
import com.software.ddk.coloredfire.common.item.torch.GenericTorchItem;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.Random;

public class GenericTorchBlock extends TorchBlock implements BlockEntityProvider {
    private int COLOR = 0xffffff;

    public GenericTorchBlock() {
        super(FabricBlockSettings.of(Material.PART)
                .noCollision()
                .breakInstantly()
                .lightLevel(14)
                .sounds(BlockSoundGroup.WOOD)
                .build(), ModContent.GENERIC_FLAME_PARTICLE);
    }

    public int getCOLOR(){
        return COLOR;
    }

    public void setCOLOR(int COLOR){
        this.COLOR = COLOR;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (world.isClient()){
            double x = (double)pos.getX() + 0.5D;
            double y = (double)pos.getY() + 0.7D;
            double z = (double)pos.getZ() + 0.5D;

            world.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0D, 0.0D, 0.0D);
            world.addParticle(ModContent.GENERIC_FLAME_PARTICLE, x, y, z, 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient && (!player.isCreative() && !isPistonAdyacent(world, pos))){
            this.dropItem(world, state, pos);
        }
        super.onBreak(world, pos, state, player);
    }

    private boolean isPistonAdyacent(World world, BlockPos pos){
        BlockPos[] nearby = new BlockPos[]{
                pos.east(), pos.west(), pos.north(), pos.south(), pos.up(), pos.down()
        };

        for (BlockPos blockPos : nearby) {
            if (world.getBlockState(blockPos).getBlock() instanceof PistonBlock) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onBlockRemoved(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (isPistonAdyacent(world, pos)){
            this.dropItem(world, state, pos);
        }
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.DESTROY;
    }

    private void dropItem(World world, BlockState state, BlockPos pos){
        GenericTorchItem item = (GenericTorchItem) state.getBlock().asItem();
        ItemStack stack = new ItemStack(item);
        int color = (state.getBlock().hasBlockEntity()) ? ((GenericTorchBlockEntity) Objects.requireNonNull(world.getBlockEntity(pos))).getCOLOR() : 0xffffff;
        item.setColor(stack, color);
        ItemEntity entity = new ItemEntity(world.getWorld(), pos.getX(), pos.getY(), pos.getZ(), stack);
        world.spawnEntity(entity);

    }

    @Override
    public BlockEntity createBlockEntity(BlockView view) {
        GenericTorchBlockEntity blockEntity = new GenericTorchBlockEntity();
        blockEntity.setCOLOR(COLOR);
        return blockEntity;
    }
}
