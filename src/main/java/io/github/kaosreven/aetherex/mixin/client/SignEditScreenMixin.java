package io.github.kaosreven.aetherex.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import io.github.kaosreven.aetherex.block.AetherExBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.ingame.SignEditScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SignEditScreen.class)
public class SignEditScreenMixin
{
	@ModifyExpressionValue(method = "render", at = @At(value = "FIELD", target = "Lnet/minecraft/block/Block;SIGN:Lnet/minecraft/block/Block;", opcode = 178))
	private Block nc$rotateStandingSign(Block original, @Local(ordinal = 0) Block block)
	{
		if (block == AetherExBlocks.SkyrootSign) return block;
		return original;
	}
}
