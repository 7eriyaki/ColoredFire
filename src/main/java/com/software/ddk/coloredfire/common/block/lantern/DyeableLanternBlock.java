package com.software.ddk.coloredfire.common.block.lantern;

import com.software.ddk.coloredfire.common.block.torch.GenericTorchBlockEntity;
import com.software.ddk.coloredfire.common.item.lantern.DyeableLanternItem;
import com.software.ddk.coloredfire.common.item.torch.GenericTorchItem;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Objects;

public class DyeableLanternBlock extends LanternBlock implements BlockEntityProvider {
    private int COLOR = 0xffffff;

    public DyeableLanternBlock() {
        super(FabricBlockSettings
                .of(Material.METAL)
                .hardness(3.5f)
                .sounds(BlockSoundGroup.LANTERN)
                .lightLevel(15)
                .nonOpaque()
                .build());
    }

    public int getCOLOR(){
        return COLOR;
    }

    public void setCOLOR(int COLOR){
        this.COLOR = COLOR;
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient && (!player.isCreative() && !isPistonAdyacent(world, pos))){
            if (FabricToolTags.PICKAXES.contains(player.getStackInHand(Hand.MAIN_HAND).getItem())){
                this.dropItem(world, state, pos, player);
            }
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
            this.dropItem(world, state, pos, null);
        }
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.DESTROY;
    }

    private void dropItem(World world, BlockState state, BlockPos pos, PlayerEntity player){
        DyeableLanternItem item = (DyeableLanternItem) state.getBlock().asItem();
        ItemStack stack = new ItemStack(item);
        int color = (state.getBlock().hasBlockEntity()) ? ((DyeableLanternBlockEntity) Objects.requireNonNull(world.getBlockEntity(pos))).getCOLOR() : 0xffffff;
        item.setColor(stack, color);
        ItemEntity entity = new ItemEntity(world.getWorld(), pos.getX(), pos.getY(), pos.getZ(), stack);
        world.spawnEntity(entity);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView view) {
        DyeableLanternBlockEntity blockEntity = new DyeableLanternBlockEntity();
        blockEntity.setCOLOR(COLOR);
        return blockEntity;
    }
}
