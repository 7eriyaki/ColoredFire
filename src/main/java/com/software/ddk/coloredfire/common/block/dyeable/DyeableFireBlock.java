package com.software.ddk.coloredfire.common.block.dyeable;

import com.software.ddk.coloredfire.common.block.GenericFireBlock;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
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
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getStackInHand(hand).getItem() instanceof DyeItem){
            int dyeColor = ((DyeItem) player.getStackInHand(hand).getItem()).getColor().getFireworkColor();
            //int resultColor = ((DyeableFireBlock) world.getBlockState(pos).getBlock()).getCOLOR() + dyeColor;
            //System.out.println("clickado con " + ((DyeItem) player.getStackInHand(hand).getItem()).getColor().getFireworkColor());
            if (world.getBlockState(pos).getBlock().hasBlockEntity()){
                DyeableFireBlockEntity blockEntity = ((DyeableFireBlockEntity) world.getBlockEntity(pos));
                blockEntity.setCOLOR(dyeColor);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public BlockEntity createBlockEntity(BlockView view) {
        DyeableFireBlockEntity blockEntity = new DyeableFireBlockEntity();
        blockEntity.setCOLOR(COLOR);
        return blockEntity;
    }
}
