package io.github.kaosreven.aetherex.item;

import com.matthewperiut.aether.item.accessory.ItemMoreArmor;
import io.github.kaosreven.aetherex.item.accessory.*;
import io.github.kaosreven.aetherex.item.misc.*;
import io.github.kaosreven.aetherex.item.tool.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.item.tool.ToolLevel;
import net.modificationstation.stationapi.api.item.tool.ToolMaterialFactory;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.template.item.TemplateShearsItem;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

import static com.matthewperiut.aether.util.MoaColor.getColour;

public class AetherExItems {
    @Entrypoint.Namespace
    public static Namespace MOD_ID = Null.get();

    public static Item MineFist;
    public static Item JebHammer;
    public static Item FlameGem;
    public static Item PhoenixSword;
    public static Item PhoenixPick;
    public static Item PhoenixAxe;
    public static Item PhoenixShovel;
    public static Item StrongHealStaff;
    public static Item WeakHealStaff;
    public static Item HealMatrix;
    public static Item SpeedRing;
    public static Item SentryShield;
    public static Item AerShield;
    public static Item LuckyPendant;
    public static Item ValkyrieRing;
    public static Item JebShield;
    public static Item ChainGloves;
    public static Item AerCape;
    public static Item PinkCape;
    public static Item OrangeCape;
    public static Item PurpleCape;
    public static Item BrownCape;
    public static Item LimeCape;
    public static Item BlackCape;
    public static Item HalloweenBag;
    public static Item VileEssence;
    public static Item VileSword;
    public static Item UnholySword;
    public static Item UnholyBow;
    public static Item Candy;
    public static Item HalloweenCape;
    public static Item UnholyArrow;
    public static Item BlueMoaStaff;
    public static Item WhiteMoaStaff;
    public static Item BlackMoaStaff;
    public static Item OrangeMoaEgg;
    public static Item VoidTomato;
    public static Item GoldenBrew;
    public static Item GoldenElixir;
    public static Item MoaArmor;
    public static Item ResurrectionPendant;
    public static Item CloudsDisc;
    public static Item LabyrinthDisc;
    public static Item ApproachesDisc;
    public static Item CrepusculumDisc;
    public static Item BriseDisc;
    public static Item AscendingDisc;
    public static Item LightNightDisc;
    public static Item ZaniteShears;
    public static Item ObsidianSword;
    public static Item GoldenLeather;


    public static final ToolMaterial MineFistTool = ToolMaterialFactory.create("MineFist", 3, 3000, 10.0F, 2);
    public static final ToolMaterial JebHammerTool = ToolMaterialFactory.create("JebHammer", 3, 2000, 12.0F, 2);
    public static final ToolMaterial PhoenixTools = ToolMaterialFactory.create("PhoenixTools", 3, 2000, 9.0F, 5).toolLevel(ToolLevel.getNumeric(3));
    public static final ToolMaterial VileSwordTool = ToolMaterialFactory.create("VileSword", 0, 200, 5.0F, 2);
    public static final ToolMaterial UnholySwordTool = ToolMaterialFactory.create("UnholySword", 0, 1750, 5.0F, 4);
    public static final ToolMaterial ObsidianTools = ToolMaterialFactory.create("ObsidianTools", 3, 5000, 9.0F, 5).toolLevel(ToolLevel.getNumeric(3));

    //TODO: fix the moa dropping feathers when being put pack into staff on low health
    //TODO: Healing stuff left click
    //TODO: Phoenix Paxel in paxel mod
    //TODO: Orange moa stuff
    //TODO: Make moa staff entity

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        VileEssence = (new TemplateItem(Identifier.of(MOD_ID, "vile_essence"))).setTranslationKey(MOD_ID, "vile_essence");
        VoidTomato = (new TemplateItem(Identifier.of(MOD_ID, "void_tomato"))).setTranslationKey(MOD_ID, "void_tomato");
        GoldenBrew = (new TemplateItem(Identifier.of(MOD_ID, "golden_brew"))).setTranslationKey(MOD_ID, "golden_brew");
        GoldenElixir = (new TemplateItem(Identifier.of(MOD_ID, "golden_elixir"))).setTranslationKey(MOD_ID, "golden_elixir");
        UnholyArrow = (new TemplateItem(Identifier.of(MOD_ID, "unholy_arrow"))).setTranslationKey(MOD_ID, "unholy_arrow");
        //GoldenLeather = (new TemplateItem(Identifier.of(MOD_ID, "golden_leather"))).setTranslationKey(MOD_ID, "golden_leather");

