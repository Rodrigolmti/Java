package com.me.rodrigolmti.duel.runnables.duels;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.me.rodrigolmti.duel.datatypes.player.PlayerData;
import com.me.rodrigolmti.duel.util.player.DuelManager;

public class DuelEndTask extends BukkitRunnable {
    private final Player player;

    public DuelEndTask(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        if (player.isValid() && PlayerData.isInDuel(player)) {
            DuelManager.endDuelInTie(player);
        }
    }
}
