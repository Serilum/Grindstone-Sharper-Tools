package com.natamus.grindstonesharpertools.util;

import com.natamus.grindstonesharpertools.config.ConfigHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class Util {
	public static void updateName(ItemStack itemstack, int uses) {
		if (!ConfigHandler.showUsesLeftInItemName) {
			return;
		}

		String prefix = ConfigHandler.nameUsesPrefix;
		Component hoverName = itemstack.getHoverName();
		String name = hoverName.getString();
		List<Component> flatList = hoverName.toFlatList(Style.EMPTY);

		flatList.removeIf(component -> component.toString().contains(prefix));
		if (uses > 0) {
			Style last = flatList.get(flatList.size() - 1).getStyle();
			flatList.add(
					new TextComponent(" " + ConfigHandler.nameUsesPrefix
							+ uses + ConfigHandler.nameUsesSuffix).withStyle(last)
			);
		}

		MutableComponent mutableComponent = new TextComponent("");
		for (Component component : flatList) {
			mutableComponent.append(component);
		}

		itemstack.setHoverName(mutableComponent);

		if (uses == 0) {
			if ((new ItemStack(itemstack.getItem()).getHoverName().getString()).equals(itemstack.getHoverName().getString())) {
				itemstack.resetHoverName();
			}
		}
	}
}