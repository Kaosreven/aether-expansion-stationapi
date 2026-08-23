package io.github.kaosreven.aetherex.entity.projectile;

import com.matthewperiut.aether.entity.projectile.EntityFiroBall;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityFiroBallEx extends EntityFiroBall {

    public EntityFiroBallEx(World world) {
        super(world);
        this.setBoundingBoxSpacing(1.2F, 1.2F);
    }

    public EntityFiroBallEx(World world, double d, double d1, double d2, PlayerEntity entityplayer) {
        super(world, d, d1, d2, false);
        this.setBoundingBoxSpacing(1.2F, 1.2F);
        if (entityplayer != null) {
            Vec3d vec3d = entityplayer.getLookVector();
            this.smotionX = vec3d.x;
            this.smotionY = vec3d.y;
            this.smotionZ = vec3d.z;
        }
    }

    public EntityFiroBallEx(World world, double x, double y, double z) {
        this(world, x, y, z, null);
    }

    @Override
    public void tickLiving() {
        this.velocityX = this.smotionX;
        this.velocityY = this.smotionY;
        this.velocityZ = this.smotionZ;

        for(int i = 0; i < 5; ++i) {
            double d = this.random.nextGaussian() * (double)0.02F;
            double d1 = this.random.nextGaussian() * (double)0.02F;
            double d2 = this.random.nextGaussian() * (double)0.02F;
            this.world.addParticle("flame", this.x, this.y + 0.45D, this.z, d, d1, d2);
        }

        if(this.hasCollided) {
            this.splode();
            this.fizzle();
            this.dead = true;
        }

        this.updateAnims();
    }

    @Override
    public void splode() {
        if(!this.world.isRemote) {
            super.splode();
            int[] ai = new int[]{(int)this.x, (int)Math.round(this.x)};
            int[] ai1 = new int[]{(int)this.y, (int)Math.round(this.y)};
            int[] ai2 = new int[]{(int)this.z, (int)Math.round(this.z)};

            for(int i = 0; i < 2; ++i) {
                for(int j = 0; j < 2; ++j) {
                    for(int k = 0; k < 2; ++k) {
                        if(this.world.getBlockId(ai[i], ai1[j], ai2[k]) == 0 && this.world.getBlockId(ai[i], ai1[j] - 1, ai2[k]) != 0) {
                            this.world.playSound((double)ai[i] + 0.5D, (double)ai1[j] + 0.5D, (double)ai2[k] + 0.5D, "fire.ignite", 1.0F, this.random.nextFloat() * 0.4F + 0.8F);
                            this.world.setBlock(ai[i], ai1[j], ai2[k], Block.FIRE.id);
                        }
                    }
                }
            }
        }

    }
}