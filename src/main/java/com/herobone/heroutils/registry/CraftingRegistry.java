package com.herobone.heroutils.registry;

import java.util.Iterator;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingRegistry {

	public CraftingRegistry() {
	}
	
	public void register() {
		GameRegistry.addShapedRecipe(new ItemStack(BlockRegistry.tutblock, 2), new Object[] {
			"dxx",
			"dlx",
			"dxx",
			'd', new ItemStack(Blocks.DIRT),
			'l', new ItemStack(Items.DYE, 1, 4)
		});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.tutitem), Blocks.DIRT, Blocks.STONE);
	}

	public void unregister() {
		Iterator<IRecipe> it = CraftingManager.getInstance().getRecipeList().iterator();
		
		while (it.hasNext()) {
			IRecipe recipe = it.next();
			ItemStack output = recipe.getRecipeOutput();
			if (output != null && output.getItem() != null) {
				if (output.isItemEqual(new ItemStack(Blocks.IRON_BARS))){
					it.remove();
				}
				if (output.isItemEqual(new ItemStack(Blocks.IRON_BLOCK))){
					it.remove();
				}
				if (output.isItemEqual(new ItemStack(Items.IRON_SWORD))){
					output.addAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED.getAttributeUnlocalizedName(), new AttributeModifier("Weapon modifier", 20, 0), EntityEquipmentSlot.MAINHAND);
				}
			}
		}
	}
	
}
