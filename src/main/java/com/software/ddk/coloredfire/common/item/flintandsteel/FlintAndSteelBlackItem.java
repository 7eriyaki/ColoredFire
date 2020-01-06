package com.software.ddk.coloredfire.common.item.flintandsteel;

import com.software.ddk.coloredfire.ModContent;
import com.software.ddk.coloredfire.common.block.colored.BlackFireBlock;
import com.software.ddk.coloredfire.common.item.GenericFlintAndSteel;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class FlintAndSteelBlackItem extends GenericFlintAndSteel {
    public FlintAndSteelBlackItem() {
        super(new Item.Settings().maxCount(1).rarity(Rarity.RARE).group(ModContent.GROUP));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext itemUsageContext_1) {
        return onUse(itemUsageContext_1, ((BlackFireBlock) ModContent.BLACK_FIRE_BLOCK).getStateForPosition(getContextIworld(itemUsageContext_1), getContextBlockPos(itemUsageContext_1)));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world_1, PlayerEntity playerEntity_1, Hand hand_1) {
        return super.use(world_1, playerEntity_1, hand_1);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("coloredfire.flint_and_steel_black.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
