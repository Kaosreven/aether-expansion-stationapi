package io.github.kaosreven.aetherex.events;

import com.matthewperiut.aether.blockentity.block.BlockEntityEnchanter;
import io.github.kaosreven.aetherex.item.AetherExItems;
import io.github.kaosreven.aetherex.optional.AetherExConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;

public class AetherEx implements ModInitializer {
    public static Logger LOGGER = LogManager.getLogger("AetherEx");
    public static boolean isHal;
    public static boolean speedRingToggle = true;
    public static boolean shieldToggle = true;
    public static boolean moaGuiToogle = false;

    @Override
    public void onInitialize() {
        if (FabricLoader.getInstance().isModLoaded("aether") && FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            AetherExLore.registerLore();
        }
        isHal();
        if (isHal) {
            CraftingRegistry.addShapedRecipe(new ItemStack(AetherExItems.VileSword), "XXX", "XYX", "XXX", 'X', AetherExItems.VileEssence, 'Y', Item.GOLDEN_SWORD);
            BlockEntityEnchanter.addEnchantment(new ItemStack(Block.SOUL_SAND, 1), new ItemStack(AetherExItems.VileEssence, 1), 2500);
        }
    }

    private void isHal() {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(5);
        int month = cal.get(2);
        isHal = day >= 18 && day <= 31 && month == 9;
        if(AetherExConfig.CONFIG.forceHal) {
            isHal = true;
        }
    }


    /*
    @EventListener
    private static void getReach(PlayerEvent.Reach event) {
        ItemStack[] list = AccessoryAccess.getAccessories(event.player, "ring");
        for (ItemStack itemStack : list) {
            if (itemStack.itemId == AetherExItems.ValkyrieRing.id) {
                if (itemStack.getItem() instanceof CustomReachProvider provider) {
                    ItemStack stack = event.player.getHand();
                    if (stack != null) {
                        //if (!(stack.getItem() instanceof CustomReachProvider))
                        event.currentReach = provider.getReach(itemStack, event.player, event.type, event.currentReach);
                    }
                }
            }
        }
    }
     */
}
