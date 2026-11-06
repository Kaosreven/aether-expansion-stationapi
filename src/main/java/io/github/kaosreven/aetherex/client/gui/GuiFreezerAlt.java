package io.github.kaosreven.aetherex.client.gui;

import io.github.kaosreven.aether.blockentity.block.BlockEntityFreezer;
import io.github.kaosreven.aether.blockentity.container.ContainerFreezer;
import io.github.kaosreven.aether.client.gui.GuiFreezer;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import org.lwjgl.opengl.GL11;

public class GuiFreezerAlt extends GuiFreezer {
    private final BlockEntityFreezer freezerInventory;

    public GuiFreezerAlt(PlayerInventory inventoryplayer, BlockEntityFreezer tileentityFreezer) {
        super(inventoryplayer, tileentityFreezer);
        this.freezerInventory = tileentityFreezer;
    }

    @Override
    protected void drawBackground(float f) {
        int i = this.minecraft.textureManager.getTextureId("/assets/aetherex/stationapi/textures/gui/EnchanterAlt.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.textureManager.bindTexture(i);
        int j = (this.width - this.backgroundWidth) / 2;
        int k = (this.height - this.backgroundHeight) / 2;
        this.drawTexture(j, k, 0, 0, this.backgroundWidth, this.backgroundHeight);
        int i1;
        if (this.freezerInventory.isBurning()) {
            i1 = this.freezerInventory.getBurnTimeRemainingScaled(12);
            this.drawTexture(j + 57, k + 47 - i1, 176, 12 - i1, 14, i1 + 2);
        }

        i1 = this.freezerInventory.getCookProgressScaled(24);
        this.drawTexture(j + 79, k + 35, 176, 14, i1 + 1, 16);
    }
}
