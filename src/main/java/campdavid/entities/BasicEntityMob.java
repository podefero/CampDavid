package campdavid.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BasicEntityMob extends EntityMob {

	public BasicEntityMob(World worldIn) {
		super(worldIn);
		
		//this.setHeldItem(getActiveHand(), getSkullDrop());
		
		
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	 protected void initEntityAI()
	    {
			//super.initEntityAI();
	        this.tasks.addTask(0, new EntityAISwimming(this));
	        this.tasks.addTask(7, new EntityAIAttackMelee(this, 1.0D, true));
	        this.tasks.addTask(2, new EntityAIMoveTowardsRestriction(this, 1.0D));
	        this.tasks.addTask(3, new EntityAIWanderAvoidWater(this, 1.0D));
	        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	        this.tasks.addTask(1, new EntityAILookIdle(this));
	        this.targetTasks.addTask(8, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, true));
	        
	        
	    }
	
		
	 	
	 	@Override
	 	protected void applyEntityAttributes()
	    {
	        super.applyEntityAttributes();
	        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.53000000417232513D);
	        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
	        //this.getAttributeMap().registerAttribute(SPAWN_REINFORCEMENTS_CHANCE).setBaseValue(this.rand.nextDouble() * net.minecraftforge.common.ForgeModContainer.zombieSummonBaseChance);
	    }
	
	
}