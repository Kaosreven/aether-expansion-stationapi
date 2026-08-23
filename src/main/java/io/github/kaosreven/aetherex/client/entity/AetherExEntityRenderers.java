package io.github.kaosreven.aetherex.client.entity;


import com.matthewperiut.aether.client.entity.model.ModelMoa;
import io.github.kaosreven.aetherex.client.entity.renderer.living.RenderOrangeMoa;
import io.github.kaosreven.aetherex.client.entity.renderer.projectile.RenderUnholyArrow;
import io.github.kaosreven.aetherex.client.entity.renderer.projectile.RenderUnholySwordDart;
import io.github.kaosreven.aetherex.entity.EntityOrangeMoa;
import io.github.kaosreven.aetherex.entity.projectile.EntityLightningUnholyArrow;
import io.github.kaosreven.aetherex.entity.projectile.EntityUnholySwordDart;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.render.entity.EntityRendererRegisterEvent;

public class AetherExEntityRenderers {
      @EventListener
      public void registerEntityRenderers(EntityRendererRegisterEvent event) {
        event.renderers.put(EntityLightningUnholyArrow.class, new RenderUnholyArrow());
        event.renderers.put(EntityUnholySwordDart.class, new RenderUnholySwordDart());
        event.renderers.put(EntityOrangeMoa.class, new RenderOrangeMoa(new ModelMoa(), 1.0F));
    }
}
