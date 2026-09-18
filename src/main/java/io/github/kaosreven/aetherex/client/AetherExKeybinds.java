package io.github.kaosreven.aetherex.client;

import com.periut.accessoryapi.api.helper.AccessoryAccess;
import io.github.kaosreven.aetherex.entity.EntityOrangeMoa;
import io.github.kaosreven.aetherex.entity.projectile.EntityFiroBallEx;
import io.github.kaosreven.aetherex.item.AetherExItems;
import io.github.kaosreven.aetherex.util.Aerplosion;
import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.modificationstation.stationapi.api.client.event.keyboard.KeyStateChangedEvent;
import net.modificationstation.stationapi.api.client.event.option.KeyBindingRegisterEvent;
import org.lwjgl.input.Keyboard;

import java.util.List;

import static io.github.kaosreven.aetherex.events.AetherEx.*;
import static io.github.kaosreven.aetherex.item.accessory.ItemAerCape.jumpsRemaining;
import static io.github.kaosreven.aetherex.item.accessory.ItemSentryShield.sentryActiveReady;
import static io.github.kaosreven.aetherex.item.accessory.ItemSentryShield.sentryActiveTick;

public class AetherExKeybinds {

    public static KeyBinding keyShieldEnable;
    public static KeyBinding keySentryShield;
    public static KeyBinding keyOrangeMoa;
    public static KeyBinding keyFireballMoa;
    public static KeyBinding keySpeedRingToggle;
    public static KeyBinding keyGainLore;

    @EventListener
    public void registerKeyBindings(KeyBindingRegisterEvent event) {
        List<KeyBinding> list = event.keyBindings;
        list.add(keyShieldEnable = new KeyBinding("key.aetherex.shieldtoggle", Keyboard.KEY_V));
        list.add(keySentryShield = new KeyBinding("key.aetherex.sentrytoggle", Keyboard.KEY_C));
        list.add(keyOrangeMoa = new KeyBinding("key.aetherex.moagui", Keyboard.KEY_X));
        list.add(keyFireballMoa = new KeyBinding("key.aetherex.moaattack", Keyboard.KEY_Z));
        list.add(keySpeedRingToggle = new KeyBinding("key.aetherex.speedringtoggle", Keyboard.KEY_N));
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
            }
        }
    }
}
