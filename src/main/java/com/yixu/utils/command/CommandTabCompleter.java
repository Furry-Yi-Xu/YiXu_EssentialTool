package com.yixu.utils.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandTabCompleter implements TabCompleter {

    private final List<String> subCommands = Arrays.asList("fly", "reload", "suicide", "open");

    private final List<String> openCommands = Arrays.asList("workbench", "anvil", "enderchest", "trash");

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            String start = args[0].toLowerCase();
            for (String cmd : subCommands) {
                if (cmd.startsWith(start)) {
                    completions.add(cmd);
                }
            }
            return completions;
        }

        if (args[0].equalsIgnoreCase("open")) {
            String start = args[1].toLowerCase();
            for (String cmd : openCommands) {
                if (cmd.startsWith(start)) {
                    completions.add(cmd);
                }
            }
            return completions;
        }

        return completions;
    }
}
