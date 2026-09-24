package io.github.kaosreven.aetherex.client;

import com.matthewperiut.aether.block.AetherBlocks;
import com.matthewperiut.aether.block.DungeonBlock;
import com.matthewperiut.aether.block.Holystone;
import com.matthewperiut.aether.client.texture.AetherTextures;
import io.github.kaosreven.aetherex.block.*;
import io.github.kaosreven.aetherex.item.AetherExItems;
import io.github.kaosreven.aetherex.item.misc.ItemBaseMoaStaff;
import io.github.kaosreven.aetherex.item.misc.ItemCandy;
import io.github.kaosreven.aetherex.item.misc.ItemHalloweenBag;
import io.github.kaosreven.aetherex.item.misc.ItemMoaArmor;
import io.github.kaosreven.aetherex.item.tool.ItemHealingStaff;
import io.github.kaosreven.aetherex.item.tool.ItemPhoenixSword;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.client.texture.atlas.ExpandableAtlas;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

import static io.github.kaosreven.aetherex.events.AetherEx.isNFCAddonPresent;
import static net.modificationstation.stationapi.api.util.Identifier.of;

public class AetherExTextures {
    @Entrypoint.Namespace
    public static Namespace MOD_ID = Null.get();
    public static int Shield;
    public static int MoaEgg;

    @EventListener
    public static void registerTextures(TextureRegisterEvent event) {
        ExpandableAtlas terrain = Atlases.getTerrain();
        ExpandableAtlas items = Atlases.getGuiItems();
        setBlockTextures(terrain);
        setItemTextures(items);
    }

    public static void setBlockTextures(ExpandableAtlas terrain) {
        VoidLog.sprTop = terrain.addTexture(of(MOD_ID, "block/VoidLogTop")).index;
        VoidLog.sprSide = terrain.addTexture(of(MOD_ID, "block/VoidLogSide")).index;
        VoidLeaves.sprVoid = terrain.addTexture(of(MOD_ID, "block/VoidLeaves")).index;
        AdvancedIncubator.topTexture = terrain.addTexture(of(MOD_ID, "block/AdvancedIncubatorTop")).index;
        AdvancedIncubator.sideTexture = terrain.addTexture(of(MOD_ID, "block/AdvancedIncubatorSide")).index;
        LoreBookshelf.topTexture = terrain.addTexture(of(MOD_ID, "block/BookshelfOfLoreTop")).index;
        LoreBookshelf.sideTexture = terrain.addTexture(of(MOD_ID, "block/BookshelfOfLoreSide")).index;

        if (!isNFCAddonPresent) {
            AetherExBlocks.SkyrootPlate.textureId = AetherBlocks.Plank.textureId;
            AetherExBlocks.HolystonePlate.textureId = Holystone.sprNormal;
            AetherExBlocks.MossyHolystonePlate.textureId = Holystone.sprMossy;
            AetherExBlocks.CarvedPlate.textureId = DungeonBlock.sprBronze;
            AetherExBlocks.CarvedLitPlate.textureId = DungeonBlock.sprBronzeLit;
            AetherExBlocks.AngelicPlate.textureId = DungeonBlock.sprSilver;
            AetherExBlocks.AngelicLitPlate.textureId = DungeonBlock.sprSilverLit;
            AetherExBlocks.HellfirePlate.textureId = DungeonBlock.sprGold;
            AetherExBlocks.HellfireLitPlate.textureId = DungeonBlock.sprGoldLit;

            AetherExBlocks.SkyrootSlab.textureId = AetherBlocks.Plank.textureId;
            AetherExBlocks.HolystoneSlab.textureId = Holystone.sprNormal;
            AetherExBlocks.MossyHolystoneSlab.textureId = Holystone.sprMossy;
            AetherExBlocks.CarvedSlab.textureId = DungeonBlock.sprBronze;
            AetherExBlocks.CarvedLitSlab.textureId = DungeonBlock.sprBronzeLit;
            AetherExBlocks.AngelicSlab.textureId = DungeonBlock.sprSilver;
            AetherExBlocks.AngelicLitSlab.textureId = DungeonBlock.sprSilverLit;
            AetherExBlocks.HellfireSlab.textureId = DungeonBlock.sprGold;
            AetherExBlocks.HellfireLitSlab.textureId = DungeonBlock.sprGoldLit;
            AetherExBlocks.AerogelSlab.textureId = AetherBlocks.Aerogel.textureId;
        }
    }

