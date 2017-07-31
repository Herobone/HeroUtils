package com.herobone.heroutils.proxy;

import com.herobone.heroutils.HeroUtils;
import com.herobone.heroutils.entity.EntityDummy;
import com.herobone.heroutils.entity.projectile.PlasmaArrow;
import com.herobone.heroutils.registry.BlockRegistry;
import com.herobone.heroutils.registry.ItemRegistry;
import com.herobone.heroutils.render.entity.RendererDummy;
import com.herobone.heroutils.render.tileentity.RendererCookieJar;
import com.herobone.heroutils.tileentity.TileEntityCookieJar;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	private String inv = "inventory";
	
	public void registerModels() {
		registerModel(BlockRegistry.herohead, 0, new ModelResourceLocation(BlockRegistry.herohead.getRegistryName(), inv));
		registerModel(BlockRegistry.cookiejar, 0, new ModelResourceLocation(BlockRegistry.cookiejar.getRegistryName(), inv));
		registerModel(ItemRegistry.gravitybelt, 0, new ModelResourceLocation(ItemRegistry.gravitybelt.getRegistryName(), inv));
		registerModel(ItemRegistry.plasmacannon, 0, new ModelResourceLocation(ItemRegistry.plasmacannon.getRegistryName(), inv));
		registerModel(ItemRegistry.plasmaprojectile, 0, new ModelResourceLocation(ItemRegistry.plasmaprojectile.getRegistryName(), inv));
		registerModel(ItemRegistry.trident, 0, new ModelResourceLocation(ItemRegistry.trident.getRegistryName(), inv));
		registerModel(ItemRegistry.snowcepter, 0, new ModelResourceLocation(ItemRegistry.snowcepter.getRegistryName(), inv));
	}
	
	@SideOnly(Side.CLIENT)
	public void init() {
		RenderingRegistry.registerEntityRenderingHandler(PlasmaArrow.class, new IRenderFactory<PlasmaArrow>() {
			@Override
			public Render<PlasmaArrow> createRenderFor(RenderManager manager)
			{
				return new RenderArrow<PlasmaArrow>(manager) {
					@Override
					protected ResourceLocation getEntityTexture(PlasmaArrow entity) {
						return new ResourceLocation(HeroUtils.MODID, "textures/entity/projectile.png");
					}
				};
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityDummy.class, new IRenderFactory<EntityDummy>() {
			@Override
			public Render<EntityDummy> createRenderFor(RenderManager manager)
			{
				return new RendererDummy(manager);
			}
		});
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCookieJar.class, new RendererCookieJar());
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
