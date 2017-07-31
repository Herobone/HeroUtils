package com.herobone.heroutils.registry;

import com.herobone.heroutils.HeroUtils;
import com.herobone.heroutils.blocks.*;
import com.herobone.heroutils.utils.NameUtils;

import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegistry {

	public static Block herohead;
	public static Block cookiejar;

	public void init() {
		herohead = new HeroHead().setCreativeTab(HeroUtils.instance.tab);
		NameUtils.setNames(herohead, "herohead");
		
		cookiejar = new CookieJar().setCreativeTab(HeroUtils.instance.tab);
		NameUtils.setNames(cookiejar, "cookiejar");
	}

	public void register() {
		registerBlocks(herohead);
		registerBlocks(cookiejar);
	}
	
	private void registerBlocks(Block block) {
		GameRegistry.register(block);
		ItemBlock itemblock = new ItemBlock(block);
		itemblock.setUnlocalizedName(block.getUnlocalizedName()).setRegistryName(block.getRegistryName());
		GameRegistry.register(itemblock);
	}

}
