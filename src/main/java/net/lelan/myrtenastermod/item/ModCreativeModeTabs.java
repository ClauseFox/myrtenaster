package net.lelan.myrtenastermod.item;

import net.lelan.myrtenastermod.MyrtenasterMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MyrtenasterMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
	public static CreativeModeTab MYRTENASTER_TAB;

	@SubscribeEvent
	public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
		MYRTENASTER_TAB = event.registerCreativeModeTab(new ResourceLocation(MyrtenasterMod.MOD_ID, "myrtenaster_tab"),
				builder -> builder.icon(() -> new ItemStack(ModItems.MYRTENASTER.get()))
						.title(Component.translatable("creativemodetab.myrtenaster_tab")));
	}
}
