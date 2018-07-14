package campdavid;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.apache.logging.log4j.Logger;

import campdavid.blocks.BasicBlock;
import campdavid.init.CampDavidBlocks;


@Mod(modid = CampDavid.MODID, name = CampDavid.NAME, version = CampDavid.VERSION)
public class CampDavid
{
	//public static final CampDavidBlocks blockRegistry = new CampDavidBlocks(); 
    public static final String MODID = "campdavid";
    public static final String NAME = "campdavid";
    public static final String VERSION = "1.0.0	";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        CampDavidBlocks.init();
       
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        
    }
    
    //initialize blocks, items, and others
    
   
    
}
