package io.github.kaosreven.aetherex.item.accessory;

import com.matthewperiut.aether.item.accessory.ItemMoreArmor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemLuckyPendant extends ItemMoreArmor {
    public static int luckyRandomTick = 0;
    public static boolean luckyRandomReady = false;
    public ItemLuckyPendant(Identifier i, int j, String path, int l) {
        super(i, j, path, l);
        this.setMaxDamage(50);
    }

    @Override
    public ItemStack tickWhileWorn(PlayerEntity player, ItemStack itemStack) {
        if (itemStack.getDamage() < itemStack.getMaxDamage()) {
            if (luckyRandomTick == 60) {
                luckyRandomReady = true;
            } else if (!luckyRandomReady) {
                ++luckyRandomTick;
            }
        }
        return itemStack;
    }
}
