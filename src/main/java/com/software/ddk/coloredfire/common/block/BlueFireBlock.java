package com.software.ddk.coloredfire.common.block;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlueFireBlock extends FireBlock {
    public BlueFireBlock() {
        super(FabricBlockSettings.of(Material.FIRE, MaterialColor.BLUE)
                .noCollision()
                .ticksRandomly()
                .breakInstantly()
                .lightLevel(15)
                .sounds(BlockSoundGroup.WOOL)
                .dropsNothing()
                .build());
    }

    @Override
    public void onEntityCollision(BlockState blockState_1, World world_1, BlockPos blockPos_1, Entity entity_1) {
        entity_1.setOnFireFor(1);
        //entity_1.isLiving()
        if (entity_1.isLiving()){
            ((LivingEntity) entity_1).addPotionEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 200));
        }
    }

    @Override
    public void onBreak(World world_1, BlockPos blockPos_1, BlockState blockState_1, PlayerEntity playerEntity_1) {
        super.onBreak(world_1, blockPos_1, blockState_1, playerEntity_1);
    }

}
