package io.github.kaosreven.aetherex.events;

import com.matthewperiut.aether.block.AetherBlocks;
import com.matthewperiut.aether.blockentity.block.BlockEntityEnchanter;
import com.matthewperiut.aether.item.AetherItems;
import io.github.kaosreven.aetherex.block.AetherExBlocks;
import io.github.kaosreven.aetherex.item.AetherExItems;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;

import java.util.Objects;

import static io.github.kaosreven.aetherex.events.AetherEx.isNFCAddonPresent;
import static io.github.kaosreven.aetherex.events.AetherEx.isStoneWallPresent;

public class AetherExRecipes {
    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {
        RecipeRegisterEvent.Vanilla type = RecipeRegisterEvent.Vanilla.fromType(event.recipeId);
        if (Objects.requireNonNull(type) == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPED) {
            CraftingRegistry.addShapedRecipe(new ItemStack(AetherExItems.PinkCape), "XX", "XX", "XX", 'X', new ItemStack(Block.WOOL, 1, 6));
            CraftingRegistry.addShapedRecipe(new ItemStack(AetherExItems.PinkCape), "XX", "XX", "XX", 'X', new ItemStack(Block.WOOL, 1, 2));
            CraftingRegistry.addShapedRecipe(new ItemStack(AetherExItems.PurpleCape), "XX", "XX", "XX", 'X', new ItemStack(Block.WOOL, 1, 10));
            CraftingRegistry.addShapedRecipe(new ItemStack(AetherExItems.OrangeCape), "XX", "XX", "XX", 'X', new ItemStack(Block.WOOL, 1, 1));
            CraftingRegistry.addShapedRecipe(new ItemStack(AetherExItems.BrownCape), "XX", "XX", "XX", 'X', new ItemStack(Block.WOOL, 1, 12));
            CraftingRegistry.addShapedRecipe(new ItemStack(AetherExItems.LimeCape), "XX", "XX", "XX", 'X', new ItemStack(Block.WOOL, 1, 5));
            CraftingRegistry.addShapedRecipe(new ItemStack(AetherExItems.BlackCape), "XX", "XX", "XX", 'X', new ItemStack(Block.WOOL, 1, 15));
            CraftingRegistry.addShapedRecipe(new ItemStack(AetherExItems.BlackCape), "XX", "XX", "XX", 'X', new ItemStack(Block.WOOL, 1, 7));
            CraftingRegistry.addShapedRecipe(new ItemStack(AetherExItems.LimeCape), "XX", "XX", "XX", 'X', new ItemStack(Block.WOOL, 1, 13));
            CraftingRegistry.addShapedRecipe(new ItemStack(AetherExItems.HealMatrix), "XYX", 'X', AetherItems.RegenerationStone, 'Y', AetherItems.GoldenAmber);
            CraftingRegistry.addShapedRecipe(new ItemStack(AetherExItems.OrangeMoaEgg), "XXX", "XYX", "XXX", 'X', AetherExItems.GoldenElixir, 'Y', new ItemStack(AetherItems.MoaEgg, 1, 1));
            CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.AdvancedIncubator), "XYX", "YZY", "XYX", 'X', AetherBlocks.EnchantedGravitite, 'Y', AetherExItems.GoldenElixir, 'Z', AetherBlocks.Incubator);
            CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.BookshelfOfLore), "XXX", "ABC", "XXX", 'X', AetherBlocks.Plank, 'A', new ItemStack(AetherItems.LoreBook, 1, 0), 'B', new ItemStack(AetherItems.LoreBook, 1, 1), 'C', new ItemStack(AetherItems.LoreBook, 1, 2));
            CraftingRegistry.addShapedRecipe(new ItemStack(AetherExItems.GoldenBrew), "XYX", "YZY", "XYX", 'X', AetherItems.GoldenAmber, 'Y', AetherExItems.GoldenElixir, 'Z', new ItemStack(AetherItems.Bucket, 1, 3));
            CraftingRegistry.addShapedRecipe(new ItemStack(AetherExItems.ZaniteShears), " X", "X ", 'X', AetherItems.Zanite);
            if (!isNFCAddonPresent) {
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.SkyrootStairs, 4), "X  ", "XX ", "XXX", 'X', AetherBlocks.Plank);
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.HolystoneStairs, 4), "X  ", "XX ", "XXX", 'X', new ItemStack(AetherBlocks.Holystone, 1, 1));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.MossyHolystoneStairs, 4), "X  ", "XX ", "XXX", 'X', new ItemStack(AetherBlocks.Holystone, 1, 3));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.CarvedStairs, 4), "X  ", "XX ", "XXX", 'X', new ItemStack(AetherBlocks.DungeonStone, 1, 0));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.CarvedLitStairs, 4), "X  ", "XX ", "XXX", 'X', new ItemStack(AetherBlocks.LightDungeonStone, 1, 0));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.AngelicStairs, 4), "X  ", "XX ", "XXX", 'X', new ItemStack(AetherBlocks.DungeonStone, 1, 1));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.AngelicLitStairs, 4), "X  ", "XX ", "XXX", 'X', new ItemStack(AetherBlocks.LightDungeonStone, 1, 1));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.HellfireStairs, 4), "X  ", "XX ", "XXX", 'X', new ItemStack(AetherBlocks.DungeonStone, 1, 2));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.HellfireLitStairs, 4), "X  ", "XX ", "XXX", 'X', new ItemStack(AetherBlocks.LightDungeonStone, 1, 2));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.AerogelStairs, 4), "X  ", "XX ", "XXX", 'X', new ItemStack(AetherBlocks.Aerogel, 1));

                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.SkyrootSlab, 3), "XXX", 'X', AetherBlocks.Plank);
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.HolystoneSlab, 3), "XXX", 'X', new ItemStack(AetherBlocks.Holystone, 1, 1));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.MossyHolystoneSlab, 3), "XXX", 'X', new ItemStack(AetherBlocks.Holystone, 1, 3));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.CarvedSlab, 3), "XXX", 'X', new ItemStack(AetherBlocks.DungeonStone, 1, 0));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.CarvedLitSlab, 3), "XXX", 'X', new ItemStack(AetherBlocks.LightDungeonStone, 1, 0));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.AngelicSlab, 3), "XXX", 'X', new ItemStack(AetherBlocks.DungeonStone, 1, 1));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.AngelicLitSlab, 3), "XXX", 'X', new ItemStack(AetherBlocks.LightDungeonStone, 1, 1));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.HellfireSlab, 3), "XXX", 'X', new ItemStack(AetherBlocks.DungeonStone, 1, 2));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.HellfireLitSlab, 3), "XXX", 'X', new ItemStack(AetherBlocks.LightDungeonStone, 1, 2));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.AerogelSlab, 3), "XXX", 'X', new ItemStack(AetherBlocks.Aerogel, 1));

                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.SkyrootPlate), "XX ", 'X', AetherBlocks.Plank);
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.HolystonePlate), "XX ", 'X', new ItemStack(AetherBlocks.Holystone, 1, 1));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.MossyHolystonePlate), "XX ", 'X', new ItemStack(AetherBlocks.Holystone, 1, 3));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.CarvedPlate), "XX ", 'X', new ItemStack(AetherBlocks.DungeonStone, 1, 0));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.CarvedLitPlate), "XX ", 'X', new ItemStack(AetherBlocks.LightDungeonStone, 1, 0));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.AngelicPlate), "XX ", 'X', new ItemStack(AetherBlocks.DungeonStone, 1, 1));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.AngelicLitPlate), "XX ", 'X', new ItemStack(AetherBlocks.LightDungeonStone, 1, 1));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.HellfirePlate), "XX ", 'X', new ItemStack(AetherBlocks.DungeonStone, 1, 2));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.HellfireLitPlate), "XX ", 'X', new ItemStack(AetherBlocks.LightDungeonStone, 1, 2));
            }
            if (isStoneWallPresent) {
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.HolystoneWall, 6), "###", "###", '#', new ItemStack(AetherBlocks.Holystone, 1, 1));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.MossyHolystoneWall, 6), "###", "###", '#', new ItemStack(AetherBlocks.Holystone, 1, 3));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.CarvedWall, 6), "###", "###", '#', new ItemStack(AetherBlocks.DungeonStone, 1, 0));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.AngelicWall, 6), "###", "###", '#', new ItemStack(AetherBlocks.DungeonStone, 1, 1));
                CraftingRegistry.addShapedRecipe(new ItemStack(AetherExBlocks.HellfireWall, 6), "###", "###", '#', new ItemStack(AetherBlocks.DungeonStone, 1, 2));
            }
        }
        BlockEntityEnchanter.addEnchantment(new ItemStack(AetherExItems.SentryShield, 1), new ItemStack(AetherExItems.SentryShield, 1), 20000);
        BlockEntityEnchanter.addEnchantment(new ItemStack(AetherExItems.LuckyPendant, 1), new ItemStack(AetherExItems.LuckyPendant, 1), 7500);
        BlockEntityEnchanter.addEnchantment(new ItemStack(AetherExItems.JebShield, 1), new ItemStack(AetherExItems.JebShield, 1), 12500);
        BlockEntityEnchanter.addEnchantment(new ItemStack(AetherExItems.AerShield, 1), new ItemStack(AetherExItems.AerShield, 1), 7500);
        BlockEntityEnchanter.addEnchantment(new ItemStack(AetherExItems.ChainGloves, 1), new ItemStack(AetherExItems.ChainGloves, 1), 1000);
        BlockEntityEnchanter.addEnchantment(new ItemStack(AetherExItems.AerCape, 1), new ItemStack(AetherExItems.AerCape, 1), 20000);
    }
}
