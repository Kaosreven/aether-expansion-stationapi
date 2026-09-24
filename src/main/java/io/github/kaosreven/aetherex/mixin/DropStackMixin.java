package io.github.kaosreven.aetherex.mixin;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static io.github.kaosreven.aetherex.item.AetherExItems.PhoenixTools;
import static io.github.kaosreven.aetherex.util.PhoenixDrop.dropSmelted;

@Mixin(Block.class)
public class DropStackMixin {
    @Inject(method = "Lnet/minecraft/block/Block;dropStack(Lnet/minecraft/world/World;IIILnet/minecraft/item/ItemStack;)V", at = @At("HEAD"), cancellable = true)
    private void disablePhoenixDrops(World world, int x, int y, int z, ItemStack itemStack, CallbackInfo ci) {
        if (FabricLoader.getInstance().getGameInstance() instanceof Minecraft mc) {
            if (mc.player != null) {
                if (mc.player.getHand() != null) {
                    if (mc.player.getHand().getItem() instanceof ToolItem tool) {
                        if (tool.getMaterial(mc.player.getHand()) == PhoenixTools) {
                            if (dropSmelted) ci.cancel();
                        }
                    }
                }
            }
        }
    }
}
