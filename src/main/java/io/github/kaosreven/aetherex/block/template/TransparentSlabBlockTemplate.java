package io.github.kaosreven.aetherex.block.template;

import net.minecraft.block.Block;
import net.minecraft.world.BlockView;
import net.modificationstation.stationapi.api.util.Identifier;

public class TransparentSlabBlockTemplate extends SlabBlockTemplate {

    public TransparentSlabBlockTemplate(Identifier identifier, Block baseBlock) {
        super(identifier, baseBlock);
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
