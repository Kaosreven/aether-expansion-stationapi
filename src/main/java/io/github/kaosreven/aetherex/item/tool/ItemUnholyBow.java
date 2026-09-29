package io.github.kaosreven.aetherex.item.tool;

import io.github.kaosreven.aetherex.entity.projectile.EntityUnholyArrow;
import io.github.kaosreven.aetherex.item.AetherExItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemUnholyBow extends TemplateItem {
    public BowMode bowMode = BowMode.LIGHTNING;
    public static int unholyBowTick = 0;
    public static boolean unholyBowReady = true;
    public ItemUnholyBow(Identifier identifier) {
        super(identifier);
    }

    @Override
    public ItemStack use(ItemStack stack, World world, PlayerEntity user) {
        NbtCompound nbtCompound = stack.getStationNbt();
        if (nbtCompound.contains("bowMode")) bowMode = BowMode.valueOf(nbtCompound.getString("bowMode"));
        if (user.isSneaking() && !world.isRemote) {
            if (bowMode.ordinal() < modes.length - 2)
                bowMode = modes[bowMode.ordinal() + 1];
            else
                bowMode = modes[0];
            user.sendMessage("\u00a76" + bowMode.display + " shot enabled");
            nbtCompound.putString("bowMode", bowMode.name());
            return stack;
        }
        else {
            if (unholyBowReady) {
                if (user.inventory.remove(AetherExItems.UnholyArrow.id) && unholyBowReady) {
                    world.spawnEntity(new EntityUnholyArrow(world, user, bowMode));
                    world.playSound(user, "mob.ghast.fireball", 1.0F, 1.0F / (random.nextFloat() * 0.4F + 0.8F));
                    unholyBowTick = 0;
                    unholyBowReady = false;
                }
            }
            else if (!world.isRemote) {
                user.sendMessage("\u00a76Bow is on cooldown");
            }
        }
        return stack;
    }

    public enum BowMode {
        LIGHTNING(6, "Lightning"),
        EXPLOSIVE(4, "Explosive"),
        MULTI(9, "Multi-Shot"); //unused for now

        BowMode(int damage, String display) {
            this.damage = damage;
            this.display = display;
        }

        public final int damage;
        public final String display;
    }

    private static final BowMode[] modes = BowMode.values();
}
