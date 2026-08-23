package io.github.kaosreven.aetherex.block.template;

import net.minecraft.block.PressurePlateActivationRule;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplatePressurePlateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class PressurePlateTemplate extends TemplatePressurePlateBlock {
    public PressurePlateTemplate(Identifier identifier, PressurePlateActivationRule pressurePlateActivationRule, Material material) {
        super(identifier, 0, pressurePlateActivationRule, material);
    }
}
