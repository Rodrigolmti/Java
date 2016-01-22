package com.me.rodrigolmti.duel.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.me.rodrigolmti.duel.Duel;
import com.me.rodrigolmti.duel.datatypes.player.PlayerData;
import com.me.rodrigolmti.duel.locale.LocaleLoader;
import com.me.rodrigolmti.duel.util.CommandUtils;
import com.me.rodrigolmti.duel.util.Misc;
import com.me.rodrigolmti.duel.util.player.DuelManager;
import com.me.rodrigolmti.duel.util.player.UserManager;

public class ChallengeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (CommandUtils.noConsoleUsage(sender)) {
            return true;
        }

        switch (args.length) {
            case 2:
                Player player = (Player) sender;
                Player target = Duel.p.getServer().getPlayer(Misc.getMatchedPlayerName(args[1]));

                if (CommandUtils.isOffline(player, target)) {
                    return true;
                }

                if (player == target) {
                    sender.sendMessage(LocaleLoader.getString("Duel.Challenge.Self"));
                    return true;
                }

                if (!DuelManager.canDuel(player, false)) {
                    return true;
                }

                if (UserManager.getPlayer(target).getOccupied()) {
                    player.sendMessage(LocaleLoader.getString("Duel.Challenge.Occupied", target.getName()));
                    return true;
                }

                if (CommandUtils.tooFar(player, target, 5)) {
                    return true;
                }

                if (PlayerData.isInDuel(player) || PlayerData.isInDuel(target)) {
                    sender.sendMessage(LocaleLoader.getString("Duel.Invite.Occupied"));
                    return true;
                }

                DuelManager.handleDuelInvites(player, target);
                return true;

            default:
                sender.sendMessage(LocaleLoader.getString("Commands.Usage.2", "duel", "challenge", "<player>"));
                return true;
        }
    }
}
