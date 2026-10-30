package io.github.kaosreven.aetherex.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.BlockView;
import net.modificationstation.stationapi.api.template.block.TemplateFurnaceBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class HolystoneFurnaceBlock extends TemplateFurnaceBlock
{
	public static int furnaceTop;
	public static int furnaceFront;
	public static int furnaceFrontLit;
	final boolean lit;

	public HolystoneFurnaceBlock(Identifier identifier, boolean lit)
	{
		super(identifier, lit);
		this.lit = lit;

		this.setHardness(0.5F).setSoundGroup(STONE_SOUND_GROUP);
	}

	@Override
	public int getDroppedItemId(int blockMeta, Random random)
	{
		return AetherExBlocks.HolystoneFurnace.asItem().id;
	}

	@Environment(EnvType.CLIENT)
	@Override
	public int getTextureId(BlockView blockView, int x, int y, int z, int side)
	{
		if (side <= 1) return furnaceTop;
		int var6 = blockView.getBlockMeta(x, y, z);
		return side == var6 ? (this.lit ? furnaceFrontLit : furnaceFront) : this.textureId;
	}

	@Override
	public int getTexture(int side)
	{
		if (side <= 1) return furnaceTop;
		return side == 3 ? (this.lit ? furnaceFrontLit : furnaceFront) : this.textureId;
	}
}
