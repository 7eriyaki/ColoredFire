package com.software.ddk.coloredfire.common.item.flintandsteel;

import com.software.ddk.coloredfire.ModContent;
import com.software.ddk.coloredfire.common.block.colored.GreenFireBlock;
import com.software.ddk.coloredfire.common.item.GenericFlintAndSteel;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import java.util.List;

public class FlintAndSteelGreenItem extends GenericFlintAndSteel {
    public FlintAndSteelGreenItem() {
        super(new Item.Settings().rarity(Rarity.RARE).maxCount(1).group(ModContent.GROUP));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext itemUsageContext_1) {
        return onUse(itemUsageContext_1, ((GreenFireBlock) ModContent.GREEN_FIRE_BLOCK).getStateForPosition(getContextIworld(itemUsageContext_1), getContextBlockPos(itemUsageContext_1)));
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("coloredfire.flint_and_steel_green.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
