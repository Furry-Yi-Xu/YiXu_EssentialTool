package com.yixu.command.commands;

import com.yixu.EssentialTool;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.yixu.utils.permission.PermissionNodes.MainPREFIX;
import static com.yixu.utils.permission.PermissionsCheck.checkPlayerWithPermission;

public class Fly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String sub = args[0].toLowerCase();

        if (sub.equals("fly") && checkPlayerWithPermission(sender, MainPREFIX + sub)) {
            Player player = (Player) sender;
            boolean canFly = player.getAllowFlight();
            player.setAllowFlight(!canFly);
            player.setFlying(!canFly);
            String key = canFly ? "commands.fly.fly-disabled" : "commands.fly.fly-enabled";
            player.sendMessage(EssentialTool.getInstance().getMessage(key));
            return true;
        }
        return false;
    }
}