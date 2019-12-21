package com.software.ddk.coloredfire.common.item.flintandsteel;

import com.software.ddk.coloredfire.ModContent;
import com.software.ddk.coloredfire.common.block.dyeable.DyeableFireBlock;
import com.software.ddk.coloredfire.common.item.GenericFlintAndSteel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class FlintAndSteelDyeableItem extends GenericFlintAndSteel implements DyeableItem {

    public FlintAndSteelDyeableItem() {
        super(new Item.Settings().group(ItemGroup.TOOLS));
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
        //System.out.println("block color: " + block.getCOLOR());
        return onUse(itemUsageContext_1, block.getStateForPosition(getContextIworld(itemUsageContext_1), getContextBlockPos(itemUsageContext_1)));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world_1, PlayerEntity playerEntity_1, Hand hand_1) {
        return super.use(world_1, playerEntity_1, hand_1);
    }

}
