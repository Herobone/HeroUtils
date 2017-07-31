package com.herobone.heroutils.registry;

import com.herobone.heroutils.HeroUtils;
import com.herobone.heroutils.entity.EntityDummy;
import com.herobone.heroutils.entity.projectile.PlasmaArrow;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityRegister {
	
	private static int ENTITY_ID = 123;
	
	public void register() {
		registerEnity(PlasmaArrow.class, "PlasmaProjectile");
		registerEnity(EntityDummy.class, "EntityDummy");
	}
	
	public static void registerEnity(Class<? extends Entity> classIn, String name) {
		EntityRegistry.registerModEntity(classIn, name, ++ENTITY_ID, HeroUtils.instance, 64, 10, false);
	}
	
}
