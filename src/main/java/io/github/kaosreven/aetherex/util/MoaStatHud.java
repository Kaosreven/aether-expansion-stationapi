package io.github.kaosreven.aetherex.util;

import io.github.kaosreven.aetherex.entity.EntityOrangeMoa;
import net.minecraft.client.Minecraft;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.hud.InGameHud;

import java.text.DecimalFormat;
import java.util.HashMap;

import static io.github.kaosreven.aetherex.events.AetherEx.moaGuiToogle;

public class MoaStatHud {
    public static HashMap<Integer, String> armorMap = new HashMap<>();
    public static void gui(Minecraft client) {
        if (moaGuiToogle && client.player.vehicle instanceof EntityOrangeMoa moa) {
            TextRenderer font = client.textRenderer;
            String armor = armorMap.get(moa.getArmor());
            String ballStatus = moa.getFireball() ? "Unlocked":"Locked";

            /*
            String ready;
            if (moa.getShoot()) {
                ready = "Ready";
            } else {
                ready = "Not Ready";
            }
             */

            font.drawWithShadow("\u00a7cMoa Stats", 2, 2, 16777215);
            font.drawWithShadow("\u00a7aUpgrades Available: " + moa.getUpgrades(), 2, 15, 16777215);
            DecimalFormat df = new DecimalFormat("#.##");
            //font.drawWithShadow("\u00a7aSpeed Factor: " + df.format((double) moa.speedfactor) + "x", 2, 28, 16777215);
            font.drawWithShadow("\u00a7aJumps: " + moa.getMaxJumps(), 2, 41, 16777215);
            font.drawWithShadow("\u00a7aUpgrade Increase: " + moa.getUpgradeIncrease(), 2, 54, 16777215);
            font.drawWithShadow("\u00a7aArmor: " + armor, 2, 67, 16777215);
            font.drawWithShadow("\u00a7aHealth: " + moa.health, 2, 80, 16777215);
            font.drawWithShadow("\u00a7aFireball: " + ballStatus, 2, 93, 16777215);
            /*
            if (moa.getFireball()) {
                font.drawWithShadow("\u00a7aFireball Status: " + ready, 2, 106, 16777215);
            }
             */
        }
    }

    static {
        armorMap.put(-1, "None");
        armorMap.put(0, "Iron");
        armorMap.put(1, "Gold");
        armorMap.put(2, "Diamond");
        armorMap.put(3, "Zanite");
        armorMap.put(4, "Gravitite");
    }
}
