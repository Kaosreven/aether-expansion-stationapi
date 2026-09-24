package io.github.kaosreven.aetherex.mixin;

import com.matthewperiut.aether.blockentity.block.BlockEntityEnchanter;
import com.matthewperiut.aether.blockentity.block.BlockEntityFreezer;
import com.matthewperiut.aether.blockentity.block.BlockEntityIncubator;
import com.matthewperiut.aether.client.gui.AetherGuis;
import io.github.kaosreven.aetherex.client.gui.GuiEnchanterAlt;
import io.github.kaosreven.aetherex.client.gui.GuiFreezerAlt;
import io.github.kaosreven.aetherex.client.gui.GuiIncubatorAlt;
import io.github.kaosreven.aetherex.optional.AetherExConfig;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AetherGuis.class)
public class HijackAetherGuiMixin {

    @Inject(method = "openIncubator", at = @At("HEAD"), cancellable = true)
    public void IncubatorGuiAlt(PlayerEntity player, Inventory inventoryBase, CallbackInfoReturnable<HandledScreen> cir) {
        if (AetherExConfig.CONFIG.EnableFancyGui) {
            cir.setReturnValue(new GuiIncubatorAlt(player.inventory, (BlockEntityIncubator) inventoryBase));
        }
    }

    @Inject(method = "openFreezer", at = @At("HEAD"), cancellable = true)
    public void FreezerGuiAlt(PlayerEntity player, Inventory inventoryBase, CallbackInfoReturnable<HandledScreen> cir) {
        if (AetherExConfig.CONFIG.EnableFancyGui) {
            cir.setReturnValue(new GuiFreezerAlt(player.inventory, (BlockEntityFreezer) inventoryBase));
        }
    }

    @Inject(method = "openEnchanter", at = @At("HEAD"), cancellable = true)
    public void openEnchanter(PlayerEntity player, Inventory inventoryBase, CallbackInfoReturnable<HandledScreen> cir) {
        if (AetherExConfig.CONFIG.EnableFancyGui) {
            cir.setReturnValue(new GuiEnchanterAlt(player.inventory, (BlockEntityEnchanter) inventoryBase));
        }
    }
}
