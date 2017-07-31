package com.herobone.heroutils.render.entity;

import com.herobone.heroutils.HeroUtils;
import com.herobone.heroutils.entity.EntityDummy;
import com.herobone.heroutils.render.model.entity.ModelDummy;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RendererDummy extends RenderLiving<EntityDummy>{

	public RendererDummy(RenderManager renderManager) {
		super(renderManager, new ModelDummy(), 0.5F);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityDummy entity) {
		return new ResourceLocation(HeroUtils.MODID, "textures/entity/baum.png");
	}

}
