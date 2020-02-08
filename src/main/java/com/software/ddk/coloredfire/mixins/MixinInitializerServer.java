package com.software.ddk.coloredfire.mixins;

import com.software.ddk.coloredfire.api.PostRegisterInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.dedicated.MinecraftDedicatedServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

//based on CottonMC cotton-datapack module

@Mixin(MinecraftDedicatedServer.class)
public abstract class MixinInitializerServer {

    @Inject(method = "setupServer", at = @At(value = "INVOKE", target = "Lorg/apache/logging/log4j/Logger;info(Ljava/lang/String;)V", ordinal = 0, remap = false))
    public void onInit(CallbackInfoReturnable cir){
        FabricLoader.getInstance().getEntrypoints("postregister", PostRegisterInitializer.class).forEach(PostRegisterInitializer::onPostRegister);
    }

}
