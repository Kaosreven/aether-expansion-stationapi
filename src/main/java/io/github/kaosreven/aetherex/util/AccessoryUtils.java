package io.github.kaosreven.aetherex.util;

import com.periut.accessoryapi.api.helper.AccessoryAccess;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AccessoryUtils {
    public static boolean DoesPlayerHave(PlayerEntity player, Item accessory) {
        ItemStack[] list = AccessoryAccess.getAccessories(player);
        for (ItemStack itemStack : list) {
            if (itemStack != null) {
                if (itemStack.itemId == accessory.id) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void UseAccessory(PlayerEntity player, Item accessory) {
        ItemStack[] list = AccessoryAccess.getAccessories(player);
        for (ItemStack itemStack : list) {
            if (itemStack != null) {
                if (itemStack.itemId == accessory.id) {
                    itemStack.damage(1, player);
                    return;
                }
            }
        }
    }
}
