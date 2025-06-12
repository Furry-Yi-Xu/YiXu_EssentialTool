package com.yixu.command.commands;

import com.yixu.utils.container.ContainerUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static com.yixu.utils.permission.PermissionNodes.ContainerPREFIX;
import static com.yixu.utils.permission.PermissionsCheck.checkPlayerWithPermission;

public class ContainerGUI implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String Sub = args[0].toLowerCase();

        if (Sub.equals("open") && checkPlayerWithPermission(sender, ContainerPREFIX + Sub)) {
            ContainerUtils.openContainer(sender, args);
            return true;
        }
        return false;
    }
}
