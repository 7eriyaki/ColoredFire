package com.software.ddk.coloredfire;

import com.software.ddk.coloredfire.common.block.BlueFireBlock;
import com.software.ddk.coloredfire.common.block.RedFireBlock;
import com.software.ddk.coloredfire.common.item.FlintAndSteelBlueItem;
import com.software.ddk.coloredfire.common.item.FlintAndSteelRedItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModContent {

    public static Block RED_FIRE_BLOCK = new RedFireBlock();
    public static Block BLUE_FIRE_BLOCK = new BlueFireBlock();
    public static Item FLINT_AND_STEEL_RED = new FlintAndSteelRedItem(new Item.Settings().group(ItemGroup.TOOLS));
    public static Item FLINT_AND_STEEL_BLUE = new FlintAndSteelBlueItem(new Item.Settings().group(ItemGroup.TOOLS));

    public static void RegisterAll(){
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "red_fire"), RED_FIRE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "blue_fire"), BLUE_FIRE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "flint_and_steel_red"), FLINT_AND_STEEL_RED);
        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "flint_and_steel_blue"), FLINT_AND_STEEL_BLUE);

    }
}
