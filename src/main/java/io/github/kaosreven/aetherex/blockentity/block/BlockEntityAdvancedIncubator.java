package io.github.kaosreven.aetherex.blockentity.block;

import com.matthewperiut.aether.achievement.AetherAchievements;
import com.matthewperiut.aether.block.AetherBlocks;
import com.matthewperiut.aether.blockentity.block.BlockEntityIncubator;
import com.matthewperiut.aether.entity.living.EntityMoa;
import com.matthewperiut.aether.item.AetherItems;
import com.matthewperiut.aether.util.MoaColor;
import io.github.kaosreven.aetherex.achievement.AetherExAchievements;
import io.github.kaosreven.aetherex.entity.EntityOrangeMoa;
import io.github.kaosreven.aetherex.item.AetherExItems;
import io.github.kaosreven.aetherex.optional.AetherExConfig;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;

public class BlockEntityAdvancedIncubator extends BlockEntityIncubator implements Inventory {

    public BlockEntityAdvancedIncubator() {
    }

    @Override
    public String getName() {
        return "Advanced Incubator";
    }

    @Override
    public void tick() {
        if (this.torchPower > 0) {
            --this.torchPower;
            if (this.IncubatorItemStacks[1] != null) {
                if (this.IncubatorItemStacks[1].itemId == AetherItems.MoaEgg.id) {
                    this.torchPower -= AetherExConfig.CONFIG.advancedIncubatorSpeed;
                    this.progress += AetherExConfig.CONFIG.advancedIncubatorSpeed;
                }
            }
        }

        if (this.IncubatorItemStacks[1] == null) {
            this.progress = 0;
        } else if (this.IncubatorItemStacks[1].itemId != AetherExItems.OrangeMoaEgg.id && this.IncubatorItemStacks[1].itemId != AetherItems.MoaEgg.id) {
            this.progress = 0;
        }

        if (this.progress >= 6000) {
            if (this.IncubatorItemStacks[1] != null) {
                if (this.IncubatorItemStacks[1].itemId == AetherExItems.OrangeMoaEgg.id) {
                    EntityOrangeMoa moa = new EntityOrangeMoa(this.world, true, false, false);
                    moa.setPosition((double) this.x + 0.5, (double) this.y + 1.5, (double) this.z + 0.5);
                    this.world.spawnEntity(moa);
                    PlayerEntity player = world.getClosestPlayer(x, y, z, 100);
                    if (player != null) AetherExAchievements.giveAchievement(AetherExAchievements.evolution, player);
                }
                else {
                    EntityMoa moa = new EntityMoa(this.world, true, false, false, MoaColor.getColour(this.IncubatorItemStacks[1].getDamage()));
                    moa.setPosition((double) this.x + 0.5, (double) this.y + 1.5, (double) this.z + 0.5);
                    this.world.spawnEntity(moa);
                }
            }

            PlayerEntity player = world.getClosestPlayer(x, y, z, 100);
            if (player != null) AetherAchievements.giveAchievement(AetherAchievements.incubator, player);
            this.removeStack(1, 1);
            this.progress = 0;
        }

        if (this.torchPower <= 0 && this.IncubatorItemStacks[1] != null && (this.IncubatorItemStacks[1].itemId == AetherExItems.OrangeMoaEgg.id || this.IncubatorItemStacks[1].itemId == AetherItems.MoaEgg.id) && this.getStack(0) != null && this.getStack(0).itemId == AetherBlocks.AmbrosiumTorch.asItem().id) {
            this.torchPower += 1000;
            this.removeStack(0, 1);
        }

    }
}
