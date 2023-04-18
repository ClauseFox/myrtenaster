/*

package net.lelan.myrtenastermod.sound;

import net.lelan.myrtenastermod.MyrtenasterMod;
import net.lelan.myrtenastermod.event.CustomSoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MyrtenasterMod.MOD_ID);

    public static final RegistryObject<SoundEvent> MYRTENASTER_FIRE_HIT =
            registerSoundEvent("myrtenaster_fire_hit");


    public static RegistryObject<SoundEvent> registerSoundEvent (String name) {
        return SOUND_EVENTS.register(name, () -> new CustomSoundEvent(new ResourceLocation(MyrtenasterMod.MOD_ID, name), 1f, true));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }


}

*/

