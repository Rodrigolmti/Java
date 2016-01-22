package com.me.rodrigolmti.duel.runnables.player;

import org.bukkit.scheduler.BukkitRunnable;

import com.me.rodrigolmti.duel.datatypes.player.DuelPlayer;
import com.me.rodrigolmti.duel.datatypes.player.PlayerData;

public class RetrieveLevelsTask extends BukkitRunnable {
    private final DuelPlayer duelPlayer;

    public RetrieveLevelsTask(DuelPlayer duelPlayer) {
        this.duelPlayer = duelPlayer;
    }

    @Override
    public void run() {
        PlayerData.retrieveLevelsAndExp(duelPlayer);
    }
}
