package io.github.kaosreven.aetherex.optional;

import net.glasslauncher.mods.gcapi3.api.ConfigEntry;
import net.glasslauncher.mods.gcapi3.api.ConfigRoot;

public class AetherExConfig {
    public static class AetherExConfigInit {
        @ConfigEntry(name = "Should the Halloween event always be enabled", requiresRestart = true)
        public Boolean forceHal = false;

        @ConfigEntry(name = "Heal amount for weak heal staff", requiresRestart = true)
        public Integer weakHeal = 6;

        @ConfigEntry(name = "Heal amount for strong heal staff", requiresRestart = true)
        public Integer strongHeal = 12;

        @ConfigEntry(name = "Enable new fancy guis (Unfinished)", requiresRestart = true)
        public Boolean EnableFancyGui = false;

        @ConfigEntry(name = "Advanced Incubator bonus processing speed for eggs below the machine tier", requiresRestart = true)
        public Integer advancedIncubatorSpeed = 2;
    }

    @ConfigRoot(value = "general", visibleName = "Aether Expansion Config")
    public static final AetherExConfigInit CONFIG = new AetherExConfigInit();
}
