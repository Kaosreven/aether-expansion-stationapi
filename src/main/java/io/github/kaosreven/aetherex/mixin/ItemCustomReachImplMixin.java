package io.github.kaosreven.aetherex.mixin;

import com.periut.accessoryapi.api.helper.AccessoryAccess;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.event.entity.player.PlayerEvent;
import net.modificationstation.stationapi.api.item.CustomReachProvider;
import net.modificationstation.stationapi.impl.entity.player.ItemCustomReachImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemCustomReachImpl.class)
public class ItemCustomReachImplMixin {
    @Inject(method = "getReach", at = @At("TAIL"), cancellable = true)
    private static void changeReach(PlayerEvent.Reach event, CallbackInfo ci) {
        ItemStack[] list = AccessoryAccess.getAccessories(event.player, "ring");
        for (ItemStack itemStack : list) {
            if (itemStack.getItem() instanceof CustomReachProvider provider) {
                ItemStack stack = event.player.getHand();
                if (stack != null) {
                    if (!(stack.getItem() instanceof CustomReachProvider)) event.currentReach = provider.getReach(itemStack, event.player, event.type, event.currentReach);
                }
            }
        }
    }
}
