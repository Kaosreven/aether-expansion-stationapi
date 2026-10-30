package io.github.kaosreven.aetherex.mixin.access;

import io.github.kaosreven.aetherex.events.AetherEx;
import net.minecraft.block.FurnaceBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(FurnaceBlock.class)
public interface FurnaceBlockAccessor
{
	@Accessor(value = "ignoreBlockRemoval")
	public static void nc$setIgnoreBlockRemoval(boolean set)
	{
		throw AetherEx.LOGGER.throwing(new AssertionError());
	}
}
