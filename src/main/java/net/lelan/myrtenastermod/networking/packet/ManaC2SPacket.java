package net.lelan.myrtenastermod.networking.packet;

import net.lelan.myrtenastermod.event.ModEvents;
import net.lelan.myrtenastermod.item.custom.MyrtenasterItem;
import net.lelan.myrtenastermod.mana.PlayerMana;
import net.lelan.myrtenastermod.mana.PlayerManaProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ManaC2SPacket {
	public static int mana = 100;
	public static int index = 0;

	public ManaC2SPacket() {

	}

	public ManaC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			//Everything in here happens on the server
			ServerPlayer player = context.getSender();
			ServerLevel level = player.getLevel();
			index++;
			if (MyrtenasterItem.current_element == "fire" && mana >= 8) {
				mana -= 2;
				player.sendSystemMessage(Component.translatable("-8").withStyle(ChatFormatting.RED));
			} else if (MyrtenasterItem.current_element == "earth" && mana >= 10) {
				mana -= 2;
				if (index % 2 == 0) {
					player.sendSystemMessage(Component.translatable("-10").withStyle(ChatFormatting.DARK_GRAY));
				}
			} else if (MyrtenasterItem.current_element == "electro" && mana >= 20) {
				mana -= 5;
				player.sendSystemMessage(Component.translatable("-20").withStyle(ChatFormatting.LIGHT_PURPLE));
			} else if (MyrtenasterItem.current_element == "water" && mana >= 10) {
				mana -= 2;
				if (index % 2 == 0) {
					player.sendSystemMessage(Component.translatable("-10").withStyle(ChatFormatting.AQUA));
				}
			} else if (MyrtenasterItem.current_element == "air" && mana >= 5) {
				mana -= 2;
				player.sendSystemMessage(Component.translatable("-5").withStyle(ChatFormatting.YELLOW));
			}
		});
		return true;
	}

}
