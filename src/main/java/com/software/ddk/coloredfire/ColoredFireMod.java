package com.software.ddk.coloredfire;

import com.software.ddk.coloredfire.api.CustomFlammablesRegistry;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ColoredFireMod implements ModInitializer {
    public static final String MODID = "coloredfire";
    public static final Logger COLOREDLOG = LogManager.getLogger(MODID);

    @Override
    public void onInitialize() {
        ModContent.registerAll();
        CustomFlammablesRegistry.registerAll();
    }
}
