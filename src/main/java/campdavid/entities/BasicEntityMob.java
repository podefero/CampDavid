package campdavid.entities;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.world.World;

public class BasicEntityMob extends EntityZombie {

	public BasicEntityMob(World worldIn) {
		super(worldIn);
		
		this.setHeldItem(getActiveHand(), getSkullDrop());
		
		
		// TODO Auto-generated constructor stub
	}
	
	
	
}