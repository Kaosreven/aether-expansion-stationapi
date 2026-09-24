package io.github.kaosreven.aetherex.events;

import io.github.kaosreven.aetherex.optional.AetherExConfig;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.mod.InitEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.resource.ResourceManagerHelper;
import net.modificationstation.stationapi.api.resource.ResourcePackActivationType;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class AetherExResourcePack {
    @Entrypoint.Namespace
    public static Namespace MOD_ID = Null.get();

    @EventListener
    public void registerResourcePacks(InitEvent event) {
        if (AetherExConfig.CONFIG.EnableFancyGui) {
            ModContainer container = FabricLoader.getInstance().getModContainer(MOD_ID.toString()).orElseThrow();
            ResourceManagerHelper.registerBuiltinResourcePack(Identifier.of(MOD_ID, "aether_expansion_gui"), container, "AetherEXGUI", ResourcePackActivationType.ALWAYS_ENABLED);
        }
    }
}
