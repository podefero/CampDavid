package campdavid.init;


import campdavid.items.BasicItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber

public  class CampDavidItems {
	
	static Item basicItem;
	
	public static final ToolMaterial BASIC_MATERIAL = EnumHelper.addToolMaterial("BASIC_MATERIAL", 1, 50, 5f, 1, 10);
	
	public static void init() {
		basicItem = new BasicItem("basic_item").setMaxStackSize(32).setCreativeTab(CreativeTabs.MISC);
		
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(basicItem);
		
	}
	
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(basicItem);
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}