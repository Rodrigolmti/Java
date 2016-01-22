package com.me.rodrigolmti.duel.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.logging.Level;

import org.bukkit.Bukkit;

import com.me.rodrigolmti.duel.Duel;

import java.io.IOException;

public class Data {
    static Duel plugin;

    public Data(Duel instance) {
        plugin = instance;
    }

    /*
     * Credits to BlahBerrys
     */

    public static void deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (String children1 : children) {
                deleteDir(new File(dir, children1));
            }
        }
        dir.delete();
    }

    public static void saveData() {
        File f = new File(Duel.p.getDataFolder(), "data.dat");
        try {
            if (!f.exists()) {
                Duel.p.getDataFolder().mkdirs();
                f.createNewFile();
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
                oos.writeObject(DatabaseManager.wins);
                oos.writeObject(DatabaseManager.losses);
                oos.writeObject(DatabaseManager.ties);
                oos.flush();
            }
            Duel.p.getLogger().log(Level.INFO, "Saved data successfully.");
        }
        catch (Exception e) {
            Duel.p.getLogger().log(Level.SEVERE, "Failed to save data.");
        }
    }

    @SuppressWarnings({"unchecked"})
    public static void loadData() {
        File f = new File(Duel.p.getDataFolder(), "data.dat");
        if (f.exists()) {
            try {
                @SuppressWarnings("resource")
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                DatabaseManager.wins = (HashMap<String, Integer>) ois.readObject();
                DatabaseManager.losses = (HashMap<String, Integer>) ois.readObject();
                DatabaseManager.ties = (HashMap<String, Integer>) ois.readObject();
                Duel.p.getLogger().log(Level.INFO, "Loaded data successfully.");
            }
            catch (IOException | ClassNotFoundException e) {
                Duel.p.getLogger().log(Level.SEVERE, "Failed to load data. Disabling the plugin!");
                Bukkit.getServer().getPluginManager().disablePlugin(Duel.p);
            }
        }
    }
}
