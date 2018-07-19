package campdavid.init;

import campdavid.entities.BasicEntityMob;
import campdavid.render.RenderBasicEntityMob;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
	
	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(BasicEntityMob.class, new IRenderFactory<BasicEntityMob>()
		{
			@Override 
			public  Render<? super BasicEntityMob> createRenderFor(RenderManager manager) {
				return new RenderBasicEntityMob(manager);
			}
		});
	}

}
