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
import net.minecraft.world.explosion.Explosion;

import static io.github.kaosreven.aetherex.item.tool.ItemUnholyBow.BowMode;

import java.util.List;

public class EntityUnholyArrow extends Entity
{

    public EntityUnholyArrow(World world)
    {
        super(world);
        xTile = -1;
        yTile = -1;
        zTile = -1;
        inTile = 0;
        inData = 0;
        inGround = false;
        doesArrowBelongToPlayer = false;
        arrowShake = 0;
        ticksInAir = 0;
        setBoundingBoxSpacing(0.5F, 0.5F);
    }

    public EntityUnholyArrow(World world, double d, double d1, double d2)
    {
        super(world);
        xTile = -1;
        yTile = -1;
        zTile = -1;
        inTile = 0;
        inData = 0;
        inGround = false;
        doesArrowBelongToPlayer = false;
        arrowShake = 0;
        ticksInAir = 0;
        setBoundingBoxSpacing(0.5F, 0.5F);
        setPositionAndAngles(d, d1, d2, yaw, pitch);
        standingEyeHeight = 0.0F;
        
    }

    public EntityUnholyArrow (World world, LivingEntity entityliving, BowMode mode)
    {
        super(world);
        xTile = -1;
        yTile = -1;
        zTile = -1;
        inTile = 0;
        inData = 0;
        inGround = false;
        doesArrowBelongToPlayer = false;
        arrowShake = 0;
        ticksInAir = 0;
        owner = entityliving;
        doesArrowBelongToPlayer = entityliving instanceof PlayerEntity;
        setBoundingBoxSpacing(0.5F, 0.5F);
        setPositionAndAnglesKeepPrevAngles(entityliving.x, entityliving.y + (double)entityliving.getEyeHeight(), entityliving.z, entityliving.yaw, entityliving.pitch);
        x -= MathHelper.cos((yaw / 180F) * 3.141593F) * 0.16F;
        y -= 0.10000000149011612D;
        z -= MathHelper.sin((yaw / 180F) * 3.141593F) * 0.16F;
        setPositionAndAngles(x, y, z, yaw, pitch);
        standingEyeHeight = 0.0F;
        velocityX = -MathHelper.sin((yaw / 180F) * 3.141593F) * MathHelper.cos((pitch / 180F) * 3.141593F);
        velocityZ = MathHelper.cos((yaw / 180F) * 3.141593F) * MathHelper.cos((pitch / 180F) * 3.141593F);
        velocityY = -MathHelper.sin((pitch / 180F) * 3.141593F);
        setArrowHeading(velocityX, velocityY, velocityZ, 1.5F, 1.0F);
        this.mode = mode;
    }

    @Override
    protected void initDataTracker()
    {
    }

    public void setArrowHeading(double d, double d1, double d2, float f,
            float f1)
    {
        float f2 = MathHelper.sqrt(d * d + d1 * d1 + d2 * d2);
        d /= f2;
        d1 /= f2;
        d2 /= f2;
        d += random.nextGaussian() * 0.0074999998323619366D * (double)f1;
        d1 += random.nextGaussian() * 0.0074999998323619366D * (double)f1;
        d2 += random.nextGaussian() * 0.0074999998323619366D * (double)f1;
        d *= f;
        d1 *= f;
        d2 *= f;
        velocityX = d;
        velocityY = d1;
        velocityZ = d2;
        float f3 = MathHelper.sqrt(d * d + d2 * d2);
        prevYaw = yaw = (float)((Math.atan2(d, d2) * 180D) / 3.1415927410125732D);
        prevPitch = pitch = (float)((Math.atan2(d1, f3) * 180D) / 3.1415927410125732D);
        ticksInGround = 0;
    }

    @Override
    public void setVelocityClient(double d, double d1, double d2)
    {
        velocityX = d;
        velocityY = d1;
        velocityZ = d2;
        if(prevPitch == 0.0F && prevYaw == 0.0F)
        {
            float f = MathHelper.sqrt(d * d + d2 * d2);
            prevYaw = yaw = (float)((Math.atan2(d, d2) * 180D) / 3.1415927410125732D);
            prevPitch = pitch = (float)((Math.atan2(d1, f) * 180D) / 3.1415927410125732D);
            prevPitch = pitch;
            prevYaw = yaw;
            setPositionAndAnglesKeepPrevAngles(x, y, z, yaw, pitch);
            ticksInGround = 0;
        }
    }

