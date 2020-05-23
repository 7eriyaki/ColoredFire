package com.software.ddk.coloredfire.client.particles;

import com.software.ddk.coloredfire.common.block.torch.GenericTorchBlock;
import com.software.ddk.coloredfire.common.block.torch.GenericTorchBlockEntity;
import com.software.ddk.coloredfire.common.block.torch.GenericWallTorchBlock;
import com.software.ddk.coloredfire.util.Colors;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

public class ColoredParticleFactory extends FlameParticle.Factory {
    private final SpriteProvider spriteProvider;

    public ColoredParticleFactory(SpriteProvider spriteProvider) {
        super(spriteProvider);
        this.spriteProvider = spriteProvider;
    }

    @Override
    public Particle createParticle(DefaultParticleType defaultParticleType, World world, double x, double y, double z, double g, double h, double i) {
        BlockPos pos = new BlockPos(x, y, z);
        BlockState state = world.getBlockState(pos);
        Block block = state.getBlock();
        Particle flame = new FlameParticle.Factory(spriteProvider).createParticle(defaultParticleType, world, x, y, z, g, h, i);

        if (block instanceof GenericTorchBlock || block instanceof GenericWallTorchBlock){
            int color = (block.hasBlockEntity()) ? ((GenericTorchBlockEntity) Objects.requireNonNull(world.getBlockEntity(pos))).getCOLOR() : 0xffffff;
            float[] col = Colors.getRGBColor(Colors.colorLighter(color, 0.9f));
            assert flame != null;
            flame.setColor(col[0], col[1], col[2]);
        }
        return flame;
    }
}
