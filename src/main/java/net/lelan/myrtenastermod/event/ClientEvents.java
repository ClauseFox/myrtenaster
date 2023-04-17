package net.lelan.myrtenastermod.event;

import net.lelan.myrtenastermod.MyrtenasterMod;
import net.lelan.myrtenastermod.client.ElementHudOverlay;
import net.lelan.myrtenastermod.item.custom.MyrtenasterItem;
import net.lelan.myrtenastermod.networking.ModMessages;
import net.lelan.myrtenastermod.networking.packet.SwitchingElementC2SPacket;
import net.lelan.myrtenastermod.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
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
				//Everything in here happens on the Client
				ModMessages.sendToServer(new SwitchingElementC2SPacket());
			}
		}
	}

	@Mod.EventBusSubscriber(modid = MyrtenasterMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ClientModBusEvents {
		@SubscribeEvent
		public static void onKeyRegister(RegisterKeyMappingsEvent event) {
			event.register(KeyBinding.SWITCHING_KEY);
		}

		@SubscribeEvent
		public static void registerGUIOverlays(RegisterGuiOverlaysEvent event) {
			event.registerAboveAll("element", ElementHudOverlay.HUD_ELEMENT);
		}
	}

}
