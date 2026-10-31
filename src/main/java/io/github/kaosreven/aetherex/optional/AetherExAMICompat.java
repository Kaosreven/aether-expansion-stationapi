package io.github.kaosreven.aetherex.optional;

import io.github.kaosreven.aetherex.block.AetherExBlocks;
import io.github.kaosreven.aetherex.events.AetherEx;
import net.glasslauncher.mods.alwaysmoreitems.api.*;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.modificationstation.stationapi.api.util.Identifier;

public class AetherExAMICompat implements ModPluginProvider {
    public static final Identifier ID = AetherEx.NAMESPACE.id("aetherex");

    @Override
    public String getName() {
        return "Aether Expansion";
    }

    @Override
    public Identifier getId() {
        return ID;
    }

    @Override
    public void onAMIHelpersAvailable(AMIHelpers amiHelpers) {
    }

    @Override
    public void onItemRegistryAvailable(ItemRegistry itemRegistry) {
    }

    @Override
    public void register(ModRegistry registry) {
    }

    @Override
    public void onRecipeRegistryAvailable(RecipeRegistry recipeRegistry) {
    }

    @Override
    public SyncableRecipe deserializeRecipe(NbtCompound recipe) {
        return null;
    }

    @Override
    public void updateBlacklist(AMIHelpers amiHelpers) {
        ItemBlacklist blacklist = amiHelpers.getItemBlacklist();

        // Blocks
        blacklist.addItemToBlacklist(new ItemStack(AetherExBlocks.SkyrootSign));
        blacklist.addItemToBlacklist(new ItemStack(AetherExBlocks.SkyrootWallSign));
        blacklist.addItemToBlacklist(new ItemStack(AetherExBlocks.HolystoneFurnaceLit));
    }
}
