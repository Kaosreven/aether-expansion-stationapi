package io.github.kaosreven.aetherex.mixin.server;

import com.periut.accessoryapi.api.helper.AccessoryAccess;
import io.github.kaosreven.aetherex.achievement.AetherExAchievements;
import io.github.kaosreven.aetherex.item.AetherExItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static io.github.kaosreven.aetherex.item.accessory.ItemResurrectionPendant.ResurrectionPendantUsed;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin {
    @Inject(method = "onKilledBy", at = @At("HEAD"), cancellable = true)
    void AccesoryOnDeathAbilities(Entity adversary, CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        ItemStack[] list = AccessoryAccess.getAccessories(player, "pendant");
        for (ItemStack itemStack : list) {
            if (itemStack.itemId == AetherExItems.ResurrectionPendant.id) {
                AetherExAchievements.giveAchievement(AetherExAchievements.secondChance, player);
                player.health = 15;
                player.fireTicks = 0;
                ResurrectionPendantUsed = true;
                if(!player.world.isRemote) {
                    player.sendMessage("\u00a7aYour resurrection pendant has saved you!");
                }
                ci.cancel();
            }
        }
    }
}
