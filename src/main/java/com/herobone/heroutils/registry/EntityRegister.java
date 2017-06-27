package com.herobone.heroutils.registry;

import com.herobone.heroutils.HeroUtils;
import com.herobone.heroutils.entity.projectile.PlasmaArrow;
import com.herobone.heroutils.utils.NameUtils;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityRegister {
	
	public static Entity plasmaprojectile;
	
	public static int ENTITY_ID = 123;

	public void init() {
	}
	
	public void register() {
		registerEnity(PlasmaArrow.class, "PlasmaProjectile");
	}
	
	public static void registerEnity(Class<? extends Entity> classIn, String name) {
		EntityRegistry.registerModEntity(classIn, name, ++ENTITY_ID, HeroUtils.instance, 64, 10, false);
	}
	
}
