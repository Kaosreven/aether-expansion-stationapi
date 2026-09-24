package io.github.kaosreven.aetherex.optional;

import static io.github.kaosreven.aetherex.block.AetherExBlocks.*;
import static io.github.kaosreven.aetherex.block.AetherExBlocks.MOD_ID;
import static io.github.kaosreven.aetherex.events.AetherEx.isNFCAddonPresent;
import static io.github.kaosreven.aetherex.events.AetherEx.isStoneWallPresent;
import static io.github.kaosreven.aetherex.item.AetherExItems.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import paulevs.bhcreative.api.CreativeTab;
import paulevs.bhcreative.api.SimpleTab;
import paulevs.bhcreative.registry.TabRegistryEvent;


public class AetherExCreativeListener {
    public static CreativeTab aetherExBlocks;
    public static CreativeTab aetherExItems;

    @EventListener
    public void onTabInit(TabRegistryEvent event) {
        aetherExBlocks = new SimpleTab(MOD_ID.id("aetherExBlocks"), BookshelfOfLore.asItem());
        event.register(aetherExBlocks);
        add(VoidWood);
        add(VoidLeaves);
        add(AdvancedIncubator);
        add(BookshelfOfLore);
        if (!isNFCAddonPresent) {
            add(CarvedStairs);
            add(CarvedLitStairs);
            add(AngelicStairs);
            add(AngelicLitStairs);
            add(HellfireStairs);
            add(HellfireLitStairs);
            add(AerogelStairs);

            add(CarvedSlab);
            add(CarvedLitSlab);
            add(AngelicSlab);
            add(AngelicLitSlab);
            add(HellfireSlab);
            add(HellfireLitSlab);
            add(AerogelSlab);

            add(CarvedPlate);
            add(CarvedLitPlate);
            add(AngelicPlate);
            add(AngelicLitPlate);
            add(HellfirePlate);
            add(HellfireLitPlate);
        }
        if (isStoneWallPresent) {
            add(HolystoneWall);
            add(MossyHolystoneWall);
            add(CarvedWall);
            add(AngelicWall);
            add(HellfireWall);
        }

        aetherExItems = new SimpleTab(MOD_ID.id("aetherExItems"), GoldenElixir);
        event.register(aetherExItems);
        add(VileEssence);
        add(VoidTomato);
        add(GoldenElixir);
        add(UnholyArrow);
        add(OrangeMoaEgg);
        add(Candy,0);
        add(Candy,1);
        add(Candy,2);
        add(Candy,3);
        add(HalloweenBag,0);
        add(HalloweenBag,1);
        add(HalloweenBag,2);
        add(GoldenBrew);
        add(MoaArmor,0);
        add(MoaArmor,1);
        add(MoaArmor,2);
        add(MoaArmor,3);
        add(MoaArmor,4);
        add(PurpleCape);
        add(PinkCape);
        add(OrangeCape);
        add(BrownCape);
        add(LimeCape);
        add(BlackCape);
        add(HalloweenCape);
        add(SpeedRing);
        add(HealMatrix);
        add(FlameGem);
        add(AerShield);
        add(JebShield);
        add(ResurrectionPendant);
        add(LuckyPendant);
        add(JebHammer);
        add(VileSword);
        add(MineFist);
        add(BlueMoaStaff);
        add(WhiteMoaStaff);
        add(BlackMoaStaff);
        add(WeakHealStaff);
        add(StrongHealStaff);
        add(PhoenixPick);
        add(PhoenixAxe);
        add(PhoenixShovel);
        add(ChainGloves);
        add(PhoenixSword);
        add(SentryShield);
        add(AerCape);
        add(UnholySword);
        add(UnholyBow);
        add(ValkyrieRing);
    }

    private static void add(Block block) {
        aetherExBlocks.addItem(new ItemStack(block));
    }

    private static void add(Item item) {
        aetherExItems.addItem(new ItemStack(item));
    }

    private static void add(Item item, int damage) {
        aetherExItems.addItem(new ItemStack(item, 1, damage));
    }
}
