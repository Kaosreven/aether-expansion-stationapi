package io.github.kaosreven.aetherex.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.ArrayList;

public class Aerplosion extends Explosion {
    public World aerworldObj;

    public Aerplosion(World world, Entity entity, double d, double d1, double d2, float f) {
        super(world, entity, d, d1, d2, f);
        this.aerworldObj = world;
    }

    @Override
    public void playExplosionSound(boolean aerplosion) {
        this.aerworldObj.playSound(this.x, this.y, this.z, "random.explode", 4.0F, (1.0F + (this.aerworldObj.random.nextFloat() - this.aerworldObj.random.nextFloat()) * 0.2F) * 0.7F);
        ArrayList var2 = new ArrayList();
        var2.addAll(this.damagedBlocks);

        for(int var3 = var2.size() - 1; var3 >= 0; --var3) {
            BlockPos var4 = (BlockPos)var2.get(var3);
            int var5 = var4.x;
            int var6 = var4.y;
            int var7 = var4.z;
            this.aerworldObj.getBlockId(var5, var6, var7);
            if(aerplosion) {
                double var9 = (float)var5 + this.aerworldObj.random.nextFloat();
                double var11 = (float)var6 + this.aerworldObj.random.nextFloat();
                double var13 = (float)var7 + this.aerworldObj.random.nextFloat();
                double var15 = var9 - this.x;
                double var17 = var11 - this.y;
                double var19 = var13 - this.z;
                double var21 = MathHelper.sqrt(var15 * var15 + var17 * var17 + var19 * var19);
                var15 /= var21;
                var17 /= var21;
                var19 /= var21;
                double var23 = 0.5D / (var21 / (double)this.power + 0.1D);
                var23 *= (this.aerworldObj.random.nextFloat() * this.aerworldObj.random.nextFloat() + 0.3F);
                var15 *= var23;
                var17 *= var23;
                var19 *= var23;
                if(!this.aerworldObj.isRemote) {
                    this.aerworldObj.addParticle("explode", (var9 + this.x * 1.0D) / 2.0D, (var11 + this.y * 1.0D) / 2.0D, (var13 + this.z * 1.0D) / 2.0D, var15, var17, var19);
                    this.aerworldObj.addParticle("smoke", var9, var11, var13, var15, var17, var19);
                }
            }
        }

    }
}
