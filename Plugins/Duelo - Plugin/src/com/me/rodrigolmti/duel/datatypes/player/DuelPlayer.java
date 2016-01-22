package com.me.rodrigolmti.duel.datatypes.player;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;

import com.me.rodrigolmti.duel.datatypes.DuelInvitationKey;
import com.me.rodrigolmti.duel.datatypes.LevelAndExpKey;
import com.me.rodrigolmti.duel.util.Misc;

public class DuelPlayer {
    private Player player;

    private Location arena;
    private String targetName;
    private boolean occupied;
    private int lastChallengeSend;
    private int lastChallengeReceived;
    private DuelInvitationKey duelInvitationKey;
    private BukkitTask duelEndTask;
    private List<ItemStack> savedInventoryItems;
    private List<ItemStack> savedInventoryArmor;
    private LevelAndExpKey savedLevel;
    private boolean duelRespawn;

    public DuelPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    // Occupied
    public boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.occupied = isOccupied;
    }

    // Respawn
    public boolean getDuelRespawn() {
        return duelRespawn;
    }

    public void setDuelRespawn(boolean modifyNextRespawn) {
        this.duelRespawn = modifyNextRespawn;
    }

    public DuelInvitationKey getDuelInvite() {
        return duelInvitationKey;
    }

    public void setDuelInvitationKey(DuelInvitationKey duelInvitationKey) {
        this.duelInvitationKey = duelInvitationKey;
    }

    public BukkitTask getDuelEndTask() {
        return duelEndTask;
    }

    public void setDuelEndTask(BukkitTask duelEndTask) {
        this.duelEndTask = duelEndTask;
    }

    public List<ItemStack> getSavedInventoryItems() {
        return savedInventoryItems;
    }

    public void setSavedInventoryItems(List<ItemStack> savedInventoryItems) {
        this.savedInventoryItems = savedInventoryItems;
    }

    public List<ItemStack> getSavedInventoryArmor() {
        return savedInventoryArmor;
    }

    public void setSavedInventoryArmor(List<ItemStack> savedInventoryArmor) {
        this.savedInventoryArmor = savedInventoryArmor;
    }

    public LevelAndExpKey getSavedLevel() {
        return savedLevel;
    }

    public void setSavedLevel(LevelAndExpKey savedLevel) {
        this.savedLevel = savedLevel;
    }

    public Location getArena() {
        return arena;
    }

    public void setArena(Location arena) {
        this.arena = arena;
    }

    public int getLastChallengeSend() {
        return lastChallengeSend;
    }

    public void setLastChallengeSend(int lastChallengeSend) {
        this.lastChallengeSend = lastChallengeSend;
    }

    public void actualizeLastChallengeSend() {
        setLastChallengeSend(Misc.getSystemTime());
    }

    public int getLastChallengeReceived() {
        return lastChallengeReceived;
    }

    public void setLastChallengeReceived(int lastChallengeReceived) {
        this.lastChallengeReceived = lastChallengeReceived;
    }

    public void actualizeLastChallengeReceived() {
        setLastChallengeReceived(Misc.getSystemTime());
    }
}
