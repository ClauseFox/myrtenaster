package net.lelan.myrtenastermod.event;

import net.lelan.myrtenastermod.MyrtenasterMod;
import net.lelan.myrtenastermod.item.ModItems;
import net.lelan.myrtenastermod.item.custom.MyrtenasterItem;
import net.lelan.myrtenastermod.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
	public static int index = 0;
	@Mod.EventBusSubscriber(modid = MyrtenasterMod.MOD_ID, value = Dist.CLIENT)
	public static class ClientForgeEvents {

		@SubscribeEvent
		public static void onKeyInput(InputEvent.Key event) {
			if (KeyBinding.SWITCHING_KEY.consumeClick()) {
				if (index == 4) {
					index = -1;
				}
				index++;
				String elements[];
				elements = new String[]{"fire", "earth", "electro", "water", "air"};
				MyrtenasterItem.current_element = elements[index];

				Minecraft.getInstance().player.sendSystemMessage(Component.literal(MyrtenasterItem.current_element));
			}
		}
	}

	@Mod.EventBusSubscriber(modid = MyrtenasterMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ClientModBusEvents {
		@SubscribeEvent
		public static void onKeyRegister(RegisterKeyMappingsEvent event) {
			event.register(KeyBinding.SWITCHING_KEY);
		}
	}

}
