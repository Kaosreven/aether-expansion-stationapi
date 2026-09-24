package io.github.kaosreven.aetherex.util;

import com.matthewperiut.aether.entity.living.EntityFlyingCow;
import com.matthewperiut.aether.entity.living.EntityMoa;
import com.matthewperiut.aether.entity.living.EntityPhyg;
import com.periut.accessoryapi.api.helper.AccessoryAccess;
import io.github.kaosreven.aetherex.entity.EntityOrangeMoa;
import io.github.kaosreven.aetherex.item.AetherExItems;
import io.github.kaosreven.aetherex.item.accessory.ItemAerCape;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.ScreenScaler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class JumpsDisplay {
    public static void gui(Minecraft client, InGameHud hud) {
        ScreenScaler var5 = new ScreenScaler(client.options, client.displayWidth, client.displayHeight);
        int scaledWidth = var5.getScaledWidth();
        int scaledHeight = var5.getScaledHeight();
        Item aerCape = null;

        int jumps = 0;
        int maxJumps = 0;

        if (client.player.vehicle instanceof EntityMoa moa) {
            maxJumps = moa.colour.jumps;
            jumps = maxJumps - moa.jrem;
        } else if (client.player.vehicle instanceof EntityOrangeMoa moa) {
            maxJumps = moa.getMaxJumps();
            jumps = maxJumps - moa.jrem;
        }
        else if (client.player.vehicle instanceof EntityPhyg phyg) {
            maxJumps = phyg.jumps;
            jumps = maxJumps - phyg.jrem;
        } else if (client.player.vehicle instanceof EntityFlyingCow cow) {
            maxJumps = cow.jumps;
            jumps = maxJumps - cow.jrem;
        } else {
            ItemStack[] list = AccessoryAccess.getAccessories(client.player, "cape");
            for (ItemStack itemStack : list) {
                if (itemStack.itemId == AetherExItems.AerCape.id) {
                    aerCape = AetherExItems.AerCape;
                    maxJumps = ItemAerCape.jumps;
                    jumps = maxJumps - ItemAerCape.jumpsRemaining;
                }
                else aerCape = null;
            }
        }

        if (aerCape != null && !client.player.hasVehicle()) GL11.glBindTexture(3553, client.textureManager.getTextureId("aetherex:stationapi/textures/gui/AerJump.png"));
        else GL11.glBindTexture(3553, client.textureManager.getTextureId("aether:stationapi/textures/gui/jumps.png"));

        int armorValue = client.player.getTotalArmorDurability();
        int offset = 1;
        if (armorValue == 0) {
            offset--;
        }
        for (int position = 0; position < maxJumps; ++position) {
            int yOffset = scaledHeight - 32 - ((offset) * 10) - (2);
            int xOffset = scaledWidth / 2 + 12 + (10 * (8 - maxJumps)) + (position * 10);
            if (position < jumps) {
                hud.drawTexture(xOffset, yOffset, 10, 0, 10, 11); // can't Jump
            } else {
                hud.drawTexture(xOffset, yOffset, 0, 0, 10, 11); // canJump
            }
        }
        GL11.glBindTexture(3553, client.textureManager.getTextureId("/gui/icons.png"));
    }
}
