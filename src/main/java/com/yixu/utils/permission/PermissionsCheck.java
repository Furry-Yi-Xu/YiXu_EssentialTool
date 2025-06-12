package com.yixu.utils.permission;

import com.yixu.EssentialTool;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PermissionsCheck {

    /**
     * 检查命令是否由玩家执行，否则发送提示。
     * @param sender 发送者
     * @return true 如果是玩家；false 否则
     */
    public static boolean checkIsPlayer(CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(EssentialTool.getInstance().getMessage("only-player"));
            return false;
        }
        return true;
    }

    /**
     * 检查执行者是否有权限，否则发送提示。
     * @param sender 执行者
     * @param permission 权限节点
     * @return true 如果有权限；false 否则
     */
    public static boolean checkPermission(CommandSender sender, String permission) {
        if (!sender.hasPermission(permission)) {
            sender.sendMessage(EssentialTool.getInstance().getMessage("no-permission"));
            return false;
        }
        return true;
    }

    /**
     * 综合方法：先检测是否玩家，再检测权限。
     * @param sender 发送者
     * @param permission 权限节点
     * @return true 如果是玩家且有权限；false 否则
     */
    public static boolean checkPlayerWithPermission(CommandSender sender, String permission) {
        return checkIsPlayer(sender) && checkPermission(sender, permission);
    }
}
