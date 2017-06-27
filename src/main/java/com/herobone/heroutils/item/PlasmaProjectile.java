package com.herobone.heroutils.item;

import com.herobone.heroutils.entity.projectile.PlasmaArrow;
import com.herobone.heroutils.registry.ItemRegistry;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PlasmaProjectile extends ItemArrow {
	public PlasmaProjectile() {
		super();
	}

	public PlasmaArrow createArrow(World world, ItemStack itemStack, EntityPlayer player) {
		PlasmaArrow plasmaarrow = new PlasmaArrow(world, player) {
			
			@Override
			protected ItemStack getArrowStack() {
				return new ItemStack(ItemRegistry.plasmaprojectile);
			}
		};
		return plasmaarrow;
	}
}
