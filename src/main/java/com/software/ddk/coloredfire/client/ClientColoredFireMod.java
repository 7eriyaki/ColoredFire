package com.software.ddk.coloredfire.client;

import com.software.ddk.coloredfire.common.block.colored.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.ColorProviderRegistry;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.client.render.RenderLayer;

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

        BlockRenderLayerMap.INSTANCE.putBlock(BLUE_FIRE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RED_FIRE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GREEN_FIRE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BLACK_FIRE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PURPLE_FIRE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WHITE_FIRE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(YELLOW_FIRE_BLOCK, RenderLayer.getCutout());

    }
}
