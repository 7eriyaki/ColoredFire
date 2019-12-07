package com.software.ddk.coloredfire.client;

import com.software.ddk.coloredfire.common.block.colored.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.ColorProviderRegistry;

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

    }
}
