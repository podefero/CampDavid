package campdavid.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
/*
 * Basic Block is only meant for blocks that have no special effects. i.e dirt, cobblestone, sand.. 
 */
public class BasicBlock extends Block {
	public BasicBlock(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}