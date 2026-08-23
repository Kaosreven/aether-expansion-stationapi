package io.github.kaosreven.aetherex.mixin;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static io.github.kaosreven.aetherex.util.PhoenixDrop.dropSmelted;

@Mixin(Block.class)
public class DropStackMixin {
    @Inject(method = "Lnet/minecraft/block/Block;dropStack(Lnet/minecraft/world/World;IIILnet/minecraft/item/ItemStack;)V", at = @At("HEAD"), cancellable = true)
    private void disablePhoenixDrops(World world, int x, int y, int z, ItemStack itemStack, CallbackInfo ci) {
        if (dropSmelted) ci.cancel();
    }
}
