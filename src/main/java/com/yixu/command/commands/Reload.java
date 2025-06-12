package com.yixu.command.commands;

import com.yixu.EssentialTool;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static com.yixu.utils.permission.PermissionNodes.MainPREFIX;
import static com.yixu.utils.permission.PermissionsCheck.checkPlayerWithPermission;

public class Reload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String sub = args[0].toLowerCase();

        if (sub.equals("reload") && checkPlayerWithPermission(sender, MainPREFIX + sub)) {
            EssentialTool.getInstance().reloadMessages();
            sender.sendMessage(EssentialTool.getInstance().getMessage("commands.reload.reload-succeed"));
            return true;
        }
        return false;
    }
}
