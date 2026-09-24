package io.github.kaosreven.aetherex.item.accessory;

import com.matthewperiut.aether.item.accessory.ItemMoreArmor;
import com.periut.accessoryapi.api.render.AccessoryRenderer;
import com.periut.accessoryapi.api.render.HasCustomRenderer;
import com.periut.accessoryapi.api.render.builtin.NecklaceRenderer;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemPendant extends ItemMoreArmor implements HasCustomRenderer {
    AccessoryRenderer renderer;

    public ItemPendant(Identifier i, int j, String path, int l) {
        super(i, j, path, l);
    }

    @Override
    public AccessoryRenderer getRenderer() {
        return renderer;
    }

    @Override
    public void constructRenderer() {
        renderer = new NecklaceRenderer(texture);
    }
}
