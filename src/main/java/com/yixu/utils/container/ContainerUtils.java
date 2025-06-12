package com.yixu.utils.container;

import com.yixu.EssentialTool;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ContainerUtils {

    public static boolean openContainer(CommandSender sender, String[] args) {

        String container = args[1].toLowerCase();
        Player player = (Player) sender;

        switch(container){
            case "workbench":
                player.openWorkbench(null, true);
                break;
            case "anvil":
                player.openAnvil(null, true);
                break;
            case "enderchest":
                player.openInventory(player.getEnderChest());
                break;
            case "trash":
                String trashTitle = EssentialTool.getInstance().getMessage("commands.trash.trash-title");
                Inventory trashGUI = Bukkit.createInventory(null, 54, trashTitle);
                player.openInventory(trashGUI);
                break;
            default:
                String rawMessage = EssentialTool.getInstance().getMessage("commands.unknown.unknown-container");
                String sendMessage = rawMessage.replace("%container%", container);
                player.sendMessage(sendMessage);
                return false;
        }
        String rawMessage = "commands.%container%.%container%-opened";
        String sendMessage = rawMessage.replace("%container%", container);
        player.sendMessage(EssentialTool.getInstance().getMessage(sendMessage));
        return true;

    }
}
