package io.github.kaosreven.aetherex.mixin;

import io.github.kaosreven.aetherex.block.AetherExBlocks;
import io.github.kaosreven.aetherex.mixin.access.FurnaceBlockAccessor;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FurnaceBlock.class)
public class FurnaceBlockMixin
{
	@Inject(at = @At("HEAD"), method = "updateLitState", cancellable = true)
	private static void updateLitState(boolean lit, World world, int x, int y, int z, CallbackInfo callback)
	{
		int furnace = world.getBlockId(x, y, z);
		int unlitId = AetherExBlocks.HolystoneFurnace.id, litId = AetherExBlocks.HolystoneFurnaceLit.id;

		if (furnace == unlitId || furnace == litId)
		{
			int currentMeta = world.getBlockMeta(x, y, z);
			BlockEntity blockEntity = world.getBlockEntity(x, y, z);
			FurnaceBlockAccessor.nc$setIgnoreBlockRemoval(true);
			world.setBlock(x, y, z, lit ? litId : unlitId);
			FurnaceBlockAccessor.nc$setIgnoreBlockRemoval(false);
			world.setBlockMeta(x, y, z, currentMeta);
			blockEntity.cancelRemoval();
			world.setBlockEntity(x, y, z, blockEntity);

			callback.cancel();
		}
	}
}
