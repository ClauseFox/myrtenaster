package net.lelan.myrtenastermod.item.custom;

import net.lelan.myrtenastermod.effect.ModEffects;
import net.lelan.myrtenastermod.event.ModEvents;
import net.lelan.myrtenastermod.networking.ModMessages;
import net.lelan.myrtenastermod.networking.packet.ManaC2SPacket;
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
		if (current_element == "electro" && ManaC2SPacket.mana >= 20) {
			pAttacker.getLevel().playSound(null, new BlockPos(pAttacker.getX(), pAttacker.getY(), pAttacker.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 1, 1);
			pTarget.addEffect(new MobEffectInstance(ModEffects.ELECTRIFIED.get(), 200, 0), pAttacker);
			ModMessages.sendToServer(new ManaC2SPacket());
		} else if (current_element == "fire" && ManaC2SPacket.mana >= 10) {
			MyrtenasterFireHitProcedure.execute(pTarget.level, pTarget, pAttacker);
			ModMessages.sendToServer(new ManaC2SPacket());
		} else if (current_element == "air" && ManaC2SPacket.mana >= 5) {
			airExecute(pTarget);
			MyrtenasterAirHitProcedure.execute(pTarget.level, pTarget, pAttacker);
			ModMessages.sendToServer(new ManaC2SPacket());
		}
		return super.hurtEnemy(pItemStack, pTarget, pAttacker);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		if(current_element == "earth" && ManaC2SPacket.mana >= 10){
			ModEvents.earthExecute(world, entity);
			ModMessages.sendToServer(new ManaC2SPacket());
		} else if(current_element == "water" && ManaC2SPacket.mana >= 10){
			ModEvents.waterExecute(world, entity, itemstack);
			ModMessages.sendToServer(new ManaC2SPacket());
		}
		return ar;
	}
}
