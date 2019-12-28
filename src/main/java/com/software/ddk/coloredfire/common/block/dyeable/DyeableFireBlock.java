package com.software.ddk.coloredfire.common.block.dyeable;

import com.software.ddk.coloredfire.common.block.GenericFireBlock;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class DyeableFireBlock extends GenericFireBlock implements BlockEntityProvider {
    private int COLOR = 0xffffff;

    public DyeableFireBlock() {
        super(StatusEffects.INSTANT_DAMAGE, 0xffffff, 8, 1, 1);
        this.setEffect(false);
    }

    public int getCOLOR(){
        return COLOR;
    }

    public void setCOLOR(int COLOR){
        this.COLOR = COLOR;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        if (entity instanceof ItemEntity){
            //System.out.println("item!");
            ItemStack stack = ((ItemEntity) entity).getStack();
            if (stack.getItem() instanceof DyeItem){
                int dyeColor = ((DyeItem) stack.getItem()).getColor().getFireworkColor();
                if (world.getBlockState(pos).getBlock().hasBlockEntity()){
                    dyeAction(world, pos, dyeColor);
                    world.updateListeners(pos, state, state, 1);
                }
            }
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getStackInHand(hand).getItem() instanceof DyeItem){
            int dyeColor = ((DyeItem) player.getStackInHand(hand).getItem()).getColor().getFireworkColor();
            //int blockDye = ((DyeableFireBlock) world.getBlockState(pos).getBlock()).getCOLOR();
            //int resultColor = blockDye + dyeColor;
            //System.out.println("result: " + resultColor);
            if (world.getBlockState(pos).getBlock().hasBlockEntity()){
                dyeAction(world, pos, dyeColor);
                world.updateListeners(pos, state, state, 1);
            }
        }
        return ActionResult.SUCCESS;
    }

    private void dyeAction(World world, BlockPos pos, int dyeColor){
        DyeableFireBlockEntity blockEntity = ((DyeableFireBlockEntity) world.getBlockEntity(pos));
        blockEntity.setCOLOR(dyeColor);
        if (!world.isClient()){
            blockEntity.sync();
        }
    }

    @Override
    public BlockEntity createBlockEntity(BlockView view) {
        DyeableFireBlockEntity blockEntity = new DyeableFireBlockEntity();
        blockEntity.setCOLOR(COLOR);
        return blockEntity;
    }
}
