package io.github.kaosreven.aetherex.item.misc;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateFoodItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemCandy extends TemplateFoodItem {
    private final int healAmount;
    public static int candy1;
    public static int candy2;
    public static int candy3;
    public static int candy4;

    public ItemCandy(Identifier i, int healAmount, boolean isWolfFood) {
        super(i, healAmount, isWolfFood);
        this.maxCount = 8;
        this.healAmount = healAmount;
        this.setHasSubtypes(true);
    }

    public int getTextureId(int damage) {
        return switch (damage) {
            case 1 -> candy2;
            case 2 -> candy3;
            case 3 -> candy4;
            default -> candy1;
        };
    }

    public ItemStack use(ItemStack itemstack, World world, PlayerEntity entityplayer) {
        --itemstack.count;
        entityplayer.heal(this.healAmount);
        return itemstack;
    }

    public int getHealAmount() {
        return this.healAmount;
    }
}