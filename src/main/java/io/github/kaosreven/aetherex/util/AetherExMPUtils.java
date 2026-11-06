package io.github.kaosreven.aetherex.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;

public class AetherExMPUtils {
    public static void GiveItem(ItemStack loot, PlayerEntity entityplayer) {
        entityplayer.inventory.addStack(loot);
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.SERVER) {
            if (entityplayer instanceof ServerPlayerEntity serverPlayer) {
                serverPlayer.currentScreenHandler.sendContentUpdates();
            }
        }
    }
}
