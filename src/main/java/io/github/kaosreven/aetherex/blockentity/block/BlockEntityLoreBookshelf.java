package io.github.kaosreven.aetherex.blockentity.block;

import com.matthewperiut.aether.achievement.AetherAchievements;
import io.github.kaosreven.aetherex.client.gui.GuiLoreBookshelf;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockEntityLoreBookshelf extends BlockEntity {
    private ItemStack[] LoreItemStacks = new ItemStack[1];
    public BlockEntityLoreBookshelf() {

    }

    public int size() {
        return this.LoreItemStacks.length;
    }

    /*
    public ItemStack getStack(int i) {
        return this.LoreItemStacks[i];
    }

    public ItemStack removeStack(int i, int j) {
        if(this.LoreItemStacks[i] != null) {
            ItemStack itemstack1;
            if(this.LoreItemStacks[i].count <= j) {
                itemstack1 = this.LoreItemStacks[i];
                this.LoreItemStacks[i] = null;
                return itemstack1;
            } else {
                itemstack1 = this.LoreItemStacks[i].split(j);
                if(this.LoreItemStacks[i].count == 0) {
                    this.LoreItemStacks[i] = null;
                }

                return itemstack1;
            }
        } else {
            return null;
        }
    }

    public void setStack(int i, ItemStack itemstack) {
        this.LoreItemStacks[i] = itemstack;
        if(itemstack != null && itemstack.count > this.getMaxCountPerStack()) {
            itemstack.count = this.getMaxCountPerStack();
        }

    }

    public String getName() {
        return "Lore Bookshelf";
    }

    public int getMaxCountPerStack() {
        return 0;
    }

    public boolean canPlayerUse(PlayerEntity entityplayer) {
        return true;
    }
     */
}
