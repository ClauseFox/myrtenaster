package net.lelan.myrtenastermod.item.custom;

import net.lelan.myrtenastermod.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class MyrtenasterItem extends SwordItem {

	public static String current_element = "electro";

	public MyrtenasterItem(Tier tier, int damage, float attackSpeed, Properties properties) {
		super(tier, damage, attackSpeed, properties);
	}

	@Override
	public boolean hurtEnemy(ItemStack pItemStack, LivingEntity pTarget, LivingEntity pAttacker) {
		if (current_element == "electro") {
			pTarget.addEffect(new MobEffectInstance(ModEffects.ELECTRIFIED.get(), 200, 0), pAttacker);
		}
		return super.hurtEnemy(pItemStack, pTarget, pAttacker);
	}
}
