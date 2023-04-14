package net.lelan.myrtenastermod.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;



@Mod.EventBusSubscriber
public class MyrtenasterFireHitProcedure {
    @SubscribeEvent
    public static void onEntityAttacked(LivingAttackEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level, event.getEntity(), (LivingEntity) event.getSource().getEntity());
        }
}

    public static void execute(Level world, LivingEntity pTarget, LivingEntity pAttacker) {
        execute(null, world, pTarget, pAttacker);
    }

    private static void execute(@Nullable Event event, Level world, LivingEntity pTarget, LivingEntity pAttacker) {
        if (pTarget == null || pAttacker == null)
            return;
        pTarget.setSecondsOnFire(10);
        for (int index0 = 0; index0 < (int) (1000); index0++) {
            world.addParticle(ParticleTypes.FLAME, (pAttacker.getX()), (pAttacker.getY()), (pAttacker.getZ()), ((Math.random() / 2 + pTarget.getX() - pAttacker.getX()) / 2), ((Math.random() / 2 + pTarget.getY() - pAttacker.getY()) / 2),
                    ((Math.random() / 2 + pTarget.getZ() - pAttacker.getZ()) / 2));
        }
    }
}
