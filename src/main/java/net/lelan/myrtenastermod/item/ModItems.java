package net.lelan.myrtenastermod.item;

import net.lelan.myrtenastermod.MyrtenasterMod;
import net.lelan.myrtenastermod.item.custom.MyrtenasterItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS =
			DeferredRegister.create(ForgeRegistries.ITEMS, MyrtenasterMod.MOD_ID);

	//Myrtenaster
	public static final RegistryObject<SwordItem> MYRTENASTER = ITEMS.register("myrtenaster",
			() -> new MyrtenasterItem(Tiers.NETHERITE, 0, 3f, new Item.Properties().stacksTo(1)));

	//Items
	public static final RegistryObject<Item> FIRE_ESSENCE = ITEMS.register("fire_essence",
			() -> new Item(new Item.Properties().stacksTo(64)));

	public static final RegistryObject<Item> EARTH_ESSENCE = ITEMS.register("earth_essence",
			() -> new Item(new Item.Properties().stacksTo(64)));

	public static final RegistryObject<Item> AIR_ESSENCE = ITEMS.register("air_essence",
			() -> new Item(new Item.Properties().stacksTo(64)));

	public static final RegistryObject<Item> ENERGY_CELL = ITEMS.register("energy_cell",
			() -> new Item(new Item.Properties().stacksTo(64)));

	public static final RegistryObject<Item> WATER_DROPLET = ITEMS.register("water_droplet",
			() -> new Item(new Item.Properties().stacksTo(64)));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
