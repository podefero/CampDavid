package campdavid;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import campdavid.init.CampDavidBlocks;
import campdavid.init.CampDavidItems;

/*
 * This is the Main file that minecraft will execute. MODID is the unique id minecraft will use, must be all lower case.
 * Name is the name people will see
 * Version is the current version that is being developed. 
 */

@Mod(modid = CampDavid.MODID, name = CampDavid.NAME, version = CampDavid.VERSION)
public class CampDavid
{
	
    public static final String MODID = "campdavid";
    public static final String NAME = "campdavid";
    public static final String VERSION = "1.0.0	";
    

    private static Logger logger;
    
   
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        //These 2 init methods will initialize the blocks, and items we have programmed. The Class files that have that method are used to register
        // the items and blocks
        CampDavidBlocks.init();
        CampDavidItems.init();
        
       
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        
    }
    
    //initialize blocks, items, and others
    
   
    
}
