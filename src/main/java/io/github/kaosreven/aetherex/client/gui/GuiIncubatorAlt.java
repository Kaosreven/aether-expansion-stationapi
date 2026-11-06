package io.github.kaosreven.aetherex.client.gui;

import io.github.kaosreven.aether.blockentity.block.BlockEntityIncubator;
import io.github.kaosreven.aether.blockentity.container.ContainerIncubator;
import io.github.kaosreven.aether.client.gui.GuiIncubator;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import org.lwjgl.opengl.GL11;

public class GuiIncubatorAlt extends GuiIncubator {
    private final BlockEntityIncubator incubatorInventory;

    public GuiIncubatorAlt(PlayerInventory inventoryplayer, BlockEntityIncubator tileentityIncubator) {
        super(inventoryplayer, tileentityIncubator);
        this.incubatorInventory = tileentityIncubator;
    }

    @Override
    protected void drawBackground(float f) {
        int i = this.minecraft.textureManager.getTextureId("/assets/aetherex/stationapi/textures/gui/IncubatorAlt.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.textureManager.bindTexture(i);
        int j = (this.width - this.backgroundWidth) / 2;
        int k = (this.height - this.backgroundHeight) / 2;
        this.drawTexture(j, k, 0, 0, this.backgroundWidth, this.backgroundHeight);
        int i1;
        if (this.incubatorInventory.isBurning()) {
            i1 = this.incubatorInventory.getBurnTimeRemainingScaled(12);
            this.drawTexture(j + 74, k + 47 - i1, 176, 12 - i1, 14, i1 + 2);
        }

        i1 = this.incubatorInventory.getCookProgressScaled(54);
        this.drawTexture(j + 103, k + 70 - i1, 179, 70 - i1, 10, i1);
    }
}
