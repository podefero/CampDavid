package campdavid.render;

import campdavid.CampDavid;
import campdavid.entities.BasicEntityMob;
import campdavid.model.ModelBasicEntityMob;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBasicEntityMob extends RenderLiving<BasicEntityMob>{
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(CampDavid.MODID + ":" + "assets/textures/entities/basic_entity_mob.png");

	public RenderBasicEntityMob(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelBasicEntityMob(), 0.5f);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ResourceLocation getEntityTexture(BasicEntityMob entity) {
		// TODO Auto-generated method stub
		return TEXTURES;
	}

	@Override 
	protected void applyRotations(BasicEntityMob entityLiving, float p_77043_2_, float rotationYaw, float partialTicks ) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