        Candy = (new ItemCandy(Identifier.of(MOD_ID, "candy"), 3, false)).setTranslationKey(MOD_ID, "candy");
        HalloweenBag = (new ItemHalloweenBag(Identifier.of(MOD_ID, "halloween_bag"))).setTranslationKey(MOD_ID, "halloween_bag");
        MoaArmor = (new ItemMoaArmor(Identifier.of(MOD_ID, "moa_armor"))).setTranslationKey(MOD_ID, "moa_armor");
        OrangeMoaEgg = (new ItemOrangeMoaEgg(Identifier.of(MOD_ID, "orange_moa_egg"))).setTranslationKey(MOD_ID, "orange_moa_egg");

        AerCape = (new ItemAerCape(Identifier.of(MOD_ID, "aer_cape"), 0, "aetherex:stationapi/textures/other/AerCape.png", 5)).setTranslationKey(MOD_ID, "aer_cape");
        PurpleCape = (new ItemCape(Identifier.of(MOD_ID, "purple_cape"), 0, "aetherex:stationapi/textures/other/PurpleCape.png", 5, 5445265, false)).setTranslationKey(MOD_ID, "purple_cape");
        PinkCape = (new ItemCape(Identifier.of(MOD_ID, "pink_cape"), 0, "aetherex:stationapi/textures/other/PinkCape.png", 5, 9705348, false)).setTranslationKey(MOD_ID, "pink_cape");
        OrangeCape = (new ItemCape(Identifier.of(MOD_ID, "orange_cape"), 0, "aetherex:stationapi/textures/other/OrangeCape.png", 5, 13395456, false)).setTranslationKey(MOD_ID, "orange_cape");
        BrownCape = (new ItemCape(Identifier.of(MOD_ID, "brown_cape"), 0, "aetherex:stationapi/textures/other/BrownCape.png", 5, 6237199, false)).setTranslationKey(MOD_ID, "brown_cape");
        LimeCape = (new ItemCape(Identifier.of(MOD_ID, "lime_cape"), 0, "aetherex:stationapi/textures/other/LimeCape.png", 5, '\ued18', false)).setTranslationKey(MOD_ID, "lime_cape");
        BlackCape = (new ItemCape(Identifier.of(MOD_ID, "black_cape"), 0, "aetherex:stationapi/textures/other/BlackCape.png", 5, 2562843, false)).setTranslationKey(MOD_ID, "black_cape");
        HalloweenCape = (new ItemCape(Identifier.of(MOD_ID, "halloween_cape"), 0, "aetherex:stationapi/textures/other/HalloweenCape.png", 5)).setTranslationKey(MOD_ID, "halloween_cape");
        SpeedRing = (new ItemMoreArmor(Identifier.of(MOD_ID, "speed_ring"), 0, 0, 8, 2359040)).setTranslationKey(MOD_ID, "speed_ring");
        HealMatrix = (new ItemHealingMatrix(Identifier.of(MOD_ID, "healing_matrix"), 0, 0, 7)).setTranslationKey(MOD_ID, "healing_matrix");
        FlameGem = (new ItemFlameGem(Identifier.of(MOD_ID, "flame_gem"), 0, 0, 7)).setTranslationKey(MOD_ID, "flame_gem");
        AerShield = (new ItemAerShield(Identifier.of(MOD_ID, "aer_shield"),0, 0, 6, 3397631)).setTranslationKey(MOD_ID, "aer_shield");
        JebShield = (new ItemJebShield(Identifier.of(MOD_ID, "jeb_shield"), 0, 0, 6)).setTranslationKey(MOD_ID, "jeb_shield");
        ResurrectionPendant = (new ItemResurrectionPendant(Identifier.of(MOD_ID, "resurrection_pendant"), 0, "aetherex:stationapi/textures/armor/ResurrectionPendant.png", 4)).setTranslationKey(MOD_ID, "resurrection_pendant");
        LuckyPendant = (new ItemLuckyPendant(Identifier.of(MOD_ID, "lucky_pendant"), 0, "aetherex:stationapi/textures/armor/luckypendant.png", 4)).setTranslationKey(MOD_ID, "lucky_pendant");
        ValkyrieRing = (new ItemValkyrieRing(Identifier.of(MOD_ID, "valkyrie_ring"), 0, 0, 8)).setTranslationKey(MOD_ID, "valkyrie_ring");

