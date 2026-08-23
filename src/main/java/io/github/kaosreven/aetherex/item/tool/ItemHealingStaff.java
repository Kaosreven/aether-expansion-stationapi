package io.github.kaosreven.aetherex.item.tool;

import io.github.kaosreven.aetherex.optional.AetherExConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.HitResultType;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.item.CustomReachProvider;
import net.modificationstation.stationapi.api.template.item.TemplateFoodItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemHealingStaff extends TemplateFoodItem implements CustomReachProvider {
    private final boolean lesser;
    public static int LesserHealingLow;
    public static int LesserHealingMiddle;
    public static int LesserHealingHigh;
    public static int HealingLow;
    public static int HealingMiddle;
    public static int HealingHigh;
    private final int healAmount;
    public static int healTick = 0;
    public static boolean healReady = true;
    public static boolean healReadySpoke = true;

    public ItemHealingStaff(Identifier i, boolean lesser) {
        super(i, lesser ? 6:12, false);
        this.maxCount = 1;
        this.setMaxDamage(lesser ? 1500:1800);
        this.setHasSubtypes(true);
        this.setHandheld();
        this.lesser = lesser;
        this.healAmount = lesser ? AetherExConfig.CONFIG.weakHeal:AetherExConfig.CONFIG.strongHeal;
    }

    public int getTextureId(int damage) {
        if (lesser) {
            return damage >= 901 ? LesserHealingLow : (damage < 901 && damage >= 301 ? LesserHealingMiddle : LesserHealingHigh);
        }
        else return damage >= 1201 ? HealingLow : (damage < 1201 && damage >= 601 ? HealingMiddle : HealingHigh);
    }

    @Override
    public double getReach(ItemStack itemStack, PlayerEntity playerEntity, HitResultType hitType, double v) {
         return lesser ? 7.0F:8.0F;
    }

    @Override
    public void inventoryTick(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
        if(itemstack.getDamage() >= 0) itemstack.damage(-1, entity);
    }

    @Override
    public ItemStack use(ItemStack itemstack, World world, PlayerEntity user) {
        if(!world.isRemote) {
            if(itemstack.getDamage() < (lesser ? 901:1201) && healReady) {
                itemstack.damage(600, user);
                user.heal(this.healAmount);
                user.swingHand();
                healReady = false;
                healReadySpoke = false;
            } else if(itemstack.getDamage() >= (lesser ? 901:1201)) {
                user.sendMessage("Insufficient durability!");
            } else  {
                int seconds = healTick / 20;
                int display = 5 - seconds;
                user.sendMessage("You must wait seconds " + display + " seconds before doing that.");
            }
        }
        return itemstack;
    }

    /*
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

    }
     */

    public int getHealAmount() {
        return this.healAmount;
    }
}
