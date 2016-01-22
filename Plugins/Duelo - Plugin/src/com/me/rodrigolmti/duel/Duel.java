package com.me.rodrigolmti.duel;

import java.io.File;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import com.me.rodrigolmti.duel.commands.DuelCommand;
import com.me.rodrigolmti.duel.config.Config;
import com.me.rodrigolmti.duel.config.HiddenConfig;
import com.me.rodrigolmti.duel.database.Data;
import com.me.rodrigolmti.duel.hooks.WorldGuardListener;
import com.me.rodrigolmti.duel.listeners.EntityListener;
import com.me.rodrigolmti.duel.listeners.PlayerListener;
import com.me.rodrigolmti.duel.runnables.duels.DuelRangeTask;
import com.me.rodrigolmti.duel.runnables.hooks.RegionCheckTask;
import com.me.rodrigolmti.duel.util.LogFilter;
import com.me.rodrigolmti.duel.util.Misc;
import com.me.rodrigolmti.duel.util.player.UserManager;
import com.google.common.collect.ImmutableList;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import java.util.logging.Level;

public class Duel extends JavaPlugin {
    public static Duel p;

    public static File duel;

    private boolean worldGuardEnabled = false;

    public boolean noErrorsInConfigFiles = true;

    /**
     * Run things on enable.
     */
    @Override
    public void onEnable() {
        p = this;
        getLogger().setFilter(new LogFilter(this));

        Config.getInstance();
        HiddenConfig.getInstance();

        if (!noErrorsInConfigFiles) {
            return;
        }

        registerEvents();

        setupWorldGuard();

        setupFilePaths();
        
        if (HiddenConfig.getInstance().isCommandEnabled()) {
            getCommand("duel").setExecutor(new DuelCommand());
        }

        Data.loadData();

        for (Player player : ImmutableList.copyOf(Duel.p.getServer().getOnlinePlayers())) {
            UserManager.addUser(player); // In case of reload add all users back into UserManager
        }

        ImmutableList.copyOf(Duel.p.getServer().getOnlinePlayers()).stream().forEach((player) -> {
            UserManager.addUser(player); // In case of reload add all users back into UserManager
        });

        scheduleTasks();
    }

    /**
     * Registers all event listeners
     */
    private void registerEvents() {
        PluginManager pluginManager = getServer().getPluginManager();

        // Register events
        pluginManager.registerEvents(new PlayerListener(), this);
        pluginManager.registerEvents(new EntityListener(), this);
    }

    public void debug(String message) {
        getLogger().log(Level.INFO, "[Debug] {0}", message);
    }

    private void setupWorldGuard() {
        if (getServer().getPluginManager().isPluginEnabled("WorldGuard")) {
            worldGuardEnabled = true;
            debug("Hooked into WorldGuard successfully!");
            getServer().getPluginManager().registerEvents(new WorldGuardListener(), this);
        }
    }

    public WorldGuardPlugin getWorldGuard() {
        Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");

        if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
            return null;
        }

        return (WorldGuardPlugin) plugin;
    }

    /**
     * Run things on disable.
     */
    @Override
    public void onDisable() {
        Data.saveData();
        this.getServer().getScheduler().cancelTasks(this);
    }

    /**
     * Setup the various storage file paths
     */
    private void setupFilePaths() {
        duel = getFile();
    }

    private void scheduleTasks() {
        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new DuelRangeTask(), 0, 2 * Misc.TICK_CONVERSION_FACTOR);

        //Region check timer (Runs every five seconds)
        new RegionCheckTask().runTaskTimer(this, 5 * Misc.TICK_CONVERSION_FACTOR, 5 * Misc.TICK_CONVERSION_FACTOR);
    }

    public boolean isWorldGuardEnabled() {
        return worldGuardEnabled;
    }
}