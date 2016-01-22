package com.me.rodrigolmti.duel.runnables.hooks;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.me.rodrigolmti.duel.datatypes.player.PlayerData;
import com.me.rodrigolmti.duel.locale.LocaleLoader;
import com.me.rodrigolmti.duel.util.RegionUtils;
import com.me.rodrigolmti.duel.util.player.DuelManager;

public class RegionCheckTask extends BukkitRunnable {

    @Override
    public void run() {
        checkRegion();
    }

    public void checkRegion() {
        for (Player player : PlayerData.getDuelingPlayers()) {
            Location location = player.getLocation();

            if (!RegionUtils.canDuelHereWG(location)) {
                player.sendMessage(LocaleLoader.getString("Duel.Cancelled.WorldGuard"));
                DuelManager.endDuelInTie(player);
                return;
            }
        }
    }
}