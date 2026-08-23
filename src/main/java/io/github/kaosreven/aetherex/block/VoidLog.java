package io.github.kaosreven.aetherex.block;

import com.matthewperiut.aether.block.AetherBlocks;
import com.matthewperiut.aether.block.UtilSkyroot;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class VoidLog extends TemplateBlock {
    private static final Random rand = new Random();
    public static int sprTop;
    public static int sprSide;

    public VoidLog(Identifier identifier) {
        super(identifier, sprSide, Material.WOOD);
    }

    public int getTexture(int i) {
        if (i == 1) {
            return sprTop;
        } else {
            return i == 0 ? sprTop : sprSide;
        }
    }

    public int getDroppedItemCount(Random random) {
        return 1;
    }

    public int getDroppedItemId(int blockMeta, Random random) {
        return AetherBlocks.Log.asItem().id;
    }

    @Override
    public void dropStacks(World world, int x, int y, int z, int meta, float luck) {
        if (!world.isRemote) {
            int count = 1;
            PlayerEntity player = world.getClosestPlayer(x,y,z,16.F);

            if (player != null) {
                if (UtilSkyroot.axe(player)) {
                    count = 2;
                }
            }

            for(int i = 0; i < count; ++i) {
                if (!(world.random.nextFloat() > luck)) {
                    int var9 = this.getDroppedItemId(meta, world.random);
                    if (var9 > 0) {
                        this.dropStack(world, x, y, z, new ItemStack(var9, 1, this.getDroppedItemMeta(meta)));
                    }
                }
            }
        }
    }
}