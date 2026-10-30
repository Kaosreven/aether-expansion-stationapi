package io.github.kaosreven.aetherex.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import io.github.kaosreven.aetherex.block.AetherExBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(SignBlockEntityRenderer.class)
public class SignBlockEntityRendererMixin
{
	@ModifyExpressionValue(method = "render", at = @At(value = "FIELD", target = "Lnet/minecraft/block/Block;SIGN:Lnet/minecraft/block/Block;", opcode = 178))
	private Block nc$rotateStandingSign(Block original, @Local(ordinal = 0) Block block)
	{
		if (block == AetherExBlocks.SkyrootSign) return block;
		return original;
	}

	@ModifyArg(method = "render", at = @At(value = "INVOKE", target = "net/minecraft/client/render/block/entity/SignBlockEntityRenderer.bindTexture(Ljava/lang/String;)V"), index = 0)
	private String nc$modifySignTexture(String texturePath, @Local(argsOnly = true) SignBlockEntity signBlockEntity)
	{
		if (signBlockEntity != null && signBlockEntity.getBlock() == AetherExBlocks.SkyrootSign || signBlockEntity.getBlock() == AetherExBlocks.SkyrootWallSign)
			return "aetherex:stationapi/textures/other/skyroot_sign.png";

		return texturePath;
	}
}