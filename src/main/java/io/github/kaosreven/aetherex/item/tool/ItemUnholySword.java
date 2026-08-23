package io.github.kaosreven.aetherex.item.tool;

import io.github.kaosreven.aetherex.entity.projectile.EntityUnholySwordDart;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateSwordItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemUnholySword extends TemplateSwordItem {
    public static int unholySwordTick = 0;
    public static boolean unholySwordReady = true;
    public ItemUnholySword(Identifier identifier, ToolMaterial material) {
        super(identifier, material);
    }

    @Override
    public ItemStack use(ItemStack stack, World world, PlayerEntity user) {
        if (unholySwordReady) {
            EntityUnholySwordDart dart = new EntityUnholySwordDart(world, user);
            world.spawnEntity(dart);
            stack.damage(2, user);
            unholySwordTick = 0;
            unholySwordReady = false;
        }
        else {
            int seconds = unholySwordTick / 20;
            int display = 3 - seconds;
            user.sendMessage("You must wait seconds " + display + " seconds before doing that.");
        }
        return stack;
    }
}
