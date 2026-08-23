package io.github.kaosreven.aetherex.item.accessory;

import com.matthewperiut.aether.item.accessory.ItemMoreArmor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemAerShield extends ItemMoreArmor {
    public int shieldRandomTick = 0;
    public static boolean aerShieldRandomReady = false;

    public ItemAerShield(Identifier i, int j, int k, int l, int col) {
        super(i, j, k, l, col);
        this.setMaxDamage(60);
    }

    @Override
    public ItemStack tickWhileWorn(PlayerEntity player, ItemStack itemStack) {
        if (itemStack.getDamage() < itemStack.getMaxDamage()) {
            if (this.shieldRandomTick == 60) {
                aerShieldRandomReady = true;
                this.shieldRandomTick = 0;
            } else if (!aerShieldRandomReady) {
                ++this.shieldRandomTick;
            }
        }
        return itemStack;
    }
}
