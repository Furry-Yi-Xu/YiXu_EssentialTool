package com.yixu.listener.listeners;

import com.yixu.EssentialTool;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class onTrashClose implements Listener {

    @EventHandler
    public void onTrashClose(InventoryCloseEvent event) {
        if (!(event.getPlayer() instanceof Player)) return;

        Inventory inventory = event.getInventory();
        String title = event.getView().getTitle();
        String trashTitle = EssentialTool.getInstance().getMessage("commands.trash.trash-title");

        if (title.equals(trashTitle)) {
            inventory.clear();
        }
    }
}
