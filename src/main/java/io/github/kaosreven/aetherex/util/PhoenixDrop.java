package io.github.kaosreven.aetherex.util;

import net.minecraft.block.Block;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.recipe.SmeltingRegistry;
import net.modificationstation.stationapi.api.registry.BlockRegistry;

import java.util.Random;

public class PhoenixDrop {
    public static ItemStack smelted;
    public static boolean dropSmelted;
    public static boolean dropSmelted(ItemStack stack, int blockId, int x, int y, int z, LivingEntity miner) {
        smelted = null;
        Block toBreak = BlockRegistry.INSTANCE.get(blockId);
        int Dropped = toBreak.getDroppedItemId(0, null);
        smelted = SmeltingRegistry.getResultFor(new ItemStack(Dropped, 1, 0));
        stack.damage(1, miner);
        if (smelted != null) {
            ItemEntity result = new ItemEntity(miner.world, x, y, z, new ItemStack(smelted.itemId, toBreak.getDroppedItemCount(new Random()), 0));
            miner.world.spawnEntity(result);
            dropSmelted = true;
        }
        else {
            dropSmelted = false;
        }
        return dropSmelted;
    }
}
