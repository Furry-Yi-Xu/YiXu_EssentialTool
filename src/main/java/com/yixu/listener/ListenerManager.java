package com.yixu.listener;

import com.yixu.listener.listeners.onPlayerDeath;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ListenerManager {

    public ListenerManager(Plugin plugin) {
        PluginManager pluginManager = plugin.getServer().getPluginManager();
        pluginManager.registerEvents(new onPlayerDeath(), plugin);
    }

}
