package io.github.kaosreven.aetherex.mixin.access;

import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(LivingEntity.class)
public interface LivingEntityExAccessor {
    @Accessor("jumping")
    boolean getJumping();
}
