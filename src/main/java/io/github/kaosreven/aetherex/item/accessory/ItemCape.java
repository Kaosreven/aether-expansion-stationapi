package io.github.kaosreven.aetherex.item.accessory;

import com.matthewperiut.aether.item.accessory.ItemMoreArmor;
import com.periut.accessoryapi.api.render.AccessoryRenderer;
import com.periut.accessoryapi.api.render.HasCustomRenderer;
import com.periut.accessoryapi.api.render.builtin.CapeRenderer;
import com.periut.accessoryapi.api.render.builtin.ConfigurableRenderer;
import net.modificationstation.stationapi.api.util.Identifier;

import java.awt.*;

public class ItemCape extends ItemMoreArmor implements HasCustomRenderer {

    private ConfigurableRenderer renderer;

    public ItemCape(Identifier i, int j, String path, int l) {
        super(i, j, path, l);
    }

    public ItemCape(Identifier i, int j, String path, int l, int m) {
        super(i, j, path, l, m);
    }

    public ItemCape(Identifier i, int j, String path, int l, int m, boolean flag) {
        super(i, j, path, l, m, flag);
    }

    @Override
    public AccessoryRenderer getRenderer() {
        return renderer;
    }

    @Override
    public void constructRenderer() {
        if (colouriseRender) renderer = new CapeRenderer(texture).withColor(new Color(colour));
        else renderer = new CapeRenderer(texture);
    }
}
