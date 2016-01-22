package com.me.rodrigolmti.duel.listeners;

import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Tameable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.projectiles.ProjectileSource;

import com.me.rodrigolmti.duel.Duel;
import com.me.rodrigolmti.duel.config.Config;
import com.me.rodrigolmti.duel.datatypes.InteractType;
import com.me.rodrigolmti.duel.datatypes.player.PlayerData;
import com.me.rodrigolmti.duel.locale.LocaleLoader;
import com.me.rodrigolmti.duel.runnables.player.HealPlayerTask;
import com.me.rodrigolmti.duel.util.Misc;
import com.me.rodrigolmti.duel.util.player.ArenaManager;
import com.me.rodrigolmti.duel.util.player.DuelManager;
import com.me.rodrigolmti.duel.util.player.UserManager;

public class EntityListener implements Listener {

    /**
     * Handle EntityDamageEvent events that involve modifying the event.
     *
     * @param event The event to modify
     */
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onEntityDamage(EntityDamageEvent event) {
        if (Config.getInstance().getCallDeathEvents()) {
            return;
        }

        Entity entity = event.getEntity();

        if (Misc.isNPCEntity(entity)) {
            return;
        }

        if (!(entity instanceof Player)) {
            return;
        }

        Player player = (Player) entity;

        if (!PlayerData.isInDuel(player)) {
            return;
        }

        double playerHealth = player.getHealth();
        double damageAmount = event.getFinalDamage();

        if ((playerHealth - damageAmount) > 0) {
            return;
        }

        event.setCancelled(true);
        player.setHealth(1);
        player.teleport(ArenaManager.getArenaLocation(player));
        DuelManager.endDuelResult(PlayerData.getDuelTarget(player), player);
        new HealPlayerTask(player).runTaskLater(Duel.p, 1);
    }
    
    /**
     * Handle EntityDamageByEntityEvent events that involve modifying the event.
     *
     * @param event The event to modify
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamage() <= 0) {
            return;
        }

        Entity attacker = event.getDamager();
        Entity defender = event.getEntity();

        if (Misc.isNPCEntity(attacker) || Misc.isNPCEntity(defender)) {
            return;
        }

        if (attacker instanceof Projectile) {
            ProjectileSource projectileSource = ((Projectile) attacker).getShooter();

            if (projectileSource instanceof LivingEntity) {
                attacker = (LivingEntity) projectileSource;
            }
        }
        else if (attacker instanceof Tameable) {
            AnimalTamer animalTamer = ((Tameable) attacker).getOwner();

            if (animalTamer instanceof Entity) {
                attacker = (Entity) animalTamer;
            }
        }

        if (defender instanceof Player) {
            Player defendingPlayer = (Player) defender;

            if (!defendingPlayer.isOnline()) {
                return;
            }

            if (attacker instanceof Player) {
                Player attackingPlayer = (Player) attacker;
                if (Config.getInstance().getOverridePVP() && PlayerData.areDueling(attackingPlayer, defendingPlayer)) {
                    event.setCancelled(false);
                }
            }
        }
    }

    /**
     * Handle EntityDamageByEntityEvent events that involve modifying the event.
     *
     * @param event The event to modify
     */
    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onEntityDamageByEntityLowest(EntityDamageByEntityEvent event) {
        if (event.getDamage() <= 0) {
            return;
        }

        Entity attacker = event.getDamager();
        Entity defender = event.getEntity();

        if (Misc.isNPCEntity(attacker) || Misc.isNPCEntity(defender)) {
            return;
        }

        if (attacker instanceof Projectile) {
            ProjectileSource projectileSource = ((Projectile) attacker).getShooter();

            if (projectileSource instanceof LivingEntity) {
                attacker = (LivingEntity) projectileSource;
            }
        }
        else if (attacker instanceof Tameable) {
            AnimalTamer animalTamer = ((Tameable) attacker).getOwner();

            if (animalTamer instanceof Entity) {
                attacker = (Entity) animalTamer;
            }
        }

        if (defender instanceof Player) {
            Player defendingPlayer = (Player) defender;

            if (!defendingPlayer.isOnline()) {
                return;
            }

            if (attacker instanceof Player) {
                Player attackingPlayer = (Player) attacker;
                if (PlayerData.areDueling(attackingPlayer, defendingPlayer)) {
                    return;
                }

                if (Config.getInstance().getPreventPVP()) {
                    event.setCancelled(true);
                }

                if (Config.getInstance().getChallengeInteractType() == InteractType.LEFT_CLICK) {
                    if (!DuelManager.canDuel(attackingPlayer) || !DuelManager.canDuel(defendingPlayer, false)) {
                        return;
                    }

                    if (UserManager.getPlayer(defendingPlayer).getOccupied()) {
                        attackingPlayer.sendMessage(LocaleLoader.getString("Duel.Challenge.Occupied", defendingPlayer.getName()));
                        return;
                    }

                    event.setCancelled(true);

                    DuelManager.handleDuelInvites(attackingPlayer, defendingPlayer);
                }
            }
        }
    }

    /**
     * Handle PotionSplashEvent events that involve modifying the event.
     *
     * @param event The event to modify
     */
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPotionSplash(PotionSplashEvent event) {
        ProjectileSource projectileSource = event.getPotion().getShooter();

        if (!(projectileSource instanceof Player)) {
            return;
        }

        Player player = (Player) projectileSource;

        if (Misc.isNPCEntity(player)) {
            return;
        }

        event.getAffectedEntities().stream().filter((entity) -> !(!(entity instanceof Player))).map((entity) -> (Player) entity).filter((target) -> !(player == target)).forEach((target) -> {
            if (PlayerData.isInDuel(target)) {
                if (!PlayerData.areDueling(player, target)) {
                    event.setIntensity(target, 0);
                }
            }
            else if (Config.getInstance().getPreventPVP()) {
                event.setIntensity(target, 0);
            }
        });
    }
}
