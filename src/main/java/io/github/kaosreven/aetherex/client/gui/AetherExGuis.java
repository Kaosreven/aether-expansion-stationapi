package io.github.kaosreven.aetherex.client.gui;

import io.github.kaosreven.aetherex.blockentity.block.BlockEntityAdvancedIncubator;
import io.github.kaosreven.aetherex.blockentity.block.BlockEntityLoreBookshelf;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.modificationstation.stationapi.api.client.gui.screen.GuiHandler;
import net.modificationstation.stationapi.api.client.registry.GuiHandlerRegistry;
import net.modificationstation.stationapi.api.event.registry.GuiHandlerRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Registry;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class AetherExGuis {
    @Entrypoint.Namespace
    public static Namespace MOD_ID = Null.get();

    @Environment(EnvType.CLIENT)
    @EventListener
    public void registerGuiHandlers(GuiHandlerRegistryEvent event) {
        GuiHandlerRegistry registry = event.registry;
        Registry.register(registry, Identifier.of(MOD_ID, "advanced_incubator"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openAdvancedIncubator, BlockEntityAdvancedIncubator::new));
        //Registry.register(registry, Identifier.of(MOD_ID, "lore_bookshelf"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openLorebookshelf, BlockEntityLoreBookshelf::new));
    }

    @Environment(EnvType.CLIENT)
    public HandledScreen openAdvancedIncubator(PlayerEntity player, Inventory inventoryBase) {
        return new GuiAdvancedIncubator(player.inventory, (BlockEntityAdvancedIncubator) inventoryBase);
    }

    @Environment(EnvType.CLIENT)
    public HandledScreen openLorebookshelf(PlayerEntity player, Inventory inventoryBase) {
        return new GuiLoreBookshelf(player.inventory, 0);
    }
}
