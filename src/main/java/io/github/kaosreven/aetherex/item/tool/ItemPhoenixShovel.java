package io.github.kaosreven.aetherex.item.tool;

import io.github.kaosreven.aetherex.item.AetherExItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateShovelItem;
import net.modificationstation.stationapi.api.util.Identifier;

import static io.github.kaosreven.aetherex.util.PhoenixDrop.dropSmelted;

public class ItemPhoenixShovel extends TemplateShovelItem {
    public ItemPhoenixShovel(Identifier identifier, ToolMaterial material) {
        super(identifier, material);
        this.setMaxDamage(material.getDurability());
    }

    @Override
    public boolean postMine(ItemStack stack, int blockId, int x, int y, int z, LivingEntity miner) {
        return dropSmelted(stack, blockId, x, y, z, miner);
    }

    @Override
    public void inventoryTick(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
        if (entity instanceof PlayerEntity player) {
            if (player.isWet()) {
                itemstack.damage(1, player);
                if (itemstack.getDamage2() > itemstack.getMaxDamage() - 2) {
                    player.inventory.setStack(i, new ItemStack(AetherExItems.ObsidianShovel, 1));
                }
            }
        }
    }
}
