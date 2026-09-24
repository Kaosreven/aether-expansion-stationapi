package io.github.kaosreven.aetherex.world.gen.feature;

import com.matthewperiut.aether.block.AetherBlocks;
import io.github.kaosreven.aetherex.block.AetherExBlocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class VoidTreeNewFeature extends Feature {

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        if (random.nextInt(400) != 0)
            return false;
        y = random.nextInt(41) + 60;
        for (int xCheck = -7; xCheck < 7; xCheck++)
            for (int zCheck = -7; zCheck < 7; zCheck++)
                for (int yCheck = -5; yCheck < 15; yCheck++)
                    if (world.getBlockId(x + xCheck, y + yCheck, z + zCheck) != 0)
                        return false;
        for (int height = 0; height < 5; height++)
            for (int xOffset = -height; xOffset <= height; xOffset++)
                for (int zOffset = -height; zOffset <= height; zOffset++)
                    if (height < 4)
                        world.setBlock(x + xOffset, y + height, z + zOffset, AetherBlocks.Holystone.id);
                    else
                        world.setBlock(x + xOffset, y + height, z + zOffset, AetherBlocks.Grass.id);
        for (int yPosition = 0; yPosition <= 5; yPosition += 5)
            for (int squareX = -1; squareX <= 1; squareX++)
                for (int squareZ = -1; squareZ <= 1; squareZ++)
                    world.setBlock(x + squareX, y + 6 + yPosition, z + squareZ, AetherExBlocks.VoidLeaves.id);
        for (int squareX = -2; squareX <= 2; squareX++)
            for (int squareZ = -2; squareZ <= 2; squareZ++)
                world.setBlock(x + squareX, y + 8, z + squareZ, AetherExBlocks.VoidLeaves.id);
        for (int squareX = -3; squareX <= 3; squareX++)
            for (int squareZ = -3; squareZ <= 3; squareZ++)
                if (!((squareX == 3 || squareX == -3) && (squareZ == 2 || squareZ == -2) || (squareZ == 3 || squareZ == -3) && (squareX >= 2 || squareX <= -2)))
                    world.setBlock(x + squareX, y + 10, z + squareZ, AetherExBlocks.VoidLeaves.id);
        world.setBlock(x, y + 12, z, AetherExBlocks.VoidLeaves.id);
        for (int stem = 0; stem < 6; stem++)
            world.setBlock(x, y + 5 + stem, z, AetherExBlocks.VoidWood.id, 0);
        return true;
    }
}
