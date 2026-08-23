package io.github.kaosreven.aetherex.mixin;

import io.github.kaosreven.aetherex.achievement.AetherExAchievements;
import io.github.kaosreven.aetherex.block.AetherExBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.CraftingResultSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CraftingResultSlot.class)
public class CraftingResultSlotMixin {
    @Shadow
    private PlayerEntity player;

    @Inject(method = "onTakeItem", at = @At("HEAD"))
    public void achievementCraftingCatcher(ItemStack stack, CallbackInfo ci) {
        if (stack.itemId == AetherExBlocks.BookshelfOfLore.asItem().id)
            AetherExAchievements.giveAchievement(AetherExAchievements.knowledge, player);
    }
}
