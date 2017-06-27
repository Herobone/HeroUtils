package com.herobone.heroutils.registry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabRegister extends CreativeTabs{

	public TabRegister() {
		super("tutorial");
		this.setBackgroundImageName("item_search.png");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(BlockRegistry.tutblock);
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}

}
