package me.tiger.spamshield.command;

import me.tiger.spamshield.SpamShield;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ToggleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.isOp()) {
            sender.sendMessage("§cOnly OPs can use this command!");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage("§cUsage: /spamshield <enable|disable>");
            return true;
        }

        if (args[0].equalsIgnoreCase("enable")) {
            SpamShield.getInstance().setEnabledFilter(true);
            sender.sendMessage("§aSpamShield enabled!");
            return true;
        }

        if (args[0].equalsIgnoreCase("disable")) {
            SpamShield.getInstance().setEnabledFilter(false);
            sender.sendMessage("§cSpamShield disabled!");
            return true;
        }

        return true;
    }
}
