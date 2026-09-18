package io.github.kaosreven.aetherex.events;

import static com.matthewperiut.aether.client.gui.GuiLore.Lore;
import static com.matthewperiut.aether.client.gui.GuiLore.lores;

import io.github.kaosreven.aetherex.block.AetherExBlocks;
import io.github.kaosreven.aetherex.item.AetherExItems;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemStack;

@SuppressWarnings("UnnecessaryUnicodeEscape")
public class AetherExLore {
    public static void registerLore() {
        lores.add(new Lore(AetherExItems.LuckyPendant, "\u00a7aLucky Pendant", "A pendant that has", "a 15% chance to", "negate damage that", "isn\'t from a mob.", "Also drops more ore", "with Jeb Hammer.", 2));
        lores.add(new Lore(AetherExItems.SentryShield, "\u00a7aSentry Shield", "Has 15% chance to", "block damage and", "create an explosion", "around the player.", "Press button for", "ability.", 2));
        lores.add(new Lore(AetherExItems.StrongHealStaff, "\u00a7aStaff of Healing", "Heals any player", "or mob. Right click to", "heal. Hit a mob or", "player to heal", "them. Unbreakable", "but has a cooldown.", 2));
        lores.add(new Lore(AetherExItems.WeakHealStaff, "\u00a7aStaff of Lesser Healing", "Like the Staff of", "Healing but heals", "less and has a", "smaller durability", "buffer.", "", 2));
        lores.add(new Lore(AetherExItems.MineFist, "\u00a7eFist of mine_diver", "Has extended reach.", "Can break any", "block. Right clicking", "destroys area.", "Has a 10 cooldown", "on the ability though.", 2));
        lores.add(new Lore(AetherExItems.JebHammer, "\u00a7bJeb Hammer", "Mines any block at", "fast speeds. Also", "has area mode. 25%", "chance to double", "aether ore drops", "with Lucky Pendant.", 2));
        lores.add(new Lore(AetherExItems.ValkyrieRing, "\u00a7aValkyrie Ring", "Extends reach of", "every tool by 3", "blocks. Also extends", "block placement", "range.", "", 2));
        lores.add(new Lore(AetherExItems.ChainGloves, "Chain Gloves", "Has no use, added", "just because.", "", "", "", "", 0));
        lores.add(new Lore(AetherExItems.PhoenixSword, "\u00a7aPhoenix Sword", "Lights mobs on fire.", "can be used as a", "flint and steel.", "Can also shoot a", "fireball projectile if", "durability isn\'t low.", 2));
        lores.add(new Lore(AetherExItems.PhoenixPick, "\u00a7aPhoenix Pickaxe", "Smelts pickaxe", "stuff. Yay!", "", "", "", "", 2));
        lores.add(new Lore(AetherExItems.PhoenixAxe, "\u00a7aPhoenix Axe", "Smelts axe stuff.", "Yay!", "", "", "", "", 2));
        lores.add(new Lore(AetherExItems.PhoenixShovel, "\u00a7aPhoenix Shovel", "Smelts shovel", "stuff. Yay!", "", "", "", "", 2));
        lores.add(new Lore(AetherExItems.HealMatrix, "\u00a7aHealing Matrix", "Generates health", "at a rate that is", "twice as fast as", "the healing stone.", "Does not stack with", "the healing stone.", 2));
        lores.add(new Lore(AetherExItems.FlameGem, "\u00a7eFlaming Gemstone", "Has a 25% chance", "to set the attacker", "on fire for 10", "seconds.", "", "", 2));
        lores.add(new Lore(AetherExItems.SpeedRing, "\u00a7aRing of Speed", "Increases the", "player\'s speed.", "", "", "", "", 2));
        lores.add(new Lore(AetherExItems.JebShield, "\u00a7aShield of Jeb", "Has a 20% chance to", "block damage from", "attacker and deal", "4x more damage", "back to the", " attacker.", 2));
        lores.add(new Lore(AetherExItems.AerShield, "\u00a7aAer Shield", "Has a 25% chance to", "block damage from", "attacker and launch", "the attacker in the", "air.", "", 2));
        lores.add(new Lore(AetherExItems.AerCape, "\u00a7aAer Cape", "Ability to jump 3", "times midair. Negates", "fall damage. Must be", "repaired in the", "enchanter for more", "uses. Unbreakable.", 2));
        lores.add(new Lore(AetherExItems.PinkCape, "Pink Cape", "Worn in cape", "slot.", "Purely decorative.", "", "", "", 2));
        lores.add(new Lore(AetherExItems.PurpleCape, "Purple Cape", "Worn in cape", "slot.", "Purely decorative.", "", "", "", 2));
        lores.add(new Lore(AetherExItems.LimeCape, "Green Cape", "Worn in cape", "slot.", "Purely decorative.", "", "", "", 2));
        lores.add(new Lore(AetherExItems.OrangeCape, "Orange Cape", "Worn in cape", "slot.", "Purely decorative.", "", "", "", 2));
        lores.add(new Lore(AetherExItems.BrownCape, "Brown Cape", "Worn in cape", "slot.", "Purely decorative.", "", "", "", 2));
        lores.add(new Lore(AetherExItems.BlackCape, "Black Cape", "Worn in cape", "slot.", "Purely decorative.", "", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherExItems.HalloweenBag, 1, 0), "\u00a7aCommon Halloween Bag", "Found during the", "spoopy season.", "Has some cool stuff.", "", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherExItems.HalloweenBag, 1, 1), "\u00a75Rare Halloween Bag", "Found during the", "spoopy season.", "Has some cool stuff.", "", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherExItems.HalloweenBag, 1, 2), "\u00a76Legendary Halloween Bag", "Found during the", "spoopy season.", "Has some cool stuff.", "", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherExItems.Candy, 1, 0), "Candy", "Known to be healthy.", "Eat them all at", "once.", "", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherExItems.Candy, 1, 1), "Candy", "Known to be healthy.", "Eat them all at", "once.", "", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherExItems.Candy, 1, 2), "Candy", "Known to be healthy.", "Eat them all at", "once.", "", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherExItems.Candy, 1, 3), "Candy", "Known to be healthy.", "Eat them all at", "once.", "", "", "", 2));
        lores.add(new Lore(AetherExItems.VileEssence, "Vile Essence", "Useless and gross.", "Maybe it has a", "purpose?", "", "", "", 2));
        lores.add(new Lore(AetherExItems.VileSword, "\u00a7aVile Blade", "Killing mobs during", "the spoopy season", "has a chance to", "drop some good", "loot! Lucky pendant", "increases chances.", 2));
        lores.add(new Lore(AetherExItems.HalloweenCape, "\u00a74Halloween Cape", "Exclusive cape that", "is purely cosmetic.", "", "", "", "", 2));
        lores.add(new Lore(AetherExItems.UnholyArrow, "\u00a74Unholy Arrow", "Ammunition for the", "\u00a74Unholy Crossbow", "Found in halloween", "bags.", "", "", 2));
        lores.add(new Lore(AetherExItems.UnholyBow, "\u00a74Unholy Crossbow", "Shoots lightning", "or explosive bolts.", "Use sneak+right", "click to swap", "modes. Uses unholy", "arrows as ammo.", 2));
        lores.add(new Lore(AetherExItems.UnholySword, "\u00a74Unholy Sword", "Has a chance to", "create an explosion", "when fighting. Right", "clicking shoots a", "poisonous lightning", "dart.", 2));
        lores.add(new Lore(AetherExItems.BlueMoaStaff, "Blue Moa Staff", "Used for capturing", "a blue moa. This is", "pog. Found in", "bronze dungeons.", "", "", 2));
        lores.add(new Lore(AetherExItems.WhiteMoaStaff, "White Moa Staff", "Used for capturing", "a white moa. This is", "pog. Found in silver", "dungeons.", "", "", 2));
        lores.add(new Lore(AetherExItems.BlackMoaStaff, "Black Moa Staff", "Used for capturing", "a black moa. This is", "pog. Found in gold", "dungeons.", "", "", 2));
        lores.add(new Lore(AetherExItems.ZaniteShears, "Zanite Shears", "Used for getting", "leaves and other", "cool stuff :)", "", "", "", 2));
        lores.add(new Lore(AetherExItems.OrangeMoaEgg, "Orange Moa Egg", "Used in advanced", "incubator. Orange", "moa can be", "upgraded.", "", "", 2));
        lores.add(new Lore(AetherExItems.GoldenElixir, "Golden Elixir", "Has many uses.", "Use sparingly. This", "is not pog.", "", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherExItems.MoaArmor, 1, 0), "Iron Moa Armor", "Strong Moa armor.", "I am stronk.", "Stronks = Stonks", "", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherExItems.MoaArmor, 1, 1), "Golden Moa Armor", "Weakest Moa armor.", "Side note: if it\'s", "like 2050, is Intel", "still releasing 14 NM", "CPUs?", "", 2));
        lores.add(new Lore(new ItemStack(AetherExItems.MoaArmor, 1, 2), "Diamond Moa Armor", "Strongest Moa", "armor. Does anyone", "actually read these?", "", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherExItems.MoaArmor, 1, 3), "Zanite Moa Armor", "Strong Moa armor.", "Oh it\'s purple! So", "cute like Meefy-", "Chan! Ok sorry I\'m", "cringe.", "", 2));
        lores.add(new Lore(new ItemStack(AetherExItems.MoaArmor, 1, 4), "Gravitite Moa Armor", "Strongest Moa", "armor. Also makes", "moa jump higher.", "Proof that la", "cronge will prevail.", "", 2));
        lores.add(new Lore(AetherExItems.VoidTomato, "\u00a7eVoid Tomato", "If it\'s in the void,", "how are you reading", "this? Ok seriously", "it upgrades orange", "moas. Happy? K", "cool.", 2));
        lores.add(new Lore(AetherExItems.GoldenBrew, "\u00a7aGolden Brew", "When the imposter is", "sus, give him this.", "He will be speeedy", "", "", "", 2));
        lores.add(new Lore(AetherExItems.AscendingDisc, "\247bAscending Dawn", "Courtesy of Emile", "van Krieken!", "Dropped by the", "Valkyrie Queen.", "", "", 2));
        lores.add(new Lore(AetherExItems.LightNightDisc, "\2479A Light in the Night", "Courtesy of Emile", "van Krieken! Found", "in Rare Halloween", "bags.", "", "", 2));
        lores.add(new Lore(AetherExItems.ApproachesDisc, "\247aApproaches", "Courtesy of Emile", "van Krieken! Found", "in Silver dungeons.", "", "", "", 2));
        lores.add(new Lore(AetherExItems.BriseDisc, "\247dBrise", "Courtesy of Emile", "van Krieken!", "Dropped by the Sun", "Spirit.", "", "", 2));
        lores.add(new Lore(AetherExItems.CrepusculumDisc, "\247cCrepusculum", "Courtesy of Emile", "van Krieken!", "Dropped by the", "Slider.", "", "", 2));
        lores.add(new Lore(AetherExItems.LabyrinthDisc, "\2474Labyrinth's Vengeance", "Courtesy of Emile", "van Krieken! Found", "in Bronze dungeons.", "", "", "", 2));

        lores.add(new Lore(AetherExBlocks.AdvancedIncubator, "Advanced Incubator", "Incubates orange", "moa eggs. Evolution", "is great isn\'t it.", "", "", "", 2));
        lores.add(new Lore(AetherExItems.ResurrectionPendant, "\u00a7aResurrection Pendant", "Will save your life", "once when you die.", "Oh what a hero!", "Give him a bread", "sandwich. ", "", 2));
        lores.add(new Lore(AetherExBlocks.VoidLeaves, "Void Leaves", "This is unobtainable.", "The fact that", "you\'re reading this", "is maaaad sus.", "", "", 2));
        lores.add(new Lore(AetherExBlocks.VoidWood, "Void Wood", "Unobtainable. But!", "La cronge shall", "prevail.", "", "", "", 2));
        lores.add(new Lore(AetherExBlocks.BookshelfOfLore, "Bookshelf of Lore", "Contains secrets", "to the universe, it", "knows all.", "", "", "", 0));
        lores.add(new Lore(AetherExBlocks.BookshelfOfLore, "Bookshelf of Lore", "Contains secrets", "to the universe, it", "knows all.", "", "", "", 1));
        lores.add(new Lore(AetherExBlocks.BookshelfOfLore, "Bookshelf of Lore", "Contains secrets", "to the universe, it", "knows all.", "", "", "", 2));

        lores.add(new Lore(AetherExBlocks.CarvedStairs, "Carved Stairs", "Double it and give", "it to the next", "person.", "", "", "", 2));
        lores.add(new Lore(AetherExBlocks.AngelicStairs, "Angelic Stairs", "They're stairs, why", "you reading this?", "", "", "", "", 2));
        lores.add(new Lore(AetherExBlocks.HellfireStairs, "Hellfire Stairs", "I'm Glenn Quagmire.", "I'm Glenn Quagmire.", "I'm Glenn Quagmire.", "I'm Glenn Quagmire.", "I'm Glenn Quagmire.", "I'm Glenn Quagmire.", 2));
        lores.add(new Lore(AetherExBlocks.CarvedLitStairs, "Sentry Stairs", "I'd like 5 whoppers,", "and 5 more", "whoppers.", "", "", "", 2));
        lores.add(new Lore(AetherExBlocks.AngelicLitStairs, "Light Angelic Stairs", "Morbius made 3", "morbillion dollars.", "", "", "", "", 2));
        lores.add(new Lore(AetherExBlocks.HellfireLitStairs, "Light Hellfire Stairs", "Spongebob", "spongebob. Patrick", "patrick.", "", "", "Gary.", 2));
        lores.add(new Lore(AetherExBlocks.AerogelStairs, "\u00A7aAerogel Stairs", "██████", "█████", "████", "███", "██", "█", 2));

        lores.add(new Lore(AetherExBlocks.SkyrootSlab, "Skyroot Slab", "When in doubt,", "follow Giovanni's", "conjecture.", "", "", "", 2));
        lores.add(new Lore(AetherExBlocks.HolystoneSlab, "Holystone Slab", "It's a problem with", "the whole way of", "life.", "", "", "", 2));
        lores.add(new Lore(AetherExBlocks.MossyHolystoneSlab, "Mossy Holystone Slab", "\"I am the yeast of", "thoughts and minds\"", "", "", "", "- Globglogabgalab", 2));
        lores.add(new Lore(AetherExBlocks.CarvedSlab, "Carved Slab", "Value is subjective,", "time is absolute.", "", "", "", "", 2));
        lores.add(new Lore(AetherExBlocks.AngelicSlab, "Angelic Slab", "I cannot wait to", "finish this update.", "", "", "", "", 2));
        lores.add(new Lore(AetherExBlocks.HellfireSlab, "Hellfire Slab", "Roblox is a bad", "game. Minecraft", "superior.", "", "", "", 2));
        lores.add(new Lore(AetherExBlocks.CarvedLitSlab, "Sentry Slab", "Meefy ate the lore", "*burps*", "Sorry :(", "", "", "", 2));
        lores.add(new Lore(AetherExBlocks.AngelicLitSlab, "Light Angelic Slab", "As a wise man once", "said, you have less", "time than you had", "before.", "", "", 2));
        lores.add(new Lore(AetherExBlocks.HellfireLitSlab, "Light Hellfire Slab", "It's not clock...", "it's not clock.", "", "", "", "", 2));
        lores.add(new Lore(AetherExBlocks.AerogelSlab, "\u00A7aAerogel Slab", "Let me be clear...", "", "", "", "", "", 2));
        if (FabricLoader.getInstance().isModLoaded("stonewall")) {
            lores.add(new Lore(AetherExBlocks.HolystoneWall, "Holystone Wall", "Walls are for", "people who hate", "open concept designs.", "", "", "", 2));
            lores.add(new Lore(AetherExBlocks.MossyHolystoneWall, "Mossy Holystone Wall", "Must have been", "the Aether.", "", "", "", "", 2));
            lores.add(new Lore(AetherExBlocks.CarvedWall, "Carved Wall", "Did you hear", "the joke about", "the high wall?", "I still can't", "get over it!", "", 2));
            lores.add(new Lore(AetherExBlocks.AngelicWall, "Angelic Wall", "I tried to make", "the wall laugh.", "It cracked.", "", "", "", 2));
            lores.add(new Lore(AetherExBlocks.HellfireWall, "Hellfire Wall", "I was going to", "tell you a joke", "about a tall fence...", "but you probably", "wouldn't get over it.", "", 2));
        }
    }
}