    public static void setItemTextures(ExpandableAtlas items) {
        Shield = items.addTexture(of(MOD_ID, "item/Shield")).index;
        MoaEgg = items.addTexture(of(MOD_ID, "item/MoaEgg")).index;

        AetherExItems.PurpleCape.setTextureId(AetherTextures.CapeTexture);
        AetherExItems.PinkCape.setTextureId(AetherTextures.CapeTexture);
        AetherExItems.OrangeCape.setTextureId(AetherTextures.CapeTexture);
        AetherExItems.BrownCape.setTextureId(AetherTextures.CapeTexture);
        AetherExItems.LimeCape.setTextureId(AetherTextures.CapeTexture);
        AetherExItems.BlackCape.setTextureId(AetherTextures.CapeTexture);
        AetherExItems.HalloweenCape.setTexture(of(MOD_ID, "item/HalloweenCape"));
        AetherExItems.SpeedRing.setTextureId(AetherTextures.Ring);
        AetherExItems.ValkyrieRing.setTexture(of(MOD_ID, "item/ValkyrieRing"));
        AetherExItems.HealMatrix.setTexture(of(MOD_ID, "item/HealingMatrix"));
        AetherExItems.FlameGem.setTexture(of(MOD_ID, "item/FlamingGemstone"));
        AetherExItems.AerShield.setTextureId(Shield);
        AetherExItems.LuckyPendant.setTexture(of(MOD_ID, "item/LuckyPendant"));
        AetherExItems.JebShield.setTexture(of(MOD_ID, "item/JebShield"));
        AetherExItems.ResurrectionPendant.setTexture(of(MOD_ID, "item/ResurrectionPendant"));
        AetherExItems.ChainGloves.setTexture(of(MOD_ID, "item/ChainGloves"));

        ItemCandy.candy1 = items.addTexture(of(MOD_ID, "item/Candy1")).index;
        ItemCandy.candy2 = items.addTexture(of(MOD_ID, "item/Candy2")).index;
        ItemCandy.candy3 = items.addTexture(of(MOD_ID, "item/Candy3")).index;
        ItemCandy.candy4 = items.addTexture(of(MOD_ID, "item/Candy4")).index;
        ItemHalloweenBag.commonBag = items.addTexture(of(MOD_ID, "item/CommonBag")).index;
        ItemHalloweenBag.rareBag = items.addTexture(of(MOD_ID, "item/RareBag")).index;
        ItemHalloweenBag.legendaryBag = items.addTexture(of(MOD_ID, "item/LegendaryBag")).index;
        AetherExItems.VileEssence.setTexture(of(MOD_ID, "item/VileEssence"));
        AetherExItems.VoidTomato.setTexture(of(MOD_ID, "item/VoidTomato"));
        AetherExItems.GoldenBrew.setTexture(of(MOD_ID, "item/GoldenBrew"));
        AetherExItems.GoldenElixir.setTexture(of(MOD_ID, "item/GoldenElixir"));
        ItemMoaArmor.ironMoaArmor = items.addTexture(of(MOD_ID, "item/IronMoaArmor")).index;
        ItemMoaArmor.GoldMoaArmor = items.addTexture(of(MOD_ID, "item/GoldMoaArmor")).index;
        ItemMoaArmor.DiamondMoaArmor = items.addTexture(of(MOD_ID, "item/DiamondMoaArmor")).index;
        ItemMoaArmor.ZaniteMoaArmor = items.addTexture(of(MOD_ID, "item/ZaniteMoaArmor")).index;
        ItemMoaArmor.GravititeMoaArmor = items.addTexture(of(MOD_ID, "item/GravititeMoaArmor")).index;
        AetherExItems.OrangeMoaEgg.setTextureId(MoaEgg);
        AetherExItems.UnholyArrow.setTexture(of(MOD_ID, "item/UnholyArrow"));
        //AetherExItems.GoldenLeather.setTexture(of(MOD_ID, "item/GoldenLeather"));

        AetherExItems.JebHammer.setTexture(of(MOD_ID, "item/HammerOfJeb"));
        AetherExItems.VileSword.setTexture(of(MOD_ID, "item/VileBlade"));
        AetherExItems.MineFist.setTexture(of(MOD_ID, "item/MineFist"));
        ItemBaseMoaStaff.moaStaffBlue = items.addTexture(of(MOD_ID, "item/MoaStaffBlue")).index;
        ItemBaseMoaStaff.moaStaffWhite = items.addTexture(of(MOD_ID, "item/MoaStaffWhite")).index;
        ItemBaseMoaStaff.moaStaffBlack = items.addTexture(of(MOD_ID, "item/MoaStaffBlack")).index;
        ItemHealingStaff.LesserHealingLow = items.addTexture(of(MOD_ID, "item/LesserHealingLow")).index;
        ItemHealingStaff.LesserHealingMiddle = items.addTexture(of(MOD_ID, "item/LesserHealingMiddle")).index;
        ItemHealingStaff.LesserHealingHigh = items.addTexture(of(MOD_ID, "item/LesserHealingHigh")).index;
        ItemHealingStaff.HealingLow = items.addTexture(of(MOD_ID, "item/HealingLow")).index;
        ItemHealingStaff.HealingMiddle = items.addTexture(of(MOD_ID, "item/HealingMiddle")).index;
        ItemHealingStaff.HealingHigh = items.addTexture(of(MOD_ID, "item/HealingHigh")).index;
        AetherExItems.PhoenixPick.setTexture(of(MOD_ID, "item/PhoenixPickaxe"));
        AetherExItems.PhoenixAxe.setTexture(of(MOD_ID, "item/PhoenixAxe"));
        AetherExItems.PhoenixShovel.setTexture(of(MOD_ID, "item/PhoenixShovel"));
        //AetherExItems.PhoenixSword.setTexture(of(MOD_ID, "item/PhoenixSword"));
        AetherExItems.PhoenixSword.setTexture(of(MOD_ID, "item/animations/PhoenixFlameAnim"));
        ItemPhoenixSword.PhoenixSwordTexture = items.addTexture(of(MOD_ID, "item/PhoenixSword")).index;
        ItemPhoenixSword.PhoenixAnimTexture = items.addTexture(of(MOD_ID, "item/animations/PhoenixFlameAnim")).index;
        AetherExItems.SentryShield.setTexture(of(MOD_ID, "item/SentryShield"));
        AetherExItems.AerCape.setTexture(of(MOD_ID, "item/AerCape"));
        AetherExItems.UnholySword.setTexture(of(MOD_ID, "item/UnholySword"));
        AetherExItems.UnholyBow.setTexture(of(MOD_ID, "item/UnholyBow"));
        AetherExItems.ZaniteShears.setTexture(of(MOD_ID, "item/ZaniteShears"));
        //AetherExItems.ObsidianSword.setTexture(of(MOD_ID, "item/ObsidianSword"));

        //AetherExItems.CloudsDisc.setTexture(of(MOD_ID, "item/discs/DiscClouds"));
        AetherExItems.LabyrinthDisc.setTexture(of(MOD_ID, "item/discs/DiscLabyrinth"));
        AetherExItems.ApproachesDisc.setTexture(of(MOD_ID, "item/discs/DiscApproaches"));
        AetherExItems.CrepusculumDisc.setTexture(of(MOD_ID, "item/discs/DiscCrepusculum"));
        AetherExItems.BriseDisc.setTexture(of(MOD_ID, "item/discs/DiscBrise"));
        AetherExItems.AscendingDisc.setTexture(of(MOD_ID, "item/discs/DiscAscending"));
        AetherExItems.LightNightDisc.setTexture(of(MOD_ID, "item/discs/DiscLightNight"));
    }


}
