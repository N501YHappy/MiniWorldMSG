package org.n501yhappy.miniworldmsg.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.n501yhappy.miniworldmsg.MiniWorldMSG;
import org.n501yhappy.miniworldmsg.RandomGetList;

import java.util.ArrayList;
import java.util.List;

import static org.n501yhappy.miniworldmsg.messages.kick;
import static org.n501yhappy.miniworldmsg.messages.server_stop;

public class PlayerJoin implements Listener {
    public List<Player> loading = new ArrayList<>();
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage("§6" + event.getPlayer().getName() + "§2进入了房间");
        event.getPlayer().sendMessage("温馨提示：共同维护健康游戏环境，请勿模仿游戏内任何虚拟行为，当发现虚假信息、不良信息时，可向官方举报！");
        event.getPlayer().sendMessage("§严禁制作色情、政治、暴力等内容，违者将依法追究法律责任");
        loading.add(event.getPlayer());
        Bukkit.getScheduler().runTaskLater(MiniWorldMSG.miniWorldMSG, new Runnable() {
            int countdown = 3;

            public void run() {
                if (countdown > 0) {
                    event.getPlayer().sendTitle("" + countdown, "", 10, 20, 10);
                    countdown--;
                } else {
                    loading.remove(event.getPlayer());
                }
            }
        }, 20L); // 延迟1秒钟开始倒计时
        loading.remove(event.getPlayer());
    }
    @EventHandler
    public void onPlayerLeft(PlayerQuitEvent event){
        event.setQuitMessage("§6" + event.getPlayer().getName() + "§c离开了房间");
    }
    @EventHandler
    public void PlayerMove(PlayerMoveEvent event){
        if (loading.contains(event.getPlayer())){
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void Kick(PlayerKickEvent event){
        event.setReason(RandomGetList.get(kick));
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            player.sendMessage("§c房主把§r" + event.getPlayer().getName() + "§c踢出了房间");
        }
    }
    @EventHandler
    public void onServerShutdown(ServerCommandEvent event) {
        String command = event.getCommand();
        if (command.equalsIgnoreCase("stop")) {
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                player.kickPlayer(RandomGetList.get(server_stop));
            }
        }
    }
}
