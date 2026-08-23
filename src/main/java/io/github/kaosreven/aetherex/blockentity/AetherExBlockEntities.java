package io.github.kaosreven.aetherex.blockentity;

import io.github.kaosreven.aetherex.blockentity.block.BlockEntityAdvancedIncubator;
import io.github.kaosreven.aetherex.blockentity.block.BlockEntityLoreBookshelf;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.block.entity.BlockEntityRegisterEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class AetherExBlockEntities {
    @Entrypoint.Namespace
    public static Namespace MOD_ID = Null.get();

    @EventListener
    public void registerTileEntities(BlockEntityRegisterEvent event) {
        event.register(MOD_ID.id("advanced_incubator").toString(), BlockEntityAdvancedIncubator.class);
        event.register(MOD_ID.id("lore_bookshelf").toString(), BlockEntityLoreBookshelf.class);
    }
}
