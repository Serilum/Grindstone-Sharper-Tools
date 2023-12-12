package com.natamus.grindstonesharpertools.forge.events;

import com.natamus.grindstonesharpertools.events.GrindEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeGrindEvent {
	@SubscribeEvent
	public void onDamage(LivingHurtEvent e) {
		LivingEntity livingEntity = e.getEntity();

		float originalDamage = e.getAmount();
		float newDamage = GrindEvent.onDamage(livingEntity.level, livingEntity, e.getSource(), originalDamage);

		if (originalDamage != newDamage) {
			e.setAmount(newDamage);
		}
	}

	@SubscribeEvent
	public void onClick(PlayerInteractEvent.RightClickBlock e) {
		GrindEvent.onClick(e.getLevel(), e.getEntity(), e.getHand(), e.getPos(), e.getHitVec());
	}
}
