package net.lelan.myrtenastermod.effect;

import net.lelan.myrtenastermod.MyrtenasterMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
	public static final DeferredRegister<MobEffect> MOB_EFFECTS
			= DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MyrtenasterMod.MOD_ID);

	public static final RegistryObject<MobEffect> ELECTRIFIED = MOB_EFFECTS.register("electrified",
			() -> new ElectrifiedEffect(MobEffectCategory.HARMFUL, 3124687));

	public static void register(IEventBus eventBus) {
		MOB_EFFECTS.register(eventBus);
	}
}
