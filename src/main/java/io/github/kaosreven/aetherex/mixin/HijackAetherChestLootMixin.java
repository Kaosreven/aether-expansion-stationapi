package io.github.kaosreven.aetherex.mixin;

import com.matthewperiut.aether.block.AetherBlocks;
import com.matthewperiut.aether.block.AetherChest;
import com.matthewperiut.aether.item.AetherItems;
import io.github.kaosreven.aetherex.item.AetherExItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Random;

@Mixin(AetherChest.class)
public class HijackAetherChestLootMixin {
    /**
     * @author Kaosreven
     * @reason Overwrite bronze loot with Aether Expansion
     */
    @Overwrite
    private ItemStack getNormalLootBronze(Random random){
        int item = random.nextInt(17);
        switch (item) {
            case 0:
                return new ItemStack(AetherItems.PickZanite);
            case 1:
                return new ItemStack(AetherItems.AxeZanite);
            case 2:
                return new ItemStack(AetherItems.SwordZanite);
            case 3:
                return new ItemStack(AetherItems.ShovelZanite);
            case 4:
                return new ItemStack(AetherItems.AgilityCape);
            case 5:
                return new ItemStack(AetherItems.AmbrosiumShard, random.nextInt(10) + 1);
            case 6:
                return new ItemStack(AetherItems.Dart, random.nextInt(5) + 1, 0);
            case 7:
                return new ItemStack(AetherItems.Dart, random.nextInt(3) + 1, 1);
            case 8:
                return new ItemStack(AetherItems.Dart, random.nextInt(3) + 1, 2);
            case 9:
                if (random.nextInt(20) == 0) {
                    return new ItemStack(AetherItems.BlueMusicDisk);
                }
                break;
            case 10:
                return new ItemStack(AetherItems.Bucket);
            case 11:
                if (random.nextInt(10) == 0) {
                    return new ItemStack(Item.ITEMS[Item.RECORD_THIRTEEN.id + random.nextInt(2)]);
                }
                break;
            case 12:
                if (random.nextInt(4) == 0) {
                    return new ItemStack(AetherItems.IronRing);
                }
                break;
            case 13:
                if (random.nextInt(10) == 0) {
                    return new ItemStack(AetherItems.GoldRing);
                }
                break;
            case 14:
                return new ItemStack(AetherExItems.GoldenElixir, random.nextInt(3)+1);
            case 15:
                return new ItemStack(AetherExItems.MoaArmor, 1, 1);
            case 16:
                if (random.nextInt(15) == 0) {
                    return new ItemStack(AetherExItems.LabyrinthDisc);
                }
                break;
        }
        return new ItemStack(AetherBlocks.AmbrosiumTorch);
    }

    /**
     * @author Kaosreven
     * @reason Overwrite silver loot with Aether Expansion
     */
    @Overwrite
    private ItemStack getNormalLootSilver(final Random random) {
        final int item = random.nextInt(18);
        switch (item) {
            case 0:
                return new ItemStack(AetherItems.PickZanite);
            case 1:
                return new ItemStack(AetherItems.Bucket, 1, 2);
            case 2:
                return new ItemStack(AetherItems.DartShooter);
            case 3:
                return new ItemStack(AetherItems.MoaEgg, 1, 0);
            case 4:
                return new ItemStack(AetherItems.AmbrosiumShard, random.nextInt(10) + 1);
            case 5:
                return new ItemStack(AetherItems.Dart, random.nextInt(5) + 1, 0);
            case 6:
                return new ItemStack(AetherItems.Dart, random.nextInt(3) + 1, 1);
            case 7:
                return new ItemStack(AetherItems.Dart, random.nextInt(3) + 1, 2);
            case 8:
                if (random.nextInt(20) == 0) {
                    return new ItemStack(AetherItems.BlueMusicDisk);
                }
                break;
            case 9:
                return new ItemStack(AetherItems.Bucket);
            case 10:
                if (random.nextInt(10) == 0) {
                    return new ItemStack(Item.ITEMS[Item.RECORD_THIRTEEN.id + random.nextInt(2)]);
                }
                break;
            case 11:
                if (random.nextInt(2) == 0) {
                    return new ItemStack(AetherItems.ZaniteBoots);
                }
                if (random.nextInt(2) == 0) {
                    return new ItemStack(AetherItems.ZaniteHelmet);
                }
                if (random.nextInt(2) == 0) {
                    return new ItemStack(AetherItems.ZaniteLeggings);
                }
                if (random.nextInt(2) == 0) {
                    return new ItemStack(AetherItems.ZaniteChestplate);
                }
                break;
            case 12:
                if (random.nextInt(4) == 0) {
                    return new ItemStack(AetherItems.IronPendant);
                }
                break;
            case 13:
                if (random.nextInt(10) == 0) {
                    return new ItemStack(AetherItems.GoldPendant);
                }
                break;
            case 14:
                if (random.nextInt(15) == 0) {
                    return new ItemStack(AetherItems.ZaniteRing);
                }
                break;
            case 15:
                return new ItemStack(AetherExItems.GoldenElixir, random.nextInt(3)+1);
            case 16:
                return new ItemStack(AetherExItems.MoaArmor, 1, 1);
            case 17:
                if (random.nextInt(15) == 0) {
                    return new ItemStack(AetherExItems.ApproachesDisc);
                }
                break;
        }
        return new ItemStack(AetherBlocks.AmbrosiumTorch, random.nextInt(5));
    }
}
