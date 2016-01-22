package com.me.rodrigolmti.duel.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.me.rodrigolmti.duel.Duel;
import com.me.rodrigolmti.duel.config.Config;
import com.me.rodrigolmti.duel.locale.LocaleLoader;

public class DuelCommand implements CommandExecutor {
    private CommandSender sender;

    private CommandExecutor reloadCommand = new ReloadCommand();
    private CommandExecutor helpCommand = new HelpCommand();
    private CommandExecutor statsCommand = new StatsCommand();
    private CommandExecutor challengeCommand = new ChallengeCommand();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        this.sender = sender;

        if (args.length < 1) {
            return printUsage();
        }

        DuelSubcommandType subcommand = DuelSubcommandType.getSubcommand(args[0]);

        if (subcommand == null) {
            return printUsage();
        }

        switch (subcommand) {
            case RELOAD:
                return reloadCommand.onCommand(sender, command, label, args);
            case HELP:
                return helpCommand.onCommand(sender, command, label, args);
            case STATS:
                return statsCommand.onCommand(sender, command, label, args);
            case CHALLENGE:
                if (Config.getInstance().getChallengeCommandsEnabled()) {
                    return challengeCommand.onCommand(sender, command, label, args);
                }
            default:
                break;
        }

        return true;
    }

    private boolean printUsage() {
        sender.sendMessage(LocaleLoader.getString("General.Plugin.Header", Duel.p.getDescription().getName(), Duel.p.getDescription().getAuthors()));
        sender.sendMessage(LocaleLoader.getString("General.Plugin.Authors", Duel.p.getDescription().getAuthors()));
        sender.sendMessage(LocaleLoader.getString("General.Running_Version", Duel.p.getDescription().getVersion()));
        sender.sendMessage(LocaleLoader.getString("General.Use_Help"));
        return true;
    }
}
