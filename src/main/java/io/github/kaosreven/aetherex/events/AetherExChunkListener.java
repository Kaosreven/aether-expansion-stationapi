package io.github.kaosreven.aetherex.events;

import com.matthewperiut.aether.gen.dim.AetherDimension;
import io.github.kaosreven.aetherex.world.gen.feature.VoidTreeNewFeature;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.world.gen.WorldGenEvent;

public class AetherExChunkListener {

    @EventListener
    public void populate(WorldGenEvent.ChunkDecoration event) {
        if (event.world.dimension instanceof AetherDimension) populateAether(event);
    }

    public void populateAether (WorldGenEvent.ChunkDecoration event) {
        int x = event.x + event.random.nextInt(16);
        int y = event.random.nextInt(64) + 32;
        int z = event.z + event.random.nextInt(16);
        (new VoidTreeNewFeature()).generate(event.world, event.random, x, y, z);
    }
}