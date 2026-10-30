package io.github.kaosreven.aetherex.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import io.github.kaosreven.aetherex.block.AetherExBlocks;
import net.minecraft.block.Block;
import net.minecraft.screen.CraftingScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CraftingScreenHandler.class)
public class CraftingScreenHandlerMixin
{
	@ModifyExpressionValue(at = @At(value = "INVOKE", target = "net/minecraft/world/World.getBlockId(III)I"), method = "canUse")
	private int canUseBlock(int blockId)
	{
		return (blockId == AetherExBlocks.SkyrootWorkbench.id || blockId == AetherExBlocks.VoidWorkbench.id) ? Block.CRAFTING_TABLE.id : blockId;
	}
}
