package net.lelan.myrtenastermod.item.custom;

import net.lelan.myrtenastermod.effect.ModEffects;
import net.lelan.myrtenastermod.event.ModEvents;
import net.lelan.myrtenastermod.procedures.MyrtenasterAirHitProcedure;
import net.lelan.myrtenastermod.procedures.MyrtenasterFireHitProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

import static net.lelan.myrtenastermod.event.ModEvents.airExecute;

public class MyrtenasterItem extends SwordItem {

	public static String current_element = "fire";

	public MyrtenasterItem(Tier tier, int damage, float attackSpeed, Properties properties) {
		super(tier, damage, attackSpeed, properties);
	}

	@Override
	public boolean hurtEnemy(ItemStack pItemStack, LivingEntity pTarget, LivingEntity pAttacker) {
		if (current_element == "electro") {
			pAttacker.getLevel().playSound(null, new BlockPos(pAttacker.getX(), pAttacker.getY(), pAttacker.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 1, 1);
			pTarget.addEffect(new MobEffectInstance(ModEffects.ELECTRIFIED.get(), 200, 0), pAttacker);
		} else if (current_element == "fire") {
			MyrtenasterFireHitProcedure.execute(pTarget.level, pTarget, pAttacker);
		} else if (current_element == "air") {
			airExecute(pTarget);
			MyrtenasterAirHitProcedure.execute(pTarget.level, pTarget, pAttacker);
		}
		return super.hurtEnemy(pItemStack, pTarget, pAttacker);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		if(current_element == "earth"){
			ModEvents.earthExecute(world, entity);
		}else if(current_element == "water"){
			ModEvents.waterExecute(world, entity, itemstack);
		}
		return ar;
	}
}
