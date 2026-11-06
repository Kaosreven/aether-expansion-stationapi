package io.github.kaosreven.aetherex.client;

import io.github.kaosreven.aether.block.AetherBlocks;
import io.github.kaosreven.aether.block.DungeonBlock;
import io.github.kaosreven.aether.block.Holystone;
import io.github.kaosreven.aether.client.AetherTextures;
import io.github.kaosreven.aetherex.block.*;
import io.github.kaosreven.aetherex.item.AetherExItems;
import io.github.kaosreven.aetherex.item.misc.ItemBaseMoaStaff;
import io.github.kaosreven.aetherex.item.misc.ItemCandy;
import io.github.kaosreven.aetherex.item.misc.ItemHalloweenBag;
import io.github.kaosreven.aetherex.item.misc.ItemMoaArmor;
import io.github.kaosreven.aetherex.item.tool.ItemHealingStaff;
import io.github.kaosreven.aetherex.item.tool.ItemPhoenixSword;
import io.github.kaosreven.aetherex.optional.AetherExConfig;
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
    public static int SkyrootLadder;
    public static int VoidLadder;

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

        if (AetherExConfig.CONFIG.EnableNewContent) {
            AetherExDungeonBlock.sprPlatinum = terrain.addTexture(of(MOD_ID, "block/AetherialStone")).index;
            AetherExDungeonBlock.sprPlatinumLit = terrain.addTexture(of(MOD_ID, "block/animations/LightAetherialStone")).index;
            AetherExBlocks.Plank.textureId = terrain.addTexture(of(MOD_ID, "block/Plank")).index;
            AetherExBlocks.SkyrootWallSign.textureId = AetherExBlocks.SkyrootSign.textureId = AetherBlocks.Plank.textureId;
            AetherExBlocks.HolystoneFurnace.textureId = AetherExBlocks.HolystoneFurnaceLit.textureId = terrain.addTexture(of(MOD_ID, "block/HolystoneFurnaceSide")).index;
            HolystoneFurnaceBlock.furnaceFront = terrain.addTexture(of(MOD_ID, "block/HolystoneFurnaceFront")).index;
            HolystoneFurnaceBlock.furnaceFrontLit = terrain.addTexture(of(MOD_ID, "block/HolystoneFurnaceFrontOn")).index;
            HolystoneFurnaceBlock.furnaceTop = terrain.addTexture(of(MOD_ID, "block/HolystoneFurnaceTB")).index;
            VoidWorkbenchBlock.bottomTexture = terrain.addTexture(of(MOD_ID, "block/VoidWorkbenchBottom")).index;
            VoidWorkbenchBlock.topTexture = terrain.addTexture(of(MOD_ID, "block/VoidWorkbenchTop")).index;
            VoidWorkbenchBlock.sideTexture = terrain.addTexture(of(MOD_ID, "block/VoidWorkbenchSide")).index;
            SkyrootWorkbenchBlock.bottomTexture = terrain.addTexture(of(MOD_ID, "block/SkyrootWorkbenchBottom")).index;
            SkyrootWorkbenchBlock.topTexture = terrain.addTexture(of(MOD_ID, "block/SkyrootWorkbenchTop")).index;
            SkyrootWorkbenchBlock.sideTexture = terrain.addTexture(of(MOD_ID, "block/SkyrootWorkbenchSide")).index;
            AetherExBlocks.SkyrootLadder.textureId = SkyrootLadder = terrain.addTexture(of(MOD_ID, "block/SkyrootLadder")).index;
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
        AetherExItems.HalloweenCape.setTexture(of(MOD_ID, "item/halloween/HalloweenCape"));
        AetherExItems.SpeedRing.setTextureId(AetherTextures.Ring);
        AetherExItems.ValkyrieRing.setTexture(of(MOD_ID, "item/ValkyrieRing"));
        AetherExItems.HealMatrix.setTexture(of(MOD_ID, "item/HealingMatrix"));
        AetherExItems.FlameGem.setTexture(of(MOD_ID, "item/FlamingGemstone"));
        AetherExItems.AerShield.setTextureId(Shield);
        AetherExItems.LuckyPendant.setTexture(of(MOD_ID, "item/LuckyPendant"));
        AetherExItems.JebShield.setTexture(of(MOD_ID, "item/JebShield"));
        AetherExItems.ResurrectionPendant.setTexture(of(MOD_ID, "item/ResurrectionPendant"));
        AetherExItems.ChainGloves.setTexture(of(MOD_ID, "item/ChainGloves"));

        ItemCandy.candy1 = items.addTexture(of(MOD_ID, "item/halloween/Candy1")).index;
        ItemCandy.candy2 = items.addTexture(of(MOD_ID, "item/halloween/Candy2")).index;
        ItemCandy.candy3 = items.addTexture(of(MOD_ID, "item/halloween/Candy3")).index;
        ItemCandy.candy4 = items.addTexture(of(MOD_ID, "item/halloween/Candy4")).index;
        ItemHalloweenBag.commonBag = items.addTexture(of(MOD_ID, "item/halloween/CommonBag")).index;
        ItemHalloweenBag.rareBag = items.addTexture(of(MOD_ID, "item/halloween/RareBag")).index;
        ItemHalloweenBag.legendaryBag = items.addTexture(of(MOD_ID, "item/halloween/LegendaryBag")).index;
        AetherExItems.VileEssence.setTexture(of(MOD_ID, "item/halloween/VileEssence"));
        AetherExItems.VoidTomato.setTexture(of(MOD_ID, "item/VoidTomato"));
        AetherExItems.GoldenBrew.setTexture(of(MOD_ID, "item/GoldenBrew"));
        AetherExItems.GoldenElixir.setTexture(of(MOD_ID, "item/GoldenElixir"));
        ItemMoaArmor.ironMoaArmor = items.addTexture(of(MOD_ID, "item/IronMoaArmor")).index;
        ItemMoaArmor.GoldMoaArmor = items.addTexture(of(MOD_ID, "item/GoldMoaArmor")).index;
        ItemMoaArmor.DiamondMoaArmor = items.addTexture(of(MOD_ID, "item/DiamondMoaArmor")).index;
        ItemMoaArmor.ZaniteMoaArmor = items.addTexture(of(MOD_ID, "item/ZaniteMoaArmor")).index;
        ItemMoaArmor.GravititeMoaArmor = items.addTexture(of(MOD_ID, "item/GravititeMoaArmor")).index;
        AetherExItems.OrangeMoaEgg.setTextureId(MoaEgg);
        AetherExItems.UnholyArrow.setTexture(of(MOD_ID, "item/halloween/UnholyArrow"));

        AetherExItems.JebHammer.setTexture(of(MOD_ID, "item/HammerOfJeb"));
        AetherExItems.VileSword.setTexture(of(MOD_ID, "item/halloween/VileBlade"));
        AetherExItems.MineFist.setTexture(of(MOD_ID, "item/MineFist"));
        ItemBaseMoaStaff.moaStaffBlue = items.addTexture(of(MOD_ID, "item/moastaff/MoaStaffBlue")).index;
        ItemBaseMoaStaff.moaStaffWhite = items.addTexture(of(MOD_ID, "item/moastaff/MoaStaffWhite")).index;
        ItemBaseMoaStaff.moaStaffBlack = items.addTexture(of(MOD_ID, "item/moastaff/MoaStaffBlack")).index;
        ItemBaseMoaStaff.moaStaffBlueUnusable = items.addTexture(of(MOD_ID, "item/moastaff/MoaStaffBlueUnusable")).index;
        ItemBaseMoaStaff.moaStaffWhiteUnusable = items.addTexture(of(MOD_ID, "item/moastaff/MoaStaffWhiteUnusable")).index;
        ItemBaseMoaStaff.moaStaffBlackUnusable = items.addTexture(of(MOD_ID, "item/moastaff/MoaStaffBlackUnusable")).index;
        ItemHealingStaff.LesserHealingLow = items.addTexture(of(MOD_ID, "item/healingwand/LesserHealingLow")).index;
        ItemHealingStaff.LesserHealingMiddle = items.addTexture(of(MOD_ID, "item/healingwand/LesserHealingMiddle")).index;
        ItemHealingStaff.LesserHealingHigh = items.addTexture(of(MOD_ID, "item/healingwand/LesserHealingHigh")).index;
        ItemHealingStaff.HealingLow = items.addTexture(of(MOD_ID, "item/healingwand/HealingLow")).index;
        ItemHealingStaff.HealingMiddle = items.addTexture(of(MOD_ID, "item/healingwand/HealingMiddle")).index;
        ItemHealingStaff.HealingHigh = items.addTexture(of(MOD_ID, "item/healingwand/HealingHigh")).index;
        AetherExItems.PhoenixPick.setTexture(of(MOD_ID, "item/PhoenixPickaxe"));
        AetherExItems.PhoenixAxe.setTexture(of(MOD_ID, "item/PhoenixAxe"));
        AetherExItems.PhoenixShovel.setTexture(of(MOD_ID, "item/PhoenixShovel"));
        ItemPhoenixSword.PhoenixSwordTexture = items.addTexture(of(MOD_ID, "item/PhoenixSword")).index;
        ItemPhoenixSword.PhoenixAnimTexture = items.addTexture(of(MOD_ID, "item/animations/PhoenixFlameAnim")).index;
        ItemPhoenixSword.ObsidianSwordTexture = items.addTexture(of(MOD_ID, "item/ObsidianSword")).index;
        AetherExItems.SentryShield.setTexture(of(MOD_ID, "item/SentryShield"));
        AetherExItems.AerCape.setTexture(of(MOD_ID, "item/AerCape"));
        AetherExItems.UnholySword.setTexture(of(MOD_ID, "item/halloween/UnholySword"));
        AetherExItems.UnholyBow.setTexture(of(MOD_ID, "item/halloween/UnholyBow"));
        AetherExItems.ZaniteShears.setTexture(of(MOD_ID, "item/ZaniteShears"));

        //AetherExItems.CloudsDisc.setTexture(of(MOD_ID, "item/discs/DiscClouds"));
        AetherExItems.LabyrinthDisc.setTexture(of(MOD_ID, "item/discs/DiscLabyrinth"));
        AetherExItems.ApproachesDisc.setTexture(of(MOD_ID, "item/discs/DiscApproaches"));
        AetherExItems.CrepusculumDisc.setTexture(of(MOD_ID, "item/discs/DiscCrepusculum"));
        AetherExItems.BriseDisc.setTexture(of(MOD_ID, "item/discs/DiscBrise"));
        AetherExItems.AscendingDisc.setTexture(of(MOD_ID, "item/discs/DiscAscending"));
        AetherExItems.LightNightDisc.setTexture(of(MOD_ID, "item/discs/DiscLightNight"));

        if (AetherExConfig.CONFIG.EnableNewContent) {
            AetherExItems.GoldenLeather.setTexture(of(MOD_ID, "item/GoldenLeather"));
            AetherExItems.SkyrootSign.setTexture(of(MOD_ID, "item/SkyrootSign"));
            AetherExBlocks.SkyrootLadder.asItem().setTextureId(SkyrootLadder);
            AetherExItems.ChristmasCape.setTexture(of(MOD_ID, "item/christmas/ChristmasCape"));
            AetherExItems.SantaHelmet.setTexture(of(MOD_ID, "item/christmas/SantaHelmet"));
            AetherExItems.SantaChestplate.setTexture(of(MOD_ID, "item/christmas/SantaChestplate"));
            AetherExItems.SantaLeggings.setTexture(of(MOD_ID, "item/christmas/SantaLeggings"));
            AetherExItems.SantaBoots.setTexture(of(MOD_ID, "item/christmas/SantaBoots"));
            AetherExItems.CandyCaneSword.setTexture(of(MOD_ID, "item/christmas/CandyCaneSword"));
            AetherExItems.VoidStick.setTexture(of(MOD_ID, "item/VoidStick"));
            AetherExItems.DebugRing.setTextureId(AetherTextures.Ring);
            AetherExItems.ObsidianPick.setTexture(of(MOD_ID, "item/ObsidianPickaxe"));
            AetherExItems.ObsidianAxe.setTexture(of(MOD_ID, "item/ObsidianAxe"));
            AetherExItems.ObsidianShovel.setTexture(of(MOD_ID, "item/ObsidianShovel"));
        }
    }


}
