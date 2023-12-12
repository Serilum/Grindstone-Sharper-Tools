package com.natamus.grindstonesharpertools;

import com.natamus.collective.check.RegisterMod;
import com.natamus.collective.fabric.callbacks.CollectiveBlockEvents;
import com.natamus.collective.fabric.callbacks.CollectiveEntityEvents;
import com.natamus.grindstonesharpertools.events.GrindEvent;
import com.natamus.grindstonesharpertools.util.Reference;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class ModFabric implements ModInitializer {
	
	@Override
	public void onInitialize() {
		setGlobalConstants();
		ModCommon.init();

		loadEvents();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadEvents() {
		CollectiveEntityEvents.ON_LIVING_DAMAGE_CALC.register((Level world, Entity entity, DamageSource damageSource, float damageAmount) -> {
			return GrindEvent.onDamage(world, entity, damageSource, damageAmount);
		});

		CollectiveBlockEvents.BLOCK_RIGHT_CLICK.register((Level world, Player player, InteractionHand hand, BlockPos pos, BlockHitResult hitVec) -> {
			return GrindEvent.onClick(world, player, hand, pos, hitVec);
		});
	}

	private static void setGlobalConstants() {

	}
}
