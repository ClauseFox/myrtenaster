package net.lelan.myrtenastermod.effect;

import com.ibm.icu.impl.duration.TimeUnit;
import net.lelan.myrtenastermod.networking.ModMessages;
import net.lelan.myrtenastermod.networking.packet.IdkC2SPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;



public class ElectrifiedEffect extends MobEffect {
	public int tick = 1;

	public ElectrifiedEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	@Override
	public void	applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level.isClientSide()) {
			double x = pLivingEntity.getX();
			double y = pLivingEntity.getY();
			double z = pLivingEntity.getZ();

			ServerLevel world = ((ServerLevel) pLivingEntity.level);
			BlockPos position = pLivingEntity.blockPosition();

			if (tick % 60 == 0) {
				EntityType.LIGHTNING_BOLT.spawn(world, (ItemStack) null, null, position, MobSpawnType.TRIGGERED, true, true);
/*				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}*/
			}
			tick++;
		}
		super.applyEffectTick(pLivingEntity, pAmplifier);
	}

	@Override
	public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
		return true;
	}
}
