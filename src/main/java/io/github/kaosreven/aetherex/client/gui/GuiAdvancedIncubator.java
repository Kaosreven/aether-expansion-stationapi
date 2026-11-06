package io.github.kaosreven.aetherex.client.gui;

import io.github.kaosreven.aether.client.gui.GuiIncubator;
import io.github.kaosreven.aetherex.blockentity.block.BlockEntityAdvancedIncubator;
import net.minecraft.entity.player.PlayerInventory;

public class GuiAdvancedIncubator extends GuiIncubatorAlt {

    public GuiAdvancedIncubator(PlayerInventory inventoryplayer, BlockEntityAdvancedIncubator tileentityIncubator) {
        super(inventoryplayer, tileentityIncubator);
    }

    @Override
    protected void drawForeground() {
        this.textRenderer.draw("Advanced Incubator", 37, 6, 4210752);
        this.textRenderer.draw("Inventory", 8, this.backgroundHeight - 96 + 2, 4210752);
    }
}
