package io.github.kaosreven.aetherex.item.tool;

import io.github.kaosreven.aether.item.AetherItems;
import io.github.kaosreven.aether.mixin.access.EntityAccessor;
import io.github.kaosreven.aetherex.entity.projectile.EntityFiroBallEx;
import io.github.kaosreven.aetherex.item.AetherExItems;
import net.minecraft.block.Block;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateSwordItem;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

import static io.github.kaosreven.aetherex.util.AetherExMPUtils.GiveItem;

public class ItemPhoenixSword extends TemplateSwordItem {
    private final boolean frosty;
    public static int phoenixSwordTick = 0;
    public static boolean phoenixSwordReady = true;
    public static int PhoenixSwordTexture;
    public static int ObsidianSwordTexture;
    public static int PhoenixAnimTexture;
    public ItemPhoenixSword(Identifier identifier, ToolMaterial material, boolean frosty) {
        super(identifier, material);
        this.frosty = frosty;
    }

    @Override
    public boolean useOnBlock(ItemStack stack, PlayerEntity user, World world, int x, int y, int z, int side) {
        if (!frosty) {
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
                world.playSound((double) x + (double) 0.5F, (double) y + (double) 0.5F, (double) z + (double) 0.5F, "fire.ignite", 1.0F, random.nextFloat() * 0.4F + 0.8F);
                world.setBlock(x, y, z, Block.FIRE.id);
            }
            stack.damage(1, user);
        }
        return true;
    }

    @Override
    public ItemStack use(ItemStack stack, World world, PlayerEntity user) {
        if (!world.isRemote) {
            if (stack.getDamage() < stack.getMaxDamage() - 100 && phoenixSwordReady) {
                world.playSound(user, "mob.ghast.fireball", 1.0F, 1.0F / ((new Random()).nextFloat() * 0.4F + 0.8F));
                Vec3d vec3d = user.getLookVector();
                double x = user.x + vec3d.x * 1.5D;
                double y = user.y - 0.5D + vec3d.y * 1.5D;
                double z = user.z + vec3d.z * 1.5D;
                EntityFiroBallEx ball = new EntityFiroBallEx(world, x, y, z, user, frosty);
                world.spawnEntity(ball);
                stack.damage(20, user);
                user.swingHand();
                ball.smotionX = vec3d.x * 2.5D;
                ball.smotionY = vec3d.y * 2.5D;
                ball.smotionZ = vec3d.z * 2.5D;
                phoenixSwordTick = 0;
                phoenixSwordReady = false;
            } else if (stack.getDamage() < stack.getMaxDamage() - 100) {
                int seconds = phoenixSwordTick / 20;
                int display = 3 - seconds;
                user.sendMessage("You must wait seconds " + display + " seconds before doing that.");
            } else user.sendMessage("Insufficient durability!");
        }
        return stack;
    }

    @Override
    public boolean postHit(ItemStack itemstack, LivingEntity target, LivingEntity attacker) {
        super.postHit(itemstack, target, attacker);
        if(target == null || attacker == null) {
            return false;
        }
        if (!frosty) {
            if (target.fireTicks < 200) target.fireTicks = 200;
            for (int j = 0; j < 30; j++) {
                target.world.addParticle("flame", target.x + ((EntityAccessor) target).getRand().nextGaussian() / 1.5D, target.y + 1.0D + ((EntityAccessor) target).getRand().nextGaussian() / 3D, target.z + ((EntityAccessor) target).getRand().nextGaussian() / 1.5D, 0.0D, 0.0D, 0.0D);
            }
        }
        return true;
    }

    @Override
    public void inventoryTick(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
        if (entity instanceof PlayerEntity player && !frosty) {
            if (player.isWet()) {
                itemstack.damage(1, player);
                if (itemstack.getDamage2() > itemstack.getMaxDamage() - 2) {
                    player.inventory.setStack(i, new ItemStack(AetherExItems.ObsidianSword, 1));
                }
            }
        }
    }

    @Override
    public int getTextureId(int damage) {
        if (frosty) return ObsidianSwordTexture;
        else return damage >= this.getMaxDamage() - 100 ? PhoenixSwordTexture : PhoenixAnimTexture;
    }
}