    @SuppressWarnings("rawtypes")
    @Override
	public void tick()
    {
        super.tick();
        if(prevPitch == 0.0F && prevYaw == 0.0F)
        {
            float f = MathHelper.sqrt(velocityX * velocityX + velocityZ * velocityZ);
            prevYaw = yaw = (float)((Math.atan2(velocityX, velocityZ) * 180D) / 3.1415927410125732D);
            prevPitch = pitch = (float)((Math.atan2(velocityY, f) * 180D) / 3.1415927410125732D);
        }
        int i = world.getBlockId(xTile, yTile, zTile);
        if(i > 0)
        {
            Block.BLOCKS[i].updateBoundingBox(world, xTile, yTile, zTile);
            Box box = Block.BLOCKS[i].getCollisionShape(world, xTile, yTile, zTile);
            if(box != null && box.contains(Vec3d.createCached(x, y, z)))
            {
                inGround = true;
            }
        }
        if(arrowShake > 0)
        {
            arrowShake--;
        }
        if(inGround)
        {
            int j = world.getBlockId(xTile, yTile, zTile);
            int k = world.getBlockMeta(xTile, yTile, zTile);
            if(j != inTile || k != inData)
            {
                inGround = false;
                velocityX *= random.nextFloat() * 0.2F;
                velocityY *= random.nextFloat() * 0.2F;
                velocityZ *= random.nextFloat() * 0.2F;
                ticksInGround = 0;
                ticksInAir = 0;
                return;
            }
            ticksInGround++;
            if(ticksInGround == 1200)
            {
                markDead();
            }
            return;
        }
        ticksInAir++;
        Vec3d vec3d = Vec3d.createCached(x, y, z);
        Vec3d vec3d1 = Vec3d.createCached(x + velocityX, y + velocityY, z + velocityZ);
        HitResult movingobjectposition = world.raycast(vec3d, vec3d1, false, true);
        vec3d = Vec3d.createCached(x, y, z);
        vec3d1 = Vec3d.createCached(x + velocityX, y + velocityY, z + velocityZ);
        if(movingobjectposition != null)
        {
            vec3d1 = Vec3d.createCached(movingobjectposition.pos.x, movingobjectposition.pos.y, movingobjectposition.pos.z);
        }
        Entity entity = null;
        List list = world.getEntities(this, boundingBox.stretch(velocityX, velocityY, velocityZ).expand(1.0D, 1.0D, 1.0D));
        double d = 0.0D;
        for(int l = 0; l < list.size(); l++)
        {
            Entity entity1 = (Entity)list.get(l);
            if(!entity1.isCollidable() || entity1 == owner && ticksInAir < 5)
            {
                continue;
            }
            float f4 = 0.3F;
            Box axisalignedbb1 = entity1.boundingBox.expand(f4, f4, f4);
            HitResult movingobjectposition1 = axisalignedbb1.raycast(vec3d, vec3d1);
            if(movingobjectposition1 == null)
            {
                continue;
            }
            double d1 = vec3d.distanceTo(movingobjectposition1.pos);
            if(d1 < d || d == 0.0D)
            {
                entity = entity1;
                d = d1;
            }
        }

        if(entity != null)
        {
            movingobjectposition = new HitResult(entity);
        }
        if(movingobjectposition != null)
        {
            if(movingobjectposition.entity != null)
            {
                if(movingobjectposition.entity.damage(owner, mode.damage))
                {
                	if (!world.isRemote) {
                        if(mode == BowMode.LIGHTNING)
                            world.spawnEntity(new LightningEntity(world, (int)movingobjectposition.entity.x, (int)movingobjectposition.entity.y, (int)movingobjectposition.entity.z));
                        else if (mode == BowMode.EXPLOSIVE) {
                            Explosion explosion = new Explosion(world, owner, x, y, z, 2.5F);
                            explosion.explode();
                            explosion.playExplosionSound(true);
                        }
                	}
                    this.tickInVoid();
                    markDead();
                } else
                {
                    velocityX *= -0.10000000149011612D;
                    velocityY *= -0.10000000149011612D;
                    velocityZ *= -0.10000000149011612D;
                    yaw += 180F;
                    prevYaw += 180F;
                    ticksInAir = 0;
                }
            } else
            {
                xTile = movingobjectposition.blockX;
                yTile = movingobjectposition.blockY;
                zTile = movingobjectposition.blockZ;
                inTile = world.getBlockId(xTile, yTile, zTile);
                inData = world.getBlockMeta(xTile, yTile, zTile);
                velocityX = (float)(movingobjectposition.pos.x - x);
                velocityY = (float)(movingobjectposition.pos.y - y);
                velocityZ = (float)(movingobjectposition.pos.z - z);
                float f1 = MathHelper.sqrt(velocityX * velocityX + velocityY * velocityY + velocityZ * velocityZ);
                x -= (velocityX / (double)f1) * 0.05000000074505806D;
                y -= (velocityY / (double)f1) * 0.05000000074505806D;
                z -= (velocityZ / (double)f1) * 0.05000000074505806D;
                int xPos = MathHelper.floor(x);
                int yPos = MathHelper.floor(y);
                int zPos = MathHelper.floor(z);
                if (!world.isRemote) {
                    if (mode == BowMode.LIGHTNING)
                        world.spawnEntity(new LightningEntity(world, xPos, yPos, zPos));
                    else if (mode == BowMode.EXPLOSIVE) {
                        Explosion explosion = new Explosion(world, owner, xPos, yPos, zPos, 2.5F);
                        explosion.explode();
                        explosion.playExplosionSound(true);
                    }
                }
                inGround = true;
                arrowShake = 7;
                this.tickInVoid();
            }
        }
        x += velocityX;
        y += velocityY;
        z += velocityZ;
        float f2 = MathHelper.sqrt(velocityX * velocityX + velocityZ * velocityZ);
        yaw = (float)((Math.atan2(velocityX, velocityZ) * 180D) / 3.1415927410125732D);
        for(pitch = (float)((Math.atan2(velocityY, f2) * 180D) / 3.1415927410125732D); pitch - prevPitch < -180F; prevPitch -= 360F) { }
        for(; pitch - prevPitch >= 180F; prevPitch += 360F) { }
        for(; yaw - prevYaw < -180F; prevYaw -= 360F) { }
        for(; yaw - prevYaw >= 180F; prevYaw += 360F) { }
        pitch = prevPitch + (pitch - prevPitch) * 0.2F;
        yaw = prevYaw + (yaw - prevYaw) * 0.2F;
        float f3 = 0.99F;
        float f5 = 0.03F;
        if(isSubmergedInWater())
        {
            for(int i1 = 0; i1 < 4; i1++)
            {
                float f6 = 0.25F;
                world.addParticle("bubble", x - velocityX * (double)f6, y - velocityY * (double)f6, z - velocityZ * (double)f6, velocityX, velocityY, velocityZ);
            }

            f3 = 0.8F;
        }
        velocityX *= f3;
        velocityY *= f3;
        velocityZ *= f3;
        velocityY -= f5;
        setPositionAndAngles(x, y, z, yaw, pitch);
    }

