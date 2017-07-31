package com.herobone.heroutils;

import com.herobone.heroutils.handler.TutorialEventHandler;
import com.herobone.heroutils.proxy.CommonProxy;
import com.herobone.heroutils.registry.BlockRegistry;
import com.herobone.heroutils.registry.CraftingRegistry;
import com.herobone.heroutils.registry.EntityRegister;
import com.herobone.heroutils.registry.ItemRegistry;
import com.herobone.heroutils.registry.SmeltingRegistry;
import com.herobone.heroutils.registry.TabRegister;
import com.herobone.heroutils.tileentity.TileEntityCookieJar;

import mekanism.api.EnumColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = HeroUtils.MODID, version = HeroUtils.VERSION, name = HeroUtils.NAME, dependencies = "after:CoFHCore;")
public class HeroUtils
{
    public static final String MODID = "heroutils";
    public static final String VERSION = "1.0";
    public static final String NAME = "Herobone-Utils Mod";
    
    @Instance(MODID)
    public static final HeroUtils instance = new HeroUtils();
    
    @SidedProxy(modId = MODID, serverSide = "com.herobone.heroutils.proxy.CommonProxy", clientSide = "com.herobone.heroutils.proxy.ClientProxy")
    public static final CommonProxy proxy = new CommonProxy();
    
    public static final RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
    public static final RenderItem itemRenderer = Minecraft.getMinecraft().getRenderItem();
    
    public TabRegister tab;
    
    public static final String CHATPREFIX = EnumColor.DARK_BLUE + "[HeroUtils] ";
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
    	ItemRegistry items;
        BlockRegistry blocks;
        EntityRegister entityreg;
    	
    	OBJLoader.INSTANCE.addDomain(HeroUtils.MODID);

    	proxy.init();
    	
    	tab = new TabRegister();
    	
    	items = new ItemRegistry();
    	items.init();
    	items.register();
    	
    	blocks = new BlockRegistry();
    	blocks.init();
    	blocks.register();
    	
    	entityreg = new EntityRegister();
    	entityreg.register();
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	CraftingRegistry crafting;
        SmeltingRegistry smelting;
    	
    	crafting = new CraftingRegistry();
    	crafting.unregister();
    	crafting.register();
    	
    	smelting = new SmeltingRegistry();
    	smelting.unregister();
    	smelting.register();
    	
    	GameRegistry.registerTileEntity(TileEntityCookieJar.class, MODID + "TileEntityCookieJar");
    	
    	MinecraftForge.EVENT_BUS.register(new TutorialEventHandler());
    	
    	proxy.init();
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {
    	proxy.registerModels();
    }
}
