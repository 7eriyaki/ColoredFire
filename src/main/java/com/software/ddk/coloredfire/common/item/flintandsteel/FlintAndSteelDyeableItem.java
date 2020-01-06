package com.software.ddk.coloredfire.common.item.flintandsteel;

import com.software.ddk.coloredfire.ModContent;
import com.software.ddk.coloredfire.common.block.dyeable.DyeableFireBlock;
import com.software.ddk.coloredfire.common.item.GenericFlintAndSteel;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class FlintAndSteelDyeableItem extends GenericFlintAndSteel implements DyeableItem {

    public FlintAndSteelDyeableItem() {
        super(new Item.Settings().rarity(Rarity.UNCOMMON).group(ModContent.GROUP));
    }

    @Override
    public int getColor(ItemStack stack) {
        CompoundTag compoundTag = stack.getSubTag("display");
        return compoundTag != null && compoundTag.contains("color", 99) ? compoundTag.getInt("color") : 0xffffff;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext itemUsageContext_1) {
        DyeableFireBlock block = ((DyeableFireBlock) ModContent.DYEABLE_FIRE_BLOCK);
        block.setCOLOR(this.getColor(itemUsageContext_1.getStack()));
        return onUse(itemUsageContext_1, block.getStateForPosition(getContextIworld(itemUsageContext_1), getContextBlockPos(itemUsageContext_1)));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world_1, PlayerEntity playerEntity_1, Hand hand_1) {
        return super.use(world_1, playerEntity_1, hand_1);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("coloredfire.flint_and_steel_dyeable.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }

}
