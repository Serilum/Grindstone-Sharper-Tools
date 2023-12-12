package com.natamus.grindstonesharpertools.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.grindstonesharpertools.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry(min = 1, max = 5000) public static int usesAfterGrinding = 32;
	@Entry(min = 0, max = 100.0) public static double sharpenedDamageModifier = 1.5;
	@Entry public static boolean infiniteCreativeUses = false;
	@Entry public static boolean sendUsesLeftInChat = true;
	@Entry public static boolean showUsesLeftInItemName = true;
	@Entry public static String nameUsesPrefix = "(Sharpened uses: ";
	@Entry public static String nameUsesSuffix = ")";

	public static void initConfig() {
		configMetaData.put("usesAfterGrinding", Arrays.asList(
			"The amount of sharper uses a tool has after using it on the grindstone."
		));
		configMetaData.put("sharpenedDamageModifier", Arrays.asList(
			"The damage modifier of sharpened tools."
		));
		configMetaData.put("infiniteCreativeUses", Arrays.asList(
			"Whether to decrease sharpened uses in creative."
		));
		configMetaData.put("sendUsesLeftInChat", Arrays.asList(
			"Sends the sharpened tool user a message at 75%, 50%, 25%, 10%."
		));
		configMetaData.put("showUsesLeftInItemName", Arrays.asList(
			"Shows the uses left in the name of the item."
		));
		configMetaData.put("nameUsesPrefix", Arrays.asList(
			"The prefix of the sharpened uses left in the tool name."
		));
		configMetaData.put("nameUsesSuffix", Arrays.asList(
			"The suffix of the sharpened uses left in the tool name."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}