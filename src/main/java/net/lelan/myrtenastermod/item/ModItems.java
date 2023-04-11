package net.lelan.myrtenastermod.item;

import net.lelan.myrtenastermod.MyrtenasterMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS =
			DeferredRegister.create(ForgeRegistries.ITEMS, MyrtenasterMod.MOD_ID);

	public static final RegistryObject<Item> MYRTENASTER = ITEMS.register("myrtenaster",
			() -> new Item(new Item.Properties()));


	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}


}
