package io.github.kaosreven.aetherex.entity;

import com.matthewperiut.aether.block.UtilSkyroot;
import com.matthewperiut.aether.entity.MountInput;
import com.matthewperiut.aether.entity.living.EntityAetherAnimal;
import com.matthewperiut.aether.item.AetherItems;
import com.matthewperiut.aether.mixin.access.EntityAccessor;
import io.github.kaosreven.aetherex.achievement.AetherExAchievements;
import io.github.kaosreven.aetherex.item.AetherExItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.server.entity.MobSpawnDataProvider;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.HashMap;

import static com.matthewperiut.aether.entity.AetherEntities.MOD_ID;

public class EntityOrangeMoa extends EntityAetherAnimal implements MobSpawnDataProvider, MountInput {
    private float mountForward;
    private float mountStrafe;
    private boolean mountJump;
    private float mountYaw;
    private float mountPitch;
    public float field_752_b;
    public float destPos;
    public float field_757_d;
    public float field_756_e;
    public float field_755_h;
    public int jrem;
    int petalsEaten;
    boolean wellFed;
    boolean followPlayer;
    public boolean jpress;
    public boolean baby;
    public boolean grown;
    public boolean saddled;
    private static HashMap<Integer, String> armorList = new HashMap<>();

    public EntityOrangeMoa(World world) {
        this(world, false, false, false);
    }

    public EntityOrangeMoa(World world, boolean babyBool, boolean grownBool, boolean saddledBool) {
        super(world);
        this.petalsEaten = 0;
        this.wellFed = false;
        this.followPlayer = false;
        this.baby = false;
        this.grown = false;
        this.saddled = false;
        this.destPos = 0.0F;
        this.field_755_h = 1.0F;
        this.stepHeight = 1.0F;
        this.jrem = 0;
        this.baby = babyBool;
        this.grown = grownBool;
        this.saddled = saddledBool;
        if (this.baby) {
            this.setBoundingBoxSpacing(0.4F, 0.5F);
        }
        this.texture = getTexture(this.saddled);
        this.setBoundingBoxSpacing(1.0F, 2.0F);
        this.health = 40;
        syncMoaState();
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(16, (byte) 0);  // state bits
        //this.dataTracker.startTracking(17, 0);         // colour ID
        this.dataTracker.startTracking(18, (byte) 0);  // jrem
        this.dataTracker.startTracking(19, (byte) 3);  // upgrades
        this.dataTracker.startTracking(20, (byte) 3);  // upgrade increases
        this.dataTracker.startTracking(21, (byte) 0);  // fireball
        this.dataTracker.startTracking(22, (byte) 0);  // shoot
        this.dataTracker.startTracking(23, (byte) -1);  // armor
        this.dataTracker.startTracking(24, (byte) 5);  // max jumps
    }

    public boolean getFireball() {
        return (this.dataTracker.getByte(21) & 1) != 0;
    }

    public void setFireball(boolean flag) {
        if(flag) {
            this.dataTracker.set(21, (byte) 1);
        } else {
            this.dataTracker.set(21, (byte) 0);
        }
    }

    public byte getUpgradeIncrease() {
        return this.dataTracker.getByte(20);
    }

    public void setUpgradeIncrease(int i) {
        this.dataTracker.set(20, (byte) i);
    }

    public byte getUpgrades() {
        return this.dataTracker.getByte(19);
    }

    public void setUpgrades(int i) {
        this.dataTracker.set(19, (byte) i);
    }

    public int getArmor() {
        return this.dataTracker.getByte(23);
    }

    public void setArmor(int i) {
        this.dataTracker.set(23, (byte) i);
    }

    public byte getMaxJumps() {
        return this.dataTracker.getByte(24);
    }

    public void setMaxJumps(int i) {
        this.dataTracker.set(24, (byte) i);
    }

    private void syncMoaState() {
        byte state = 0;
        if (this.saddled) state |= 1;
        if (this.baby) state |= 2;
        if (this.grown) state |= 4;
        if (this.onGround) state |= 8;
        this.dataTracker.set(16, state);
        this.dataTracker.set(18, (byte) this.jrem);
    }

