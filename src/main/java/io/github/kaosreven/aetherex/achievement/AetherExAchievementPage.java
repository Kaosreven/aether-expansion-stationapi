package io.github.kaosreven.aetherex.achievement;

import com.matthewperiut.aether.block.DungeonBlock;
import net.modificationstation.stationapi.api.client.gui.screen.achievement.AchievementPage;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class AetherExAchievementPage extends AchievementPage {

    public AetherExAchievementPage(Identifier id) {
        super(id);
    }

    @Override
    public int getBackgroundTexture(Random random, int column, int row, int randomizedRow, int currentTexture) {
        int texture = DungeonBlock.sprSilver;
        int rand = random.nextInt(1 + row) + row / 2;
        if(rand == 8 || rand == 22) {
            texture = DungeonBlock.sprSilverLit;
        }
        return texture;
    }
}
