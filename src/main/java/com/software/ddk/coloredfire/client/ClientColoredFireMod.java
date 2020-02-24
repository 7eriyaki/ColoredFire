package com.software.ddk.coloredfire.client;

import com.software.ddk.coloredfire.ColoredFireMod;
import com.software.ddk.coloredfire.client.particles.GenericFlameParticle;
import com.software.ddk.coloredfire.common.block.colored.*;
import com.software.ddk.coloredfire.common.block.dyeable.DyeableFireBlockEntity;
import com.software.ddk.coloredfire.common.block.torch.GenericTorchBlockEntity;
import com.software.ddk.coloredfire.common.item.torch.GenericTorchItem;
import com.software.ddk.coloredfire.util.Colors;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.item.DyeableItem;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import static com.software.ddk.coloredfire.ModContent.*;

public class ClientColoredFireMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        //colored fire tints
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> (tintIndex == 0) ? BlueFireBlock.COLOR : BlueFireBlock.COLOR_BRIGHT, BLUE_FIRE_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> (tintIndex == 0) ? RedFireBlock.COLOR : RedFireBlock.COLOR_BRIGHT, RED_FIRE_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> (tintIndex == 0) ? GreenFireBlock.COLOR : GreenFireBlock.COLOR_BRIGHT, GREEN_FIRE_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> (tintIndex == 0) ? PurpleFireBlock.COLOR : PurpleFireBlock.COLOR_BRIGHT, PURPLE_FIRE_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> WhiteFireBlock.COLOR, WHITE_FIRE_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> (tintIndex == 0) ? YellowFireBlock.COLOR : YellowFireBlock.COLOR_BRIGHT, YELLOW_FIRE_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> (tintIndex == 0) ? BlackFireBlock.COLOR : BlackFireBlock.COLOR_BRIGHT, BLACK_FIRE_BLOCK);

        //dyeable fire
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> (tintIndex == 1) ? ((DyeableItem) stack.getItem()).getColor(stack) : 0xffffff, FLINT_AND_STEEL_DYEABLE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            World world = MinecraftClient.getInstance().world;
            BlockEntity blockEntity;
            int color = 0xffffff;
            try {
                if (state.getBlock().hasBlockEntity()){
                    assert world != null;
                    assert pos != null;
                    blockEntity = world.getBlockEntity(pos);
                    color = (blockEntity instanceof DyeableFireBlockEntity) ? ((DyeableFireBlockEntity) blockEntity).getCOLOR() : 0xffffff;
                }
            } catch (NullPointerException ex){
                //todo - try to reproduce this nullpointer crash
            }
            return (tintIndex == 0) ? color : Colors.colorLighter(color, 0.88f);
        }, DYEABLE_FIRE_BLOCK);

        //dyeable torches
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> (tintIndex == 1) ? ((GenericTorchItem) stack.getItem()).getColor(stack) : 0xffffff, GENERIC_TORCH_ITEM);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            World world = MinecraftClient.getInstance().world;
            BlockEntity blockEntity;
            int color = 0xffffff;
            try {
                if (state.getBlock().hasBlockEntity()){
                    assert world != null;
                    assert pos != null;
                    blockEntity = world.getBlockEntity(pos);
                    color = (blockEntity instanceof GenericTorchBlockEntity) ? ((GenericTorchBlockEntity) blockEntity).getCOLOR() : 0xffffff;
                }
            } catch (NullPointerException ex){
                //todo - try to reproduce this nullpointer crash (Torch)
            }
            return (tintIndex == 0) ? color : (tintIndex == 2) ? Colors.colorLighter(color, 0.9f) : 0xffffff;
        }, GENERIC_TORCH_BLOCK, GENERIC_WALL_TORCH_BLOCK);

        //torch particles registry
        ParticleFactoryRegistry.getInstance().register(GENERIC_FLAME_PARTICLE, GenericFlameParticle.Factory::new);
        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.PARTICLE_ATLAS_TEX).register((atlasTexture, registry) -> {
            registry.register(new Identifier(ColoredFireMod.MODID, "particle/generic_flame"));
        });

        //renderlayers
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                BLUE_FIRE_BLOCK, RED_FIRE_BLOCK, GREEN_FIRE_BLOCK, BLACK_FIRE_BLOCK,
                PURPLE_FIRE_BLOCK, WHITE_FIRE_BLOCK, YELLOW_FIRE_BLOCK, DYEABLE_FIRE_BLOCK,
                GENERIC_TORCH_BLOCK, GENERIC_WALL_TORCH_BLOCK);

    }
}
