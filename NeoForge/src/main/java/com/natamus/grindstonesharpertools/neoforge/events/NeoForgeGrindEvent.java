package com.natamus.grindstonesharpertools.neoforge.events;

import com.natamus.grindstonesharpertools.events.GrindEvent;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber
public class NeoForgeGrindEvent {
	@SubscribeEvent
	public static void onDamage(LivingIncomingDamageEvent e) {
		LivingEntity livingEntity = e.getEntity();

		float originalDamage = e.getAmount();
		float newDamage = GrindEvent.onDamage(livingEntity.level(), livingEntity, e.getSource(), originalDamage);

		if (originalDamage != newDamage) {
			e.setAmount(newDamage);
		}
	}

	@SubscribeEvent
	public static void onClick(PlayerInteractEvent.RightClickBlock e) {
		GrindEvent.onClick(e.getLevel(), e.getEntity(), e.getHand(), e.getPos(), e.getHitVec());
	}
}
