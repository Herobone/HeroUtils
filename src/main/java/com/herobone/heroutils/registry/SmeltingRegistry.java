package com.herobone.heroutils.registry;

import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingRegistry {
	
	public SmeltingRegistry() {
	}

	public void register() {
		GameRegistry.addSmelting(Blocks.DIRT, new ItemStack(BlockRegistry.tutblock, 1), 1.0F);
	}

	public void unregister() {
		Iterator<Entry<ItemStack, ItemStack>> it = FurnaceRecipes.instance().getSmeltingList().entrySet().iterator();
		while(it.hasNext()) {
			Entry<ItemStack,ItemStack> entry = it.next();
			ItemStack input = entry.getKey();
			ItemStack output = entry.getValue();
			if (input != null && input.getItem() != null) {
				if (input.getItem() == Item.getItemFromBlock(Blocks.IRON_ORE)) {
					it.remove();
				}
			}
			if (output != null && output.getItem() != null) {
				if (output.getItem() == Items.GOLD_INGOT) {
					it.remove();
				}
			}
		}
	}

}
