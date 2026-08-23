package io.github.kaosreven.aetherex.item.accessory;

import com.matthewperiut.aether.mixin.access.EntityAccessor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemAerCape extends ItemCape {
    public static int jumps = 3;
    public static int jumpsRemaining = jumps;
    public ItemAerCape(Identifier i, int j, String path, int l) {
        super(i, j, path, l);
        this.setMaxDamage(51);
    }

    @Override
    public ItemStack tickWhileWorn(PlayerEntity player, ItemStack itemstack) {
        if(itemstack.getDamage() < itemstack.getMaxDamage()) {
            ((EntityAccessor) (player)).setFallDistance(0.0F);
        }
        if (player.onGround) jumpsRemaining = jumps;
        return itemstack;
    }
}
