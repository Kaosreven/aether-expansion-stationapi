package io.github.kaosreven.aetherex.item.tool;

import com.matthewperiut.aether.entity.living.EntityValkyrie;
import io.github.kaosreven.aetherex.item.AetherExItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.modificationstation.stationapi.api.template.item.TemplateSwordItem;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

import static io.github.kaosreven.aetherex.events.AetherEx.isHal;
import static io.github.kaosreven.aetherex.item.accessory.ItemLuckyPendant.luckyRandomReady;

public class ItemVileBlade extends TemplateSwordItem {
    public ItemVileBlade(Identifier identifier, ToolMaterial material) {
        super(identifier, material);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (isHal) {
            if (target instanceof EntityValkyrie && ((EntityValkyrie) target).boss && target.health <= 0) {
                target.dropItem(new ItemStack(AetherExItems.HalloweenBag, 4, 2), 0);
            } else {
                int chance;
                if (target.health <= 0) {
                    if (!luckyRandomReady) chance = (new Random()).nextInt(50);
                    else chance = (new Random()).nextInt(40);
                    if (chance == 1 || chance == 0) {
                        target.dropItem(new ItemStack(AetherExItems.HalloweenBag, 4, 2), 0);
                    }
                    if (chance == 2 || chance == 3 || chance == 9 || chance == 10) {
                        target.dropItem(new ItemStack(AetherExItems.HalloweenBag, 4, 1), 0);
                    }
                    if (chance == 4 || chance == 5 || chance == 6 || chance == 7 || chance == 8 || chance == 11) {
                        target.dropItem(new ItemStack(AetherExItems.HalloweenBag, 4, 0), 0);
                    }
                }
            }
        }
        stack.damage(1, attacker);
        return true;
    }
}
