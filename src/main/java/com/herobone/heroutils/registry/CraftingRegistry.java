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
	
	public void register() {
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.plasmacannon, 1), new Object[] {
				"igi",
				"dss",
				"xii",
				'i', new ItemStack(Items.IRON_INGOT),
				'g', new ItemStack(Blocks.GLASS),
				'd', new ItemStack(Blocks.DRAGON_EGG),
				's', new ItemStack(Items.NETHER_STAR)
			});
	}

	public void unregister() {
		Iterator<IRecipe> it = CraftingManager.getInstance().getRecipeList().iterator();
		
		while (it.hasNext()) {
			IRecipe recipe = it.next();
			ItemStack output = recipe.getRecipeOutput();
			if (output != null && output.getItem() != null) {
				if (output.isItemEqual(new ItemStack(Items.IRON_SWORD))){
					output.addAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED.getAttributeUnlocalizedName(), new AttributeModifier("Weapon modifier", 20, 0), EntityEquipmentSlot.MAINHAND);
					output.addAttributeModifier(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), new AttributeModifier("Weapon modifier", 6, 0), EntityEquipmentSlot.MAINHAND);
				}
				if (output.isItemEqual(new ItemStack(Items.GOLDEN_SWORD))){
					output.addAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED.getAttributeUnlocalizedName(), new AttributeModifier("Weapon modifier", 20, 0), EntityEquipmentSlot.MAINHAND);
					output.addAttributeModifier(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), new AttributeModifier("Weapon modifier", 5, 0), EntityEquipmentSlot.MAINHAND);
				}
				if (output.isItemEqual(new ItemStack(Items.DIAMOND_SWORD))){
					output.addAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED.getAttributeUnlocalizedName(), new AttributeModifier("Weapon modifier", 20, 0), EntityEquipmentSlot.MAINHAND);
					output.addAttributeModifier(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), new AttributeModifier("Weapon modifier", 8, 0), EntityEquipmentSlot.MAINHAND);
				}
				if (output.isItemEqual(new ItemStack(Items.WOODEN_SWORD))){
					output.addAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED.getAttributeUnlocalizedName(), new AttributeModifier("Weapon modifier", 20, 0), EntityEquipmentSlot.MAINHAND);
					output.addAttributeModifier(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), new AttributeModifier("Weapon modifier", 4, 0), EntityEquipmentSlot.MAINHAND);
				}
				if (output.isItemEqual(new ItemStack(Items.STONE_SWORD))){
					output.addAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED.getAttributeUnlocalizedName(), new AttributeModifier("Weapon modifier", 20, 0), EntityEquipmentSlot.MAINHAND);
					output.addAttributeModifier(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), new AttributeModifier("Weapon modifier", 5, 0), EntityEquipmentSlot.MAINHAND);
				}
			}
		}
	}
	
}
