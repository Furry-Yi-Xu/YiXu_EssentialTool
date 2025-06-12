package com.yixu.listener.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static com.yixu.utils.permission.PermissionNodes.MainPREFIX;
import static com.yixu.utils.permission.PermissionsCheck.checkPlayerWithPermission;

public class onPlayerDeath implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        if(checkPlayerWithPermission(event.getPlayer(), MainPREFIX + "keepinventory")){
            event.setKeepInventory(true);
            event.setKeepLevel(true);
            event.getDrops().clear();
            event.setDroppedExp(0);
        }

    }

}