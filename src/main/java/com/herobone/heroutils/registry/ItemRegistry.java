package com.herobone.heroutils.registry;

import com.herobone.heroutils.HeroUtils;
import com.herobone.heroutils.item.GravityBelt;
import com.herobone.heroutils.item.ItemTut;
import com.herobone.heroutils.item.ItemTutFood;
import com.herobone.heroutils.item.PlasmaCannon;
import com.herobone.heroutils.item.PlasmaProjectile;
import com.herobone.heroutils.utils.NameUtils;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {
	
	public static Item tutitem;
	public static Item tutfood;
	public static Item gravitybelt;
	public static Item plasmacannon;
	public static Item plasmaprojectile;

	public void init() {
		tutitem = new ItemTut().setCreativeTab(HeroUtils.instance.tab);
		NameUtils.setNames(tutitem, "tutitem");
		
		tutfood = new ItemTutFood().setCreativeTab(HeroUtils.instance.tab);
		NameUtils.setNames(tutfood, "tutfood");
		
		gravitybelt = new GravityBelt().setCreativeTab(HeroUtils.instance.tab);
		NameUtils.setNames(gravitybelt, "gravitybelt");
		
		plasmacannon = new PlasmaCannon().setCreativeTab(HeroUtils.instance.tab);
		NameUtils.setNames(plasmacannon, "plasmacannon");
		
		plasmaprojectile = new PlasmaProjectile().setCreativeTab(HeroUtils.instance.tab);
		NameUtils.setNames(plasmaprojectile, "plasmaprojectile");
	}
	
	public void register() {
		registerItem(tutitem);
		registerItem(tutfood);
		registerItem(gravitybelt);
		registerItem(plasmacannon);
		registerItem(plasmaprojectile);
	}
	
	private void registerItem(Item item) {
		GameRegistry.register(item);
	}
	
}
