package io.github.kaosreven.aetherex.item.accessory;

import com.matthewperiut.aether.item.accessory.ItemMoreArmor;
import com.periut.accessoryapi.api.render.AccessoryRenderer;
import com.periut.accessoryapi.api.render.HasCustomRenderer;
import com.periut.accessoryapi.api.render.builtin.GloveRenderer;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemGloves extends ItemMoreArmor implements HasCustomRenderer {
    AccessoryRenderer renderer;

    public ItemGloves(Identifier i, int j, String path, int l, int m) {
        super(i, j, path, l, m);
    }

    public ItemGloves(Identifier i, int j, String path, int l) {
        super(i, j, path, l);
    }

    @Override
    public AccessoryRenderer getRenderer() {
        return renderer;
    }

    @Override
    public void constructRenderer() {
        renderer = new GloveRenderer(texture);
    }
}
