package io.github.kaosreven.aetherex.block;

import io.github.kaosreven.aetherex.blockentity.block.BlockEntityLoreBookshelf;
import io.github.kaosreven.aetherex.client.gui.GuiLoreBookshelf;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlockWithEntity;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.SideUtil;

public class LoreBookshelf extends TemplateBlockWithEntity {
    public static int topTexture;
    public static int sideTexture;

    protected LoreBookshelf(Identifier blockID) {
        super(blockID, Material.WOOD);
    }

    @Override
    public int getTexture(int i) {
        if (i == 1) {
            return topTexture;
        } else {
            return i == 0 ? topTexture : sideTexture;
        }
    }

    @Override
    public boolean onUse(World world, int i, int j, int k, PlayerEntity player) {
        if (!world.isRemote) {
            SideUtil.run(() -> useLoreClient(player), () -> useLoreServer(player));
        }
        return true;
    }

    @Override
    protected BlockEntity createBlockEntity() {
        return new BlockEntityLoreBookshelf();
    }

    @Environment(EnvType.SERVER)
    public void useLoreServer(final PlayerEntity player) {
    }

    @Environment(EnvType.CLIENT)
    public static void useLoreClient(final PlayerEntity player) {
        //noinspection deprecation
        if (FabricLoader.getInstance().getGameInstance() instanceof Minecraft mc) {
            mc.setScreen(new GuiLoreBookshelf(player.inventory, 0));
        }
    }
}
