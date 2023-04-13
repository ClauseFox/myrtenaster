package net.lelan.myrtenastermod.networking;

import net.lelan.myrtenastermod.MyrtenasterMod;
import net.lelan.myrtenastermod.networking.packet.IdkC2SPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessages {
	private static SimpleChannel INSTANCE;

	private static int packetId = 0;
	private static int id() {
		return packetId++;
	}

	public static void register() {
		SimpleChannel net = NetworkRegistry.ChannelBuilder
				.named(new ResourceLocation(MyrtenasterMod.MOD_ID, "messages"))
				.networkProtocolVersion(() -> "1.0")
				.clientAcceptedVersions(s -> true)
				.serverAcceptedVersions(s -> true)
				.simpleChannel();

		INSTANCE = net;

		net.messageBuilder(IdkC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(IdkC2SPacket::new)
				.encoder(IdkC2SPacket::toBytes)
				.consumerMainThread(IdkC2SPacket::handle)
				.add();

	}

	public static <MSG> void sendToServer(MSG message) {
		INSTANCE.sendToServer(message);
	}

	public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {

	}

}
