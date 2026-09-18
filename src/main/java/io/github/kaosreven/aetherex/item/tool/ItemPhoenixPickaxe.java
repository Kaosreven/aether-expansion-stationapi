package io.github.kaosreven.aetherex.item.tool;

import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.template.item.TemplatePickaxeItem;
import net.modificationstation.stationapi.api.util.Identifier;

import static io.github.kaosreven.aetherex.util.PhoenixDrop.dropSmelted;

public class ItemPhoenixPickaxe extends TemplatePickaxeItem {
    public ItemPhoenixPickaxe(Identifier identifier, ToolMaterial material) {
        super(identifier, material);
        this.setMaxDamage(material.getDurability());
    }

    @Override
    public boolean postMine(ItemStack stack, int blockId, int x, int y, int z, LivingEntity miner) {
        Block toBreak = BlockRegistry.INSTANCE.get(blockId);
        if (!this.isSuitableFor(toBreak)) return false;
        return dropSmelted(stack, blockId, x, y, z, miner);
    }
}
