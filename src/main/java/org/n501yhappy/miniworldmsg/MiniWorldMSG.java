package org.n501yhappy.miniworldmsg;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.n501yhappy.miniworldmsg.Listeners.PlayerJoin;

import static org.n501yhappy.miniworldmsg.messages.kick;
import static org.n501yhappy.miniworldmsg.messages.server_stop;

public final class MiniWorldMSG extends JavaPlugin {
    public static MiniWorldMSG miniWorldMSG;

    @Override
    public void onEnable() {
        miniWorldMSG = this;
        messages.full_list();
        getServer().getPluginManager().registerEvents(new PlayerJoin() ,this);
        getLogger().info("迷你世界Plugin 启动");
        getLogger().info(String.valueOf(kick.size()));
        getLogger().info(String.valueOf(server_stop.size()));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
