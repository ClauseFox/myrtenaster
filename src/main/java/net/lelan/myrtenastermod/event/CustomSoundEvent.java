/*

package net.lelan.myrtenastermod.event;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.Optional;

public class CustomSoundEvent extends SoundEvent {
    public static final Codec<CustomSoundEvent> DIRECT_CODEC = RecordCodecBuilder.create((p_263380_) -> {
        return p_263380_.group(ResourceLocation.CODEC.fieldOf("sound_id").forGetter(CustomSoundEvent::getLocation), Codec.FLOAT.optionalFieldOf("range").forGetter(CustomSoundEvent::fixedRange)).apply(p_263380_, CustomSoundEvent::create);
    });
    public static final Codec<Holder<CustomSoundEvent>> CODEC = RegistryFileCodec.create(Registries.SOUND_EVENT, DIRECT_CODEC);
    private static final float DEFAULT_RANGE = 16.0F;
    private final ResourceLocation location;
    private final float range;
    private final boolean newSystem;

    private static SoundEvent create(ResourceLocation p_263406_, Optional<Float> p_263346_) {
        return p_263346_.map((p_263360_) -> {
            return createFixedRangeEvent(p_263406_, p_263360_);
        }).orElseGet(() -> {
            return createVariableRangeEvent(p_263406_);
        });
    }

    public static CustomSoundEvent createVariableRangeEvent(ResourceLocation p_262973_) {
        return new CustomSoundEvent(p_262973_, 16.0F, false);
    }

    public static CustomSoundEvent createFixedRangeEvent(ResourceLocation p_263003_, float p_263029_) {
        return new CustomSoundEvent(p_263003_, p_263029_, true);
    }
    @Override
    public CustomSoundEvent(ResourceLocation resourceLocation, float v, boolean b) {
        super(resourceLocation);
        this.location = resourceLocation;
        this.range = v;
        this.newSystem = b;
    }
    public ResourceLocation getLocation() {
        return this.location;
    }

    public float getRange(float p_215669_) {
        if (this.newSystem) {
            return this.range;
        } else {
            return p_215669_ > 1.0F ? 16.0F * p_215669_ : 16.0F;
        }
    }

    private Optional<Float> fixedRange() {
        return this.newSystem ? Optional.of(this.range) : Optional.empty();
    }

    public void writeToNetwork(FriendlyByteBuf p_263344_) {
        p_263344_.writeResourceLocation(this.location);
        p_263344_.writeOptional(this.fixedRange(), FriendlyByteBuf::writeFloat);
    }

    public static SoundEvent readFromNetwork(FriendlyByteBuf p_263371_) {
        ResourceLocation resourcelocation = p_263371_.readResourceLocation();
        Optional<Float> optional = p_263371_.readOptional(FriendlyByteBuf::readFloat);
        return create(resourcelocation, optional);
    }
}

*/

