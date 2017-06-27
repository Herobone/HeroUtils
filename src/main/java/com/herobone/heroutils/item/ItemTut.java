package com.herobone.heroutils.item;

import com.herobone.heroutils.registry.ItemRegistry;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemTut extends Item {

	public ItemTut() {
		super();
		this.setMaxDamage(1024);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
		playerIn.jump();
		playerIn.fallDistance = 0.0F;
		itemStackIn.damageItem(1, playerIn);
		return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
	}
	
}