    @Override
    public void writeNbt(NbtCompound nbttagcompound)
    {
        nbttagcompound.putShort("xTile", (short)xTile);
        nbttagcompound.putShort("yTile", (short)yTile);
        nbttagcompound.putShort("zTile", (short)zTile);
        nbttagcompound.putByte("inTile", (byte)inTile);
        nbttagcompound.putByte("inData", (byte)inData);
        nbttagcompound.putByte("shake", (byte)arrowShake);
        nbttagcompound.putByte("inGround", (byte)(inGround ? 1 : 0));
        nbttagcompound.putBoolean("player", doesArrowBelongToPlayer);
        nbttagcompound.putString("mode", mode.name());
    }

    @Override
    public void readNbt(NbtCompound nbttagcompound)
    {
        xTile = nbttagcompound.getShort("xTile");
        yTile = nbttagcompound.getShort("yTile");
        zTile = nbttagcompound.getShort("zTile");
        inTile = nbttagcompound.getByte("inTile") & 0xff;
        inData = nbttagcompound.getByte("inData") & 0xff;
        arrowShake = nbttagcompound.getByte("shake") & 0xff;
        inGround = nbttagcompound.getByte("inGround") == 1;
        doesArrowBelongToPlayer = nbttagcompound.getBoolean("player");
        mode = BowMode.valueOf(nbttagcompound.getString("mode"));
    }
    
    @Override
    public float getShadowRadius()
    {
        return 0.0F;
    }

    private int xTile;
    private int yTile;
    private int zTile;
    private int inTile;
    private int inData;
    private boolean inGround;
    public boolean doesArrowBelongToPlayer;
    public int arrowShake;
    public LivingEntity owner;
    private int ticksInGround;
    private int ticksInAir;
    private BowMode mode = BowMode.LIGHTNING;
}