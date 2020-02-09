package com.software.ddk.coloredfire.mixins;

import com.software.ddk.coloredfire.api.PostRegisterInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//based on CottonMC cotton-datapack module

@Mixin(MinecraftClient.class)
public abstract class MixinInitializerClient {

    @Inject(method = "<init>", at = @At("RETURN"))
    public void onInit(CallbackInfo ci){
        FabricLoader.getInstance().getEntrypoints("postregister", PostRegisterInitializer.class).forEach(PostRegisterInitializer::onPostRegister);
    }
}
