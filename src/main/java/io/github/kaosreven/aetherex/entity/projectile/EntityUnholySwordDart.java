package io.github.kaosreven.aetherex.entity.projectile;

import com.matthewperiut.aether.entity.projectile.EntityDartPoison;
import com.matthewperiut.aether.poison.AetherPoison;
import com.matthewperiut.aether.poison.PoisonControl;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.server.entity.HasTrackingParameters;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.TriState;

import static io.github.kaosreven.aetherex.entity.AetherExEntities.MOD_ID;

@HasTrackingParameters(trackingDistance = 50, sendVelocity = TriState.TRUE, updatePeriod = 1)
public class EntityUnholySwordDart extends EntityDartPoison {

    public EntityUnholySwordDart(World world) {
        super(world);
    }

    public EntityUnholySwordDart(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    public EntityUnholySwordDart(World world, LivingEntity ent) {
        super(world, ent);
    }

    @Override
    public void initDataTracker() {
        super.initDataTracker();
        this.item = null;
        this.dmg = 3;
    }

    @Override
    public boolean onHitTarget(Entity target) {
        if (target instanceof AetherPoison poison) {
            poison.getPoison().afflictPoison();
            dead = false;
            despawnTime = PoisonControl.maxPoisonTime;
            this.world.spawnEntity(new LightningEntity(this.world, target.x, target.y, target.z));
            markDead();
        }
        return super.onHitTarget(target);
    }

    @Override
    public boolean onHitBlock() {
        this.curvature = 0.03F;
        this.world.playSound(this, "random.drr", 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
        this.world.spawnEntity(new LightningEntity(this.world, this.x, this.y, this.z));
        markDead();
        return this.victim == null;
    }

    @Override
    public Identifier getHandlerIdentifier() {
        return MOD_ID.id("UnholySwordDart");
    }
}
