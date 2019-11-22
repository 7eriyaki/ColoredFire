package com.software.ddk.coloredfire;

import net.fabricmc.api.ModInitializer;

public class ColoredFireMod implements ModInitializer {
    public static final String MODID = "coloredfire";

    @Override
    public void onInitialize() {
        ModContent.RegisterAll();
    }
}
