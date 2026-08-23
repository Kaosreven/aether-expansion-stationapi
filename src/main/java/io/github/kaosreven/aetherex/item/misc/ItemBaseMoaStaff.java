package io.github.kaosreven.aetherex.item.misc;

import com.matthewperiut.aether.entity.living.EntityMoa;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;
import com.matthewperiut.aether.util.MoaColor;

public class ItemBaseMoaStaff extends TemplateItem {
    public static int moaStaffBlue;
    public static int moaStaffWhite;
    public static int moaStaffBlack;
    private final MoaColor color;
    public ItemBaseMoaStaff(Identifier i, MoaColor color) {
        super(i);
        this.maxCount = 1;
        this.setMaxDamage(40);
        this.setHasSubtypes(true);
        this.color = color;
        this.setHandheld();
    }

    public int getTextureId(int damage) {
        return switch (color.ID) {
            case 1 -> moaStaffBlack;
            case 2 -> moaStaffWhite;
            default -> moaStaffBlue;
        };
    }

    @Override
    public boolean useOnBlock(ItemStack stack, PlayerEntity user, World world, int x, int y, int z, int side) {
        if(stack.getDamage() != 40 && !world.isRemote) {
            EntityMoa moa = new EntityMoa(world, false, true, true, this.color);
            moa.setPositionAndAngles(x, (y + 1), z, user.yaw, 0.0F);
            moa.health = 40 - stack.getDamage();
            moa.timeUntilNextEgg = Integer.MAX_VALUE;
            world.spawnEntity(moa);
            stack.setDamage(40);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(target != null && attacker != null && stack.getDamage() == 40 && attacker.vehicle == null && !target.world.isRemote) {
            EntityMoa moa1 = (EntityMoa)target;
            if(!moa1.saddled || moa1.baby || moa1.colour != this.color) return false;
            if(target.health <= 0) {
                target.health = 1;
            }
            target.dead = true;
            stack.damage((-target.health)-2, attacker);
            return true;
        } else {
            return false;
        }
    }
}
