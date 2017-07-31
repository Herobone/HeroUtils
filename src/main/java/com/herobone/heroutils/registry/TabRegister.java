package com.herobone.heroutils.registry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabRegister extends CreativeTabs {

	public TabRegister() {
		super("heroutils");
		this.setBackgroundImageName("item_search.png");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(BlockRegistry.herohead);
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}

}
