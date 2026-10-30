package io.github.kaosreven.aetherex.block;

import io.github.kaosreven.aetherex.item.AetherExItems;
import net.minecraft.block.Block;
import net.minecraft.block.entity.SignBlockEntity;
import net.modificationstation.stationapi.api.template.block.TemplateSignBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class SkyrootSign extends TemplateSignBlock
{
	public SkyrootSign(Identifier identifier, boolean standing)
	{
		super(identifier, SignBlockEntity.class, standing);

		this.setSoundGroup(Block.WOOD_SOUND_GROUP).setHardness(2.0F).setResistance(5.0F);
	}

	@Override
	public int getDroppedItemId(int blockMeta, Random random)
	{
		return AetherExItems.SkyrootSign.id;
	}
}
