package io.github.kaosreven.aetherex.item.tool;

import com.matthewperiut.aether.block.AetherBlocks;
import com.periut.accessoryapi.api.helper.AccessoryAccess;
import io.github.kaosreven.aetherex.item.AetherExItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

import static io.github.kaosreven.aetherex.item.accessory.ItemLuckyPendant.luckyRandomReady;
import static io.github.kaosreven.aetherex.item.accessory.ItemLuckyPendant.luckyRandomTick;

public class ItemJebHammer extends ItemGenericAetherPaxel {
    public static boolean areaMode = false;
    public ItemJebHammer(Identifier identifier, ToolMaterial material) {
        super(identifier, material);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack itemstack, Block block) {
        return !areaMode ? 12.0F : 6.0F;
    }

    @Override
    public ItemStack use(ItemStack stack, World world, PlayerEntity user) {
        if(FabricLoader.INSTANCE.getEnvironmentType() == EnvType.CLIENT && world.isRemote) return stack;
        NbtCompound nbtCompound = stack.getStationNbt();
        areaMode = nbtCompound.getBoolean("areaMode");
        if (areaMode) user.sendMessage("Area mode disabled");
        else user.sendMessage("Area mode enabled");
        areaMode = !areaMode;
        nbtCompound.putBoolean("areaMode", areaMode);
        return stack;
    }

    @Override
    public boolean postMine(ItemStack stack, int blockId, int x, int y, int z, LivingEntity miner) {
        if (!areaMode && luckyRandomReady) {
            Block toBreak = BlockRegistry.INSTANCE.get(blockId);
            int Dropped = toBreak.getDroppedItemId(0, null);
            if (blockId == AetherBlocks.AmbrosiumOre.id || blockId == AetherBlocks.ZaniteOre.id || blockId == AetherBlocks.GravititeOre.id) {
                int next = (new Random()).nextInt(20);
                if(next == 1 || next == 2 || next == 3) {
                    ItemEntity result = new ItemEntity(miner.world, x, y, z, new ItemStack(Dropped, 1, 0));
                    miner.world.spawnEntity(result);
                    luckyRandomTick = 0;
                    luckyRandomReady = false;
                    ItemStack[] list = AccessoryAccess.getAccessories((PlayerEntity) miner, "pendant");
                    for (ItemStack itemStack : list) {
                        if (itemStack.itemId == AetherExItems.LuckyPendant.id) {
                            itemStack.damage(1, miner);
                        }
                    }
                }
            }
        }
        areaModeHandling(stack, x, y, z , miner);
        return true;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int i, boolean flag) {
        NbtCompound nbtCompound = stack.getStationNbt();
        if (areaMode != nbtCompound.getBoolean("areaMode")) areaMode = nbtCompound.getBoolean("areaMode");
    }

    private void areaModeHandling(ItemStack stack, int x, int y, int z, LivingEntity miner) {
        World world = miner.world;
        int pitch = MathHelper.floor((double)miner.pitch);
        int rot = MathHelper.floor((double)(miner.yaw * 4.0F / 360.0F) + 0.5D) & 3;
        if(!world.isRemote) {
            if(!areaMode) {
                stack.damage(1, miner);
            } else {
                stack.damage(5, miner);
                if(pitch < 60 && pitch > -60) {
                    if(rot == 0 || rot == 2) {
                        this.breakBlockAt(x, y + 1, z, miner);
                        this.breakBlockAt(x - 1, y + 1, z, miner);
                        this.breakBlockAt(x + 1, y + 1, z, miner);
                        this.breakBlockAt(x - 1, y, z, miner);
                        this.breakBlockAt(x + 1, y, z, miner);
                        this.breakBlockAt(x + 1, y - 1, z, miner);
                        this.breakBlockAt(x - 1, y - 1, z, miner);
                        this.breakBlockAt(x, y - 1, z, miner);
                    }

                    if(rot == 1 || rot == 3) {
                        this.breakBlockAt(x, y, z - 1, miner);
                        this.breakBlockAt(x, y, z + 1, miner);
                        this.breakBlockAt(x, y + 1, z - 1, miner);
                        this.breakBlockAt(x, y + 1, z, miner);
                        this.breakBlockAt(x, y + 1, z + 1, miner);
                        this.breakBlockAt(x, y - 1, z + 1, miner);
                        this.breakBlockAt(x, y - 1, z, miner);
                        this.breakBlockAt(x, y - 1, z - 1, miner);
                    }

                } else {
                    this.breakBlockAt(x + 1, y, z, miner);
                    this.breakBlockAt(x - 1, y, z, miner);
                    this.breakBlockAt(x + 1, y, z + 1, miner);
                    this.breakBlockAt(x - 1, y, z + 1, miner);
                    this.breakBlockAt(x, y, z + 1, miner);
                    this.breakBlockAt(x, y, z - 1, miner);
                    this.breakBlockAt(x + 1, y, z - 1, miner);
                    this.breakBlockAt(x - 1, y, z - 1, miner);
                }
            }
        }
    }

    private void breakBlockAt(int x, int y, int z, LivingEntity miner) {
        Block toBreak = miner.world.getBlockState(x, y, z).getBlock();
        if(areaMode && toBreak != null && toBreak.getHardness() > 0.0F && !miner.world.isRemote) {
            toBreak.dropStacks(miner.world, x, y, z, miner.world.getBlockMeta(x, y, z));
            miner.world.setBlock(x, y, z, 0);
        }
    }
}
