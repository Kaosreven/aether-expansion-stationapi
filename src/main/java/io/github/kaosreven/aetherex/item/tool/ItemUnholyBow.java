package io.github.kaosreven.aetherex.item.tool;

import io.github.kaosreven.aetherex.entity.projectile.EntityExplosiveUnholyArrow;
import io.github.kaosreven.aetherex.entity.projectile.EntityLightningUnholyArrow;
import io.github.kaosreven.aetherex.item.AetherExItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemUnholyBow extends TemplateItem {
    public static int shotMode = 0;
    public static int unholyBowTick = 0;
    public static boolean unholyBowReady = true;
    public ItemUnholyBow(Identifier identifier) {
        super(identifier);
    }


    @Override
    public ItemStack use(ItemStack stack, World world, PlayerEntity user) {
        NbtCompound nbtCompound = stack.getStationNbt();
        shotMode = nbtCompound.getInt("shotMode");
        if (user.isSneaking() && !world.isRemote) {
            shotMode++;
            if (shotMode > 1) shotMode = 0;
            switch (shotMode) {
                case 0:
                    user.sendMessage("\u00a76Lightning shot enabled");
                    break;
                case 1:
                    user.sendMessage("\u00a76Explosive shot enabled");
                    break;
            }
            nbtCompound.putInt("shotMode", shotMode);
            return stack;
        }
        else {
            if (unholyBowReady) {
                if (user.inventory.remove(AetherExItems.UnholyArrow.id) && unholyBowReady) {
                    switch (shotMode) {
                        case 0:
                            world.spawnEntity(new EntityLightningUnholyArrow(world, user));
                            break;
                        case 1:
                            world.spawnEntity(new EntityExplosiveUnholyArrow(world, user));
                            break;
                    }
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
}
