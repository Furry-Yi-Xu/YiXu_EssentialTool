package com.yixu.command.commands;

import com.yixu.EssentialTool;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.yixu.utils.permission.PermissionNodes.MainPREFIX;
import static com.yixu.utils.permission.PermissionsCheck.checkPlayerWithPermission;

public class Suicide implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String sub = args[0].toLowerCase();

        if (sub.equals("suicide") && checkPlayerWithPermission(sender, MainPREFIX + sub)) {
            Player player = (Player) sender;
            player.setHealth(0.0);
            sender.sendMessage(EssentialTool.getInstance().getMessage("commands.suicide.suicide-succeed"));
            return true;
        }
        return false;
    }
}
