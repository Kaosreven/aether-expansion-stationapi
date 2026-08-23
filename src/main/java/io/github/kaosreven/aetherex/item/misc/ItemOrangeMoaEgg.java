package io.github.kaosreven.aetherex.item.misc;

import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemOrangeMoaEgg extends TemplateItem {
    public ItemOrangeMoaEgg(Identifier i) {
        super(i);
    }

    public int getColorMultiplier(int damage) {
        return 15560724;
    }
}
