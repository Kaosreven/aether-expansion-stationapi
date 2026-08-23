package io.github.kaosreven.aetherex.item.misc;

import com.matthewperiut.aether.block.AetherBlocks;
import com.matthewperiut.aether.item.AetherItems;
import io.github.kaosreven.aetherex.item.AetherExItems;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class ItemHalloweenBag extends TemplateItem {
    public static int commonBag;
    public static int rareBag;
    public static int legendaryBag;

    public ItemHalloweenBag(Identifier i) {
        super(i);
        this.maxCount = 8;
        this.setHasSubtypes(true);
    }

    @Override
    public String getTranslationKey(ItemStack itemstack) {
        int i = itemstack.getDamage();
        return this.getTranslationKey() + i;
    }

    public int getTextureId(int damage) {
        return switch (damage) {
            case 1 -> rareBag;
            case 2 -> legendaryBag;
            default -> commonBag;
        };
    }

    @Override
    public ItemStack use(ItemStack itemstack, World world, PlayerEntity entityplayer) {
        --itemstack.count;
        ItemStack loot;
        byte min;
        byte max;
        int amount;
        if (!world.isRemote) {
            switch (itemstack.getDamage()) {
                case 0: {
                    int chance = (new Random()).nextInt(13);
                    switch (chance) {
                        case 0:
                            min = 4;
                            max = 7;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(AetherItems.AmbrosiumShard, amount);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 1:
                            min = 2;
                            max = 4;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(AetherItems.Zanite, amount);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 2:
                            min = 3;
                            max = 6;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(Item.COOKIE, amount);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 3:
                            loot = new ItemStack(Item.CAKE, 1);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 4:
                            min = 1;
                            max = 3;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(AetherItems.GummieSwet, amount, 0);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 5:
                            min = 1;
                            max = 2;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(AetherItems.GummieSwet, amount, 1);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 6:
                            min = 3;
                            max = 8;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(Item.IRON_INGOT, amount);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 7:
                            min = 1;
                            max = 3;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(AetherItems.HealingStone, amount);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 8:
                            loot = new ItemStack(AetherItems.MoaEgg, 1, 0);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 9:
                            int variant = (new Random()).nextInt(4);
                            min = 3;
                            max = 7;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(AetherExItems.Candy, amount, variant);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 10:
                            min = 10;
                            max = 20;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(AetherExItems.UnholyArrow, amount);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 11:
                            min = 3;
                            max = 6;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(Block.PUMPKIN.asItem(), amount);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 12:
                            min = 3;
                            max = 6;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(Block.JACK_O_LANTERN.asItem(), amount);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                    }
                }
                case 1: {
                    int chance = (new Random()).nextInt(13);
                    switch (chance) {
                        case 0:
                            min = 3;
                            max = 7;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(AetherBlocks.Aercloud.asItem(), amount, 2);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 1:
                            min = 1;
                            max = 3;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(Item.DIAMOND, amount);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 2:
                            min = 1;
                            max = 3;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(AetherBlocks.EnchantedGravitite.asItem(), amount);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 3:
                            min = 5;
                            max = 12;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(AetherItems.AmbrosiumShard, amount);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 4:
                            loot = new ItemStack(Item.GOLDEN_APPLE, 1);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 5:
                            min = 2;
                            max = 5;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(AetherItems.HealingStone, amount);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 6:
                            loot = new ItemStack(AetherExItems.HalloweenBag, 2, 0);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 7:
                            min = 4;
                            max = 7;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(AetherItems.Zanite, amount);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 8:
                            loot = new ItemStack(AetherExItems.VileSword, 1);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 9:
                            loot = new ItemStack(AetherExItems.HalloweenCape, 1);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 10:
                            min = 15;
                            max = 32;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(AetherExItems.UnholyArrow, amount);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 11:
                            min = 5;
                            max = 9;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            int variant = (new Random()).nextInt(3);
                            loot = new ItemStack(AetherItems.Dart, amount, variant);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 12:
                            loot = new ItemStack(AetherExItems.MoaArmor, 1, 0);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                    }
                }
                case 2: {
                    int chance = (new Random()).nextInt(15);
                    switch (chance) {
                        case 0:
                            loot = new ItemStack(AetherExItems.FlameGem, 1);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 1:
                            min = 2;
                            max = 6;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(Item.DIAMOND, amount);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 2:
                            min = 2;
                            max = 6;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(AetherBlocks.EnchantedGravitite.asItem(), amount);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 3:
                            min = 3;
                            max = 7;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(AetherItems.LightningKnife, amount);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 4:
                            loot = new ItemStack(AetherExItems.HalloweenBag, 2, 1);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 5:
                            loot = new ItemStack(AetherExItems.VileSword, 1);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 6:
                            loot = new ItemStack(AetherItems.MoaEgg, 1, 2);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 7:
                            loot = new ItemStack(AetherExItems.UnholyBow, 1);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 8:
                            loot = new ItemStack(AetherExItems.UnholySword, 1);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 9:
                            loot = new ItemStack(AetherExItems.WeakHealStaff, 1);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 10:
                            min = 30;
                            max = 50;
                            amount = (new Random()).nextInt(max - min + 1) + min;
                            loot = new ItemStack(AetherExItems.UnholyArrow, amount);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 11:
                            loot = new ItemStack(AetherExItems.AerShield, 1);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 12:
                            loot = new ItemStack(AetherExItems.SpeedRing, 1);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 13:
                            loot = new ItemStack(AetherItems.AgilityCape, 1);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                        case 14:
                            loot = new ItemStack(AetherExItems.MoaArmor, 1, 2);
                            entityplayer.inventory.addStack(loot);
                            return itemstack;
                    }
                }
            }
        }
        return itemstack;
    }
}