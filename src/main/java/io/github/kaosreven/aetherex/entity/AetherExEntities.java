package io.github.kaosreven.aetherex.entity;

import com.matthewperiut.aether.entity.living.EntityMoa;
import io.github.kaosreven.aetherex.entity.projectile.EntityExplosiveUnholyArrow;
import io.github.kaosreven.aetherex.entity.projectile.EntityFiroBallEx;
import io.github.kaosreven.aetherex.entity.projectile.EntityLightningUnholyArrow;
import io.github.kaosreven.aetherex.entity.projectile.EntityUnholySwordDart;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.entity.EntityRegisterEvent;
import net.modificationstation.stationapi.api.event.registry.EntityHandlerRegistryEvent;
import net.modificationstation.stationapi.api.event.registry.MobHandlerRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Registry;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class AetherExEntities {
    @Entrypoint.Namespace
    public static Namespace MOD_ID = Null.get();

    @EventListener
    public void registerEntities(EntityRegisterEvent event) {
        event.register(MOD_ID.id("FiroBallEx"), EntityFiroBallEx.class);
        event.register(MOD_ID.id("UnholyArrowLightning"), EntityLightningUnholyArrow.class);
        event.register(MOD_ID.id("UnholyArrowExplosive"), EntityExplosiveUnholyArrow.class);
        event.register(MOD_ID.id("UnholySwordDart"), EntityUnholySwordDart.class);
        event.register(MOD_ID.id("OrangeMoa"), EntityOrangeMoa.class);
    }

    @EventListener
    public void registerMobHandlers(MobHandlerRegistryEvent event) {
        Registry.register(event.registry, MOD_ID.id("OrangeMoa"), EntityOrangeMoa::new);
    }

    @EventListener
    public void registerEntityHandlers(EntityHandlerRegistryEvent event) {
        Registry.register(event.registry, MOD_ID.id("FiroBallEx"), EntityFiroBallEx::new);
        Registry.register(event.registry, MOD_ID.id("UnholyArrowLightning"), EntityLightningUnholyArrow::new);
        Registry.register(event.registry, MOD_ID.id("UnholyArrowExplosive"), EntityExplosiveUnholyArrow::new);
        Registry.register(event.registry, MOD_ID.id("UnholySwordDart"), EntityUnholySwordDart::new);
    }
}
