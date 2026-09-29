package io.github.kaosreven.aetherex.block.template;

import net.minecraft.block.Block;
import net.minecraft.world.BlockView;
import net.modificationstation.stationapi.api.util.Identifier;

public class TransparentStairsBlockTemplate extends StairsBlockTemplate {

    public TransparentStairsBlockTemplate(Identifier identifier, Block block) {
        super(identifier, block);
    }

    @Override
    public int getRenderLayer() {
        return 1;
    }

    @Override
    public boolean isSideVisible(BlockView iblockaccess, int i, int j, int k, int l) {
        return super.isSideVisible(iblockaccess, i, j, k, 1 - l);
    }
}
