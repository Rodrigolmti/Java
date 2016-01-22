package com.me.rodrigolmti.duel.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;

import com.me.rodrigolmti.duel.Duel;
import com.me.rodrigolmti.duel.config.Config;
import com.me.rodrigolmti.duel.datatypes.InteractType;
import com.me.rodrigolmti.duel.datatypes.player.DuelPlayer;
import com.me.rodrigolmti.duel.datatypes.player.PlayerData;
import com.me.rodrigolmti.duel.locale.LocaleLoader;
import com.me.rodrigolmti.duel.runnables.player.RetrieveLevelsTask;
import com.me.rodrigolmti.duel.util.Misc;
import com.me.rodrigolmti.duel.util.player.ArenaManager;
import com.me.rodrigolmti.duel.util.player.DuelManager;
import com.me.rodrigolmti.duel.util.player.UserManager;

public class PlayerListener implements Listener {

    /**
     * Monitor PlayerInteractEntityEvent events.
     *
     * @param event The event to watch
     */
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEntityEvent event) {
        if (Config.getInstance().getChallengeInteractType() != InteractType.RIGHT_CLICK) {
            return;
        }

        Player player = event.getPlayer();
        Entity entity = event.getRightClicked();

        if (Misc.isNPCEntity(player) || Misc.isNPCEntity(entity)) {
            return;
        }

        if (entity instanceof Player) {
            Player target = (Player) entity;

            if (!DuelManager.canDuel(player) || !DuelManager.canDuel(target, false)) {
                return;
            }

            if (UserManager.getPlayer(target).getOccupied()) {
                player.sendMessage(LocaleLoader.getString("Duel.Challenge.Occupied", target.getName()));
                return;
            }

            event.setCancelled(true);

            DuelManager.handleDuelInvites(player, target);
        }
    }

    /**
     * Monitor PlayerJoin events.
     *
     * @param event The event to watch
     */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    private void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (Misc.isNPCEntity(player)) {
            return;
        }

        DuelPlayer duelPlayer = UserManager.addUser(player);
        duelPlayer.setOccupied(false);
    }

    /**
     * Check PlayerTeleportEvent events.
     *
     * @param event The event to check
     */
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        Player player = event.getPlayer();

        if (Misc.isNPCEntity(player)) {
            return;
        }

        if (!PlayerData.isInDuel(player)) {
            return;
        }

        Location targetLocation = event.getTo();
        Location arenaCenter = ArenaManager.getArenaLocation(player);

        if (!Misc.isNear(targetLocation, arenaCenter, Config.getInstance().getArenaSize())) {
            event.setCancelled(true);
        }
    }

    /**
     * Check PlayerQuitEvent events.
     *
     * @param event The event to check
     */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (Misc.isNPCEntity(player)) {
            return;
        }

        if (PlayerData.isInDuel(player)) {
            Player target = PlayerData.getDuelTarget(player);

            DuelManager.endDuelResult(target, player);
        }

        if (UserManager.getPlayer(player).getDuelRespawn()) {
            ArenaManager.deleteArena(player);
        }
    }

    /**
     * Check PlayerRespawnEvent events.
     *
     * @param event The event to check
     */
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    private void onPlayerRespawn(PlayerRespawnEvent event) {
        if (!Config.getInstance().getCallDeathEvents()) {
            return;
        }

        Player player = event.getPlayer();

        if (Misc.isNPCEntity(player)) {
            return;
        }

        Location arenaCenter = ArenaManager.getArenaLocation(player);

        DuelPlayer duelPlayer = UserManager.getPlayer(player);

        if (!duelPlayer.getDuelRespawn() || arenaCenter == null) {
            return;
        }

        event.setRespawnLocation(arenaCenter);
        duelPlayer.setDuelRespawn(false);
        ArenaManager.deleteArena(player);

        if (Config.getInstance().getSaveInventory()) {
            List<ItemStack> armorList = PlayerData.retrieveArmor(duelPlayer);
            ItemStack[] armor = armorList.toArray(new ItemStack[armorList.size()]);
            player.getInventory().setArmorContents(armor);

            List<ItemStack> items = new ArrayList<>();
            items = PlayerData.retrieveInventory(duelPlayer);
            if (items != null) {
                for (ItemStack item : items) {
                    player.getInventory().addItem(item);
                }
            }
            new RetrieveLevelsTask(duelPlayer).runTaskLater(Duel.p, 1);

            player.updateInventory();
        }
    }

    /**
     * Check PlayerDeathEvent events.
     *
     * @param event The event to check
     */
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerDeathEvent(PlayerDeathEvent event) {
        if (!Config.getInstance().getCallDeathEvents()) {
            return;
        }

        Player player = event.getEntity();

        if (Misc.isNPCEntity(player)) {
            return;
        }

        if (!PlayerData.isInDuel(player)) {
            return;
        }

        DuelPlayer duelPlayer = UserManager.getPlayer(player);
        duelPlayer.setDuelRespawn(true);

        if (Config.getInstance().getSaveInventory()) {
            List<ItemStack> armorItems = new ArrayList<>();
            for (ItemStack armor : player.getInventory().getArmorContents()) {
                if (armor != null) {
                    armorItems.add(armor);
                }
            }

            List<ItemStack> items = new ArrayList<>();
            for (ItemStack item : player.getInventory().getContents()) {
                if (item != null) {
                    items.add(item);
                }
            }

            PlayerData.storeArmor(duelPlayer, armorItems);
            PlayerData.storeInventory(duelPlayer, items);
            PlayerData.storeLevelsAndExp(duelPlayer);

            event.getDrops().clear();
            event.setDroppedExp(0);
        }

        DuelManager.endDuelResult(PlayerData.getDuelTarget(player), player);
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();

        if (!PlayerData.isInDuel(player)) {
            return;
        }

        if (Config.getInstance().getBlockedCommands().contains(event.getMessage())) {
            player.sendMessage(LocaleLoader.getString("Duel.Command.Blocked", event.getMessage()));
            event.setCancelled(true);
        }
    }
}
