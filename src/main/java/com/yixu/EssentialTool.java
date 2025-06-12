package com.yixu;

import com.yixu.command.CommandManager;
import com.yixu.listener.ListenerManager;
import com.yixu.utils.command.CommandTabCompleter;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class EssentialTool extends JavaPlugin {

    private static EssentialTool instance;
    private FileConfiguration messages;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultMessages();
        reloadMessages();
        getLogger().info("YiXu_EssentialTool 插件已启用！");
        getCommand("yixu-essentialtool").setExecutor(new CommandManager());
        getCommand("yixu-essentialtool").setTabCompleter(new CommandTabCompleter());
        new ListenerManager(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("YiXu_EssentialTool 插件已卸载！");
    }

    public static EssentialTool getInstance() {
        return instance;
    }

    private void saveDefaultMessages() {
        File messageFile = new File(getDataFolder(), "messages.yml");
        if (!messageFile.exists()) {
            saveResource("messages.yml", false);
        }
    }

    public void reloadMessages() {
        File messageFile = new File(getDataFolder(), "messages.yml");
        messages = YamlConfiguration.loadConfiguration(messageFile);
    }

    public String getMessage(String path) {
        if (messages == null) reloadMessages();
        String prefix = messages.getString("prefix");
        String rawMessage = messages.getString(path, "未找到消息: " + path);
        String sendMessage = rawMessage.replace("%prefix%", prefix);
        return ChatColor.translateAlternateColorCodes('&', sendMessage);
    }
}
