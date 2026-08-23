package io.github.kaosreven.aetherex.item.accessory;

import com.matthewperiut.aether.item.accessory.ItemMoreArmor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemSentryShield extends ItemMoreArmor {
    public static int sentryRandomTick = 0;
    public static boolean sentryRandomReady = false;
    public static int sentryActiveTick = 0;
    public static boolean sentryActiveReady = true;

    public ItemSentryShield(Identifier i, int j, int k, int l) {
        super(i, j, k, l);
        this.setMaxDamage(50);
    }

    public void onAccessoryRemoved(PlayerEntity player, ItemStack accessory) {
        sentryRandomTick = 0;
        sentryActiveTick = 0;
    }

    @Override
    public ItemStack tickWhileWorn(PlayerEntity player, ItemStack itemStack) {
        if (itemStack.getDamage() < itemStack.getMaxDamage()) {
            if (sentryRandomTick == 60) {
                sentryRandomReady = true;
                sentryRandomTick = 0;
            } else if (!sentryRandomReady) {
                ++sentryRandomTick;
            }
            ++sentryActiveTick;
        }
        else sentryRandomReady = false;
        return itemStack;
    }
}
