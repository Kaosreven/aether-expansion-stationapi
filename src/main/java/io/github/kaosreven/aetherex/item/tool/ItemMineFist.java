package io.github.kaosreven.aetherex.item.tool;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.hit.HitResultType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.item.CustomReachProvider;
import net.modificationstation.stationapi.api.util.Identifier;


public class ItemMineFist extends ItemGenericAetherPaxel implements CustomReachProvider {
    public static int mineTick = 0;
    public static boolean mineReady = true;
    public ItemMineFist(Identifier identifier, ToolMaterial material) {
        super(identifier, material);
    }

    @Override
    public boolean useOnBlock(ItemStack stack, PlayerEntity user, World world, int x, int y, int z, int side) {
        int seconds = mineTick / 20;
        int display = 10 - seconds;
        if (display < 0) mineReady = true;
        if(mineReady && !world.isRemote) {
            stack.damage(30, user);
            int yaw = MathHelper.floor((double)(user.yaw * 4.0F / 360.0F) + 0.5D) & 3;
            int pitch = MathHelper.floor((double)user.pitch);
            boolean pitch1 = pitch <= -60;
            boolean pitch2 = pitch >= 60;
            int i;
            if(pitch1) {
                world.playSound(x, y, z, "random.explode", 4.0F, (1.0F + (world.random.nextFloat() - world.random.nextFloat()) * 0.2F) * 0.7F);

                for(i = 0; i <= 6; ++i) {
                    this.breakBlockAt(x, y + i, z, user);
                    this.breakBlockAt(x + 1, y + i, z, user);
                    this.breakBlockAt(x - 1, y + i, z, user);
                    this.breakBlockAt(x + 1, y + i, z + 1, user);
                    this.breakBlockAt(x - 1, y + i, z + 1, user);
                    this.breakBlockAt(x, y + i, z + 1, user);
                    this.breakBlockAt(x, y + i, z - 1, user);
                    this.breakBlockAt(x + 1, y + i, z - 1, user);
                    this.breakBlockAt(x - 1, y + i, z - 1, user);
                    this.breakBlockAt(x + 2, y + i, z, user);
                    this.breakBlockAt(x - 2, y + i, z, user);
                    this.breakBlockAt(x, y + i, z + 2, user);
                    this.breakBlockAt(x, y + i, z - 2, user);
                    this.breakBlockAt(x + 2, y + i, z + 2, user);
                    this.breakBlockAt(x - 2, y + i, z - 2, user);
                    this.breakBlockAt(x + 2, y + i, z - 2, user);
                    this.breakBlockAt(x - 2, y + i, z + 2, user);
                    this.breakBlockAt(x + 2, y + i, z + 1, user);
                    this.breakBlockAt(x + 2, y + i, z - 1, user);
                    this.breakBlockAt(x - 2, y + i, z + 1, user);
                    this.breakBlockAt(x - 2, y + i, z - 1, user);
                    this.breakBlockAt(x - 1, y + i, z + 2, user);
                    this.breakBlockAt(x - 1, y + i, z - 2, user);
                    this.breakBlockAt(x + 1, y + i, z + 2, user);
                    this.breakBlockAt(x + 1, y + i, z - 2, user);
                }
            }

            if(pitch2) {
                world.playSound(x, y, z, "random.explode", 4.0F, (1.0F + (world.random.nextFloat() - world.random.nextFloat()) * 0.2F) * 0.7F);

                for(i = 0; i <= 6; ++i) {
                    this.breakBlockAt(x, y - i, z, user);
                    this.breakBlockAt(x + 1, y - i, z, user);
                    this.breakBlockAt(x - 1, y - i, z, user);
                    this.breakBlockAt(x + 1, y - i, z + 1, user);
                    this.breakBlockAt(x - 1, y - i, z + 1, user);
                    this.breakBlockAt(x, y - i, z + 1, user);
                    this.breakBlockAt(x, y - i, z - 1, user);
                    this.breakBlockAt(x + 1, y - i, z - 1, user);
                    this.breakBlockAt(x - 1, y - i, z - 1, user);
                    this.breakBlockAt(x + 2, y - i, z, user);
                    this.breakBlockAt(x - 2, y - i, z, user);
                    this.breakBlockAt(x, y - i, z + 2, user);
                    this.breakBlockAt(x, y - i, z - 2, user);
                    this.breakBlockAt(x + 2, y - i, z + 2, user);
                    this.breakBlockAt(x - 2, y - i, z - 2, user);
                    this.breakBlockAt(x + 2, y - i, z - 2, user);
                    this.breakBlockAt(x - 2, y - i, z + 2, user);
                    this.breakBlockAt(x + 2, y - i, z + 1, user);
                    this.breakBlockAt(x + 2, y - i, z - 1, user);
                    this.breakBlockAt(x - 2, y - i, z + 1, user);
                    this.breakBlockAt(x - 2, y - i, z - 1, user);
                    this.breakBlockAt(x - 1, y - i, z + 2, user);
                    this.breakBlockAt(x - 1, y - i, z - 2, user);
                    this.breakBlockAt(x + 1, y - i, z + 2, user);
                    this.breakBlockAt(x + 1, y - i, z - 2, user);
                }
            }

            if(yaw == 0 && !pitch1 && !pitch2) {
                world.playSound(x, y, z, "random.explode", 4.0F, (1.0F + (world.random.nextFloat() - world.random.nextFloat()) * 0.2F) * 0.7F);

                for(i = 0; i <= 6; ++i) {
                    this.breakBlockAt(x, y, z + i, user);
                    this.breakBlockAt(x, y + 1, z + i, user);
                    this.breakBlockAt(x - 1, y + 1, z + i, user);
                    this.breakBlockAt(x + 1, y + 1, z + i, user);
                    this.breakBlockAt(x - 1, y, z + i, user);
                    this.breakBlockAt(x + 1, y, z + i, user);
                    this.breakBlockAt(x + 1, y - 1, z + i, user);
                    this.breakBlockAt(x - 1, y - 1, z + i, user);
                    this.breakBlockAt(x, y - 1, z + i, user);
                    this.breakBlockAt(x + 2, y, z + i, user);
                    this.breakBlockAt(x - 2, y, z + i, user);
                    this.breakBlockAt(x, y + 2, z + i, user);
                    this.breakBlockAt(x, y - 2, z + i, user);
                    this.breakBlockAt(x + 2, y + 2, z + i, user);
                    this.breakBlockAt(x - 2, y - 2, z + i, user);
                    this.breakBlockAt(x + 2, y - 2, z + i, user);
                    this.breakBlockAt(x - 2, y + 2, z + i, user);
                    this.breakBlockAt(x + 2, y + 1, z + i, user);
                    this.breakBlockAt(x + 2, y - 1, z + i, user);
                    this.breakBlockAt(x - 2, y + 1, z + i, user);
                    this.breakBlockAt(x - 2, y - 1, z + i, user);
                    this.breakBlockAt(x - 1, y + 2, z + i, user);
                    this.breakBlockAt(x - 1, y - 2, z + i, user);
                    this.breakBlockAt(x + 1, y + 2, z + i, user);
                    this.breakBlockAt(x + 1, y - 2, z + i, user);
                }
            }

            if(yaw == 2 && !pitch1 && !pitch2) {
                world.playSound(x, y, z, "random.explode", 4.0F, (1.0F + (world.random.nextFloat() - world.random.nextFloat()) * 0.2F) * 0.7F);

                for(i = 0; i <= 6; ++i) {
                    this.breakBlockAt(x, y, z - i, user);
                    this.breakBlockAt(x, y + 1, z - i, user);
                    this.breakBlockAt(x - 1, y + 1, z - i, user);
                    this.breakBlockAt(x + 1, y + 1, z - i, user);
                    this.breakBlockAt(x - 1, y, z - i, user);
                    this.breakBlockAt(x + 1, y, z - i, user);
                    this.breakBlockAt(x + 1, y - 1, z - i, user);
                    this.breakBlockAt(x - 1, y - 1, z - i, user);
                    this.breakBlockAt(x, y - 1, z - i, user);
                    this.breakBlockAt(x + 2, y, z - i, user);
                    this.breakBlockAt(x - 2, y, z - i, user);
                    this.breakBlockAt(x, y + 2, z - i, user);
                    this.breakBlockAt(x, y - 2, z - i, user);
                    this.breakBlockAt(x + 2, y + 2, z - i, user);
                    this.breakBlockAt(x - 2, y - 2, z - i, user);
                    this.breakBlockAt(x + 2, y - 2, z - i, user);
                    this.breakBlockAt(x - 2, y + 2, z - i, user);
                    this.breakBlockAt(x + 2, y + 1, z - i, user);
                    this.breakBlockAt(x + 2, y - 1, z - i, user);
                    this.breakBlockAt(x - 2, y + 1, z - i, user);
                    this.breakBlockAt(x - 2, y - 1, z - i, user);
                    this.breakBlockAt(x - 1, y + 2, z - i, user);
                    this.breakBlockAt(x - 1, y - 2, z - i, user);
                    this.breakBlockAt(x + 1, y + 2, z - i, user);
                    this.breakBlockAt(x + 1, y - 2, z - i, user);
                }
            }

            if(yaw == 1 && !pitch1 && !pitch2) {
                world.playSound(x, y, z, "random.explode", 4.0F, (1.0F + (world.random.nextFloat() - world.random.nextFloat()) * 0.2F) * 0.7F);

                for(i = 0; i <= 6; ++i) {
                    this.breakBlockAt(x - i, y, z, user);
                    this.breakBlockAt(x - i, y, z - 1, user);
                    this.breakBlockAt(x - i, y, z + 1, user);
                    this.breakBlockAt(x - i, y + 1, z - 1, user);
                    this.breakBlockAt(x - i, y + 1, z, user);
                    this.breakBlockAt(x - i, y + 1, z + 1, user);
                    this.breakBlockAt(x - i, y - 1, z + 1, user);
                    this.breakBlockAt(x - i, y - 1, z, user);
                    this.breakBlockAt(x - i, y - 1, z - 1, user);
                    this.breakBlockAt(x - i, y, z + 2, user);
                    this.breakBlockAt(x - i, y, z - 2, user);
                    this.breakBlockAt(x - i, y + 2, z, user);
                    this.breakBlockAt(x - i, y - 2, z, user);
                    this.breakBlockAt(x - i, y + 2, z + 2, user);
                    this.breakBlockAt(x - i, y - 2, z - 2, user);
                    this.breakBlockAt(x - i, y - 2, z + 2, user);
                    this.breakBlockAt(x - i, y + 2, z - 2, user);
                    this.breakBlockAt(x - i, y + 1, z + 2, user);
                    this.breakBlockAt(x - i, y - 1, z + 2, user);
                    this.breakBlockAt(x - i, y + 1, z - 2, user);
                    this.breakBlockAt(x - i, y - 1, z - 2, user);
                    this.breakBlockAt(x - i, y + 2, z - 1, user);
                    this.breakBlockAt(x - i, y - 2, z - 1, user);
                    this.breakBlockAt(x - i, y + 2, z + 1, user);
                    this.breakBlockAt(x - i, y - 2, z + 1, user);
                }
            }

            if(yaw == 3 && !pitch1 && !pitch2) {
                world.playSound(x, y, z, "random.explode", 4.0F, (1.0F + (world.random.nextFloat() - world.random.nextFloat()) * 0.2F) * 0.7F);

                for(i = 0; i <= 6; ++i) {
                    this.breakBlockAt(x + i, y, z, user);
                    this.breakBlockAt(x + i, y, z - 1, user);
                    this.breakBlockAt(x + i, y, z + 1, user);
                    this.breakBlockAt(x + i, y + 1, z - 1, user);
                    this.breakBlockAt(x + i, y + 1, z, user);
                    this.breakBlockAt(x + i, y + 1, z + 1, user);
                    this.breakBlockAt(x + i, y - 1, z + 1, user);
                    this.breakBlockAt(x + i, y - 1, z, user);
                    this.breakBlockAt(x + i, y - 1, z - 1, user);
                    this.breakBlockAt(x + i, y, z + 2, user);
                    this.breakBlockAt(x + i, y, z - 2, user);
                    this.breakBlockAt(x + i, y + 2, z, user);
                    this.breakBlockAt(x + i, y - 2, z, user);
                    this.breakBlockAt(x + i, y + 2, z + 2, user);
                    this.breakBlockAt(x + i, y - 2, z - 2, user);
                    this.breakBlockAt(x + i, y - 2, z + 2, user);
                    this.breakBlockAt(x + i, y + 2, z - 2, user);
                    this.breakBlockAt(x + i, y + 1, z + 2, user);
                    this.breakBlockAt(x + i, y - 1, z + 2, user);
                    this.breakBlockAt(x + i, y + 1, z - 2, user);
                    this.breakBlockAt(x + i, y - 1, z - 2, user);
                    this.breakBlockAt(x + i, y + 2, z - 1, user);
                    this.breakBlockAt(x + i, y - 2, z - 1, user);
                    this.breakBlockAt(x + i, y + 2, z + 1, user);
                    this.breakBlockAt(x + i, y - 2, z + 1, user);
                }
            }
            mineTick = 0;
            mineReady = false;
        } else {
            if (!world.isRemote) {
                user.sendMessage("You must wait seconds " + display + " seconds before doing that.");
            }
        }
        return false;
    }

    private void breakBlockAt(int x, int y, int z, LivingEntity miner) {
        Block toBreak = miner.world.getBlockState(x, y, z).getBlock();
        if(toBreak != null && toBreak.getHardness() > 0.0F && !miner.world.isRemote) {
            toBreak.dropStacks(miner.world, x, y, z, miner.world.getBlockMeta(x, y, z));
            miner.world.setBlock(x, y, z, 0);
        }
    }

    @Override
    public double getReach(ItemStack itemStack, PlayerEntity playerEntity, HitResultType hitType, double v) {
        return 8.0F;
    }
}
