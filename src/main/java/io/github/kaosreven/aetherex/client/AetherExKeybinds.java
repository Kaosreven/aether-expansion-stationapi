package io.github.kaosreven.aetherex.client;

import com.periut.accessoryapi.api.helper.AccessoryAccess;
import io.github.kaosreven.aether.gen.dim.AetherDimensions;
import io.github.kaosreven.aether.gen.dim.BareAetherTravelAgent;
import io.github.kaosreven.aether.util.VoidUtil;
import io.github.kaosreven.aetherex.entity.EntityOrangeMoa;
import io.github.kaosreven.aetherex.entity.projectile.EntityFiroBallEx;
import io.github.kaosreven.aetherex.item.AetherExItems;
import io.github.kaosreven.aetherex.util.Aerplosion;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.HitResultType;
import net.minecraft.util.math.Vec3d;
import net.modificationstation.stationapi.api.client.event.keyboard.KeyStateChangedEvent;
import net.modificationstation.stationapi.api.client.event.option.KeyBindingRegisterEvent;
import net.modificationstation.stationapi.api.registry.DimensionRegistry;
import net.modificationstation.stationapi.api.world.dimension.DimensionHelper;
import net.modificationstation.stationapi.api.world.dimension.VanillaDimensions;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.util.List;
import java.util.OptionalInt;

import static io.github.kaosreven.aether.gen.dim.AetherDimensions.MOD_ID;
import static io.github.kaosreven.aetherex.events.AetherEx.*;
import static io.github.kaosreven.aetherex.item.accessory.ItemAerCape.jumpsRemaining;
import static io.github.kaosreven.aetherex.item.accessory.ItemDebugRing.debugReady;
import static io.github.kaosreven.aetherex.item.accessory.ItemSentryShield.sentryActiveReady;
import static io.github.kaosreven.aetherex.item.accessory.ItemSentryShield.sentryActiveTick;

public class AetherExKeybinds {

    public static KeyBinding keyShieldEnable;
    public static KeyBinding keySentryShield;
    public static KeyBinding keyOrangeMoa;
    public static KeyBinding keyFireballMoa;
    public static KeyBinding keySpeedRingToggle;

    @EventListener
    public void registerKeyBindings(KeyBindingRegisterEvent event) {
        List<KeyBinding> list = event.keyBindings;
        list.add(keyShieldEnable = new KeyBinding("key.aetherex.shieldtoggle", Keyboard.KEY_V));
        list.add(keySentryShield = new KeyBinding("key.aetherex.sentrytoggle", Keyboard.KEY_C));
        list.add(keyOrangeMoa = new KeyBinding("key.aetherex.moagui", Keyboard.KEY_X));
        list.add(keyFireballMoa = new KeyBinding("key.aetherex.moaattack", Keyboard.KEY_Z));
        list.add(keySpeedRingToggle = new KeyBinding("key.aetherex.speedringtoggle", Keyboard.KEY_N));
    }

    private double getTemperature(PlayerEntity player) {
        player.world.method_1781().temperatureMap = player.world.method_1781().temperatureSampler.sample(player.world.method_1781().temperatureMap, player.x, player.z, 1, 1, 0.025F, 0.025F, 0.5F);
        return player.world.method_1781().temperatureMap[0];
    }

