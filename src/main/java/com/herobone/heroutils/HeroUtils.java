package com.herobone.heroutils;

import java.lang.reflect.Proxy;

import com.herobone.heroutils.handler.TutorialEventHandler;
import com.herobone.heroutils.proxy.CommonProxy;
import com.herobone.heroutils.registry.BlockRegistry;
import com.herobone.heroutils.registry.CraftingRegistry;
import com.herobone.heroutils.registry.EntityRegister;
import com.herobone.heroutils.registry.ItemRegistry;
import com.herobone.heroutils.registry.SmeltingRegistry;
import com.herobone.heroutils.registry.TabRegister;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.*;

@Mod(modid = HeroUtils.MODID, version = HeroUtils.VERSION, name = HeroUtils.NAME, dependencies = "after:CoFHCore;")
public class HeroUtils
{
    public static final String MODID = "heroutils";
    public static final String VERSION = "1.0";
    public static final String NAME = "Herobone-Utils Mod";
    
    @Instance(MODID)
    public static HeroUtils instance = new HeroUtils();
    
    @SidedProxy(modId = MODID, serverSide = "com.herobone.heroutils.proxy.CommonProxy", clientSide = "com.herobone.heroutils.proxy.ClientProxy")
    public static CommonProxy proxy = new CommonProxy();
    
    public static RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
    public static RenderItem itemRenderer = Minecraft.getMinecraft().getRenderItem();
    
    public TabRegister tab;
    
    public ItemRegistry items;
    public BlockRegistry blocks;
    public EntityRegister entityreg;

    public CraftingRegistry crafting;
    public SmeltingRegistry smelting;
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	OBJLoader.INSTANCE.addDomain(HeroUtils.MODID);
    	
    	tab = new TabRegister();
    	
    	items = new ItemRegistry();
    	items.init();
    	items.register();
    	
    	blocks = new BlockRegistry();
    	blocks.init();
    	blocks.register();
    	
    	entityreg = new EntityRegister();
    	entityreg.register();
    	
    	proxy.registerTileEntities();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	crafting = new CraftingRegistry();
    	crafting.unregister();
    	crafting.register();
    	
    	smelting = new SmeltingRegistry();
    	smelting.unregister();
    	smelting.register();
    	
    	MinecraftForge.EVENT_BUS.register(new TutorialEventHandler());
    	
    	proxy.init();
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {
    	proxy.registerModels();
    }
}