    private void updateMoaTexture() {
        byte state = this.dataTracker.getByte(16);
        boolean s = (state & 1) != 0;
        this.texture = getTexture(s);
    }

    public void tick() {
        super.tick();
        this.ignoreFrustumCull = this.passenger instanceof PlayerEntity;
        if (!this.world.isRemote) {
            syncMoaState();
        } else {
            this.jrem = this.dataTracker.getByte(18);
        }
        updateMoaTexture();
    }

    private boolean getSyncedOnGround() {
        return this.world.isRemote ? (this.dataTracker.getByte(16) & 8) != 0 : this.onGround;
    }

    public void tickMovement() {
        super.tickMovement();
        boolean grounded = getSyncedOnGround();
        this.field_756_e = this.field_752_b;
        this.field_757_d = this.destPos;
        this.destPos = (float) ((double) this.destPos + (double) (grounded ? -1 : 4) * 0.05);
        if (this.destPos < 0.01F) {
            this.destPos = 0.01F;
        }

        if (this.destPos > 1.0F) {
            this.destPos = 1.0F;
        }

        if (grounded) {
            this.destPos = 0.0F;
            this.jpress = false;
            this.jrem = this.getMaxJumps();
        }

        if (!grounded && this.field_755_h < 1.0F) {
            this.field_755_h = 1.0F;
        }

        this.field_755_h = (float) ((double) this.field_755_h * 0.9);
        if (!grounded && this.velocityY < 0.0) {
            if (this.passenger == null) {
                this.velocityY *= 0.6;
            } else {
                this.velocityY *= 0.6375;
            }
        }

        this.field_752_b += this.field_755_h * 2.0F;

        if (this.wellFed && this.random.nextInt(2000) == 0) {
            this.wellFed = false;
        }

        if (this.saddled && this.passenger == null) {
            this.movementSpeed = 0.0F;
        } else {
            this.movementSpeed = 0.7F;
        }

    }

    protected void onLanding(float f) {
    }

    public boolean damage(Entity entity, int i) {
        int armor = this.getArmor();
        if(armor == 0 || armor == 3) {
            i = (int)Math.round((double)i * 0.8D);
        }

        if(armor == 2 || armor == 4) {
            i = (int)Math.round((double)i * 0.75D);
        }

        if(armor == 1) {
            i = (int)Math.round((double)i * 0.85D);
        }
        boolean flag = super.damage(entity, i);
        if (flag && this.passenger != null && (this.health <= 0 || this.random.nextInt(3) == 0)) {
            this.passenger.setVehicle(null);
        }

        return flag;
    }

    public void tickLiving() {
        if (this.passenger != null && this.passenger instanceof LivingEntity) {
            this.forwardSpeed = 0.0F;
            this.sidewaysSpeed = 0.0F;
            this.jumping = false;
            ((EntityAccessor) this.passenger).setFallDistance(0.0F);
            this.prevYaw = this.yaw = this.mountYaw;
            this.prevPitch = this.pitch = this.mountPitch;
            this.bodyYaw = this.mountYaw;

            float forward = this.mountForward;
            float strafe = this.mountStrafe;
            boolean jump = this.mountJump;
            float riderYaw = this.mountYaw;

            float f1 = 3.141593F / 180.0F;
            float f5;
            if (forward > 0.1F || forward < -0.1F) {
                f5 = riderYaw * f1;
                this.velocityX += (double) forward * -Math.sin(f5) * 0.17499999701976776;
                this.velocityZ += (double) forward * Math.cos(f5) * 0.17499999701976776;
            }

            if (strafe > 0.1F || strafe < -0.1F) {
                f5 = riderYaw * f1;
                this.velocityX += (double) strafe * Math.cos(f5) * 0.17499999701976776;
                this.velocityZ += (double) strafe * Math.sin(f5) * 0.17499999701976776;
            }

            if (this.onGround && jump) {
                this.onGround = false;
                this.velocityY = 0.875;
                this.jpress = true;
                --this.jrem;
            } else if (this.checkWaterCollisions() && jump) {
                this.velocityY = 0.5;
                this.jpress = true;
                --this.jrem;
            } else if (this.jrem > 0 && !this.jpress && jump) {
                this.velocityY = 0.75;
                this.jpress = true;
                --this.jrem;
            }

            if (this.jpress && !jump) {
                this.jpress = false;
            }

            double d = Math.abs(Math.sqrt(this.velocityX * this.velocityX + this.velocityZ * this.velocityZ));
            if (d > 0.375) {
                double d1 = 0.375 / d;
                this.velocityX *= d1;
                this.velocityZ *= d1;
            }

        } else {
            super.tickLiving();
        }
    }

