package io.github.kaosreven.aetherex.block;

import com.matthewperiut.aether.block.Incubator;
import com.matthewperiut.aether.blockentity.container.ContainerIncubator;
import io.github.kaosreven.aetherex.blockentity.block.BlockEntityAdvancedIncubator;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.gui.screen.container.GuiHelper;
import net.modificationstation.stationapi.api.util.Identifier;

import static io.github.kaosreven.aetherex.blockentity.AetherExBlockEntities.MOD_ID;

public class AdvancedIncubator extends Incubator {
    public static int topTexture;
    public static int sideTexture;

    protected AdvancedIncubator(Identifier blockID) {
        super(blockID);
    }

    @Override
    public int getTexture(int i) {
        if (i == 1) {
            return topTexture;
        } else {
            return i == 0 ? topTexture : sideTexture;
        }
    }

    @Override
    public boolean onUse(World world, int i, int j, int k, PlayerEntity player) {
        if (!world.isRemote) {
            BlockEntityAdvancedIncubator blockEntityAdvancedIncubator = (BlockEntityAdvancedIncubator) world.getBlockEntity(i, j, k);
            GuiHelper.openGUI(player, MOD_ID.id("advanced_incubator"), blockEntityAdvancedIncubator, new ContainerIncubator(player.inventory, blockEntityAdvancedIncubator));
        }
        return true;
    }

    @Override
    protected BlockEntity createBlockEntity() {
        return new BlockEntityAdvancedIncubator();
    }
}
