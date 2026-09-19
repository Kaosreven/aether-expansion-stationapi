package io.github.kaosreven.aetherex.item.accessory;

import com.matthewperiut.aether.item.accessory.ItemMoreArmor;
import com.periut.accessoryapi.api.PlayerExtraHP;
import com.periut.accessoryapi.api.helper.AccessoryAccess;
import io.github.kaosreven.aetherex.item.AetherExItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.util.Identifier;
import com.matthewperiut.aether.item.AetherItems;

public class ItemHealingMatrix extends ItemMoreArmor {
    public ItemHealingMatrix(Identifier i, int j, int k, int l) {
        super(i, j, k, l);
    }

    @Override
    public ItemStack tickWhileWorn(PlayerEntity player, ItemStack itemstack) {
        ItemStack[] list = AccessoryAccess.getAccessories(player, "misc");
        if (list.length >= 2) {
            if ((list[0].itemId == AetherExItems.HealMatrix.id && list[1].itemId == AetherItems.RegenerationStone.id) || (list[1].itemId == AetherExItems.HealMatrix.id && list[0].itemId == AetherItems.RegenerationStone.id)) {
                for (ItemStack itemStack : list) if (itemStack.itemId == AetherExItems.HealMatrix.id) {
                    itemStack.getStationNbt().putBoolean("occupied", true);
                }
            }
        }
        else for (ItemStack itemStack : list) {
            if (itemStack.itemId == AetherExItems.HealMatrix.id) {
                itemStack.getStationNbt().putBoolean("occupied", false);
            }
        }
        if (!(itemstack.getStationNbt().getBoolean("occupied"))) {
            if (player.age % 200 == 0) {
                int maxHealth = 20 + ((PlayerExtraHP) player).getExtraHP();
                if (player.health < maxHealth) {
                    player.health += 2;
                }
            }
        }
        return itemstack;
    }
}
