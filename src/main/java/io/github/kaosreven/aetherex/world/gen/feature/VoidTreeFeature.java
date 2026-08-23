package io.github.kaosreven.aetherex.world.gen.feature;

import com.matthewperiut.aether.block.AetherBlocks;
import io.github.kaosreven.aetherex.block.AetherExBlocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class VoidTreeFeature extends Feature {

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        byte min = 60;
        byte max = 100;
        int yLevel = (new Random()).nextInt(max - min + 1) + min;
            int tree;
            int logX;
            int logY;
            for(tree = 0; tree < 15; ++tree) {
                for(logX = 0; logX < 11; ++logX) {
                    for(logY = 0; logY < 11; ++logY) {
                        if(world.getBlockId(x + logX, yLevel - 5 + tree, z + logY) != 0) {
                            return false;
                        }
                    }
                }
            }

            for(tree = 0; tree < 9; ++tree) {
                for(logX = 0; logX < 9; ++logX) {
                    world.setBlock(x + tree, yLevel, z + logX, AetherBlocks.Grass.id);
                }
            }

            for(tree = 0; tree < 7; ++tree) {
                for(logX = 0; logX < 7; ++logX) {
                    world.setBlock(x + tree + 1, yLevel - 1, z + logX + 1, AetherBlocks.Holystone.id);
                }
            }

            for(tree = 0; tree < 5; ++tree) {
                for(logX = 0; logX < 5; ++logX) {
                    world.setBlock(x + tree + 2, yLevel - 2, z + logX + 2, AetherBlocks.Holystone.id);
                }
            }

            for(tree = 0; tree < 3; ++tree) {
                for(logX = 0; logX < 3; ++logX) {
                    world.setBlock(x + tree + 3, yLevel - 3, z + logX + 3, AetherBlocks.Holystone.id);
                }
            }

            world.setBlock(x + 4, yLevel - 4, z + 4, AetherBlocks.Holystone.id);

            for(tree = 0; tree < 6; ++tree) {
                logX = x + 4;
                logY = yLevel + 1 + tree;
                int logZ = z + 4;
                int leave;
                int leave2;
                if(tree == 3) {
                    for(leave = 0; leave < 3; ++leave) {
                        for(leave2 = 0; leave2 < 3; ++leave2) {
                            world.setBlock(logX + leave, logY, logZ + leave2, AetherExBlocks.VoidLeaves.id);
                            world.setBlock(logX - leave, logY, logZ + leave2, AetherExBlocks.VoidLeaves.id);
                            world.setBlock(logX + leave, logY, logZ - leave2, AetherExBlocks.VoidLeaves.id);
                            world.setBlock(logX - leave, logY, logZ - leave2, AetherExBlocks.VoidLeaves.id);
                        }
                    }
                }

                if(tree == 5) {
                    leave = 0;

                    while(true) {
                        if(leave >= 4) {
                            world.setBlock(logX + 3, logY, logZ + 3, 0);
                            world.setBlock(logX + 3, logY, logZ + 2, 0);
                            world.setBlock(logX + 2, logY, logZ + 3, 0);
                            world.setBlock(logX - 3, logY, logZ - 3, 0);
                            world.setBlock(logX - 3, logY, logZ - 2, 0);
                            world.setBlock(logX - 2, logY, logZ - 3, 0);
                            world.setBlock(logX - 3, logY, logZ + 3, 0);
                            world.setBlock(logX - 3, logY, logZ + 2, 0);
                            world.setBlock(logX - 2, logY, logZ + 3, 0);
                            world.setBlock(logX + 3, logY, logZ - 3, 0);
                            world.setBlock(logX + 3, logY, logZ - 2, 0);
                            world.setBlock(logX + 2, logY, logZ - 3, 0);
                            break;
                        }

                        for(leave2 = 0; leave2 < 4; ++leave2) {
                            world.setBlock(logX + leave, logY, logZ + leave2, AetherExBlocks.VoidLeaves.id);
                            world.setBlock(logX - leave, logY, logZ + leave2, AetherExBlocks.VoidLeaves.id);
                            world.setBlock(logX + leave, logY, logZ - leave2, AetherExBlocks.VoidLeaves.id);
                            world.setBlock(logX - leave, logY, logZ - leave2, AetherExBlocks.VoidLeaves.id);
                        }

                        ++leave;
                    }
                }

                if(tree == 1) {
                    for(leave = 0; leave < 2; ++leave) {
                        for(leave2 = 0; leave2 < 2; ++leave2) {
                            world.setBlock(logX + leave, logY, logZ + leave2, AetherExBlocks.VoidLeaves.id);
                            world.setBlock(logX - leave, logY, logZ + leave2, AetherExBlocks.VoidLeaves.id);
                            world.setBlock(logX + leave, logY, logZ - leave2, AetherExBlocks.VoidLeaves.id);
                            world.setBlock(logX - leave, logY, logZ - leave2, AetherExBlocks.VoidLeaves.id);
                        }
                    }
                }

                world.setBlock(logX, logY, logZ, AetherExBlocks.VoidWood.id, 0);
                if(tree == 5) {
                    for(leave = 0; leave < 2; ++leave) {
                        for(leave2 = 0; leave2 < 2; ++leave2) {
                            world.setBlock(logX + leave, logY + 1, logZ + leave2, AetherExBlocks.VoidLeaves.id);
                            world.setBlock(logX - leave, logY + 1, logZ + leave2, AetherExBlocks.VoidLeaves.id);
                            world.setBlock(logX + leave, logY + 1, logZ - leave2, AetherExBlocks.VoidLeaves.id);
                            world.setBlock(logX - leave, logY + 1, logZ - leave2, AetherExBlocks.VoidLeaves.id);
                        }

                        world.setBlock(logX, logY + 2, logZ, AetherExBlocks.VoidLeaves.id);
                    }
                }
            }
        return true;
    }
}
