package com.herobone.heroutils.registry;

import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class SmeltingRegistry {

	/**
	 * GameRegistry.addSmelting(Blocks.DIRT, new ItemStack(BlockRegistry.herohead, 1), 1.0F);
	 */
	public void register() {
		
	}

	/**
	 * if (input != null && input.getItem() != null) {
	 * 		if (input.getItem() == Item.getItemFromBlock(Blocks.IRON_ORE)) {
	 * 			it.remove();
	 * 		}
	 * 	}
	 * if (output != null && output.getItem() != null) {
	 *		if (output.getItem() == Items.GOLD_INGOT) {
	 *			it.remove();
	 *		}
	 *	}
	 */
	@SuppressWarnings("unused")
	public void unregister() {
		Iterator<Entry<ItemStack, ItemStack>> it = FurnaceRecipes.instance().getSmeltingList().entrySet().iterator();
		
		while(it.hasNext()) {
			Entry<ItemStack,ItemStack> entry = it.next();
			ItemStack input = entry.getKey();
			ItemStack output = entry.getValue();
		}
	}

}
