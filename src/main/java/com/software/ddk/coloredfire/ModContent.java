package com.software.ddk.coloredfire;

import com.software.ddk.coloredfire.common.block.BlueFireBlock;
import com.software.ddk.coloredfire.common.block.GreenFireBlock;
import com.software.ddk.coloredfire.common.block.RedFireBlock;
import com.software.ddk.coloredfire.common.item.flintandsteel.FlintAndSteelBlueItem;
import com.software.ddk.coloredfire.common.item.flintandsteel.FlintAndSteelGreenItem;
import com.software.ddk.coloredfire.common.item.flintandsteel.FlintAndSteelRedItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModContent {
    public static Block RED_FIRE_BLOCK = new RedFireBlock();
    public static Block BLUE_FIRE_BLOCK = new BlueFireBlock();
    public static Block GREEN_FIRE_BLOCK = new GreenFireBlock();

    public static Item FLINT_AND_STEEL_RED = new FlintAndSteelRedItem();
    public static Item FLINT_AND_STEEL_BLUE = new FlintAndSteelBlueItem();
    public static Item FLINT_AND_STEEL_GREEN = new FlintAndSteelGreenItem();

    public static void RegisterAll(){
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "red_fire"), RED_FIRE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "blue_fire"), BLUE_FIRE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "green_fire"), GREEN_FIRE_BLOCK);

        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "flint_and_steel_red"), FLINT_AND_STEEL_RED);
        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "flint_and_steel_blue"), FLINT_AND_STEEL_BLUE);
        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "flint_and_steel_green"), FLINT_AND_STEEL_GREEN);

    }
}
