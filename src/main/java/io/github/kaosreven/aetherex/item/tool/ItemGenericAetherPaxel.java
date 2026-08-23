package io.github.kaosreven.aetherex.item.tool;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.modificationstation.stationapi.api.template.item.TemplateToolItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemGenericAetherPaxel extends TemplateToolItem {
    public ItemGenericAetherPaxel(Identifier identifier, ToolMaterial material) {
        super(identifier, 3, material, Block.BLOCKS);
        this.setMaxDamage(material.getDurability());
    }

    @Override
    public boolean isSuitableFor(Block block) {
        return true;
    }
}
