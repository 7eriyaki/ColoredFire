package com.software.ddk.coloredfire.common.item.torch;

import com.software.ddk.coloredfire.ModContent;
import com.software.ddk.coloredfire.common.block.torch.GenericTorchBlock;
import com.software.ddk.coloredfire.common.block.torch.GenericWallTorchBlock;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityContext;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.List;

public class GenericTorchItem extends WallStandingBlockItem implements DyeableItem {

    public GenericTorchItem() {
        super(ModContent.GENERIC_TORCH_BLOCK, ModContent.GENERIC_WALL_TORCH_BLOCK, new Item.Settings().group(ModContent.GROUP));
    }

    @Override
    public int getColor(ItemStack stack) {
        CompoundTag compoundTag = stack.getSubTag("display");
        return compoundTag != null && compoundTag.contains("color", 99) ? compoundTag.getInt("color") : 0xffffff;
    }

    @Override
    public void setColor(ItemStack stack, int color) {
        stack.getOrCreateSubTag("display").putInt("color", color);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("coloredfire.generic_torch.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    protected BlockState getPlacementState(ItemPlacementContext context) {
        GenericWallTorchBlock wallBlock = ((GenericWallTorchBlock) this.wallBlock);
        GenericTorchBlock block = ((GenericTorchBlock) this.getBlock());
        wallBlock.setCOLOR(getColor(context.getStack()));
        block.setCOLOR(getColor(context.getStack()));
        //System.out.println("PLACEMENT: " + wallBlock.getCOLOR() + " -- " + block.getCOLOR());
        BlockState blockState = wallBlock.getPlacementState(context);
        BlockState blockState2 = null;
        WorldView worldView = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        Direction[] var6 = context.getPlacementDirections();
        int var7 = var6.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            Direction direction = var6[var8];
            if (direction != Direction.UP) {
                BlockState blockState3 = direction == Direction.DOWN ? block.getPlacementState(context) : blockState;
                if (blockState3 != null && blockState3.canPlaceAt(worldView, blockPos)) {
                    blockState2 = blockState3;
                    break;
                }
            }
        }

        return blockState2 != null && worldView.canPlace(blockState2, blockPos, EntityContext.absent()) ? blockState2 : null;
    }
}
