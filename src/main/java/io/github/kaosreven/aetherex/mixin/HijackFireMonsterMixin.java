package io.github.kaosreven.aetherex.mixin;


import com.matthewperiut.aether.block.AetherBlocks;
import com.matthewperiut.aether.entity.living.EntityFireMonster;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.matthewperiut.aether.achievement.AetherAchievements.defeatGold;

@Mixin(EntityFireMonster.class)
public abstract class HijackFireMonsterMixin {

    @Shadow
    public Entity target;

    @Shadow
    protected abstract void setDoor(int ID);

    @Shadow
    public int chatLog;

    @Shadow
    public abstract boolean chatWithMe();

    @Inject(method = "interact", at = @At("HEAD"), cancellable = true)
    public void interact(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        if (FabricLoader.getInstance().getGameInstance() instanceof Minecraft mc) {
            if (mc.stats.hasAchievement(defeatGold)) {
                this.target = player;
                if (!mc.world.isRemote) {
                    this.setDoor(AetherBlocks.LockedDungeonStone.id);
                }
                this.chatLog = 9;
                this.chatWithMe();
                cir.setReturnValue(false);
            }
        }
    }
}
