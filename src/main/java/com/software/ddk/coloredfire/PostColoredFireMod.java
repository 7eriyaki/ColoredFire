package com.software.ddk.coloredfire;

import com.software.ddk.coloredfire.api.CustomFlammablesRegistry;
import com.software.ddk.coloredfire.api.PostRegisterInitializer;

public class PostColoredFireMod implements PostRegisterInitializer {
    @Override
    public void onPostRegister() {
        CustomFlammablesRegistry.registerAll();
    }
}
