package com.software.ddk.coloredfire.client;

import com.software.ddk.coloredfire.common.block.colored.*;
import com.software.ddk.coloredfire.common.block.dyeable.DyeableFireBlockEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.ColorProviderRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.DyeableItem;
import net.minecraft.world.World;
import java.util.Objects;

import static com.software.ddk.coloredfire.ModContent.*;

public class ClientColoredFireMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        //colored fire tints
        ColorProviderRegistry.BLOCK.register((blockState, extendedBlockView, blockPos, i) -> BlueFireBlock.COLOR, BLUE_FIRE_BLOCK);
        ColorProviderRegistry.BLOCK.register((blockState, extendedBlockView, blockPos, i) -> RedFireBlock.COLOR, RED_FIRE_BLOCK);
        ColorProviderRegistry.BLOCK.register((blockState, extendedBlockView, blockPos, i) -> GreenFireBlock.COLOR, GREEN_FIRE_BLOCK);
        ColorProviderRegistry.BLOCK.register((blockState, extendedBlockView, blockPos, i) -> BlackFireBlock.COLOR, BLACK_FIRE_BLOCK);
        ColorProviderRegistry.BLOCK.register((blockState, extendedBlockView, blockPos, i) -> PurpleFireBlock.COLOR, PURPLE_FIRE_BLOCK);
        ColorProviderRegistry.BLOCK.register((blockState, extendedBlockView, blockPos, i) -> WhiteFireBlock.COLOR, WHITE_FIRE_BLOCK);
        ColorProviderRegistry.BLOCK.register((blockState, extendedBlockView, blockPos, i) -> YellowFireBlock.COLOR, YELLOW_FIRE_BLOCK);

        //dyeable fire
        //todo - a bit hacky
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            int color = ((DyeableItem) stack.getItem()).getColor(stack);
            if (tintIndex == 1){ return color; } else { return 0xffffff; }
        }, FLINT_AND_STEEL_DYEABLE);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            World world = MinecraftClient.getInstance().world;
            assert world != null;
            if (world.getBlockState(pos).getBlock().hasBlockEntity()){
                return ((DyeableFireBlockEntity) Objects.requireNonNull(world.getBlockEntity(pos))).getCOLOR();
            } else {
                return 0xffffff;
            }
        }, DYEABLE_FIRE_BLOCK);

        //renderlayers
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                BLUE_FIRE_BLOCK, RED_FIRE_BLOCK, GREEN_FIRE_BLOCK, BLACK_FIRE_BLOCK,
                PURPLE_FIRE_BLOCK, WHITE_FIRE_BLOCK, YELLOW_FIRE_BLOCK, DYEABLE_FIRE_BLOCK);

    }
}
