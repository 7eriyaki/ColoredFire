package com.software.ddk.coloredfire.common.item.lantern;

import com.software.ddk.coloredfire.ModContent;
import com.software.ddk.coloredfire.common.block.lantern.DyeableLanternBlock;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;

public class DyeableLanternItem extends BlockItem implements DyeableItem {

    public DyeableLanternItem() {
        super(ModContent.DYEABLE_LANTERN_BLOCK, new Item.Settings().group(ModContent.GROUP));
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
    protected BlockState getPlacementState(ItemPlacementContext context) {
        DyeableLanternBlock block = (DyeableLanternBlock) this.getBlock();
        block.setCOLOR(getColor(context.getStack()));
        return super.getPlacementState(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("coloredfire.dyeablelantern.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }

}
