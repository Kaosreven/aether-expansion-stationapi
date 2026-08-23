package io.github.kaosreven.aetherex.client.gui;

import com.matthewperiut.aether.client.gui.GuiIncubator;
import io.github.kaosreven.aetherex.blockentity.block.BlockEntityAdvancedIncubator;
import net.minecraft.entity.player.PlayerInventory;
import org.lwjgl.opengl.GL11;

public class GuiAdvancedIncubator extends GuiIncubator {

    public GuiAdvancedIncubator(PlayerInventory inventoryplayer, BlockEntityAdvancedIncubator tileentityIncubator) {
        super(inventoryplayer, tileentityIncubator);
    }

    @Override
    protected void drawForeground() {
        this.textRenderer.draw("Advanced Incubator", 37, 6, 4210752);
        this.textRenderer.draw("Inventory", 8, this.backgroundHeight - 96 + 2, 4210752);
    }
}
