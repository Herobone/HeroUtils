package com.herobone.heroutils.render.tileentity;

import com.herobone.heroutils.tileentity.TileEntityCookieJar;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RendererCookieJar extends TileEntitySpecialRenderer<TileEntityCookieJar> {
	
	private static final EntityItem ITEM = new EntityItem(Minecraft.getMinecraft().theWorld, 0, 0, 0, new ItemStack(Items.COOKIE));

	@Override
	public void renderTileEntityAt(TileEntityCookieJar te, double x, double y, double z, float partialTicks, int destroyStage) {
		super.renderTileEntityAt(te, x, y, z, partialTicks, destroyStage);
		
		ITEM.hoverStart = 0F;
		
		GlStateManager.pushMatrix();
		
		GlStateManager.translate(x, y, z);
		GlStateManager.rotate(90F, 1, 0, 0);
		GlStateManager.translate(0.5, 0, -0.1);
		for (int i = 0; i < te.getCookieCount(); i++) {
			Minecraft.getMinecraft().getRenderManager().doRenderEntity(ITEM, 0, 0, 0, 0F, 0F, false);
			GlStateManager.translate(0, 0, -0.0625);
		}
		
		GlStateManager.popMatrix();
	}
	
}
