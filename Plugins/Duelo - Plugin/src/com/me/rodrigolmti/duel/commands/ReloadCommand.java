package com.me.rodrigolmti.duel.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.me.rodrigolmti.duel.Duel;
import com.me.rodrigolmti.duel.locale.LocaleLoader;

public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Duel.p.reloadConfig();
        sender.sendMessage(LocaleLoader.getString("Commands.Reload.Success"));
        return true;
    }
}
