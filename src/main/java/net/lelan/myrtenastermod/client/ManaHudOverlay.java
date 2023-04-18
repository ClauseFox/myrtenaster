package net.lelan.myrtenastermod.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.lelan.myrtenastermod.MyrtenasterMod;
import net.lelan.myrtenastermod.networking.packet.ManaC2SPacket;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class ManaHudOverlay {
	private static final ResourceLocation MANA_100 = new ResourceLocation(MyrtenasterMod.MOD_ID,
			"textures/mana/100_mana.png");
	private static final ResourceLocation MANA_90 = new ResourceLocation(MyrtenasterMod.MOD_ID,
			"textures/mana/90_mana.png");
	private static final ResourceLocation MANA_80 = new ResourceLocation(MyrtenasterMod.MOD_ID,
			"textures/mana/80_mana.png");
	private static final ResourceLocation MANA_70 = new ResourceLocation(MyrtenasterMod.MOD_ID,
			"textures/mana/70_mana.png");
	private static final ResourceLocation MANA_60 = new ResourceLocation(MyrtenasterMod.MOD_ID,
			"textures/mana/60_mana.png");
	private static final ResourceLocation MANA_50 = new ResourceLocation(MyrtenasterMod.MOD_ID,
			"textures/mana/50_mana.png");
	private static final ResourceLocation MANA_40 = new ResourceLocation(MyrtenasterMod.MOD_ID,
			"textures/mana/40_mana.png");
	private static final ResourceLocation MANA_30 = new ResourceLocation(MyrtenasterMod.MOD_ID,
			"textures/mana/30_mana.png");
	private static final ResourceLocation MANA_20 = new ResourceLocation(MyrtenasterMod.MOD_ID,
			"textures/mana/20_mana.png");
	private static final ResourceLocation MANA_10 = new ResourceLocation(MyrtenasterMod.MOD_ID,
			"textures/mana/10_mana.png");
	private static final ResourceLocation MANA_0 = new ResourceLocation(MyrtenasterMod.MOD_ID,
			"textures/mana/0_mana.png");

	public static final IGuiOverlay HUD_MANA = ((gui, poseStack, partialTick, width, height) -> {
		int x = width / 2;
		int y = height;

		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

		if (ManaC2SPacket.mana >= 95) {
			RenderSystem.setShaderTexture(0, MANA_100);
		} else if (ManaC2SPacket.mana >= 85) {
			RenderSystem.setShaderTexture(0, MANA_90);
		} else if (ManaC2SPacket.mana >= 75) {
			RenderSystem.setShaderTexture(0, MANA_80);
		} else if (ManaC2SPacket.mana >= 65) {
			RenderSystem.setShaderTexture(0, MANA_70);
		} else if (ManaC2SPacket.mana >= 55) {
			RenderSystem.setShaderTexture(0, MANA_60);
		} else if (ManaC2SPacket.mana >= 45) {
			RenderSystem.setShaderTexture(0, MANA_50);
		} else if (ManaC2SPacket.mana >= 35) {
			RenderSystem.setShaderTexture(0, MANA_40);
		} else if (ManaC2SPacket.mana >= 25) {
			RenderSystem.setShaderTexture(0, MANA_30);
		} else if (ManaC2SPacket.mana >= 15) {
			RenderSystem.setShaderTexture(0, MANA_20);
		} else if (ManaC2SPacket.mana >= 1) {
			RenderSystem.setShaderTexture(0, MANA_10);
		} else {
			RenderSystem.setShaderTexture(0, MANA_0);
		}
		GuiComponent.blit(poseStack, x + 10, y - 48,0,0,81,13,
				81,13);
	});

}
