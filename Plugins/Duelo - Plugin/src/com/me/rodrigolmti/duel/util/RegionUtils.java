package com.me.rodrigolmti.duel.util;

import java.util.LinkedList;

import org.bukkit.Location;
import org.bukkit.World;

import com.me.rodrigolmti.duel.Duel;
import com.me.rodrigolmti.duel.config.Config;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;


public class RegionUtils {

    public static boolean canDuelHere(Location location) {
        return canDuelHere(location.getWorld()) && (Duel.p.isWorldGuardEnabled() && canDuelHere(getRegion(location)));
    }

    public static boolean canDuelHereWG(Location location) {
        return Duel.p.isWorldGuardEnabled() && canDuelHere(getRegion(location));
    }

    public static boolean canDuelHere(World world) {
        boolean isWhitelist = Config.getInstance().getWorldUseAsWhitelist();

        if (Config.getInstance().getWorldList().contains(world.getName())) {
            return isWhitelist;
        }

        return !isWhitelist;
    }

    private static boolean canDuelHere(String region) {
        boolean isWhitelist = Config.getInstance().getWGUseAsWhitelist();

        if (isListedRegion(region)) {
            return isWhitelist;
        }

        return !isWhitelist;
    }

    private static boolean isListedRegion(String region) {
        return Config.getInstance().getWGRegionList().stream().anyMatch((name) -> (region.equalsIgnoreCase("[" + name + "]")));
    }

    private static String getRegion(Location location) {
        RegionManager regionManager = Duel.p.getWorldGuard().getRegionManager(location.getWorld());
        ApplicableRegionSet set = regionManager.getApplicableRegions(location);
        LinkedList<String> parentNames = new LinkedList<>();
        LinkedList<String> regions = new LinkedList<>();

        for (ProtectedRegion region : set) {
            String id = region.getId();
            regions.add(id);
            ProtectedRegion parent = region.getParent();
            while (parent != null) {
                parentNames.add(parent.getId());
                parent = parent.getParent();
            }
        }

        parentNames.stream().forEach((name) -> {
            regions.remove(name);
        });

        return regions.toString();
    }
}