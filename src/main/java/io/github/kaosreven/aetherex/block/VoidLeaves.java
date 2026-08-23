package io.github.kaosreven.aetherex.block;

import io.github.kaosreven.aetherex.item.AetherExItems;
import net.minecraft.block.material.Material;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateTranslucentBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class VoidLeaves extends TemplateTranslucentBlock {
    public static int sprVoid;
    int[] blocks;

    public VoidLeaves(Identifier identifier) {
        super(identifier, sprVoid, Material.LEAVES, false);
        this.setTickRandomly(true);
    }

    @Override
    public int getTexture(int i) {
        return sprVoid;
    }

    public int getDroppedItemCount(Random random) {
        return random.nextInt(20) == 0 ? 1 : 0;
    }

    public int getDroppedItemId(int i, Random random) {
        return random.nextInt(6) == 0 ? AetherExItems.VoidTomato.id : AetherExItems.GoldenElixir.id;
    }

    public void onBreak(World world, int i, int j, int k) {
        byte l = 1;
        int i1 = l + 1;
        if(world.isRegionLoaded(i - i1, j - i1, k - i1, i + i1, j + i1, k + i1)) {
            for(int j1 = -l; j1 <= l; ++j1) {
                for(int k1 = -l; k1 <= l; ++k1) {
                    for(int l1 = -l; l1 <= l; ++l1) {
                        int i2 = world.getBlockId(i + j1, j + k1, k + l1);
                        if(i2 == this.id) {
                            int j2 = world.getBlockMeta(i + j1, j + k1, k + l1);
                            world.setBlockMeta(i + j1, j + k1, k + l1, j2 | 8);
                        }
                    }
                }
            }
        }
    }

    public void onTick(World arg, int i, int j, int k, Random random) {
        if (!arg.isRemote) {
            int var6 = arg.getBlockMeta(i, j, k);
            if ((var6 & 8) != 0) {
                byte var7 = 4;
                int var8 = var7 + 1;
                byte var9 = 32;
                int var10 = var9 * var9;
                int var11 = var9 / 2;
                if (this.blocks == null) {
                    this.blocks = new int[var9 * var9 * var9];
                }

                int var12;
                if (arg.isRegionLoaded(i - var8, j - var8, k - var8, i + var8, j + var8, k + var8)) {
                    var12 = -var7;

                    label111:
                    while (true) {
                        int var13;
                        int var14;
                        int var15;
                        if (var12 > var7) {
                            var12 = 1;

                            while (true) {
                                if (var12 > 4) {
                                    break label111;
                                }

                                for (var13 = -var7; var13 <= var7; ++var13) {
                                    for (var14 = -var7; var14 <= var7; ++var14) {
                                        for (var15 = -var7; var15 <= var7; ++var15) {
                                            if (this.blocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11] == var12 - 1) {
                                                if (this.blocks[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2) {
                                                    this.blocks[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
                                                }

                                                if (this.blocks[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2) {
                                                    this.blocks[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
                                                }

                                                if (this.blocks[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] == -2) {
                                                    this.blocks[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] = var12;
                                                }

                                                if (this.blocks[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] == -2) {
                                                    this.blocks[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] = var12;
                                                }

                                                if (this.blocks[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] == -2) {
                                                    this.blocks[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] = var12;
                                                }

                                                if (this.blocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] == -2) {
                                                    this.blocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] = var12;
                                                }
                                            }
                                        }
                                    }
                                }

                                ++var12;
                            }
                        }

                        for (var13 = -var7; var13 <= var7; ++var13) {
                            for (var14 = -var7; var14 <= var7; ++var14) {
                                var15 = arg.getBlockId(i + var12, j + var13, k + var14);
                                if (var15 == AetherExBlocks.VoidWood.id) {
                                    this.blocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = 0;
                                } else if (var15 == AetherExBlocks.VoidLeaves.id) {
                                    this.blocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -2;
                                } else {
                                    this.blocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -1;
                                }
                            }
                        }

                        ++var12;
                    }
                }

                var12 = this.blocks[var11 * var10 + var11 * var9 + var11];
                if (var12 >= 0) {
                    arg.setBlockMetaWithoutNotifyingNeighbors(i, j, k, var6 & -9);
                } else {
                    this.dropAndRemove(arg, i, j, k);
                }
            }

        }
    }

    private void dropAndRemove(World arg, int i, int j, int k) {
        this.dropStacks(arg, i, j, k, arg.getBlockMeta(i, j, k));
        arg.setBlock(i, j, k, 0);
    }

    protected int getDroppedItemMeta(int i) {
        return i & 3;
    }

    public boolean isOpaque() {
        return false;
    }

    public boolean isSideVisible(BlockView iblockaccess, int i, int j, int k, int l) {
        iblockaccess.getBlockId(i, j, k);
        return true;
    }
}