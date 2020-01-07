package com.software.ddk.coloredfire.client;

import com.software.ddk.coloredfire.common.block.colored.*;
import com.software.ddk.coloredfire.common.block.dyeable.DyeableFireBlockEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.ColorProviderRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.DyeableItem;
import net.minecraft.world.World;
import java.util.Objects;

import static com.software.ddk.coloredfire.ModContent.*;

public class ClientColoredFireMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        //colored fire tints
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> (tintIndex == 0) ? BlueFireBlock.COLOR : 0xBFF7FF, BLUE_FIRE_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> (tintIndex == 0) ? RedFireBlock.COLOR : 0xFF7F7F, RED_FIRE_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> (tintIndex == 0) ? GreenFireBlock.COLOR : 0x96ED8E, GREEN_FIRE_BLOCK);
        ColorProviderRegistry.BLOCK.register((blockState, extendedBlockView, blockPos, i) -> BlackFireBlock.COLOR, BLACK_FIRE_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> (tintIndex == 0) ? PurpleFireBlock.COLOR : 0xD68CFF, PURPLE_FIRE_BLOCK);
        ColorProviderRegistry.BLOCK.register((blockState, extendedBlockView, blockPos, i) -> WhiteFireBlock.COLOR, WHITE_FIRE_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> (tintIndex == 0) ? YellowFireBlock.COLOR : 0xFFE97C, YELLOW_FIRE_BLOCK);

        //dyeable fire
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> (tintIndex == 1) ? ((DyeableItem) stack.getItem()).getColor(stack) : 0xffffff, FLINT_AND_STEEL_DYEABLE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            World world = MinecraftClient.getInstance().world;
            assert world != null;
            assert pos != null;
            return (state.getBlock().hasBlockEntity()) ? ((DyeableFireBlockEntity) Objects.requireNonNull(world.getBlockEntity(pos))).getCOLOR() : 0xffffff;
        }, DYEABLE_FIRE_BLOCK);

        //renderlayers
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                BLUE_FIRE_BLOCK, RED_FIRE_BLOCK, GREEN_FIRE_BLOCK, BLACK_FIRE_BLOCK,
                PURPLE_FIRE_BLOCK, WHITE_FIRE_BLOCK, YELLOW_FIRE_BLOCK, DYEABLE_FIRE_BLOCK);

    }
}
