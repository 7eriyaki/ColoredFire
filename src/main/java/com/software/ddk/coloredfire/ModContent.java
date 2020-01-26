package com.software.ddk.coloredfire;

import com.software.ddk.coloredfire.common.block.colored.*;
import com.software.ddk.coloredfire.common.block.dyeable.DyeableFireBlock;
import com.software.ddk.coloredfire.common.block.dyeable.DyeableFireBlockEntity;
import com.software.ddk.coloredfire.common.block.torch.GenericTorchBlock;
import com.software.ddk.coloredfire.common.block.torch.GenericTorchBlockEntity;
import com.software.ddk.coloredfire.common.block.torch.GenericWallTorchBlock;
import com.software.ddk.coloredfire.common.item.flintandsteel.*;
import com.software.ddk.coloredfire.common.item.torch.GenericTorchItem;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.WallStandingBlockItem;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModContent {
    //group
    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(new Identifier(ColoredFireMod.MODID, "group"), () -> new ItemStack(ModContent.FLINT_AND_STEEL_RED));
    public static BlockEntityType<DyeableFireBlockEntity> DYEABLE_FIRE_BLOCK_ENTITY;
    public static BlockEntityType<GenericTorchBlockEntity> GENERIC_TORCH_BLOCK_ENTITY;

    public static Block BLUE_FIRE_BLOCK = new BlueFireBlock();
    public static Block RED_FIRE_BLOCK = new RedFireBlock();
    public static Block GREEN_FIRE_BLOCK = new GreenFireBlock();
    public static Block BLACK_FIRE_BLOCK = new BlackFireBlock();
    public static Block PURPLE_FIRE_BLOCK = new PurpleFireBlock();
    public static Block WHITE_FIRE_BLOCK = new WhiteFireBlock();
    public static Block YELLOW_FIRE_BLOCK = new YellowFireBlock();
    public static Block DYEABLE_FIRE_BLOCK = new DyeableFireBlock();

    public static Block GENERIC_TORCH_BLOCK = new GenericTorchBlock();
    public static Block GENERIC_WALL_TORCH_BLOCK = new GenericWallTorchBlock();

    public static Item FLINT_AND_STEEL_BLUE = new FlintAndSteelBlueItem();
    public static Item FLINT_AND_STEEL_RED = new FlintAndSteelRedItem();
    public static Item FLINT_AND_STEEL_GREEN = new FlintAndSteelGreenItem();
    public static Item FLINT_AND_STEEL_BLACK = new FlintAndSteelBlackItem();
    public static Item FLINT_AND_STEEL_PURPLE = new FlintAndSteelPurpleItem();
    public static Item FLINT_AND_STEEL_WHITE = new FlintAndSteelWhiteItem();
    public static Item FLINT_AND_STEEL_YELLOW = new FlintAndSteelYellowItem();
    public static Item FLINT_AND_STEEL_DYEABLE = new FlintAndSteelDyeableItem();

    public static Item GENERIC_TORCH_ITEM = new GenericTorchItem();

    public static final DefaultParticleType GENERIC_FLAME_PARTICLE = Registry.register(Registry.PARTICLE_TYPE, new Identifier(ColoredFireMod.MODID, "generic_flame"), FabricParticleTypes.simple(true));

    public static void RegisterAll(){
        ColoredFireMod.COLOREDLOG.info("Colored Flames Mod Loading");

        //blockentity
        DYEABLE_FIRE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ColoredFireMod.MODID, "dyeablefireblockentity"), BlockEntityType.Builder.create(DyeableFireBlockEntity::new, DYEABLE_FIRE_BLOCK).build(null));
        GENERIC_TORCH_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ColoredFireMod.MODID, "generictorchblockentity"), BlockEntityType.Builder.create(GenericTorchBlockEntity::new, GENERIC_TORCH_BLOCK, GENERIC_WALL_TORCH_BLOCK).build(null));

        //blocks
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "blue_fire"), BLUE_FIRE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "red_fire"), RED_FIRE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "green_fire"), GREEN_FIRE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "black_fire"), BLACK_FIRE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "white_fire"), WHITE_FIRE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "purple_fire"), PURPLE_FIRE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "yellow_fire"), YELLOW_FIRE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "dyeable_fire"), DYEABLE_FIRE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "generic_torch"), GENERIC_TORCH_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ColoredFireMod.MODID, "generic_wall_torch"), GENERIC_WALL_TORCH_BLOCK);

        //items
        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "flint_and_steel_blue"), FLINT_AND_STEEL_BLUE);
        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "flint_and_steel_red"), FLINT_AND_STEEL_RED);
        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "flint_and_steel_green"), FLINT_AND_STEEL_GREEN);
        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "flint_and_steel_black"), FLINT_AND_STEEL_BLACK);
        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "flint_and_steel_purple"), FLINT_AND_STEEL_PURPLE);
        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "flint_and_steel_white"), FLINT_AND_STEEL_WHITE);
        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "flint_and_steel_yellow"), FLINT_AND_STEEL_YELLOW);
        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "flint_and_steel_dyeable"), FLINT_AND_STEEL_DYEABLE);
        Registry.register(Registry.ITEM, new Identifier(ColoredFireMod.MODID, "generic_torch"), GENERIC_TORCH_ITEM);

    }
}
