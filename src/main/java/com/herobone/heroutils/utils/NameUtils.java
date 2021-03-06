package com.herobone.heroutils.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public interface NameUtils {
	public static void setNames(Object obj, String name) {
		if (obj instanceof Item) {
			((Item)obj).setRegistryName(name).setUnlocalizedName(name);
		} else if (obj instanceof Block) {
			((Block)obj).setRegistryName(name).setUnlocalizedName(name);
		} else {
			throw new IllegalArgumentException();
		}
	}
}
