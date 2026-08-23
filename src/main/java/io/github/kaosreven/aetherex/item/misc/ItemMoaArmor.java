package io.github.kaosreven.aetherex.item.misc;

import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemMoaArmor extends TemplateItem {
    public static int ironMoaArmor;
    public static int GoldMoaArmor;
    public static int DiamondMoaArmor;
    public static int ZaniteMoaArmor;
    public static int GravititeMoaArmor;

    public ItemMoaArmor(Identifier i) {
        super(i);
        this.maxCount = 1;
        this.setHasSubtypes(true);
    }

    @Override
    public String getTranslationKey(ItemStack itemstack) {
        int i = itemstack.getDamage();
        return this.getTranslationKey() + i;
    }

    public int getTextureId(int damage) {
        return switch (damage) {
            case 1 -> GoldMoaArmor;
            case 2 -> DiamondMoaArmor;
            case 3 -> ZaniteMoaArmor;
            case 4 -> GravititeMoaArmor;
            default -> ironMoaArmor;
        };
    }
}