package campdavid.init;


import campdavid.CampDavid;
import campdavid.entities.BasicEntityMob;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;


public class CampDavidEntity {
	


	@Mod.EventBusSubscriber
	public static class RegistrationHandler {

		/**
		 * Register this mod's {@link Entity} types.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerEntities(final RegistryEvent.Register<EntityEntry> event) {
			final EntityEntry[] entries = {
					
					createBuilder("basic_entity_mob")
							.entity(BasicEntityMob.class)
							.tracker(80, 3, true)
							.egg(0x0DA70B, 0x101010)
							.build(),
			};

			event.getRegistry().registerAll(entries);
			RenderHandler.registerEntityRenders();

			addSpawns();
		}

		
		/**
		 * Add this mod's entity spawns.
		 */
		private static void addSpawns() {
			EntityRegistry.addSpawn(BasicEntityMob.class, 100, 5, 20, EnumCreatureType.MONSTER, Biomes.DEFAULT);
			//copySpawns(EntityPlayerAvoidingCreeper.class, EnumCreatureType.MONSTER, EntityCreeper.class, EnumCreatureType.MONSTER);
		}

		

		private static int entityID = 0;

		/**
		 * Create an {@link EntityEntryBuilder} with the specified unlocalised/registry name and an automatically-assigned network ID.
		 *
		 * @param name The name
		 * @param <E>  The entity type
		 * @return The builder
		 */
		private static <E extends Entity> EntityEntryBuilder<E> createBuilder(final String name) {
			final EntityEntryBuilder<E> builder = EntityEntryBuilder.create();
			final ResourceLocation registryName = new ResourceLocation(CampDavid.MODID, name);
			return builder.id(registryName, entityID++).name(registryName.toString());
		}

		/**
		 * Get an array of {@link Biome}s with the specified {@link BiomeDictionary.Type}.
		 *
		 * @param type The Type
		 * @return An array of Biomes
		 */
		private static Biome[] getBiomes(final BiomeDictionary.Type type) {
			return BiomeDictionary.getBiomes(type).toArray(new Biome[0]);
		}

		/**
		 * Add a spawn list entry for {@code classToAdd} in each {@link Biome} with an entry for {@code classToCopy} using the same weight and group count.
		 *
		 * @param classToAdd         The class to add spawn entries for
		 * @param creatureTypeToAdd  The EnumCreatureType to add spawn entries for
		 * @param classToCopy        The class to copy spawn entries from
		 * @param creatureTypeToCopy The EnumCreatureType to copy spawn entries from
		 */
		private static void copySpawns(final Class<? extends EntityLiving> classToAdd, final EnumCreatureType creatureTypeToAdd, final Class<? extends EntityLiving> classToCopy, final EnumCreatureType creatureTypeToCopy) {
			for (final Biome biome : ForgeRegistries.BIOMES) {
				biome.getSpawnableList(creatureTypeToCopy).stream()
						.filter(entry -> entry.entityClass == classToCopy)
						.findFirst()
						.ifPresent(spawnListEntry ->
								biome.getSpawnableList(creatureTypeToAdd).add(new Biome.SpawnListEntry(classToAdd, spawnListEntry.itemWeight, spawnListEntry.minGroupCount, spawnListEntry.maxGroupCount))
						);
			}
		}
	}
}