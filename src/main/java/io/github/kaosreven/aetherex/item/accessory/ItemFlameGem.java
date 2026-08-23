package io.github.kaosreven.aetherex.item.accessory;

import com.matthewperiut.aether.item.accessory.ItemMoreArmor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemFlameGem extends ItemMoreArmor {
    public static int flameRandomTick = 0;
    public static boolean flameRandomReady = false;
    public ItemFlameGem(Identifier i, int j, int k, int l) {
        super(i, j, k, l);
    }

    @Override
    public ItemStack tickWhileWorn(PlayerEntity player, ItemStack itemstack) {
        if(flameRandomTick == 60) {
            flameRandomReady = true;
            flameRandomTick = 0;
        } else if(!flameRandomReady) {
            ++flameRandomTick;
        }
        return itemstack;
    }
}
