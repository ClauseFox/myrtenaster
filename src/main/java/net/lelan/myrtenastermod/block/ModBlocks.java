package net.lelan.myrtenastermod.block;

import net.lelan.myrtenastermod.MyrtenasterMod;
import net.lelan.myrtenastermod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS =
			DeferredRegister.create(ForgeRegistries.BLOCKS, MyrtenasterMod.MOD_ID);

	public static final RegistryObject<Block> FIRE_ORE = registerBlock("fire_ore",
			() -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
					.strength(3.0f, 3.0f).requiresCorrectToolForDrops()));

	public static final RegistryObject<Block> ENERGY_ORE = registerBlock("energy_ore",
			() -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
					.strength(3.0f, 3.0f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

	public static final RegistryObject<Block> DEEPSLATE_ENERGY_ORE = registerBlock("deepslate_energy_ore",
			() -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
					.strength(6.0f, 6.0f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

	public static final RegistryObject<Block> EARTH_BLOCK = registerBlock("earth_block",
			() -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT)
					.strength(1F).sound(SoundType.GRAVEL).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));

	public static final RegistryObject<Block> AIR_FLOWER = registerBlock("air_flower",
			() -> new FlowerBlock(MobEffects.MOVEMENT_SPEED, 5,
					BlockBehaviour.Properties.copy(Blocks.DANDELION).instabreak().sound(SoundType.GRASS)));


	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}

	private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
		return ModItems.ITEMS.register(name,
				() -> new BlockItem(block.get(), new Item.Properties()));
	}

	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}

}