    @Override
    public float getMountForward() { return mountForward; }
    @Override
    public float getMountStrafe() { return mountStrafe; }
    @Override
    public boolean getMountJump() { return mountJump; }
    @Override
    public float getMountYaw() { return mountYaw; }
    @Override
    public float getMountPitch() { return mountPitch; }
    @Override
    public void setMountInput(float forward, float strafe, boolean jump, float yaw, float pitch) {
        this.mountForward = forward;
        this.mountStrafe = strafe;
        this.mountJump = jump;
        this.mountYaw = yaw;
        this.mountPitch = pitch;
    }

    public void writeNbt(NbtCompound nbttagcompound) {
        super.writeNbt(nbttagcompound);
        nbttagcompound.putShort("Remaining", (short) this.jrem);
        nbttagcompound.putBoolean("Baby", this.baby);
        nbttagcompound.putBoolean("Grown", this.grown);
        nbttagcompound.putBoolean("Saddled", this.saddled);
        nbttagcompound.putBoolean("wellFed", this.wellFed);
        nbttagcompound.putInt("petalsEaten", this.petalsEaten);
        nbttagcompound.putBoolean("followPlayer", this.followPlayer);
        nbttagcompound.putInt("Armor", this.getArmor());
        nbttagcompound.putByte("MaxJumps", this.getMaxJumps());
        nbttagcompound.putBoolean("Fireball", this.getFireball());
        nbttagcompound.putByte("Upgrades", this.getUpgrades());
        nbttagcompound.putByte("UpgradesIncrease", this.getUpgradeIncrease());
    }

    public void readNbt(NbtCompound nbttagcompound) {
        super.readNbt(nbttagcompound);
        this.jrem = nbttagcompound.getShort("Remaining");
        this.baby = nbttagcompound.getBoolean("Baby");
        this.grown = nbttagcompound.getBoolean("Grown");
        this.saddled = nbttagcompound.getBoolean("Saddled");
        this.wellFed = nbttagcompound.getBoolean("wellFed");
        this.petalsEaten = nbttagcompound.getInt("petalsEaten");
        this.followPlayer = nbttagcompound.getBoolean("followPlayer");
        this.setArmor(nbttagcompound.getInt("Armor"));
        this.setMaxJumps(nbttagcompound.getInt("MaxJumps"));
        this.setFireball(nbttagcompound.getBoolean("Fireball"));
        this.setUpgrades(nbttagcompound.getByte("Upgrades"));
        this.setUpgradeIncrease(nbttagcompound.getByte("UpgradesIncrease"));
        if (this.baby) {
            this.grown = false;
            this.saddled = false;
        }

        if (this.grown) {
            this.baby = false;
            this.saddled = false;
        }

        if (this.saddled) {
            this.baby = false;
            this.grown = false;
        }

        syncMoaState();
    }

    protected String getRandomSound() {
        return "aether:mobs.moa.idlecall";
    }

    protected String getHurtSound() {
        return "aether:mobs.moa.idlecall";
    }

    protected String getDeathSound() {
        return "aether:mobs.moa.idlecall";
    }

