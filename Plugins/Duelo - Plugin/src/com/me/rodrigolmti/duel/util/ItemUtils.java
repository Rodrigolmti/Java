package com.me.rodrigolmti.duel.util;

import org.bukkit.inventory.ItemStack;

import com.me.rodrigolmti.duel.Duel;
import com.me.rodrigolmti.duel.config.Config;

public class ItemUtils {
    Duel plugin;

    public ItemUtils(Duel instance) {
        plugin = instance;
    }

    /**
     * Checks if the item is a duel item.
     *
     * @param item Item to check
     *
     * @return true if the item is a duel item, false otherwise
     */
    public static boolean isDuelWeapon(ItemStack item) {
        return Config.getInstance().getDuelWeaponItems().contains(item.getType());
    }
}
