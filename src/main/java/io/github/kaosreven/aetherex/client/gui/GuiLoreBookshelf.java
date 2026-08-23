package io.github.kaosreven.aetherex.client.gui;

import com.matthewperiut.aether.achievement.AetherAchievements;
import com.matthewperiut.aether.block.AetherBlocks;
import com.matthewperiut.aether.blockentity.container.ContainerLore;
import com.matthewperiut.aether.client.gui.GuiLore;
import com.matthewperiut.aether.item.AetherItems;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

public class GuiLoreBookshelf extends GuiLore {

    public GuiLoreBookshelf(PlayerInventory inv, int i) {
        super(inv, i);
        this.type = i;
    }

    @Override
    protected void drawBackground(final float tickDelta) {
        this.backgroundWidth = 256;
        this.backgroundHeight = 195;
        int i;
        if (this.type == 0) {
            i = minecraft.textureManager.getTextureId("/assets/aetherex/stationapi/textures/gui/OverworldLore.png");
        }
        else if (this.type == 1) {
            i = minecraft.textureManager.getTextureId("/assets/aetherex/stationapi/textures/gui/NetherLore.png");
        }
        else {
            i = minecraft.textureManager.getTextureId("/assets/aetherex/stationapi/textures/gui/AetherLore.png");
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        minecraft.textureManager.bindTexture(i);
        final int j = (this.width - this.backgroundWidth) / 2;
        final int k = (this.height - this.backgroundHeight) / 2;
        this.drawTexture(j, k, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }

    @Override
    protected void mouseClicked(int i, int j, int k) {
        super.mouseClicked(i, j, k);
        int l = (this.width - this.backgroundWidth) / 2;
        int i1 = (this.height - this.backgroundHeight) / 2;
        i -= l;
        j -= i1;
        if (i >= 219 && i <= 238 && j <= 99 && j >= 86) {
            if (k == 0) {
                if (this.type != 0 && this.type != 1) {
                    this.type = 0;
                } else {
                    ++this.type;
                }
            } else if (k == 1) {
                if (this.type != 2 && this.type != 1) {
                    this.type = 2;
                } else {
                    --this.type;
                }
            }
        }
    }
}