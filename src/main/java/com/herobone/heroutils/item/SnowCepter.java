package com.herobone.heroutils.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SnowCepter extends Item {
	
	public SnowCepter() {
		super();
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		
		if (isSelected) {
			double x = entityIn.posX;
			double y = entityIn.posY;
			double z = entityIn.posZ;
			
			BlockPos pos = new BlockPos(x, --y, z);
			
			if (entityIn instanceof EntityPlayer 
					&& !worldIn.isAirBlock(pos) 
					&& worldIn.getBlockState(pos).getBlock() != Blocks.BEDROCK 
					&& worldIn.getBlockState(pos).getBlock() != Blocks.SNOW
					&& worldIn.getBlockState(pos).getBlock() != Blocks.LAVA
					&& worldIn.getBlockState(pos).getBlock() != Blocks.WATER
					&& worldIn.getBlockState(pos).isFullBlock()
					&& worldIn.getBlockState(pos).isFullCube()) {
				
				worldIn.setBlockState(pos, Blocks.SNOW.getDefaultState());
				
			}
		}
	}

}
