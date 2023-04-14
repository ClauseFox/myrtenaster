package net.lelan.myrtenastermod.networking.packet;

import net.lelan.myrtenastermod.client.ElementHudOverlay;
import net.lelan.myrtenastermod.item.ModItems;
import net.lelan.myrtenastermod.item.custom.MyrtenasterItem;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.network.NetworkEvent;
import java.util.function.Supplier;

public class SwitchingElementC2SPacket {
	public static int index = 0;

	public SwitchingElementC2SPacket() {

	}

	public SwitchingElementC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			//Everything in here happens on the server
			ServerPlayer player = context.getSender();
			ServerLevel level = player.getLevel();

			if (player.getMainHandItem().toString().equals("1 myrtenaster")) {

				if (index == 4) {
					index = -1;
				}

				index++;
				String elements[];
				elements = new String[]{"fire", "earth", "electro", "water", "air"};
				MyrtenasterItem.current_element = elements[index];
			}
		});
		return true;
	}

}
