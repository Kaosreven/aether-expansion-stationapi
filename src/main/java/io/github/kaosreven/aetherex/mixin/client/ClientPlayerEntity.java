package io.github.kaosreven.aetherex.mixin.client;

import io.github.kaosreven.aetherex.achievement.AetherExAchievements;
import io.github.kaosreven.aetherex.item.AetherExItems;
import io.github.kaosreven.aetherex.util.AccessoryUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static io.github.kaosreven.aetherex.item.accessory.ItemResurrectionPendant.ResurrectionPendantUsed;

@Mixin(PlayerEntity.class)
public class ClientPlayerEntity {
    @Inject(method = "onKilledBy", at = @At("HEAD"), cancellable = true)
    void AccesoryOnDeathAbilities(Entity adversary, CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        if (AccessoryUtils.DoesPlayerHave(player, AetherExItems.ResurrectionPendant)) {
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
