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
    private static final ToolMaterial MineFistTool = ToolMaterialFactory.create("mine_fist", 3, 3000, 10.0F, 2);
    private static final ToolMaterial JebHammerTool = ToolMaterialFactory.create("jeb_hammer", 3, 2000, 12.0F, 2);
    private static final ToolMaterial PhoenixTools = ToolMaterialFactory.create("phoenix_tools", 3, 1500, 9.0F, 4).toolLevel(ToolLevel.getNumeric(3));
    private static final ToolMaterial VileSwordTool = ToolMaterialFactory.create("vile_sword", 0, 200, 5.0F, 2);
    private static final ToolMaterial UnholySwordTool = ToolMaterialFactory.create("unholy_sword", 0, 1750, 5.0F, 3);

    //TODO: actually finish Valkyrie ring
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

        ChainGloves = (new ItemGloves(Identifier.of(MOD_ID, "chain_gloves"), 0, "aetherex:stationapi/textures/armor/chainglove.png", 10)).setTranslationKey(MOD_ID, "chain_gloves").setMaxDamage(50);

        //unfinished
        SentryShield = (new ItemSentryShield(Identifier.of(MOD_ID, "sentry_shield"), 0, 0, 6)).setTranslationKey(MOD_ID, "sentry_shield");
    }
}