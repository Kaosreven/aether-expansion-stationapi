package io.github.kaosreven.aetherex.block;

import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.template.block.TemplateWorkbenchBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class SkyrootWorkbenchBlock extends TemplateWorkbenchBlock {
	public static int topTexture;
	public static int bottomTexture;
	public static int sideTexture;

	public SkyrootWorkbenchBlock(Identifier identifier)
	{
		super(identifier);
		this.textureId = sideTexture;
		this.setSoundGroup(Block.WOOD_SOUND_GROUP).setHardness(2.0F).setResistance(5.0F);
	}

	@Override
	public int getTexture(int i) {
		if (i == 1) {
			return topTexture;
		} else {
			return i == 0 ? bottomTexture : sideTexture;
		}
	}
}
