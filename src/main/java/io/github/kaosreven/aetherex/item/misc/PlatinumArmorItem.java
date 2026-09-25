package io.github.kaosreven.aetherex.item.misc;

import net.minecraft.item.ArmorItem;
import net.modificationstation.stationapi.api.client.item.ArmorTextureProvider;
import net.modificationstation.stationapi.api.template.item.TemplateArmorItem;
import net.modificationstation.stationapi.api.util.Identifier;

import static io.github.kaosreven.aetherex.item.AetherExItems.MOD_ID;

public class PlatinumArmorItem extends TemplateArmorItem implements ArmorTextureProvider {

    public PlatinumArmorItem(Identifier identifier, int type, int slot) {
        super(identifier, type, 0, slot);
    }

    @Override
    public Identifier getTexture(ArmorItem armor) {
        return Identifier.of(MOD_ID, "platinum");
    }
}