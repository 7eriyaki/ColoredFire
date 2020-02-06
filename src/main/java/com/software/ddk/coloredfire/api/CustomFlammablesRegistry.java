package com.software.ddk.coloredfire.api;


import com.software.ddk.coloredfire.ColoredFireMod;
import com.software.ddk.coloredfire.ModContent;
import com.software.ddk.coloredfire.common.block.colored.*;
import com.software.ddk.coloredfire.common.block.dyeable.DyeableFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class CustomFlammablesRegistry {
    private static Object[][] FLAMMABLE_BLOCKS;

    public static void registerAll(){
        ColoredFireMod.COLOREDLOG.info("Registering custom fire flammables integration...");

        for (Object[] flammable : FLAMMABLE_BLOCKS) {
            ((BlackFireBlock) ModContent.BLACK_FIRE_BLOCK).registerFlammableBlock((Block) flammable[0], (int) flammable[1], (int) flammable[2]);
            ((BlueFireBlock) ModContent.BLUE_FIRE_BLOCK).registerFlammableBlock((Block) flammable[0], (int) flammable[1], (int) flammable[2]);
            ((RedFireBlock) ModContent.RED_FIRE_BLOCK).registerFlammableBlock((Block) flammable[0], (int) flammable[1], (int) flammable[2]);
            ((GreenFireBlock) ModContent.GREEN_FIRE_BLOCK).registerFlammableBlock((Block) flammable[0], (int) flammable[1], (int) flammable[2]);
            ((YellowFireBlock) ModContent.YELLOW_FIRE_BLOCK).registerFlammableBlock((Block) flammable[0], (int) flammable[1], (int) flammable[2]);
            ((PurpleFireBlock) ModContent.PURPLE_FIRE_BLOCK).registerFlammableBlock((Block) flammable[0], (int) flammable[1], (int) flammable[2]);
            ((WhiteFireBlock) ModContent.WHITE_FIRE_BLOCK).registerFlammableBlock((Block) flammable[0], (int) flammable[1], (int) flammable[2]);
            ((DyeableFireBlock) ModContent.DYEABLE_FIRE_BLOCK).registerFlammableBlock((Block) flammable[0], (int) flammable[1], (int) flammable[2]);
        }

        //special
        ((GreenFireBlock) ModContent.GREEN_FIRE_BLOCK).registerFlammableBlock(Blocks.WATER, 10, 15);

    }

    static{
        FLAMMABLE_BLOCKS = new Object[][]{
                {Blocks.OAK_PLANKS, 5, 20},
                {Blocks.SPRUCE_PLANKS, 5, 20},
                {Blocks.BIRCH_PLANKS, 5, 20},
                {Blocks.JUNGLE_PLANKS, 5, 20},
                {Blocks.ACACIA_PLANKS, 5, 20},
                {Blocks.DARK_OAK_PLANKS, 5, 20},
                {Blocks.OAK_SLAB, 5, 20},
                {Blocks.SPRUCE_SLAB, 5, 20},
                {Blocks.BIRCH_SLAB, 5, 20},
                {Blocks.JUNGLE_SLAB, 5, 20},
                {Blocks.ACACIA_SLAB, 5, 20},
                {Blocks.DARK_OAK_SLAB, 5, 20},
                {Blocks.OAK_FENCE_GATE, 5, 20},
                {Blocks.SPRUCE_FENCE_GATE, 5, 20},
                {Blocks.BIRCH_FENCE_GATE, 5, 20},
                {Blocks.JUNGLE_FENCE_GATE, 5, 20},
                {Blocks.DARK_OAK_FENCE_GATE, 5, 20},
                {Blocks.ACACIA_FENCE_GATE, 5, 20},
                {Blocks.OAK_FENCE, 5, 20},
                {Blocks.SPRUCE_FENCE, 5, 20},
                {Blocks.BIRCH_FENCE, 5, 20},
                {Blocks.JUNGLE_FENCE, 5, 20},
                {Blocks.DARK_OAK_FENCE, 5, 20},
                {Blocks.ACACIA_FENCE, 5, 20},
                {Blocks.OAK_STAIRS, 5, 20},
                {Blocks.BIRCH_STAIRS, 5, 20},
                {Blocks.SPRUCE_STAIRS, 5, 20},
                {Blocks.JUNGLE_STAIRS, 5, 20},
                {Blocks.ACACIA_STAIRS, 5, 20},
                {Blocks.DARK_OAK_STAIRS, 5, 20},
                {Blocks.OAK_LOG, 5, 5},
                {Blocks.SPRUCE_LOG, 5, 5},
                {Blocks.BIRCH_LOG, 5, 5},
                {Blocks.JUNGLE_LOG, 5, 5},
                {Blocks.ACACIA_LOG, 5, 5},
                {Blocks.DARK_OAK_LOG, 5, 5},
                {Blocks.STRIPPED_OAK_LOG, 5, 5},
                {Blocks.STRIPPED_SPRUCE_LOG, 5, 5},
                {Blocks.STRIPPED_BIRCH_LOG, 5, 5},
                {Blocks.STRIPPED_JUNGLE_LOG, 5, 5},
                {Blocks.STRIPPED_ACACIA_LOG, 5, 5},
                {Blocks.STRIPPED_DARK_OAK_LOG, 5, 5},
                {Blocks.STRIPPED_OAK_WOOD, 5, 5},
                {Blocks.STRIPPED_SPRUCE_WOOD, 5, 5},
                {Blocks.STRIPPED_BIRCH_WOOD, 5, 5},
                {Blocks.STRIPPED_JUNGLE_WOOD, 5, 5},
                {Blocks.STRIPPED_ACACIA_WOOD, 5, 5},
                {Blocks.STRIPPED_DARK_OAK_WOOD, 5, 5},
                {Blocks.OAK_WOOD, 5, 5},
                {Blocks.SPRUCE_WOOD, 5, 5},
                {Blocks.BIRCH_WOOD, 5, 5},
                {Blocks.JUNGLE_WOOD, 5, 5},
                {Blocks.ACACIA_WOOD, 5, 5},
                {Blocks.DARK_OAK_WOOD, 5, 5},
                {Blocks.OAK_LEAVES, 30, 60},
                {Blocks.SPRUCE_LEAVES, 30, 60},
                {Blocks.BIRCH_LEAVES, 30, 60},
                {Blocks.JUNGLE_LEAVES, 30, 60},
                {Blocks.ACACIA_LEAVES, 30, 60},
                {Blocks.DARK_OAK_LEAVES, 30, 60},
                {Blocks.BOOKSHELF, 30, 20},
                {Blocks.TNT, 15, 100},
                {Blocks.GRASS, 60, 100},
                {Blocks.FERN, 60, 100},
                {Blocks.DEAD_BUSH, 60, 100},
                {Blocks.SUNFLOWER, 60, 100},
                {Blocks.LILAC, 60, 100},
                {Blocks.ROSE_BUSH, 60, 100},
                {Blocks.PEONY, 60, 100},
                {Blocks.TALL_GRASS, 60, 100},
                {Blocks.LARGE_FERN, 60, 100},
                {Blocks.DANDELION, 60, 100},
                {Blocks.POPPY, 60, 100},
                {Blocks.BLUE_ORCHID, 60, 100},
                {Blocks.ALLIUM, 60, 100},
                {Blocks.AZURE_BLUET, 60, 100},
                {Blocks.RED_TULIP, 60, 100},
                {Blocks.ORANGE_TULIP, 60, 100},
                {Blocks.WHITE_TULIP, 60, 100},
                {Blocks.PINK_TULIP, 60, 100},
                {Blocks.OXEYE_DAISY, 60, 100},
                {Blocks.CORNFLOWER, 60, 100},
                {Blocks.LILY_OF_THE_VALLEY, 60, 100},
                {Blocks.WITHER_ROSE, 60, 100},
                {Blocks.WHITE_WOOL, 30, 60},
                {Blocks.ORANGE_WOOL, 30, 60},
                {Blocks.MAGENTA_WOOL, 30, 60},
                {Blocks.LIGHT_BLUE_WOOL, 30, 60},
                {Blocks.YELLOW_WOOL, 30, 60},
                {Blocks.LIME_WOOL, 30, 60},
                {Blocks.PINK_WOOL, 30, 60},
                {Blocks.GRAY_WOOL, 30, 60},
                {Blocks.LIGHT_GRAY_WOOL, 30, 60},
                {Blocks.CYAN_WOOL, 30, 60},
                {Blocks.PURPLE_WOOL, 30, 60},
                {Blocks.BLUE_WOOL, 30, 60},
                {Blocks.BROWN_WOOL, 30, 60},
                {Blocks.GREEN_WOOL, 30, 60},
                {Blocks.RED_WOOL, 30, 60},
                {Blocks.BLACK_WOOL, 30, 60},
                {Blocks.VINE, 15, 100},
                {Blocks.COAL_BLOCK, 5, 5},
                {Blocks.HAY_BLOCK, 60, 20},
                {Blocks.WHITE_CARPET, 60, 20},
                {Blocks.ORANGE_CARPET, 60, 20},
                {Blocks.MAGENTA_CARPET, 60, 20},
                {Blocks.LIGHT_BLUE_CARPET, 60, 20},
                {Blocks.YELLOW_CARPET, 60, 20},
                {Blocks.LIME_CARPET, 60, 20},
                {Blocks.PINK_CARPET, 60, 20},
                {Blocks.GRAY_CARPET, 60, 20},
                {Blocks.LIGHT_GRAY_CARPET, 60, 20},
                {Blocks.CYAN_CARPET, 60, 20},
                {Blocks.PURPLE_CARPET, 60, 20},
                {Blocks.BLUE_CARPET, 60, 20},
                {Blocks.BROWN_CARPET, 60, 20},
                {Blocks.GREEN_CARPET, 60, 20},
                {Blocks.RED_CARPET, 60, 20},
                {Blocks.BLACK_CARPET, 60, 20},
                {Blocks.DRIED_KELP_BLOCK, 30, 60},
                {Blocks.BAMBOO, 60, 60},
                {Blocks.SCAFFOLDING, 60, 60},
                {Blocks.LECTERN, 30, 20},
                {Blocks.COMPOSTER, 5, 20},
                {Blocks.SWEET_BERRY_BUSH, 60, 100},
                {Blocks.BEEHIVE, 5, 20},
                {Blocks.BEE_NEST, 30, 20}
        };
    }
}
