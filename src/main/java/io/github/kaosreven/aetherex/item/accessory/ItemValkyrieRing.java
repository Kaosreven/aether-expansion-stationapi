package io.github.kaosreven.aetherex.item.accessory;

import com.matthewperiut.aether.item.accessory.ItemMoreArmor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.HitResultType;
import net.modificationstation.stationapi.api.item.CustomReachProvider;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemValkyrieRing extends ItemMoreArmor implements CustomReachProvider {
    public ItemValkyrieRing(Identifier i, int j, int k, int l) {
        super(i, j, k, l);
    }

    @Override
    public ItemStack tickWhileWorn(PlayerEntity player, ItemStack itemStack) {
        return itemStack;
    }

    @Override //FIXME: doesn't work actually
    public double getReach(ItemStack itemStack, PlayerEntity playerEntity, HitResultType hitType, double v) {
        return 7.0F;
    }
}
