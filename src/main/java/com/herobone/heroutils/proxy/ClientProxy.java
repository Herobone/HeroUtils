package com.herobone.heroutils.proxy;

import com.herobone.heroutils.HeroUtils;
import com.herobone.heroutils.entity.SnowRender;
import com.herobone.heroutils.entity.projectile.PlasmaArrow;
import com.herobone.heroutils.registry.BlockRegistry;
import com.herobone.heroutils.registry.EntityRegister;
import com.herobone.heroutils.registry.ItemRegistry;
import com.herobone.heroutils.render.PlasmaArrowRender;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy {
	
	public void registerModels() {
		registerModel(ItemRegistry.tutitem, 0, new ModelResourceLocation(ItemRegistry.tutitem.getRegistryName(), "inventory"));
		registerModel(ItemRegistry.tutfood, 0, new ModelResourceLocation(ItemRegistry.tutfood.getRegistryName(), "inventory"));
		registerModel(BlockRegistry.tutblock, 0, new ModelResourceLocation(BlockRegistry.tutblock.getRegistryName(), "inventory"));
		registerModel(BlockRegistry.herohead, 0, new ModelResourceLocation(BlockRegistry.herohead.getRegistryName(), "inventory"));
		registerModel(ItemRegistry.gravitybelt, 0, new ModelResourceLocation(ItemRegistry.gravitybelt.getRegistryName(), "inventory"));
		registerModel(ItemRegistry.plasmacannon, 0, new ModelResourceLocation(ItemRegistry.plasmacannon.getRegistryName(), "inventory"));
		registerModel(ItemRegistry.plasmaprojectile, 0, new ModelResourceLocation(ItemRegistry.plasmaprojectile.getRegistryName(), "inventory"));
	}
	
	public void init() {
		RenderingRegistry.registerEntityRenderingHandler(PlasmaArrow.class, new IRenderFactory<PlasmaArrow>() {
			@Override
			public Render<PlasmaArrow> createRenderFor(RenderManager manager)
			{
				return new PlasmaArrowRender<PlasmaArrow>() {

					@Override
					protected ResourceLocation getEntityTexture(PlasmaArrow entity) {
						return new ResourceLocation(HeroUtils.MODID, "textures/entity/projectile.png");
					}
				};
			}
		});
	}

	private void registerModel(Object obj, int meta, ModelResourceLocation loc) {
		Item item = null;
		
		if (obj instanceof Item) {
			item = (Item) obj;
		} else if (obj instanceof Block) {
			item = Item.getItemFromBlock((Block)obj);
		} else {
			throw new IllegalArgumentException();
		}
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, loc);
	}
}
