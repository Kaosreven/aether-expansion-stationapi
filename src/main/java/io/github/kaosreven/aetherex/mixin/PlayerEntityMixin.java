package io.github.kaosreven.aetherex.mixin;

import com.matthewperiut.aether.block.AetherBlocks;
import com.matthewperiut.aether.entity.living.EntityFireMonster;
import com.matthewperiut.aether.entity.living.EntitySlider;
import com.matthewperiut.aether.entity.living.EntityValkyrie;
import io.github.kaosreven.aetherex.item.AetherExItems;
import io.github.kaosreven.aetherex.util.AccessoryUtils;
import io.github.kaosreven.aetherex.util.Aerplosion;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

import static io.github.kaosreven.aetherex.events.AetherEx.*;
import static io.github.kaosreven.aetherex.item.accessory.ItemAerShield.aerShieldRandomReady;
import static io.github.kaosreven.aetherex.item.accessory.ItemFlameGem.*;
import static io.github.kaosreven.aetherex.item.accessory.ItemJebShield.jebShieldRandomReady;
import static io.github.kaosreven.aetherex.item.accessory.ItemLuckyPendant.*;
import static io.github.kaosreven.aetherex.item.accessory.ItemSentryShield.*;
import static io.github.kaosreven.aetherex.item.tool.ItemHealingStaff.*;
import static io.github.kaosreven.aetherex.item.tool.ItemMineFist.*;
import static io.github.kaosreven.aetherex.item.tool.ItemObsidianSword.*;
import static io.github.kaosreven.aetherex.item.tool.ItemPhoenixSword.*;
import static io.github.kaosreven.aetherex.item.tool.ItemUnholyBow.*;
import static io.github.kaosreven.aetherex.item.tool.ItemUnholySword.*;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Unique
    PlayerEntity player = (PlayerEntity) (Object) this;

    @Inject(method = "readNbt", at = @At("TAIL"))
    public void readAdditional(NbtCompound tag, CallbackInfo ci) {
        if (tag.contains("shieldToggle")) {
            shieldToggle = tag.getBoolean("shieldToggle");
        }
        if (tag.contains("speedRingToggle")) {
            speedRingToggle = tag.getBoolean("speedRingToggle");
        }
    }

    @Inject(method = "writeNbt", at = @At("TAIL"))
    public void writeAdditional(NbtCompound tag, CallbackInfo ci) {
        tag.putBoolean("shieldToggle", shieldToggle);
        tag.putBoolean("speedRingToggle", speedRingToggle);
    }

    @Inject(method = "attack", at = @At("TAIL"))
    void AccesoryOnAttackAbilities(Entity target, CallbackInfo ci) {
        if (flameRandomReady) {
            if(!(target instanceof PlayerEntity)) {
                int i = (new Random()).nextInt(20);
                if(i == 1 && target.fireTicks < 160) {
                    target.fireTicks = 160;
                    flameRandomReady = false;
                }
            }
        }
        if (target != null && target instanceof LivingEntity) {
            if (luckyRandomReady && ((LivingEntity)target).health <= 0 && (new Random()).nextInt(5) == 0) {
                if (target instanceof EntitySlider) {
                    target.dropItem(new ItemStack(AetherExItems.CrepusculumDisc), 0F);
                    AccessoryUtils.UseAccessory(player, AetherExItems.LuckyPendant);
                }
                else if (target instanceof EntityValkyrie && ((EntityValkyrie)target).boss) {
                    target.dropItem(new ItemStack(AetherExItems.AscendingDisc), 0F);
                    AccessoryUtils.UseAccessory(player, AetherExItems.LuckyPendant);
                }
                else if (target instanceof EntityFireMonster) {
                    target.dropItem(new ItemStack(AetherExItems.BriseDisc), 0F);
                    AccessoryUtils.UseAccessory(player, AetherExItems.LuckyPendant);
                }
            }
        }
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void PlayerTickingLoop(CallbackInfo ci) {
        if (healTick == 100) {
            healReady = true;
            healTick = 0;
            if (!healReadySpoke && !player.world.isRemote) {
                player.sendMessage("Heal Staff is off cooldown!");
                healReadySpoke = true;
            }
        } else if (!healReady) {
            ++healTick;
        }
        if (mineTick == 200) {
            mineReady = true;
        } else if (!mineReady) {
            ++mineTick;
        }
        if(unholyBowTick / 20 == 1) {
            unholyBowReady = true;
        } else {
            ++unholyBowTick;
        }
        if(unholySwordTick / 60 == 1) {
            unholySwordReady = true;
        } else {
            ++unholySwordTick;
        }
        if(phoenixSwordTick / 60 == 1) {
            phoenixSwordReady = true;
        } else {
            ++phoenixSwordTick;
        }
        if(obsidianSwordTick / 60 == 1) {
            obsidianSwordReady = true;
        } else {
            ++obsidianSwordTick;
        }
        if (AccessoryUtils.DoesPlayerHave(player, AetherExItems.SpeedRing)) {
            if (speedRingToggle) {
                if (player.onGround) {
                    int i = player.world.getBlockId((int) player.x, (int) (player.y - 2.0D), (int) player.z);
                    if (i == Block.ICE.id) {
                        player.velocityX *= 1.1F;
                        player.velocityZ *= 1.1F;
                    } else if (i != AetherBlocks.Quicksoil.id && i != AetherBlocks.QuicksoilGlass.id) {
                        if (!player.isSubmergedInWater()) {
                            player.velocityX *= 1.45F;
                            player.velocityZ *= 1.45F;
                        } else {
                            player.velocityX *= 1.15F;
                            player.velocityZ *= 1.15F;
                        }
                    } else {
                        player.velocityX *= 1.0500000238418579D;
                        player.velocityZ *= 1.0500000238418579D;
                    }
                } else if (player.isSubmergedInWater()) {
                    player.velocityX *= 1.15F;
                    player.velocityZ *= 1.15F;
                } else if (!player.onGround) {
                    player.velocityX *= 1.044999976158142D;
                    player.velocityZ *= 1.044999976158142D;
                }
            }
        }
    }

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    void AccesoryOnHitAbilities(Entity damageSource, int amount, CallbackInfoReturnable<Boolean> cir) {
        if (damageSource != null && !(damageSource instanceof PlayerEntity)) {
            if (flameRandomReady) {
                int next = (new Random()).nextInt(8);
                if (next == 1 && damageSource.fireTicks < 200) {
                    flameRandomTick = 0;
                    flameRandomReady = false;
                    damageSource.fireTicks = 200;
                    cir.setReturnValue(true);
                }
            }
            if (aerShieldRandomReady && shieldToggle) {
                int next = (new Random()).nextInt(4);
                if(next == 1) {
                    aerShieldRandomReady = false;
                    ++damageSource.velocityY;
                    AccessoryUtils.UseAccessory(player, AetherExItems.AerShield);
                    amount = 0;
                    cir.setReturnValue(true);
                }
            }
            if (jebShieldRandomReady && shieldToggle) {
                int next = (new Random()).nextInt(5);
                if(next == 1) {
                    jebShieldRandomReady = false;
                    AccessoryUtils.UseAccessory(player, AetherExItems.JebShield);
                    damageSource.damage(player, amount * 4);
                    amount = 0;
                    cir.setReturnValue(true);
                }
            }
            if (sentryRandomReady && shieldToggle) {
                int next = (new Random()).nextInt(20);
                if (next == 1 || next == 2 || next == 3) {
                    sentryRandomReady = false;
                    AccessoryUtils.UseAccessory(player, AetherExItems.SentryShield);
                    Aerplosion aerplosion = new Aerplosion(player.world, player, player.x, player.y, player.z, 2.5F);
                    aerplosion.fire = false;
                    aerplosion.explode();
                    aerplosion.playExplosionSound(true);
                    cir.setReturnValue(true);
                }
            }
        }
        if(luckyRandomReady && damageSource == null) {
            LivingEntity entity = (LivingEntity) (Object) this;
            if (entity == player) {
                int next = (new Random()).nextInt(20);
                if (next == 1 || next == 2 || next == 3) {
                    luckyRandomTick = 0;
                    luckyRandomReady = false;
                    AccessoryUtils.UseAccessory(player, AetherExItems.LuckyPendant);
                    amount = 0;
                    cir.setReturnValue(true);
                }
            }
        }
    }
}
