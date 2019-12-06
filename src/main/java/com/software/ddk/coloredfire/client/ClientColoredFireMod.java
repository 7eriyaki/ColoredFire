package com.software.ddk.coloredfire.client;

import com.software.ddk.coloredfire.common.block.colored.BlueFireBlock;
import com.software.ddk.coloredfire.common.block.colored.GreenFireBlock;
import com.software.ddk.coloredfire.common.block.colored.RedFireBlock;
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

    }
}
