package com.me.rodrigolmti.duel.datatypes.player;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.me.rodrigolmti.duel.Duel;
import com.me.rodrigolmti.duel.config.Config;
import com.me.rodrigolmti.duel.datatypes.DuelInvitationKey;
import com.me.rodrigolmti.duel.datatypes.InteractType;
import com.me.rodrigolmti.duel.datatypes.LevelAndExpKey;
import com.me.rodrigolmti.duel.locale.LocaleLoader;
import com.me.rodrigolmti.duel.util.CommandUtils;
import com.me.rodrigolmti.duel.util.Misc;
import com.me.rodrigolmti.duel.util.player.UserManager;

public class PlayerData {

    public void setDuel(Player player, Player target) {
        UserManager.getPlayer(player).setTargetName(target.getName());
        UserManager.getPlayer(target).setTargetName(player.getName());
    }

    public static Player getDuelTarget(Player player) {
        String targetName = UserManager.getPlayer(player).getTargetName();

        if (targetName != null) {
            return Duel.p.getServer().getPlayer(targetName);
        }

        return null;
    }

    public static boolean removeDuelTarget(Player player) {
        DuelPlayer duelPlayer = UserManager.getPlayer(player);

        if (duelPlayer.getTargetName() != null) {
            duelPlayer.setTargetName(null);
            return true;
        }
        return false;
    }

    public static boolean isInDuel(Player player) {
        return UserManager.getPlayer(player).getTargetName() != null;
    }

    public static boolean areDueling(Player player, Player target) {
        if (player == null || target == null) {
            return false;
        }

        DuelPlayer duelPlayer = UserManager.getPlayer(player);
        DuelPlayer duelTarget = UserManager.getPlayer(target);

        String playerTargetName = duelPlayer.getTargetName();
        String targetTargetName = duelTarget.getTargetName();

        if (playerTargetName == null || targetTargetName == null) {
            return false;
        }

        return playerTargetName.equals(target.getName()) && targetTargetName.equals(player.getName());
    }

    public String getDuelInvite(DuelPlayer duelPlayer) {
        if (duelPlayer.getDuelInvite() != null) {
            return duelPlayer.getDuelInvite().getPlayerName();
        }
        else {
            return null;
        }
    }

    public boolean duelInviteIsTimedout(DuelPlayer duelPlayer) {
        DuelInvitationKey key = duelPlayer.getDuelInvite();
        return key.getTimestamp() + Config.getInstance().getInviteTimeout() < Misc.getSystemTime();
    }

    public void removeDuelInvite(DuelPlayer duelPlayer) {
        duelPlayer.setDuelInvitationKey(null);
    }

    /**
     * Handle duel challenging
     *
     * @param duelPlayer the {@link DuelPlayer} object of the challenger
     * @param duelTarget the {@link DuelPlayer} object of the challenged player
     */
    public void challenge(DuelPlayer duelPlayer, DuelPlayer duelTarget) {
        Player player = duelPlayer.getPlayer();
        String name = player.getName();

        duelPlayer.actualizeLastChallengeSend();

        if (!Misc.cooldownExpired(duelTarget.getLastChallengeReceived(), 3)) {
            return;
        }

        Player target = duelTarget.getPlayer();

        if (hasBeenChallenged(duelTarget, name) && !duelInviteIsTimedout(duelTarget)) {
            player.sendMessage(LocaleLoader.getString("Duel.Challenge.Already_Send", target.getName()));
            return;
        }

        duelTarget.actualizeLastChallengeReceived();
        player.sendMessage(LocaleLoader.getString("Duel.Challenge.Send", target.getName()));
        duelTarget.setDuelInvitationKey(new DuelInvitationKey(name));

        target.sendMessage(LocaleLoader.getString("Duel.Challenge.Receive.1", name));

        if (Config.getInstance().getChallengeInteractType() != InteractType.OFF) {
            target.sendMessage(LocaleLoader.getString("Duel.Challenge.Receive.2", CommandUtils.getControls(true), name));
        }
        else if (Config.getInstance().getChallengeCommandsEnabled()) {
            target.sendMessage(LocaleLoader.getString("Duel.Challenge.Receive.3", name));
        }
    }

    private boolean hasBeenChallenged(DuelPlayer duelTarget, String name) {
        return getDuelInvite(duelTarget) != null && getDuelInvite(duelTarget).equals(name);
    }

    public void removeDuelInvitation(DuelPlayer duelPlayer) {
        duelPlayer.setDuelInvitationKey(null);
    }

    public static List<Player> getDuelingPlayers() {
        Iterable<DuelPlayer> duelPlayers = UserManager.getPlayers();
        List<Player> duelingPlayers = new ArrayList<>();

        for (DuelPlayer duelPlayer : duelPlayers) {
            if (duelPlayer.getTargetName() != null) {
                duelingPlayers.add(duelPlayer.getPlayer());
            }
        }
        return duelingPlayers;
    }

    public static void storeInventory(DuelPlayer duelPlayer, List<ItemStack> items) {
        duelPlayer.setSavedInventoryItems(items);
    }

    public static List<ItemStack> retrieveInventory(DuelPlayer duelPlayer) {
        return duelPlayer.getSavedInventoryItems();
    }

    public static void storeArmor(DuelPlayer duelPlayer, List<ItemStack> items) {
        duelPlayer.setSavedInventoryArmor(items);
    }

    public static List<ItemStack> retrieveArmor(DuelPlayer duelPlayer) {
        return duelPlayer.getSavedInventoryArmor();
    }

    public static void storeLevelsAndExp(DuelPlayer duelPlayer) {
        Player player = duelPlayer.getPlayer();
        duelPlayer.setSavedLevel(new LevelAndExpKey(player.getLevel(), player.getExp()));
    }

    public static boolean retrieveLevelsAndExp(DuelPlayer duelPlayer) {
        Player player = duelPlayer.getPlayer();

        LevelAndExpKey key = duelPlayer.getSavedLevel();

        if (key == null) {
            return false;
        }

        player.setLevel(key.getLevel());
        player.setExp(key.getExp());
        return true;
    }
}
