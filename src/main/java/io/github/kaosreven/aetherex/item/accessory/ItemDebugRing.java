package io.github.kaosreven.aetherex.item.accessory;

import io.github.kaosreven.aether.item.accessory.ItemMoreArmor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.HitResultType;
import net.modificationstation.stationapi.api.item.CustomReachProvider;
import net.modificationstation.stationapi.api.util.Identifier;

import static io.github.kaosreven.aetherex.item.tool.ItemMineFist.mineReady;

public class ItemDebugRing extends ItemMoreArmor implements CustomReachProvider {
    public static boolean debugReady = false;
    public ItemDebugRing(Identifier i, int j, int k, int l) {
        super(i, j, k, l, 16721706);
    }

    @Override
    public ItemStack tickWhileWorn(PlayerEntity player, ItemStack itemStack) {
        mineReady = true;
        return itemStack;
    }

    @Override
    public double getReach(ItemStack itemStack, PlayerEntity playerEntity, HitResultType hitType, double v) {
        return 9999.0F;
    }

    public void onAccessoryAdded(PlayerEntity player, ItemStack accessory) {
        debugReady = true;
    }

    public void onAccessoryRemoved(PlayerEntity player, ItemStack accessory) {
        debugReady = false;
    }
}
