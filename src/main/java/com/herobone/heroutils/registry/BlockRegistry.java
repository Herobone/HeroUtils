package com.herobone.heroutils.registry;

import com.herobone.heroutils.HeroUtils;
import com.herobone.heroutils.blocks.BlockTut;
import com.herobone.heroutils.blocks.HeroHead;
import com.herobone.heroutils.utils.NameUtils;

import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegistry {
	
	public static Block tutblock;
	public static Block herohead;

	public void init() {
		tutblock = new BlockTut().setCreativeTab(HeroUtils.instance.tab);
		NameUtils.setNames(tutblock, "tutblock");
		
		herohead = new HeroHead().setCreativeTab(HeroUtils.instance.tab);
		NameUtils.setNames(herohead, "herohead");
	}

	public void register() {
		registerBlocks(tutblock);
		registerBlocks(herohead);
	}
	
	private void registerBlocks(Block block) {
		GameRegistry.register(block);
		ItemBlock itemblock = new ItemBlock(block);
		itemblock.setUnlocalizedName(block.getUnlocalizedName()).setRegistryName(block.getRegistryName());
		GameRegistry.register(itemblock);
	}

}
