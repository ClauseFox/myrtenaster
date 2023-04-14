package net.lelan.myrtenastermod.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.lelan.myrtenastermod.MyrtenasterMod;
import net.lelan.myrtenastermod.item.custom.MyrtenasterItem;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class ElementHudOverlay {
	private static final ResourceLocation FIRE_ELEMENT = new ResourceLocation(MyrtenasterMod.MOD_ID,
			"textures/element/fire_element.png");
	private static final ResourceLocation EARTH_ELEMENT = new ResourceLocation(MyrtenasterMod.MOD_ID,
			"textures/element/earth_element.png");
	private static final ResourceLocation ELECTRO_ELEMENT = new ResourceLocation(MyrtenasterMod.MOD_ID,
			"textures/element/electro_element.png");
	private static final ResourceLocation WATER_ELEMENT = new ResourceLocation(MyrtenasterMod.MOD_ID,
			"textures/element/water_element.png");
	private static final ResourceLocation AIR_ELEMENT = new ResourceLocation(MyrtenasterMod.MOD_ID,
			"textures/element/air_element.png");

	public static final IGuiOverlay HUD_ELEMENT = ((gui, poseStack, partialTick, width, height) -> {
		int x = width / 2;
		int y = height;

		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

		switch (MyrtenasterItem.current_element) {
			case "fire":
				RenderSystem.setShaderTexture(0, FIRE_ELEMENT);
				break;

			case "earth":
				RenderSystem.setShaderTexture(0, EARTH_ELEMENT);
				break;

			case "electro":
				RenderSystem.setShaderTexture(0, ELECTRO_ELEMENT);
				break;

			case "water":
				RenderSystem.setShaderTexture(0, WATER_ELEMENT);
				break;

			case "air":
				RenderSystem.setShaderTexture(0, AIR_ELEMENT);
				break;
		}

		GuiComponent.blit(poseStack, x - 6, y - 48,0,0,12,12,
				12,12);
	});

}
