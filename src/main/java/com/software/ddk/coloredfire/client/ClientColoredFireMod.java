package com.software.ddk.coloredfire.client;

import net.fabricmc.api.ClientModInitializer;

public class ClientColoredFireMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //ColorProviderRegistry.BLOCK.register((blockState, extendedBlockView, blockPos, i) -> 0xff0000, RED_FIRE_BLOCK);
    }
}
