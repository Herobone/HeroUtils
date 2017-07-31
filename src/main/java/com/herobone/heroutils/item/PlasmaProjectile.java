package com.herobone.heroutils.item;

import com.herobone.heroutils.entity.projectile.PlasmaArrow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PlasmaProjectile extends ItemArrow {
	public PlasmaProjectile() {
		super();
	}

	public PlasmaArrow createArrow(World world, ItemStack itemStack, EntityPlayer player) {
		return new PlasmaArrow(world, player);
	}
}
