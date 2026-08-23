package io.github.kaosreven.aetherex.achievement;

import io.github.kaosreven.aetherex.block.AetherExBlocks;
import io.github.kaosreven.aetherex.item.AetherExItems;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.achievement.Achievement;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.event.achievement.AchievementRegisterEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.template.achievement.AchievementTemplate;
import net.modificationstation.stationapi.api.util.Namespace;

import java.util.ArrayList;

public class AetherExAchievements {
    @Entrypoint.Namespace
    public static Namespace NAMESPACE;

    public static int acOff = 900;

    // Achievement Page
    public static AetherExAchievementPage achievementPage;
    public static final ArrayList<Achievement> ACHIEVEMENTS = new ArrayList<>();

    // Achievements
    public static Achievement pimpMoa;
    public static Achievement evolution;
    public static Achievement secondChance;
    public static Achievement knowledge;

    public static void giveAchievement(Achievement achievement, PlayerEntity player) {
        player.incrementStat(achievement);
    }

    @EventListener
    public void registerAchievements(AchievementRegisterEvent event) {
        evolution = create("evolution", AetherExItems.OrangeMoaEgg,0,0, null);
        pimpMoa = create("pimpMoa", AetherExItems.GoldenElixir, 2, 0, evolution);
        secondChance = create("secondChance", AetherExItems.ResurrectionPendant, 0, 2, null);
        knowledge = create("knowledge", AetherExBlocks.BookshelfOfLore.asItem(), 0, -2, null);

        AchievementTemplate.onConstructor(evolution, NAMESPACE.id("evolution"));
        AchievementTemplate.onConstructor(pimpMoa, NAMESPACE.id("pimpMoa"));
        AchievementTemplate.onConstructor(secondChance, NAMESPACE.id("secondChance"));
        AchievementTemplate.onConstructor(knowledge, NAMESPACE.id("knowledge"));
        acOff = 900;

        achievementPage = new AetherExAchievementPage(NAMESPACE.id("aetherex"));
        event.achievements.addAll(AetherExAchievements.ACHIEVEMENTS);
        achievementPage.addAchievements(AetherExAchievements.ACHIEVEMENTS.toArray(Achievement[]::new));
    }

    public Achievement create(String name, Item icon, int x, int y, Achievement parent){
        Achievement achievement = new Achievement(acOff, "aetherex." + name, x, y, new ItemStack(icon), parent);
        ACHIEVEMENTS.add(achievement);
        acOff++;
        return achievement;
    }

    /*
    public static Achievement create(String name, Item icon, int x, int y, Achievement parent){
        Achievement achievement = new TemplateAchievement(NAMESPACE.id(name), "aetherex." + name, x, y, new ItemStack(icon), parent);
        ACHIEVEMENTS.add(achievement);
        return achievement;
    }


    public static Achievement create(String name, Block icon, int x, int y, Achievement parent){
        Achievement achievement = new TemplateAchievement(NAMESPACE.id(name), "aetherex." + name, x, y, new ItemStack(icon), parent);
        ACHIEVEMENTS.add(achievement);
        return achievement;
    }
     */
}
