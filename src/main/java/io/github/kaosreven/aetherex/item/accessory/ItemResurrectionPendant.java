package io.github.kaosreven.aetherex.item.accessory;

import com.matthewperiut.aether.item.accessory.ItemMoreArmor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemResurrectionPendant extends ItemMoreArmor {
    public static boolean ResurrectionPendantUsed = false;
    public ItemResurrectionPendant(Identifier i, int j, String path, int l) {
        super(i, j, path, l);
    }

    @Override
    public ItemStack tickWhileWorn(PlayerEntity player, ItemStack itemStack) {
        if (ResurrectionPendantUsed) {
            itemStack = null;
            ResurrectionPendantUsed = false;
        }
        return itemStack;
    }
}
