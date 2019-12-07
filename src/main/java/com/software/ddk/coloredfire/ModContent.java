package com.software.ddk.coloredfire;

import com.software.ddk.coloredfire.common.block.colored.*;
import com.software.ddk.coloredfire.common.item.flintandsteel.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModContent {
    public static Block BLUE_FIRE_BLOCK = new BlueFireBlock();
    public static Block RED_FIRE_BLOCK = new RedFireBlock();
    public static Block GREEN_FIRE_BLOCK = new GreenFireBlock();
    public static Block BLACK_FIRE_BLOCK = new BlackFireBlock();
    public static Block PURPLE_FIRE_BLOCK = new PurpleFireBlock();
    public static Block WHITE_FIRE_BLOCK = new WhiteFireBlock();
    public static Block YELLOW_FIRE_BLOCK = new YellowFireBlock();

    public static Item FLINT_AND_STEEL_BLUE = new FlintAndSteelBlueItem();
    public static Item FLINT_AND_STEEL_RED = new FlintAndSteelRedItem();
    public static Item FLINT_AND_STEEL_GREEN = new FlintAndSteelGreenItem();
    public static Item FLINT_AND_STEEL_BLACK = new FlintAndSteelBlackItem();
    public static Item FLINT_AND_STEEL_PURPLE = new FlintAndSteelPurpleItem();
    public static Item FLINT_AND_STEEL_WHITE = new FlintAndSteelWhiteItem();
    public static Item FLINT_AND_STEEL_YELLOW = new FlintAndSteelYellowItem();

    public static void RegisterAll(){

        //blocks
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "blue_fire"), BLUE_FIRE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "red_fire"), RED_FIRE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "green_fire"), GREEN_FIRE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "black_fire"), BLACK_FIRE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "white_fire"), WHITE_FIRE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "purple_fire"), PURPLE_FIRE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "yellow_fire"), YELLOW_FIRE_BLOCK);

        //items
        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "flint_and_steel_blue"), FLINT_AND_STEEL_BLUE);
        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "flint_and_steel_red"), FLINT_AND_STEEL_RED);
        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "flint_and_steel_green"), FLINT_AND_STEEL_GREEN);
        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "flint_and_steel_black"), FLINT_AND_STEEL_BLACK);
        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "flint_and_steel_purple"), FLINT_AND_STEEL_PURPLE);
        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "flint_and_steel_white"), FLINT_AND_STEEL_WHITE);
        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "flint_and_steel_yellow"), FLINT_AND_STEEL_YELLOW);

    }
}
