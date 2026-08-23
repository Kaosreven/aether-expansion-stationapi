package io.github.kaosreven.aetherex.mixin;

import com.matthewperiut.aether.block.TreasureChest;
import com.matthewperiut.aether.item.AetherItems;
import io.github.kaosreven.aetherex.item.AetherExItems;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Random;

@Mixin(TreasureChest.class)
public class HijackTreasureChestLootMixin {
    /**
     * @author Kaosreven
     * @reason Overwrite bronze loot with Aether Expansion
     */
    @Overwrite
    private ItemStack getBronzeLoot(final Random random) {
        final int item = random.nextInt(15);
        return switch (item) {
            case 0 -> new ItemStack(AetherItems.GummieSwet, random.nextInt(8), random.nextInt(2));
            case 1 -> new ItemStack(AetherItems.PhoenixBow);
            case 2 -> new ItemStack(AetherItems.SwordFire);
            case 3 -> new ItemStack(AetherItems.HammerNotch);
            case 4 -> new ItemStack(AetherItems.LightningKnife, random.nextInt(16));
            case 5 -> new ItemStack(AetherItems.Lance);
            case 6 -> new ItemStack(AetherItems.AgilityCape);
            case 7 -> new ItemStack(AetherItems.CloudStaff);
            case 8 -> new ItemStack(AetherExItems.AerShield);
            case 9 -> new ItemStack(AetherExItems.FlameGem);
            case 10 -> new ItemStack(AetherExItems.WeakHealStaff);
            case 11 -> new ItemStack(AetherExItems.LuckyPendant);
            case 12 -> new ItemStack(AetherExItems.SpeedRing);
            case 13 -> new ItemStack(AetherExItems.BlueMoaStaff);
            case 14 -> new ItemStack(AetherExItems.MoaArmor, 1, 3);
            default -> new ItemStack(AetherItems.Stick);
        };
    }

    /**
     * @author Kaosreven
     * @reason Overwrite silver loot with Aether Expansion
     */
    @Overwrite
    private ItemStack getSilverLoot(final Random random) {
        final int item = random.nextInt(14);
        switch (item) {
            case 0:
                return new ItemStack(AetherItems.GummieSwet, random.nextInt(16));
            case 1:
                return new ItemStack(AetherItems.SwordLightning);
            case 2:
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.AxeValkyrie);
                }
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.ShovelValkyrie);
                }
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.PickValkyrie);
                }
                break;
            case 3:
                return new ItemStack(AetherItems.SwordHoly);
            case 4:
                return new ItemStack(AetherItems.GoldenFeather);
            case 5:
                return new ItemStack(AetherItems.RegenerationStone);
            case 6:
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.NeptuneHelmet);
                }
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.NeptuneLeggings);
                }
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.NeptuneChestplate);
                }
                break;
            case 7:
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.NeptuneBoots);
                }
                return new ItemStack(AetherItems.NeptuneGlove);
            case 8:
                return new ItemStack(AetherItems.InvisibilityCloak);
            case 9:
                return new ItemStack(AetherExItems.JebHammer);
            case 10:
                if (random.nextBoolean()) {
                    return new ItemStack(AetherExItems.PhoenixAxe);
                }
                if (random.nextBoolean()) {
                    return new ItemStack(AetherExItems.PhoenixShovel);
                }
                if (random.nextBoolean()) {
                    return new ItemStack(AetherExItems.PhoenixPick);
                }
            case 11:
                return new ItemStack(AetherExItems.StrongHealStaff);
            case 12:
                return new ItemStack(AetherExItems.WhiteMoaStaff);
            case 13:
                return new ItemStack(AetherExItems.JebShield);
        }
        return new ItemStack(AetherItems.ZanitePendant);
    }

    /**
     * @author Kaosreven
     * @reason Overwrite gold loot with Aether Expansion
     */
    @Overwrite
    private ItemStack getGoldLoot(final Random random) {
        final int item = random.nextInt(16);
        switch (item) {
            case 0:
                return new ItemStack(AetherItems.IronBubble);
            case 1:
                return new ItemStack(AetherItems.VampireBlade);
            case 2:
                return new ItemStack(AetherItems.PigSlayer);
            case 3:
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.PhoenixHelm);
                }
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.PhoenixLegs);
                }
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.PhoenixBody);
                }
                break;
            case 4:
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.PhoenixBoots);
                }
                return new ItemStack(AetherItems.PhoenixGlove);
            case 5:
                return new ItemStack(AetherItems.LifeShard);
            case 6:
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.GravititeHelmet);
                }
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.GravititePlatelegs);
                }
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.GravititeBodyplate);
                }
                break;
            case 7:
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.GravititeBoots);
                }
                return new ItemStack(AetherItems.GravititeGlove);
            case 8:
                return new ItemStack(AetherExItems.AerCape);
            case 9:
                return new ItemStack(AetherExItems.PhoenixSword);
            case 10:
                return new ItemStack(AetherExItems.SentryShield);
            case 11:
                return new ItemStack(AetherExItems.MineFist);
            case 12:
                return new ItemStack(AetherExItems.ResurrectionPendant);
            case 13:
                return new ItemStack(AetherExItems.ValkyrieRing);
            case 14:
                return new ItemStack(AetherExItems.BlackMoaStaff);
            case 15:
                return new ItemStack(AetherExItems.MoaArmor, 1, 4);
        }
        return new ItemStack(AetherItems.ObsidianBody);
    }
}
