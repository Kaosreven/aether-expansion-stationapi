package io.github.kaosreven.aetherex.entity.projectile;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class EntityLightningUnholyArrow extends Entity {
    private int xTile = -1;
    private int yTile = -1;
    private int zTile = -1;
    private int inTile = 0;
    private int inData = 0;
    private boolean inGround = false;
    public boolean doesArrowBelongToPlayer = false;
    public int arrowShake = 0;
    public LivingEntity owner;
    private int ticksInGround;
    private int ticksInAir = 0;

    public EntityLightningUnholyArrow(World world) {
        super(world);
        this.setBoundingBoxSpacing(0.5F, 0.5F);
    }

    public EntityLightningUnholyArrow(World world, double d, double d1, double d2) {
        super(world);
        this.setBoundingBoxSpacing(0.5F, 0.5F);
        this.setPositionAndAngles(d, d1, d2, this.yaw, this.pitch);
        this.standingEyeHeight = 0.0F;
    }

    public EntityLightningUnholyArrow(World world, double d, double d1, double d2, LivingEntity entityliving) {
        super(world);
        this.owner = entityliving;
        this.doesArrowBelongToPlayer = entityliving instanceof PlayerEntity;
        this.setBoundingBoxSpacing(0.5F, 0.5F);
        this.setPositionAndAnglesKeepPrevAngles(entityliving.x, entityliving.y + (double)entityliving.getEyeHeight(), entityliving.z, entityliving.yaw, entityliving.pitch);
        this.x -= (MathHelper.cos(this.yaw / 180.0F * 3.141593F) * 0.16F);
        this.y -= 0.1F;
        this.z -= (MathHelper.sin(this.yaw / 180.0F * 3.141593F) * 0.16F);
        this.setPositionAndAngles(d, d1, d2, this.yaw, this.pitch);
        this.standingEyeHeight = 0.0F;
        this.velocityX = (-MathHelper.sin(this.yaw / 180.0F * 3.141593F) * MathHelper.cos(this.pitch / 180.0F * 3.141593F));
        this.velocityZ = (MathHelper.cos(this.yaw / 180.0F * 3.141593F) * MathHelper.cos(this.pitch / 180.0F * 3.141593F));
        this.velocityY = (-MathHelper.sin(this.pitch / 180.0F * 3.141593F));
        this.setArrowHeading(this.velocityX, this.velocityY, this.velocityZ, 1.5F, 1.0F);
    }

    public EntityLightningUnholyArrow(World world, double d, double d1, double d2, LivingEntity entityliving, float yaw, float pitch) {
        super(world);
        this.owner = entityliving;
        this.doesArrowBelongToPlayer = entityliving instanceof PlayerEntity;
        this.setBoundingBoxSpacing(0.5F, 0.5F);
        this.setPositionAndAnglesKeepPrevAngles(entityliving.x, entityliving.y + (double)entityliving.getEyeHeight(), entityliving.z, yaw, pitch);
        this.x -= (MathHelper.cos(yaw / 180.0F * 3.141593F) * 0.16F);
        this.y -= 0.1F;
        this.z -= (MathHelper.sin(yaw / 180.0F * 3.141593F) * 0.16F);
        this.setPositionAndAngles(d, d1, d2, yaw, pitch);
        this.standingEyeHeight = 0.0F;
        this.velocityX = (-MathHelper.sin(yaw / 180.0F * 3.141593F) * MathHelper.cos(yaw / 180.0F * 3.141593F));
        this.velocityZ = (MathHelper.cos(yaw / 180.0F * 3.141593F) * MathHelper.cos(pitch / 180.0F * 3.141593F));
        this.velocityY = (-MathHelper.sin(pitch / 180.0F * 3.141593F));
        this.setArrowHeading(this.velocityX, this.velocityY, this.velocityZ, 1.5F, 1.0F);
    }

    public EntityLightningUnholyArrow(World world, LivingEntity entityliving) {
        super(world);
        this.owner = entityliving;
        this.doesArrowBelongToPlayer = entityliving instanceof PlayerEntity;
        this.setBoundingBoxSpacing(0.5F, 0.5F);
        this.setPositionAndAnglesKeepPrevAngles(entityliving.x, entityliving.y + (double)entityliving.getEyeHeight(), entityliving.z, entityliving.yaw, entityliving.pitch);
        this.x -= (MathHelper.cos(this.yaw / 180.0F * 3.141593F) * 0.16F);
        this.y -= 0.1F;
        this.z -= (MathHelper.sin(this.yaw / 180.0F * 3.141593F) * 0.16F);
        this.setPositionAndAngles(this.x, this.y, this.z, this.yaw, this.pitch);
        this.standingEyeHeight = 0.0F;
        this.velocityX = (-MathHelper.sin(this.yaw / 180.0F * 3.141593F) * MathHelper.cos(this.pitch / 180.0F * 3.141593F));
        this.velocityZ = (MathHelper.cos(this.yaw / 180.0F * 3.141593F) * MathHelper.cos(this.pitch / 180.0F * 3.141593F));
        this.velocityY = (-MathHelper.sin(this.pitch / 180.0F * 3.141593F));
        this.setArrowHeading(this.velocityX, this.velocityY, this.velocityZ, 1.5F, 1.0F);
    }

    public void setArrowHeading(double d, double d1, double d2, float f, float f1) {
        float f2 = MathHelper.sqrt(d * d + d1 * d1 + d2 * d2);
        d /= f2;
        d1 /= f2;
        d2 /= f2;
        d += this.random.nextGaussian() * (double)0.0075F * (double)f1;
        d1 += this.random.nextGaussian() * (double)0.0075F * (double)f1;
        d2 += this.random.nextGaussian() * (double)0.0075F * (double)f1;
        d *= f;
        d1 *= f;
        d2 *= f;
        this.velocityX = d;
        this.velocityY = d1;
        this.velocityZ = d2;
        float f3 = MathHelper.sqrt(d * d + d2 * d2);
        this.prevYaw = this.yaw = (float)(Math.atan2(d, d2) * 180.0D / (double)((float)Math.PI));
        this.prevPitch = this.pitch = (float)(Math.atan2(d1, f3) * 180.0D / (double)((float)Math.PI));
        this.ticksInGround = 0;
    }

    public void setVelocityClient(double d, double d1, double d2) {
        this.velocityX = d;
        this.velocityY = d1;
        this.velocityZ = d2;
        if(this.prevPitch == 0.0F && this.prevYaw == 0.0F) {
            float f = MathHelper.sqrt(d * d + d2 * d2);
            this.prevYaw = this.yaw = (float)(Math.atan2(d, d2) * 180.0D / (double)((float)Math.PI));
            this.prevPitch = this.pitch = (float)(Math.atan2(d1, f) * 180.0D / (double)((float)Math.PI));
            this.prevPitch = this.pitch;
            this.prevYaw = this.yaw;
            this.setPositionAndAnglesKeepPrevAngles(this.x, this.y, this.z, this.yaw, this.pitch);
            this.ticksInGround = 0;
        }

    }

    public void tick() {
        super.tick();
        if(this.prevPitch == 0.0F && this.prevYaw == 0.0F) {
            float i = MathHelper.sqrt(this.velocityX * this.velocityX + this.velocityZ * this.velocityZ);
            this.prevYaw = this.yaw = (float)(Math.atan2(this.velocityX, this.velocityZ) * 180.0D / (double)((float)Math.PI));
            this.prevPitch = this.pitch = (float)(Math.atan2(this.velocityY, i) * 180.0D / (double)((float)Math.PI));
        }

        int var16 = this.world.getBlockId(this.xTile, this.yTile, this.zTile);
        if(var16 > 0) {
            Block.BLOCKS[var16].updateBoundingBox(this.world, this.xTile, this.yTile, this.zTile);
            Box Vec3D = Block.BLOCKS[var16].getCollisionShape(this.world, this.xTile, this.yTile, this.zTile);
            if(Vec3D != null && Vec3D.contains(Vec3d.createCached(this.x, this.y, this.z))) {
                this.inGround = true;
            }
        }

        if(this.arrowShake > 0) {
            --this.arrowShake;
        }

        if(this.inGround) {
            int var18 = this.world.getBlockId(this.xTile, this.yTile, this.zTile);
            int var19 = this.world.getBlockMeta(this.xTile, this.yTile, this.zTile);
            if(var18 == this.inTile && var19 == this.inData) {
                ++this.ticksInGround;
                if(this.ticksInGround == 1200) {
                    this.markDead();
                }

            } else {
                this.inGround = false;
                this.velocityX *= (this.random.nextFloat() * 0.2F);
                this.velocityY *= (this.random.nextFloat() * 0.2F);
                this.velocityZ *= (this.random.nextFloat() * 0.2F);
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
        } else {
            ++this.ticksInAir;
            Vec3d var17 = Vec3d.createCached(this.x, this.y, this.z);
            Vec3d Vec3d1 = Vec3d.createCached(this.x + this.velocityX, this.y + this.velocityY, this.z + this.velocityZ);
            HitResult movingobjectposition = this.world.raycast(var17, Vec3d1, false, true);
            var17 = Vec3d.createCached(this.x, this.y, this.z);
            Vec3d1 = Vec3d.createCached(this.x + this.velocityX, this.y + this.velocityY, this.z + this.velocityZ);
            if(movingobjectposition != null) {
                Vec3d1 = Vec3d.createCached(movingobjectposition.pos.x, movingobjectposition.pos.y, movingobjectposition.pos.z);
            }

            Entity entity = null;
            List list = this.world.getEntities(this, this.boundingBox.stretch(this.velocityX, this.velocityY, this.velocityZ).expand(1.0D, 1.0D, 1.0D));
            double d = 0.0D;

            int f2;
            float f5;
            for(f2 = 0; f2 < list.size(); ++f2) {
                Entity f3 = (Entity)list.get(f2);
                if(f3.isCollidable() && (f3 != this.owner || this.ticksInAir >= 5)) {
                    f5 = 0.3F;
                    Box i1 = f3.boundingBox.expand(f5, f5, f5);
                    HitResult f6 = i1.raycast(var17, Vec3d1);
                    if(f6 != null) {
                        double d1 = var17.distanceTo(f6.pos);
                        if(d1 < d || d == 0.0D) {
                            entity = f3;
                            d = d1;
                        }
                    }
                }
            }

            if(entity != null) {
                movingobjectposition = new HitResult(entity);
            }

            float var20;
            int var24;
            if(movingobjectposition != null) {
                int var21;
                int var23;
                if(movingobjectposition.entity != null) {
                    if(movingobjectposition.entity.damage(this.owner, 4)) {
                        if(!this.world.isRemote) {
                            double var10004 = ((int)movingobjectposition.entity.x);
                            double var10005 = ((int)movingobjectposition.entity.y);
                            this.world.spawnEntity(new LightningEntity(this.world, var10004, var10005, ((int)movingobjectposition.entity.z)));
                        }
                        this.tickInVoid();
                        this.markDead();
                    } else {
                        this.velocityX *= -0.1F;
                        this.velocityY *= -0.1F;
                        this.velocityZ *= -0.1F;
                        this.yaw += 180.0F;
                        this.prevYaw += 180.0F;
                        this.ticksInAir = 0;
                    }
                } else {
                    this.xTile = movingobjectposition.blockX;
                    this.yTile = movingobjectposition.blockY;
                    this.zTile = movingobjectposition.blockZ;
                    this.inTile = this.world.getBlockId(this.xTile, this.yTile, this.zTile);
                    this.inData = this.world.getBlockMeta(this.xTile, this.yTile, this.zTile);
                    this.velocityX = ((float)(movingobjectposition.pos.x - this.x));
                    this.velocityY = ((float)(movingobjectposition.pos.y - this.y));
                    this.velocityZ = ((float)(movingobjectposition.pos.z - this.z));
                    var20 = MathHelper.sqrt(this.velocityX * this.velocityX + this.velocityY * this.velocityY + this.velocityZ * this.velocityZ);
                    this.x -= this.velocityX / (double)var20 * (double)0.05F;
                    this.y -= this.velocityY / (double)var20 * (double)0.05F;
                    this.z -= this.velocityZ / (double)var20 * (double)0.05F;
                    var21 = MathHelper.floor(this.x);
                    var23 = MathHelper.floor(this.y);
                    var24 = MathHelper.floor(this.z);
                    if(!this.world.isRemote) {
                        this.world.spawnEntity(new LightningEntity(this.world, var21, var23, var24));
                    }

                    this.inGround = true;
                    this.arrowShake = 7;
                    this.tickInVoid();
                }
            }

            this.x += this.velocityX;
            this.y += this.velocityY;
            this.z += this.velocityZ;
            var20 = MathHelper.sqrt(this.velocityX * this.velocityX + this.velocityZ * this.velocityZ);
            this.yaw = (float)(Math.atan2(this.velocityX, this.velocityZ) * 180.0D / (double)((float)Math.PI));

            for(this.pitch = (float)(Math.atan2(this.velocityY, var20) * 180.0D / (double)((float)Math.PI)); this.pitch - this.prevPitch < -180.0F; this.prevPitch -= 360.0F) {
            }

            while(this.pitch - this.prevPitch >= 180.0F) {
                this.prevPitch += 360.0F;
            }

            while(this.yaw - this.prevYaw < -180.0F) {
                this.prevYaw -= 360.0F;
            }

            while(this.yaw - this.prevYaw >= 180.0F) {
                this.prevYaw += 360.0F;
            }

            this.pitch = this.prevPitch + (this.pitch - this.prevPitch) * 0.2F;
            this.yaw = this.prevYaw + (this.yaw - this.prevYaw) * 0.2F;
            float var22 = 0.99F;
            f5 = 0.03F;
            if(this.isSubmergedInWater()) {
                for(var24 = 0; var24 < 4; ++var24) {
                    float var25 = 0.25F;
                    this.world.addParticle("bubble", this.x - this.velocityX * (double)var25, this.y - this.velocityY * (double)var25, this.z - this.velocityZ * (double)var25, this.velocityX, this.velocityY, this.velocityZ);
                }

                var22 = 0.8F;
            }

            this.velocityX *= var22;
            this.velocityY *= var22;
            this.velocityZ *= var22;
            this.velocityY -= f5;
            this.setPositionAndAngles(this.x, this.y, this.z, this.yaw, this.pitch);
        }
    }

    public void writeNbt(NbtCompound nbttagcompound) {
        nbttagcompound.putShort("xTile", (short)this.xTile);
        nbttagcompound.putShort("yTile", (short)this.yTile);
        nbttagcompound.putShort("zTile", (short)this.zTile);
        nbttagcompound.putByte("inTile", (byte)this.inTile);
        nbttagcompound.putByte("inData", (byte)this.inData);
        nbttagcompound.putByte("shake", (byte)this.arrowShake);
        nbttagcompound.putByte("inGround", (byte)(this.inGround ? 1 : 0));
        nbttagcompound.putBoolean("player", this.doesArrowBelongToPlayer);
    }

    public void readNbt(NbtCompound nbttagcompound) {
        this.xTile = nbttagcompound.getShort("xTile");
        this.yTile = nbttagcompound.getShort("yTile");
        this.zTile = nbttagcompound.getShort("zTile");
        this.inTile = nbttagcompound.getByte("inTile") & 255;
        this.inData = nbttagcompound.getByte("inData") & 255;
        this.arrowShake = nbttagcompound.getByte("shake") & 255;
        this.inGround = nbttagcompound.getByte("inGround") == 1;
        this.doesArrowBelongToPlayer = nbttagcompound.getBoolean("player");
    }

    public float getShadowRadius() {
        return 0.0F;
    }

    public void initDataTracker()  {
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inData = 0;
        this.inGround = false;
        this.doesArrowBelongToPlayer = false;
        this.arrowShake = 0;
        this.ticksInAir = 0;
        this.setBoundingBoxSpacing(0.5F, 0.5F);
        this.x -= (MathHelper.cos(this.yaw / 180.0F * 3.141593F) * 0.16F);
        this.y -= 0.1F;
        this.z -= (MathHelper.sin(this.yaw / 180.0F * 3.141593F) * 0.16F);
        this.setPositionAndAngles(this.x, this.y, this.z, this.yaw, this.pitch);
        this.trackedPosX = (int)(this.x * 32.0D);
        this.trackedPosY = (int)(this.y * 32.0D);
        this.trackedPosZ = (int)(this.z * 32.0D);
        this.standingEyeHeight = 0.0F;
        this.velocityX = (-MathHelper.sin(this.yaw / 180.0F * 3.141593F) * MathHelper.cos(this.pitch / 180.0F * 3.141593F));
        this.velocityZ = (MathHelper.cos(this.yaw / 180.0F * 3.141593F) * MathHelper.cos(this.pitch / 180.0F * 3.141593F));
        this.velocityY = (-MathHelper.sin(this.pitch / 180.0F * 3.141593F));
        this.setArrowHeading(this.velocityX, this.velocityY, this.velocityZ, 1.5F, 1.0F);
    }
}
