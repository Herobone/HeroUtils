package com.herobone.heroutils.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Trident extends Item {
	
	public Trident() {
		super();
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (entityIn instanceof EntityLivingBase) {
			EntityLivingBase entity = (EntityLivingBase) entityIn;
			if (entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) entity;
				if (entity.isInWater()) {
					entity.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 20 , 5 , false, false));
					entity.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 20 , 5 , false, false));
					player.capabilities.disableDamage = true;
				} else {
					player.capabilities.disableDamage = false;
				}
			}
		}
	}

}
