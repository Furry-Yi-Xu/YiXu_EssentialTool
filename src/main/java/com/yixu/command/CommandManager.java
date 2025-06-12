package com.yixu.command;

import com.yixu.EssentialTool;
import com.yixu.command.commands.ContainerGUI;
import com.yixu.command.commands.Fly;
import com.yixu.command.commands.Reload;
import com.yixu.command.commands.Suicide;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandManager implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            sender.sendMessage(EssentialTool.getInstance().getMessage("commands.command-usage"));
            return true;
        }

        String sub = args[0].toLowerCase();

        switch (sub) {
            case "fly":
                return new Fly().onCommand(sender, command, label, args);
            case "reload":
                return new Reload().onCommand(sender, command, label, args);
            case "suicide":
                return new Suicide().onCommand(sender, command, label, args);
            case "open":
                return new ContainerGUI().onCommand(sender, command, label, args);
            default:
                sender.sendMessage(EssentialTool.getInstance().getMessage("commands.command-usage"));
                return true;
        }
    }
}
