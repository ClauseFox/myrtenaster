package net.lelan.myrtenastermod.worldgen;

import net.lelan.myrtenastermod.MyrtenasterMod;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
	public static final ResourceKey<PlacedFeature> FIRE_ORE_PLACED_KEY = createKey("fire_ore_placed");
	public static final ResourceKey<PlacedFeature> ENERGY_ORE_PLACED_KEY = createKey("energy_ore_placed");
	public static final ResourceKey<PlacedFeature> EARTH_BLOCK_PLACED_KEY = createKey("earth_block_placed");

	public static final ResourceKey<PlacedFeature> AIR_FLOWER_PLACED_KEY = createKey("air_flower_placed");

	public static void bootstrap(BootstapContext<PlacedFeature> context) {
		HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

		register(context, FIRE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_FIRE_ORE_KEY),
				ModOrePlacement.commonOrePlacement(10, //Amount of veins per chunk
						HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));

		register(context, ENERGY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ENERGY_ORE_KEY),
				ModOrePlacement.commonOrePlacement(9, //Amount of veins per chunk
						HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

		register(context, EARTH_BLOCK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_EARTH_BLOCK_KEY),
				ModOrePlacement.rareOrePlacement(1, //Amount of veins per chunk
						HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(320))));


		register(context, AIR_FLOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_AIR_FLOWER_KEY),
				List.of(RarityFilter.onAverageOnceEvery(1), //once every *that number on the left* chunks
						InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
	}

	public static ResourceKey<PlacedFeature> createKey(String name) {
		return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(MyrtenasterMod.MOD_ID, name));
	}

	private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
								 Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
		context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
	}

	private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
								 Holder<ConfiguredFeature<?, ?>> configuration, PlacementModifier modifiers) {
		register(context, key, configuration, List.of(modifiers));
	}
}
