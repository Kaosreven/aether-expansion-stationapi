package io.github.kaosreven.aetherex.client.gui;

import com.matthewperiut.aether.client.gui.GuiLore;
import net.minecraft.entity.player.PlayerInventory;
import org.lwjgl.opengl.GL11;

public class GuiLoreBookshelf extends GuiLoreAlt {

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
            i = minecraft.textureManager.getTextureId("/assets/aetherex/stationapi/textures/gui/OverworldLoreAlt.png");
        }
        else if (this.type == 1) {
            i = minecraft.textureManager.getTextureId("/assets/aetherex/stationapi/textures/gui/NetherLoreAlt.png");
        }
        else {
            i = minecraft.textureManager.getTextureId("/assets/aetherex/stationapi/textures/gui/AetherLoreAlt.png");
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
            minecraft.soundManager.playSound("aetherex:other.page", 1.0F, 1.0F);
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