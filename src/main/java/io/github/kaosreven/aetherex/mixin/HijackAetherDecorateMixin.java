package io.github.kaosreven.aetherex.mixin;

import com.matthewperiut.aether.gen.dim.ChunkProviderAether;
import io.github.kaosreven.aetherex.world.gen.feature.VoidTreeFeature;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(ChunkProviderAether.class)
public class HijackAetherDecorateMixin {

    @Shadow
    @Final
    private Random random;

    @Shadow
    @Final
    private World world;

    @Inject(method = "decorate", at = @At("TAIL"))
    public void decorate(ChunkSource chunkSource, int chunkX, int chunkZ, CallbackInfo ci) {
        int worldX = chunkX * 16;
        int worldZ = chunkZ * 16;
        if (this.random.nextInt(150) == 0) {
            int x = worldX + this.random.nextInt(16);
            int y = this.random.nextInt(64) + 32;
            int z = worldZ + this.random.nextInt(16);
            (new VoidTreeFeature()).generate(this.world, this.random, x, y, z);
        }
    }
}
