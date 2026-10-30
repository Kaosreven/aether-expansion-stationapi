package io.github.kaosreven.aetherex.item.misc;

import io.github.kaosreven.aetherex.block.AetherExBlocks;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateSignItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class SkyrootSignItem extends TemplateSignItem
{
	public SkyrootSignItem(Identifier identifier)
	{
		super(identifier);
	}

	@Override
	public boolean useOnBlock(ItemStack stack, PlayerEntity user, World world, int x, int y, int z, int side)
	{
		if (side == 0)
			return false;

		if (!world.getMaterial(x, y, z).isSolid())
			return false;

		if (side == 1)
			y++;
		else if (side == 2)
			z--;
		else if (side == 3)
			z++;
		else if (side == 4)
			x--;
		else if (side == 5)
			x++;

		if (!AetherExBlocks.SkyrootSign.canPlaceAt(world, x, y, z))
			return false;

		if (side == 1)
			world.setBlockState(x, y, z, AetherExBlocks.SkyrootSign.getDefaultState(), MathHelper.floor((user.yaw + 180.0F) * 16.0F / 360.0F + 0.5) & 15);
		else
			world.setBlockState(x, y, z, AetherExBlocks.SkyrootWallSign.getDefaultState(), side);

		stack.count--;

		if (world.getBlockEntity(x, y, z) instanceof SignBlockEntity sign)
			user.openEditSignScreen(sign);

		return true;
	}
}
