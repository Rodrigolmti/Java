package com.me.rodrigolmti.duel.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.me.rodrigolmti.duel.Duel;

import java.util.logging.Level;

public abstract class ConfigLoader {
    protected static final Duel plugin = Duel.p;
    protected String fileName;
    protected File configFile;
    protected FileConfiguration config;

    public ConfigLoader(String relativePath, String fileName) {
        this.fileName = fileName;
        configFile = new File(plugin.getDataFolder(), relativePath + File.separator + fileName);
        loadFile();
    }

    public ConfigLoader(String fileName) {
        this.fileName = fileName;
        configFile = new File(plugin.getDataFolder(), fileName);
        loadFile();
    }

    protected void loadFile() {
        if (!configFile.exists()) {
            plugin.debug("Creating Duel " + fileName + " File...");
            createFile();
        }
        else {
            plugin.debug("Loading Duel " + fileName + " File...");
        }

        config = YamlConfiguration.loadConfiguration(configFile);
    }

    protected abstract void loadKeys();

    protected void createFile() {
        configFile.getParentFile().mkdirs();

        InputStream inputStream = plugin.getResource(fileName);

        if (inputStream == null) {
            plugin.getLogger().log(Level.SEVERE, "Missing resource file: ''{0}'' please notify the plugin authors", fileName);
            return;
        }

        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(configFile);

            int read;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }
        catch (FileNotFoundException e) {
        }
        catch (IOException e) {
        }
        finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                }
                catch (IOException e) {
                }
            }

            try {
                inputStream.close();
            }
            catch (IOException e) {
            }
        }
    }

    protected boolean validateKeys() {
        return true;
    }

    protected boolean noErrorsInConfig(List<String> issues) {
        issues.stream().forEach((issue) -> {
            plugin.getLogger().warning(issue);
        });

        return issues.isEmpty();
    }

    protected void validate() {
        if (validateKeys()) {
            plugin.debug("No errors found in " + fileName + "!");
        }
        else {
            plugin.getLogger().log(Level.WARNING, "Errors were found in {0}! Duel was disabled!", fileName);
            plugin.getServer().getPluginManager().disablePlugin(plugin);
            plugin.noErrorsInConfigFiles = false;
        }
    }
}
