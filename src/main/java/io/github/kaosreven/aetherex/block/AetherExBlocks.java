package io.github.kaosreven.aetherex.block;

import com.slainlight.stonewall.block.WallBlock;
import io.github.kaosreven.aetherex.block.template.*;
import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.PressurePlateActivationRule;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class AetherExBlocks {
    @Entrypoint.Namespace
    public static Namespace MOD_ID = Null.get();

    public static Block AdvancedIncubator;
    public static Block VoidWood;
    public static Block VoidLeaves;
    public static Block BookshelfOfLore;

    public static Block SkyrootStairs;
    public static Block HolystoneStairs;
    public static Block MossyHolystoneStairs;
    public static Block CarvedStairs;
    public static Block CarvedLitStairs;
    public static Block AngelicStairs;
    public static Block AngelicLitStairs;
    public static Block HellfireStairs;
    public static Block HellfireLitStairs;
    public static Block AerogelStairs;

    public static Block SkyrootSlab;
    public static Block HolystoneSlab;
    public static Block MossyHolystoneSlab;
    public static Block CarvedSlab;
    public static Block CarvedLitSlab;
    public static Block AngelicSlab;
    public static Block AngelicLitSlab;
    public static Block HellfireSlab;
    public static Block HellfireLitSlab;
    public static Block AerogelSlab;

    public static Block SkyrootPlate;
    public static Block HolystonePlate;
    public static Block MossyHolystonePlate;
    public static Block CarvedPlate;
    public static Block CarvedLitPlate;
    public static Block AngelicPlate;
    public static Block AngelicLitPlate;
    public static Block HellfirePlate;
    public static Block HellfireLitPlate;

    public static Block HolystoneWall;
    public static Block MossyHolystoneWall;
    public static Block CarvedWall;
    public static Block AngelicWall;
    public static Block HellfireWall;

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        VoidWood = (new VoidLog(Identifier.of(MOD_ID, "void_log"))).setHardness(2.0F).setSoundGroup(Block.WOOD_SOUND_GROUP).setTranslationKey(MOD_ID, "void_log");
        VoidLeaves = (new VoidLeaves(Identifier.of(MOD_ID, "void_leaves"))).setHardness(0.2F).setOpacity(1).setSoundGroup(Block.DIRT_SOUND_GROUP).setTranslationKey(MOD_ID, "void_leaves");
        AdvancedIncubator = (new AdvancedIncubator(Identifier.of(MOD_ID, "advanced_incubator"))).setTranslationKey(MOD_ID, "advanced_incubator").setHardness(2.0F);
        BookshelfOfLore = (new LoreBookshelf(Identifier.of(MOD_ID, "lore_bookshelf"))).setTranslationKey(MOD_ID, "lore_bookshelf").setHardness(2.0F).setSoundGroup(Block.WOOD_SOUND_GROUP);

        SkyrootStairs = (new StairsBlockTemplate(Identifier.of(MOD_ID, "skyroot_stairs"), Block.PLANKS).setTranslationKey(MOD_ID, "skyroot_stairs").setHardness(2.0F).setResistance(5.0F).setSoundGroup(Block.WOOD_SOUND_GROUP));
        HolystoneStairs = (new StairsBlockTemplate(Identifier.of(MOD_ID, "holystone_stairs"), Block.STONE).setTranslationKey(MOD_ID, "holystone_stairs").setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        MossyHolystoneStairs = (new StairsBlockTemplate(Identifier.of(MOD_ID, "mossy_holystone_stairs"), Block.STONE).setTranslationKey(MOD_ID, "mossy_holystone_stairs").setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        CarvedStairs = (new StairsBlockTemplate(Identifier.of(MOD_ID, "carved_stairs"), Block.STONE).setTranslationKey(MOD_ID, "carved_stairs").setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        CarvedLitStairs = (new StairsBlockTemplate(Identifier.of(MOD_ID, "carved_lit_stairs"), Block.STONE).setTranslationKey(MOD_ID, "carved_lit_stairs").setLuminance(0.75F).setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        AngelicStairs = (new StairsBlockTemplate(Identifier.of(MOD_ID, "angelic_stairs"), Block.STONE).setTranslationKey(MOD_ID, "angelic_stairs").setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        AngelicLitStairs = (new StairsBlockTemplate(Identifier.of(MOD_ID, "angelic_lit_stairs"), Block.STONE).setTranslationKey(MOD_ID, "angelic_lit_stairs").setLuminance(0.75F).setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        HellfireStairs = (new StairsBlockTemplate(Identifier.of(MOD_ID, "hellfire_stairs"), Block.STONE).setTranslationKey(MOD_ID, "hellfire_stairs").setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        HellfireLitStairs = (new StairsBlockTemplate(Identifier.of(MOD_ID, "hellfire_lit_stairs"), Block.STONE).setTranslationKey(MOD_ID, "hellfire_lit_stairs").setLuminance(0.75F).setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        AerogelStairs = (new TransparentStairsBlockTemplate(Identifier.of(MOD_ID, "aerogel_stairs"), Block.STONE).setTranslationKey(MOD_ID, "aerogel_stairs").setHardness(1.0F).setResistance(2000.0F).setOpacity(3).setSoundGroup(Block.STONE_SOUND_GROUP));

        SkyrootSlab = (new SlabBlockTemplate(Identifier.of(MOD_ID, "skyroot_slab"), Block.PLANKS).setTranslationKey(MOD_ID, "skyroot_slab").setHardness(2.0F).setResistance(5.0F).setSoundGroup(Block.WOOD_SOUND_GROUP));
        HolystoneSlab = (new SlabBlockTemplate(Identifier.of(MOD_ID, "holystone_slab"), Block.STONE).setTranslationKey(MOD_ID, "holystone_slab").setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        MossyHolystoneSlab = (new SlabBlockTemplate(Identifier.of(MOD_ID, "mossy_holystone_slab"), Block.STONE).setTranslationKey(MOD_ID, "mossy_holystone_slab").setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        CarvedSlab = (new SlabBlockTemplate(Identifier.of(MOD_ID, "carved_slab"), Block.STONE).setTranslationKey(MOD_ID, "carved_slab").setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        CarvedLitSlab = (new SlabBlockTemplate(Identifier.of(MOD_ID, "carved_lit_slab"), Block.STONE).setTranslationKey(MOD_ID, "carved_lit_slab").setLuminance(0.75F).setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        AngelicSlab = (new SlabBlockTemplate(Identifier.of(MOD_ID, "angelic_slab"), Block.STONE).setTranslationKey(MOD_ID, "angelic_slab").setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        AngelicLitSlab = (new SlabBlockTemplate(Identifier.of(MOD_ID, "angelic_lit_slab"), Block.STONE).setTranslationKey(MOD_ID, "angelic_lit_slab").setLuminance(0.75F).setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        HellfireSlab = (new SlabBlockTemplate(Identifier.of(MOD_ID, "hellfire_slab"), Block.STONE).setTranslationKey(MOD_ID, "hellfire_slab").setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        HellfireLitSlab = (new SlabBlockTemplate(Identifier.of(MOD_ID, "hellfire_lit_slab"), Block.STONE).setTranslationKey(MOD_ID, "hellfire_lit_slab").setLuminance(0.75F).setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        AerogelSlab = (new TransparentSlabBlockTemplate(Identifier.of(MOD_ID, "aerogel_slab"), Block.STONE).setTranslationKey(MOD_ID, "aerogel_slab").setHardness(1.0F).setResistance(2000.0F).setOpacity(3).setSoundGroup(Block.STONE_SOUND_GROUP));

        SkyrootPlate = (new PressurePlateTemplate(Identifier.of(MOD_ID, "skyroot_plate"), PressurePlateActivationRule.EVERYTHING, Material.WOOD).setTranslationKey(MOD_ID, "skyroot_plate").setHardness(2.0F).setResistance(5.0F).setSoundGroup(Block.WOOD_SOUND_GROUP));
        HolystonePlate = (new PressurePlateTemplate(Identifier.of(MOD_ID, "holystone_plate"), PressurePlateActivationRule.MOBS, Material.STONE).setTranslationKey(MOD_ID, "holystone_plate").setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        MossyHolystonePlate = (new PressurePlateTemplate(Identifier.of(MOD_ID, "mossy_holystone_plate"), PressurePlateActivationRule.MOBS, Material.STONE).setTranslationKey(MOD_ID, "mossy_holystone_plate").setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        CarvedPlate = (new PressurePlateTemplate(Identifier.of(MOD_ID, "carved_plate"), PressurePlateActivationRule.PLAYERS, Material.STONE).setTranslationKey(MOD_ID, "carved_plate").setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        CarvedLitPlate = (new PressurePlateTemplate(Identifier.of(MOD_ID, "carved_lit_plate"), PressurePlateActivationRule.EVERYTHING, Material.STONE).setTranslationKey(MOD_ID, "carved_lit_plate").setLuminance(0.75F).setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        AngelicPlate = (new PressurePlateTemplate(Identifier.of(MOD_ID, "angelic_plate"), PressurePlateActivationRule.PLAYERS, Material.STONE).setTranslationKey(MOD_ID, "angelic_plate").setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        AngelicLitPlate = (new PressurePlateTemplate(Identifier.of(MOD_ID, "angelic_lit_plate"), PressurePlateActivationRule.EVERYTHING, Material.STONE).setTranslationKey(MOD_ID, "angelic_lit_plate").setLuminance(0.75F).setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        HellfirePlate = (new PressurePlateTemplate(Identifier.of(MOD_ID, "hellfire_plate"), PressurePlateActivationRule.PLAYERS, Material.STONE).setTranslationKey(MOD_ID, "hellfire_plate").setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        HellfireLitPlate = (new PressurePlateTemplate(Identifier.of(MOD_ID, "hellfire_lit_plate"), PressurePlateActivationRule.EVERYTHING, Material.STONE).setTranslationKey(MOD_ID, "hellfire_lit_plate").setLuminance(0.75F).setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));

        if (FabricLoader.getInstance().isModLoaded("stonewall")) {
            HolystoneWall = (new WallBlock(Identifier.of(MOD_ID, "holystone_wall"), Material.STONE).setTranslationKey(MOD_ID, "holystone_wall").setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
            MossyHolystoneWall = (new WallBlock(Identifier.of(MOD_ID, "mossy_holystone_wall"), Material.STONE).setTranslationKey(MOD_ID, "mossy_holystone_wall").setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
            CarvedWall = (new WallBlock(Identifier.of(MOD_ID, "carved_wall"), Material.STONE).setTranslationKey(MOD_ID, "carved_wall").setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
            AngelicWall = (new WallBlock(Identifier.of(MOD_ID, "angelic_wall"), Material.STONE).setTranslationKey(MOD_ID, "angelic_wall").setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
            HellfireWall = (new WallBlock(Identifier.of(MOD_ID, "hellfire_wall"), Material.STONE).setTranslationKey(MOD_ID, "hellfire_wall").setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP));
        }
    }
}
