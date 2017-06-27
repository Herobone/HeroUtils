package com.herobone.heroutils.blocks;

import java.util.Random;

import com.herobone.heroutils.registry.ItemRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTut extends Block {

	public BlockTut() {
		super(Material.ROCK);
		this.blockHardness = 2.5F;
		this.blockResistance = 2000F;
		this.setSoundType(SoundType.ANVIL);
		this.setLightLevel(0.5F);
		this.blockParticleGravity = 0.6F;
		this.setHarvestLevel("pickaxe", 2);
	}
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		// TODO Auto-generated method stub
		return random.nextInt(5) + 1;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ItemRegistry.tutitem;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			worldIn.setBlockState(pos.add(0, 15, 0), Blocks.ANVIL.getDefaultState());
			EntityAreaEffectCloud cloud = new EntityAreaEffectCloud(worldIn, pos.getX(), pos.getY(), pos.getZ());
			cloud.addEffect(new PotionEffect(MobEffects.LEVITATION, 100, 2));
			cloud.addEffect(new PotionEffect(MobEffects.RESISTANCE, 300 , 6));
			cloud.setColor(0xd35400);
			cloud.setDuration(200);
			cloud.setRadius(8);
			cloud.setWaitTime(40);
			worldIn.spawnEntityInWorld(cloud);
			worldIn.setBlockToAir(pos);
			return true;
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
	}

}
