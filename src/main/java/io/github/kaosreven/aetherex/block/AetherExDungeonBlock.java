package io.github.kaosreven.aetherex.block;

import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.MetaNamedBlockItemProvider;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class AetherExDungeonBlock extends TemplateBlock implements MetaNamedBlockItemProvider {
    public static int sprPlatinum;
    public static int sprPlatinumLit;

    protected AetherExDungeonBlock(Identifier identifier) {
        super(identifier, Material.STONE);
    }

    @Override
    public int getTexture(int i, int j) {
        return this.isLit() ? sprPlatinumLit : sprPlatinum;
    }

    private boolean isLit() {
        return this.id == AetherExBlocks.LightDungeonStone.id || this.id == AetherExBlocks.LockedLightDungeonStone.id;
    }

    protected int getDroppedItemMeta(int i) {
        return i;
    }

    public int[] getValidMetas() {
        return new int[]{0};
    }
}
