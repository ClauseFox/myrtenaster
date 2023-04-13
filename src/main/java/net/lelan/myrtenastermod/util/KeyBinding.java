package net.lelan.myrtenastermod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
	public static final String KEY_CATEGORY_MYRTENASTER = "key.category.myrtenastermod.myrtenaster";
	public static final String KEY_SWITCH_ELEMENT = "key.myrtenastermod.switch_element";

	public static final KeyMapping SWITCHING_KEY = new KeyMapping(KEY_SWITCH_ELEMENT, KeyConflictContext.IN_GAME,
			InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_P, KEY_CATEGORY_MYRTENASTER);

}