    @EventListener
    public void keyStateChanged(KeyStateChangedEvent event){
        if(event.environment == KeyStateChangedEvent.Environment.IN_GAME){
            Minecraft mc = ((Minecraft) FabricLoader.getInstance().getGameInstance());
            if(Keyboard.getEventKeyState()){
                if(Keyboard.isKeyDown(keyShieldEnable.code)) {
                    shieldToggle = !shieldToggle;
                    if (!mc.world.isRemote) {
                        if (shieldToggle) mc.player.sendMessage("Shield has been enabled");
                        else mc.player.sendMessage("Shield has been disabled");
                    }
                }
                if(Keyboard.isKeyDown(keySpeedRingToggle.code)) {
                    speedRingToggle = !speedRingToggle;
                    if (!mc.world.isRemote) {
                        if (speedRingToggle) mc.player.sendMessage("Speed ring has been enabled");
                        else mc.player.sendMessage("Speed ring has been disabled");
                    }
                }
                if(Keyboard.isKeyDown(keyFireballMoa.code)) {
                    PlayerEntity player = mc.player;
                    if (player.vehicle instanceof EntityOrangeMoa moa) {
                        if (moa.getFireball()) {
                            Vec3d vec3d = player.getLookVector();
                            double x = player.x + vec3d.x * 1.5D;
                            double y = player.y - 0.5D + vec3d.y * 1.5D;
                            double z = player.z + vec3d.z * 1.5D;
                            EntityFiroBallEx entityinfernoball = new EntityFiroBallEx(player.world, x, y, z, player, false);
                            player.world.spawnEntity(entityinfernoball);
                        }
                    }
                }
                if(Keyboard.isKeyDown(keyOrangeMoa.code)) {
                    if (mc.player.vehicle instanceof EntityOrangeMoa) {
                        moaGuiToogle = !moaGuiToogle;
                    }
                }
                if (shieldToggle) {
                    if(Keyboard.isKeyDown(keySentryShield.code)) {
                        ItemStack[] list = AccessoryAccess.getAccessories(mc.player, "shield");
                        ItemStack shield = null;
                        for (ItemStack itemStack : list) {
                            if (itemStack.itemId == AetherExItems.SentryShield.id) {
                                shield = itemStack;
                            }
                        }
                        if (shield != null && !mc.player.hasVehicle()) {
                            int var7 = sentryActiveTick / 20;
                            int var8 = 25 - var7;
                            if (var8 >= 25) sentryActiveReady = true;
                            if (sentryActiveReady) {
                                Aerplosion var11 = new Aerplosion(mc.player.world, mc.player, mc.player.x, mc.player.y, mc.player.z, 2.5F);
                                var11.fire = false;
                                var11.explode();
                                var11.playExplosionSound(true);
                                shield.damage(1, mc.player);
                                sentryActiveTick = 0;
                                sentryActiveReady = false;
                            } else if (!sentryActiveReady && shield.getDamage() < 50) {
                                if (var8 < 25) {
                                    mc.player.sendMessage("You must wait seconds " + var8 + " seconds before doing that.");
                                }
                            } else if (shield.getDamage() >= 50 && sentryActiveReady) {
                                mc.player.sendMessage("Insufficient durability!");
                            }
                        }
                    }
                }
                if (Keyboard.isKeyDown(mc.options.jumpKey.code)) {
                    ItemStack[] list = AccessoryAccess.getAccessories(mc.player, "cape");
                    for (ItemStack itemStack : list) {
                        if (itemStack.itemId == AetherExItems.AerCape.id && !mc.player.hasVehicle() && jumpsRemaining > 0 && !mc.player.onGround && itemStack.getDamage() < itemStack.getMaxDamage()) {
                            --jumpsRemaining;
                            mc.player.velocityY = 1.0D;
                            itemStack.damage(1, mc.player);
                        }
                    }
                }
                if (debugReady) {
                    if (Keyboard.isKeyDown(mc.options.sneakKey.code)) {
                        PlayerEntity player = mc.player;
                        if (Mouse.isButtonDown(1)) {
                            for (int i = 0; i < player.world.entities.size(); i++) {
                                Entity entity = (Entity) player.world.entities.get(i);
                                if (!(entity instanceof PlayerEntity)) {
                                    entity.damage(player, 9000);
                                }
                            }
                        }
                        if (Keyboard.isKeyDown(mc.options.dropKey.code)) {
                            @NotNull OptionalInt dimensionId = DimensionRegistry.INSTANCE.getLegacyId(MOD_ID.id("the_aether"));
                            if (dimensionId.isPresent() && player.dimensionId == dimensionId.getAsInt()) {
                                if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
                                    if (!player.world.isRemote) {
                                        DimensionHelper.switchDimension(player, VanillaDimensions.OVERWORLD, 1, new BareAetherTravelAgent());
                                    }
                                } else {
                                    DimensionHelper.switchDimension(player, VanillaDimensions.OVERWORLD, 1, new BareAetherTravelAgent());
                                }
                            }
                            else {
                                if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
                                    if (!player.world.isRemote) {
                                        DimensionHelper.switchDimension(player, AetherDimensions.THE_AETHER, 1, new BareAetherTravelAgent());
                                    }
                                } else {
                                    DimensionHelper.switchDimension(player, AetherDimensions.THE_AETHER, 1, new BareAetherTravelAgent());
                                }
                            }
                        }
                        if (Keyboard.isKeyDown(Keyboard.KEY_1)) {
                            VoidUtil.teleport(player, -140000, 200, -140000);
                        }
                        if (Keyboard.isKeyDown(Keyboard.KEY_2)) {
                            player.sendMessage("Biome temperature: "+getTemperature(player));
                        }
                    }
                }
            }
        }
    }
}
