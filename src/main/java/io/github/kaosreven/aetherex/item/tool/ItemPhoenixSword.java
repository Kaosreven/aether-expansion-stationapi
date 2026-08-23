package io.github.kaosreven.aetherex.item.tool;

import io.github.kaosreven.aetherex.entity.projectile.EntityFiroBallEx;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateSwordItem;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class ItemPhoenixSword extends TemplateSwordItem {
    public static int phoenixSwordTick = 0;
    public static boolean phoenixSwordReady = true;
    public ItemPhoenixSword(Identifier identifier, ToolMaterial material) {
        super(identifier, material);
    }

    @Override
    public boolean useOnBlock(ItemStack stack, PlayerEntity user, World world, int x, int y, int z, int side) {
        if (side == 0) {
            --y;
        }
        if (side == 1) {
            ++y;
        }
        if (side == 2) {
            --z;
        }
        if (side == 3) {
            ++z;
        }
        if (side == 4) {
            --x;
        }
        if (side == 5) {
            ++x;
        }
        if (world.getBlockId(x, y, z) == 0) {
            world.playSound((double)x + (double)0.5F, (double)y + (double)0.5F, (double)z + (double)0.5F, "fire.ignite", 1.0F, random.nextFloat() * 0.4F + 0.8F);
            world.setBlock(x, y, z, Block.FIRE.id);
        }
        stack.damage(1, user);
        return true;
    }

    @Override
    public ItemStack use(ItemStack stack, World world, PlayerEntity user) {
        if (stack.getDamage() < stack.getMaxDamage()-100 && phoenixSwordReady) {
            world.playSound(user, "mob.ghast.fireball", 1.0F, 1.0F / ((new Random()).nextFloat() * 0.4F + 0.8F));
            Vec3d vec3d = user.getLookVector();
            double x = user.x + vec3d.x * 1.5D;
            double y = user.y - 0.5D + vec3d.y * 1.5D;
            double z = user.z + vec3d.z * 1.5D;
            EntityFiroBallEx entityinfernoball = new EntityFiroBallEx(world, x, y, z, user);
            world.spawnEntity(entityinfernoball);
            stack.damage(20, user);
            user.swingHand();
            phoenixSwordTick = 0;
            phoenixSwordReady = false;
        } else if(stack.getDamage() < stack.getMaxDamage()-100) {
            int seconds = phoenixSwordTick / 20;
            int display = 3 - seconds;
            user.sendMessage("You must wait seconds " + display + " seconds before doing that.");
        } else user.sendMessage("Insufficient durability!");
        return stack;
    }
}