        //tools
        JebHammer = (new ItemJebHammer(Identifier.of(MOD_ID, "jeb_hammer"), JebHammerTool)).setTranslationKey(MOD_ID, "jeb_hammer");
        VileSword = (new ItemVileBlade(Identifier.of(MOD_ID, "vile_sword"), VileSwordTool)).setTranslationKey(MOD_ID, "vile_sword");
        MineFist = (new ItemMineFist(Identifier.of(MOD_ID, "mine_fist"), MineFistTool)).setTranslationKey(MOD_ID, "mine_fist");
        BlueMoaStaff = (new ItemBaseMoaStaff(Identifier.of(MOD_ID, "moa_staff_blue"), getColour(0)).setTranslationKey(MOD_ID, "moa_staff_blue"));
        WhiteMoaStaff = (new ItemBaseMoaStaff(Identifier.of(MOD_ID, "moa_staff_white"), getColour(2)).setTranslationKey(MOD_ID, "moa_staff_white"));
        BlackMoaStaff = (new ItemBaseMoaStaff(Identifier.of(MOD_ID, "moa_staff_black"), getColour(1)).setTranslationKey(MOD_ID, "moa_staff_black"));
        StrongHealStaff = (new ItemHealingStaff(Identifier.of(MOD_ID, "healing_staff"), false).setTranslationKey(MOD_ID, "healing_staff"));
        WeakHealStaff = (new ItemHealingStaff(Identifier.of(MOD_ID, "lesser_healing_staff"), true).setTranslationKey(MOD_ID, "lesser_healing_staff"));
        PhoenixPick = (new ItemPhoenixPickaxe(Identifier.of(MOD_ID, "phoenix_pickaxe"), PhoenixTools).setTranslationKey(MOD_ID, "phoenix_pickaxe"));
        PhoenixAxe = (new ItemPhoenixAxe(Identifier.of(MOD_ID, "phoenix_axe"), PhoenixTools).setTranslationKey(MOD_ID, "phoenix_axe"));
        PhoenixShovel = (new ItemPhoenixShovel(Identifier.of(MOD_ID, "phoenix_shovel"), PhoenixTools).setTranslationKey(MOD_ID, "phoenix_shovel"));
        PhoenixSword = (new ItemPhoenixSword(Identifier.of(MOD_ID, "phoenix_sword"), PhoenixTools).setTranslationKey(MOD_ID, "phoenix_sword"));
        UnholySword = (new ItemUnholySword(Identifier.of(MOD_ID, "unholy_sword"), UnholySwordTool).setTranslationKey(MOD_ID, "unholy_sword"));
        UnholyBow = (new ItemUnholyBow(Identifier.of(MOD_ID, "unholy_bow")).setTranslationKey(MOD_ID, "unholy_bow").setMaxDamage(1500).setMaxCount(1).setHandheld());
        ZaniteShears = (new TemplateShearsItem(Identifier.of(MOD_ID, "zanite_shears"))).setTranslationKey(MOD_ID, "zanite_shears").setMaxDamage(Item.SHEARS.getMaxDamage());
        //ObsidianSword = (new ItemObsidianSword(Identifier.of(MOD_ID, "obsidian_sword"), ObsidianTools).setTranslationKey(MOD_ID, "obsidian_sword"));

        ChainGloves = (new ItemGloves(Identifier.of(MOD_ID, "chain_gloves"), 0, "aetherex:stationapi/textures/armor/chainglove.png", 10)).setTranslationKey(MOD_ID, "chain_gloves").setMaxDamage(50);

        //Music Discs
        //CloudsDisc = new AetherExRecordItem(Identifier.of(MOD_ID, "clouds_disc"), "aetherex:clouds", "Emile Van Krieken - Clouds").setTranslationKey(MOD_ID, "clouds_disc");
        LabyrinthDisc = new AetherExRecordItem(Identifier.of(MOD_ID, "labyrinth_disc"), "aetherex:labyrinthsvengeance", "Emile Van Krieken - Labyrinth's Vengeance").setTranslationKey(MOD_ID, "labyrinth_disc");
        ApproachesDisc = new AetherExRecordItem(Identifier.of(MOD_ID, "approaches_disc"), "aetherex:approaches", "Emile Van Krieken - Approaches").setTranslationKey(MOD_ID, "approaches_disc");
        CrepusculumDisc = new AetherExRecordItem(Identifier.of(MOD_ID, "crepusculum_disc"), "aetherex:crepusculum", "Emile Van Krieken - Crepusculum").setTranslationKey(MOD_ID, "crepusculum_disc");
        BriseDisc = new AetherExRecordItem(Identifier.of(MOD_ID, "brise_disc"), "aetherex:brise", "Emile Van Krieken - Brise").setTranslationKey(MOD_ID, "brise_disc");
        AscendingDisc = new AetherExRecordItem(Identifier.of(MOD_ID, "ascending_disc"), "aetherex:ascendingdawn", "Emile Van Krieken - Ascending Dawn").setTranslationKey(MOD_ID, "ascending_disc");
        LightNightDisc = new AetherExRecordItem(Identifier.of(MOD_ID, "light_night_disc"), "aetherex:alightinthenight", "Emile Van Krieken - A Light in the Night").setTranslationKey(MOD_ID, "light_night_disc");

        //unfinished
        SentryShield = (new ItemSentryShield(Identifier.of(MOD_ID, "sentry_shield"), 0, 0, 6)).setTranslationKey(MOD_ID, "sentry_shield");
    }
}