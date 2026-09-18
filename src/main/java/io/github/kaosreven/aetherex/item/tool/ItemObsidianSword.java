package io.github.kaosreven.aetherex.item.tool;

import io.github.kaosreven.aetherex.entity.projectile.EntityFiroBallEx;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateSwordItem;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class ItemObsidianSword extends TemplateSwordItem {
    public static int obsidianSwordTick = 0;
    public static boolean obsidianSwordReady = true;
    public ItemObsidianSword(Identifier identifier, ToolMaterial material) {
        super(identifier, material);
    }

    @Override
    public ItemStack use(ItemStack stack, World world, PlayerEntity user) {
        if (stack.getDamage() < stack.getMaxDamage()-100 && obsidianSwordReady) {
            world.playSound(user, "mob.ghast.fireball", 1.0F, 1.0F / ((new Random()).nextFloat() * 0.4F + 0.8F));
            Vec3d vec3d = user.getLookVector();
            double x = user.x + vec3d.x * 1.5D;
            double y = user.y - 0.5D + vec3d.y * 1.5D;
            double z = user.z + vec3d.z * 1.5D;
            EntityFiroBallEx ball = new EntityFiroBallEx(world, x, y, z, user, true);
            world.spawnEntity(ball);
            stack.damage(20, user);
            user.swingHand();
            if(vec3d != null) {
                ball.smotionX = vec3d.x * 2.5D;
                ball.smotionY = vec3d.y * 2.5D;
                ball.smotionZ = vec3d.z * 2.5D;
            }
            obsidianSwordTick = 0;
            obsidianSwordReady = false;
        } else if(stack.getDamage() < stack.getMaxDamage()-100) {
            int seconds = obsidianSwordTick / 20;
            int display = 3 - seconds;
            user.sendMessage("You must wait seconds " + display + " seconds before doing that.");
        } else user.sendMessage("Insufficient durability!");
        return stack;
    }
}
