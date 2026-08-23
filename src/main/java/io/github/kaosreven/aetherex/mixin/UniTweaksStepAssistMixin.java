package io.github.kaosreven.aetherex.mixin;

import com.bawnorton.mixinsquared.TargetHandler;
import com.matthewperiut.aether.item.AetherItems;
import com.periut.accessoryapi.api.helper.AccessoryAccess;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PlayerEntity.class, priority = 1500)
public class UniTweaksStepAssistMixin {
    @TargetHandler(
            mixin = "net.danygames2014.unitweaks.mixin.tweaks.stepassist.PlayerEntityMixin",
            name = "changeStepHeight"
    )
    @Inject(method = "@MixinSquared:Handler", at = @At("HEAD"), cancellable = true)
    private void NukeUnitweaksHoldOnStepHeight(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        ItemStack[] list = AccessoryAccess.getAccessories(player, "cape");
        for (ItemStack itemStack : list) {
            if (itemStack.itemId == AetherItems.AgilityCape.id) ci.cancel();
        }
    }
}