    public boolean interact(PlayerEntity entityplayer) {
        if (!this.saddled && this.grown && !this.baby && entityplayer.inventory.getSelectedItem() != null && entityplayer.inventory.getSelectedItem().itemId == Item.SADDLE.id) {
            entityplayer.inventory.setStack(entityplayer.inventory.selectedSlot, null);
            this.saddled = true;
            this.grown = false;
            syncMoaState();
            return true;
        } else if (this.saddled) {
            if (entityplayer.inventory.getSelectedItem() != null) {
                ItemStack upgradeItem = entityplayer.inventory.getSelectedItem();
                if (upgradeItem.itemId == AetherExItems.MoaArmor.id) {
                    AetherExAchievements.giveAchievement(AetherExAchievements.pimpMoa, entityplayer);
                    this.setArmor(upgradeItem.getDamage());
                    entityplayer.inventory.setStack(entityplayer.inventory.selectedSlot, null);
                    return true;
                }
                if (upgradeItem.itemId == AetherExItems.FlameGem.id) {
                    if (this.getUpgrades() <= 0 || this.getFireball()) {
                        return true;
                    }
                    AetherExAchievements.giveAchievement(AetherExAchievements.pimpMoa, entityplayer);
                    this.setUpgrades(this.getUpgrades() - 1);
                    this.setFireball(true);
                    entityplayer.inventory.setStack(entityplayer.inventory.selectedSlot, null);
                    return true;
                }
                if (upgradeItem.itemId == AetherItems.GoldenFeather.id) {
                    if(this.getUpgrades() <= 0 || this.getMaxJumps() >= 10) {
                        return true;
                    }
                    AetherExAchievements.giveAchievement(AetherExAchievements.pimpMoa, entityplayer);
                    this.setUpgrades(this.getUpgrades() - 1);
                    this.setMaxJumps(this.getMaxJumps() + 1);
                    entityplayer.inventory.setStack(entityplayer.inventory.selectedSlot, null);
                    return true;
                }
                if (upgradeItem.itemId == AetherExItems.VoidTomato.id) {
                    if(this.getUpgradeIncrease() <= 0) {
                        return true;
                    }
                    if(upgradeItem.count == 1) {
                        entityplayer.inventory.setStack(entityplayer.inventory.selectedSlot, null);
                    } else {
                        --upgradeItem.count;
                        entityplayer.inventory.setStack(entityplayer.inventory.selectedSlot, upgradeItem);
                    }
                    AetherExAchievements.giveAchievement(AetherExAchievements.pimpMoa, entityplayer);
                    this.setUpgradeIncrease(this.getUpgradeIncrease() - 1);
                    this.setUpgrades(this.getUpgrades() + 1);
                    return true;
                }
            } else if (!this.world.isRemote && (this.passenger == null || this.passenger == entityplayer)) {
                entityplayer.setVehicle(this);
                entityplayer.prevYaw = entityplayer.yaw = this.yaw;
                return true;
            }
        } else if (!this.wellFed && !this.saddled && this.baby && !this.grown) {
            ItemStack itemstack = entityplayer.inventory.getSelectedItem();
            if (itemstack != null && itemstack.itemId == AetherExItems.GoldenElixir.id) {
                ++this.petalsEaten;
                entityplayer.inventory.removeStack(entityplayer.inventory.selectedSlot, 1);
                if (this.petalsEaten > 1) {
                    this.grown = true;
                    this.baby = false;
                    syncMoaState();
                }

                this.wellFed = true;
            }

            return true;
        } else if (!this.saddled && (this.baby || this.grown)) {
                if (!this.followPlayer) {
                    this.followPlayer = true;
                    this.target = entityplayer;
                } else {
                    this.followPlayer = false;
                    this.target = null;
                }
            }
        return true;
    }

    public boolean canDespawn() {
        return !this.baby && !this.grown && !this.saddled;
    }

    protected boolean bypassesSteppingEffects() {
        return this.onGround;
    }

    protected void dropItems() {
        boolean skyrootSword = UtilSkyroot.sword(world.getClosestPlayer(x, y, z, 10));
        this.dropItem(Item.FEATHER.id, 3 * (skyrootSword ? 2 : 1));
    }

    public String getTexture(boolean saddled) {
        return "aetherex:stationapi/textures/mobs/" + (saddled ? armorList.get(this.getArmor()) : "OrangeMoa.png");
    }

    @Override
    public Identifier getHandlerIdentifier() {
        return MOD_ID.id("OrangeMoa");
    }

    static {
        armorList.put(-1, "OrangeSaddledMoa.png");
        armorList.put(0, "MosSaddle.png");
        armorList.put(1, "Gold_Armored_Moa_Saddled.png");
        armorList.put(2, "Diamond_Armored_Moa_Saddled.png");
        armorList.put(3, "Zanite_Armored_Moa_Saddled.png");
        armorList.put(4, "Gravitite_Armored_Moa_Saddled.png");
    }
}
