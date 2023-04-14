package net.lelan.myrtenastermod.networking;

import net.lelan.myrtenastermod.MyrtenasterMod;
import net.lelan.myrtenastermod.networking.packet.SwitchingElementC2SPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
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

		net.messageBuilder(SwitchingElementC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(SwitchingElementC2SPacket::new)
				.encoder(SwitchingElementC2SPacket::toBytes)
				.consumerMainThread(SwitchingElementC2SPacket::handle)
				.add();

	}

	public static <MSG> void sendToServer(MSG message) {
		INSTANCE.sendToServer(message);
	}

	public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
		INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
	}

}
