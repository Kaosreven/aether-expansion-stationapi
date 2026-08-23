package io.github.kaosreven.aetherex.mixin.client;

import com.bawnorton.mixinsquared.TargetHandler;
import io.github.kaosreven.aetherex.achievement.AetherExAchievements;
import net.minecraft.achievement.Achievement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.hud.toast.AchievementToast;
import net.minecraft.entity.player.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class HijackAetherAchievementsMixin {
    @Shadow
    protected Minecraft minecraft;

    @TargetHandler(
            mixin = "com.matthewperiut.aether.mixin.client.ClientPlayHandlerMixin",
            name = "onIncreaseStat"
    )
    @Inject(method = "@MixinSquared:Handler", at = @At("TAIL"))
    public void onIncreaseStatEx(AchievementToast instance, Achievement achievement, CallbackInfo ci) {
        int achievementId = achievement.id - 5242880;
        if (achievementId >= AetherExAchievements.acOff && achievementId <= AetherExAchievements.acOff + 3) {
            minecraft.soundManager.playSound("aether:other.achievement.achievementgen", 1.0F, 1.0F);
        }
    }
}
