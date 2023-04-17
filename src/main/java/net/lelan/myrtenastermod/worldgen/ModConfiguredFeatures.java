package net.lelan.myrtenastermod.worldgen;

import net.lelan.myrtenastermod.MyrtenasterMod;
import net.lelan.myrtenastermod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_FIRE_ORE_KEY = registerKey("fire_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ENERGY_ORE_KEY = registerKey("energy_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_EARTH_BLOCK_KEY = registerKey("earth_block");

	public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_AIR_FLOWER_KEY = registerKey("air_flower");

	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
		RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
		RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
		RuleTest dirtReplaceables = new BlockMatchTest(Blocks.DIRT);

		List<OreConfiguration.TargetBlockState> overworldEnergyOres = List.of(OreConfiguration.target(stoneReplaceables,
				ModBlocks.ENERGY_ORE.get().defaultBlockState()),
				OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ENERGY_ORE.get().defaultBlockState()));

		register(context, OVERWORLD_FIRE_ORE_KEY, Feature.ORE,
				new OreConfiguration(stoneReplaceables, ModBlocks.FIRE_ORE.get().defaultBlockState(), 9, 0.1F));
		register(context, OVERWORLD_ENERGY_ORE_KEY, Feature.ORE,
				new OreConfiguration(overworldEnergyOres, 8, 1F));
		register(context, OVERWORLD_EARTH_BLOCK_KEY, Feature.ORE,
				new OreConfiguration(dirtReplaceables, ModBlocks.EARTH_BLOCK.get().defaultBlockState(), 3, 0F));

		register(context, OVERWORLD_AIR_FLOWER_KEY, Feature.FLOWER,
				new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
						new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.AIR_FLOWER.get())))));
	}

	public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(MyrtenasterMod.MOD_ID, name));
	}

	private static <FC extends FeatureConfiguration, F extends Feature<FC>>
	void register(BootstapContext<ConfiguredFeature<?, ?>> context,
				  ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
		context.register(key, new ConfiguredFeature<>(feature, configuration));
	}
}
