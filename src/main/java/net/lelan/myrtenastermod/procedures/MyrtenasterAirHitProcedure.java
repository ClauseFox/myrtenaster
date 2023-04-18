package net.lelan.myrtenastermod.procedures;

import net.lelan.myrtenastermod.item.custom.MyrtenasterItem;
import net.lelan.myrtenastermod.networking.packet.ManaC2SPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MyrtenasterAirHitProcedure {

    @SubscribeEvent
    public static void onEntityAttacked(LivingAttackEvent event) {
        if (event != null && event.getEntity() != null && MyrtenasterItem.current_element.equals("air")) {
            execute(event, event.getEntity().level, event.getEntity(), (LivingEntity) event.getSource().getEntity());
        }
    }

    public static void execute(Level world, LivingEntity pTarget, LivingEntity pAttacker) {
        if (ManaC2SPacket.mana >= 5) {
            execute(null, world, pTarget, pAttacker);
        }
    }

    private static void execute(@Nullable Event event, Level world, LivingEntity pTarget, LivingEntity pAttacker) {
        if (ManaC2SPacket.mana >= 5) {
            if (pTarget == null || pAttacker == null)
                return;
            if (MyrtenasterItem.current_element.equals("air") && pAttacker.getMainHandItem().toString().equals("1 myrtenaster")) {
                for (int index0 = 0; index0 < (int) (1000); index0++) {
                    world.playSound(null, new BlockPos(pAttacker.getX(), pAttacker.getY(), pAttacker.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
                    world.addParticle(ParticleTypes.EXPLOSION, (pTarget.getX()), (pTarget.getY()), (pTarget.getZ()), (0), (0), (0));
                }
            }
        }
    }
}
