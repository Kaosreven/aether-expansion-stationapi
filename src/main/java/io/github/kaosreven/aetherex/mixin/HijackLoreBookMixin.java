package io.github.kaosreven.aetherex.mixin;

import com.matthewperiut.aether.item.misc.ItemLoreBook;
import io.github.kaosreven.aetherex.client.gui.GuiLoreAlt;
import io.github.kaosreven.aetherex.optional.AetherExConfig;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemLoreBook.class)
public class HijackLoreBookMixin {

    @Inject(method = "useLoreClient", at = @At("HEAD"), cancellable = true)
    private static void useLoreClient(PlayerEntity player, ItemStack item, CallbackInfo ci) {
        if (AetherExConfig.CONFIG.EnableFancyGui) {
            //noinspection deprecation
            if (FabricLoader.getInstance().getGameInstance() instanceof Minecraft mc)
                mc.setScreen(new GuiLoreAlt(player.inventory, item.getDamage2()));
            ci.cancel();
        }
    }
}
