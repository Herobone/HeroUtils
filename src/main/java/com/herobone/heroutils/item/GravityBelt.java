package com.herobone.heroutils.item;

import java.util.List;

import baubles.api.BaubleType;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import baubles.api.IBauble;

public class GravityBelt extends Item implements IBauble {
	
	public GravityBelt() {
		super();
		this.setMaxStackSize(1);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("\u00A7c" + " - Put in Bauble's Belt-Slot!");
		tooltip.add("\u00a7a" + " - Lets you fly!");
		tooltip.add("\u00a7a" + " - Disables building and digging in World");
	}
	
	public BaubleType getBaubleType(final ItemStack itemstack) {
        return BaubleType.BELT;
    }
	
	public void onWornTick(final ItemStack itemstack, final EntityLivingBase player) {
		player.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 20 , 5 , false, false));
    }
    
    public void onEquipped(final ItemStack itemstack, final EntityLivingBase playerIN) {
    	if (playerIN instanceof EntityPlayer) {
	        EntityPlayer player = (EntityPlayer) playerIN;
	        player.capabilities.allowFlying = true;
	        player.fallDistance = 0.0F;
	        player.capabilities.allowEdit = false;
	    }
    }
    
    public void onUnequipped(final ItemStack itemstack, final EntityLivingBase playerIN) {
    	if (playerIN instanceof EntityPlayer) {
	        EntityPlayer player = (EntityPlayer) playerIN;
	        player.capabilities.allowFlying = false;
	        player.fallDistance = 1.0F;
	        player.capabilities.allowEdit = true;
	    }
    }
    
    public boolean canEquip(final ItemStack itemstack, final EntityLivingBase player) {
        return true;
    }
    
    public boolean canUnequip(final ItemStack itemstack, final EntityLivingBase player) {
        return true;
    }
}
