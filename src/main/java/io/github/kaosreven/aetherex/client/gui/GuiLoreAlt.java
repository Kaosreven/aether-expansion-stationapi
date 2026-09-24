package io.github.kaosreven.aetherex.client.gui;

import com.matthewperiut.aether.client.gui.GuiLore;
import io.github.kaosreven.aetherex.optional.AetherExConfig;
import net.minecraft.entity.player.PlayerInventory;
import org.lwjgl.opengl.GL11;

public class GuiLoreAlt extends GuiLore {

    public GuiLoreAlt(PlayerInventory inv, int i) {
        super(inv, i);
        this.type = i;
    }

    @Override
    protected void drawBackground(final float tickDelta) {
        this.backgroundWidth = 256;
        this.backgroundHeight = 195;
        int i;
        switch(this.type) {
            case 0:
                if (AetherExConfig.CONFIG.EnableFancyGui) {
                    i = minecraft.textureManager.getTextureId("/assets/aetherex/stationapi/textures/gui/OverworldLoreAlt.png");
                }
                else i = minecraft.textureManager.getTextureId("/assets/aetherex/stationapi/textures/gui/OverworldLore.png");
                break;
            case 1:
                if (AetherExConfig.CONFIG.EnableFancyGui) {
                    i = minecraft.textureManager.getTextureId("/assets/aetherex/stationapi/textures/gui/NetherLoreAlt.png");
                }
                else i = minecraft.textureManager.getTextureId("/assets/aetherex/stationapi/textures/gui/NetherLore.png");
                break;
            default:
                if (AetherExConfig.CONFIG.EnableFancyGui) {
                    i = minecraft.textureManager.getTextureId("/assets/aetherex/stationapi/textures/gui/AetherLoreAlt.png");
                }
                else i = minecraft.textureManager.getTextureId("/assets/aetherex/stationapi/textures/gui/AetherLore.png");
                break;
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
    }
}