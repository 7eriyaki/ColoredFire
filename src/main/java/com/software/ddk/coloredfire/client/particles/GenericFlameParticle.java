package com.software.ddk.coloredfire.client.particles;

import com.software.ddk.coloredfire.common.block.torch.GenericTorchBlock;
import com.software.ddk.coloredfire.common.block.torch.GenericTorchBlockEntity;
import com.software.ddk.coloredfire.common.block.torch.GenericWallTorchBlock;
import com.software.ddk.coloredfire.util.Colors;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.particle.*;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Objects;

public class GenericFlameParticle extends SpriteBillboardParticle {
   private GenericFlameParticle(World world, double x, double y, double z, double vX, double vY, double vZ) {
      super(world, x, y, z, vX, vY, vZ);
      this.velocityX = this.velocityX * 0.009999999776482582D + vX;
      this.velocityY = this.velocityY * 0.009999999776482582D + vY;
      this.velocityZ = this.velocityZ * 0.009999999776482582D + vZ;
      this.x += (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.05F);
      this.y += (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.05F);
      this.z += (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.05F);
      this.maxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D)) + 4;

      BlockPos pos = new BlockPos(x, y, z);
      BlockState state = world.getBlockState(pos);
      Block block = state.getBlock();

      if (block instanceof GenericTorchBlock || block instanceof GenericWallTorchBlock){
         int color = (block.hasBlockEntity()) ? ((GenericTorchBlockEntity) Objects.requireNonNull(world.getBlockEntity(pos))).getCOLOR() : 0xffffff;
         float[] col = Colors.getRGBColor(Colors.colorLighter(color, 0.9f));
         this.setColor(col[0], col[1], col[2]);
      }
   }

   public ParticleTextureSheet getType() {
      return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
   }

   public void move(double dx, double dy, double dz) {
      this.setBoundingBox(this.getBoundingBox().offset(dx, dy, dz));
      this.repositionFromBoundingBox();
   }

   public float getSize(float tickDelta) {
      float f = ((float)this.age + tickDelta) / (float)this.maxAge;
      return this.scale * (1.0F - f * f * 0.5F);
   }

   public int getColorMultiplier(float tint) {
      float f = ((float)this.age + tint) / (float)this.maxAge;
      f = MathHelper.clamp(f, 0.0F, 1.0F);
      int i = super.getColorMultiplier(tint);
      int j = i & 255;
      int k = i >> 16 & 255;
      j += (int)(f * 15.0F * 16.0F);
      if (j > 240) {
         j = 240;
      }

      return j | k << 16;
   }

   public void tick() {
      this.prevPosX = this.x;
      this.prevPosY = this.y;
      this.prevPosZ = this.z;
      if (this.age++ >= this.maxAge) {
         this.markDead();
      } else {
         this.move(this.velocityX, this.velocityY, this.velocityZ);
         this.velocityX *= 0.9599999785423279D;
         this.velocityY *= 0.9599999785423279D;
         this.velocityZ *= 0.9599999785423279D;
         if (this.onGround) {
            this.velocityX *= 0.699999988079071D;
            this.velocityZ *= 0.699999988079071D;
         }

      }

   }

   public static class Factory implements ParticleFactory<DefaultParticleType> {
      private final SpriteProvider spriteProvider;

      public Factory(SpriteProvider spriteProvider) {
         this.spriteProvider = spriteProvider;
      }

      public Particle createParticle(DefaultParticleType defaultParticleType, World world, double x, double y, double z, double g, double h, double i) {
         //FlameParticle flameParticle = new FlameParticle(world, d, e, f, g, h, i);
         GenericFlameParticle particle = new GenericFlameParticle(world, x, y, z, g, h, i);
         particle.setSprite(this.spriteProvider);
         return particle;
      }
   }
}
