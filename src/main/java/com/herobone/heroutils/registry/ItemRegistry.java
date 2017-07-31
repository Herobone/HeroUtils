package com.herobone.heroutils.registry;

import com.herobone.heroutils.HeroUtils;
import com.herobone.heroutils.item.GravityBelt;
import com.herobone.heroutils.item.PlasmaCannon;
import com.herobone.heroutils.item.PlasmaProjectile;
import com.herobone.heroutils.item.SnowCepter;
import com.herobone.heroutils.item.Trident;
import com.herobone.heroutils.utils.NameUtils;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {
	
	public static Item trident;
	public static Item gravitybelt;
	public static Item plasmacannon;
	public static Item plasmaprojectile;
	public static Item snowcepter;

	public void init() {
		snowcepter = new SnowCepter().setCreativeTab(HeroUtils.instance.tab);
		NameUtils.setNames(snowcepter, "snowcepter");
		
		trident = new Trident().setCreativeTab(HeroUtils.instance.tab);
		NameUtils.setNames(trident, "trident");
		
		gravitybelt = new GravityBelt().setCreativeTab(HeroUtils.instance.tab);
		NameUtils.setNames(gravitybelt, "gravitybelt");
		
		plasmacannon = new PlasmaCannon().setCreativeTab(HeroUtils.instance.tab);
		NameUtils.setNames(plasmacannon, "plasmacannon");
		
		plasmaprojectile = new PlasmaProjectile().setCreativeTab(HeroUtils.instance.tab);
		NameUtils.setNames(plasmaprojectile, "plasmaprojectile");
	}
	
	public void register() {
		registerItem(trident);
		registerItem(gravitybelt);
		registerItem(plasmacannon);
		registerItem(plasmaprojectile);
		registerItem(snowcepter);
	}
	
	private void registerItem(Item item) {
		GameRegistry.register(item);
	}
	
}
