package io.github.kaosreven.aetherex.item.accessory;

import com.matthewperiut.aether.item.accessory.ItemMoreArmor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemJebShield extends ItemMoreArmor {
    public int shieldRandomTick = 0;
    public static boolean jebShieldRandomReady = false;

    public ItemJebShield(Identifier i, int j, int k, int l) {
        super(i, j, k, l);
        this.setMaxDamage(50);
    }

    @Override
    public ItemStack tickWhileWorn(PlayerEntity player, ItemStack itemStack) {
        if (itemStack.getDamage() < itemStack.getMaxDamage()) {
            if (this.shieldRandomTick == 60) {
                jebShieldRandomReady = true;
                this.shieldRandomTick = 0;
            } else if (!jebShieldRandomReady) {
                ++this.shieldRandomTick;
            }
        }
        return itemStack;
    }
}
