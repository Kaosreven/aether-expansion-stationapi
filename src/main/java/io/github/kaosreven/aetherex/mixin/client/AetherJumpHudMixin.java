package io.github.kaosreven.aetherex.mixin.client;

import com.bawnorton.mixinsquared.TargetHandler;
import io.github.kaosreven.aetherex.util.JumpsDisplay;
import io.github.kaosreven.aetherex.util.MoaStatHud;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = InGameHud.class, priority = 1500)
public class AetherJumpHudMixin {
    @Shadow
    private Minecraft minecraft;

    @TargetHandler(
            mixin = "com.matthewperiut.aether.mixin.client.InGameHudMixinJumps",
            name = "injectFeathers"
    )
    @Inject(method = "@MixinSquared:Handler", at = @At("HEAD"), cancellable = true)
    void ReplaceJumpHudLogic(float tickDelta, boolean screenOpen, int mouseX, int mouseY, CallbackInfo ci, CallbackInfo ci2) {
        JumpsDisplay.gui(minecraft, (InGameHud) (Object) this);

        MoaStatHud.gui(minecraft);
        ci2.cancel();
    }
}