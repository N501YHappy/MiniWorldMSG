package org.n501yhappy.miniworldmsg;

import com.destroystokyo.paper.Title;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class KillstreaksSystem extends JavaPlugin implements Listener {
    public static List<Player> kill;
    public static List<Player> double_kill;
    public static List<Player> triple_kill;
    public static List<Player> quadra_kill;
    public static List<Player> penta_kill;
    public static List<Player> lengendary;

    @EventHandler
    public void onPlayerDeath(EntityDeathEvent event) {
        if (event.getEntity() instanceof Player) {
            Player victim = (Player) event.getEntity();
            if (kill.contains(victim)){

            } else if (double_kill.contains(victim)) {

            } else if (triple_kill.contains(victim)) {

            } else if (quadra_kill.contains(victim)) {

            } else if (penta_kill.contains(victim)) {

            } else if (lengendary.contains(victim)) {

            }
            if (victim.getKiller() instanceof Player) {
                Player killer = victim.getKiller();
                if (lengendary.contains(killer)){
                    quadra_kill.remove(killer);
                    lengendary.add(killer);
                }else if (penta_kill.contains(killer)) {
                    penta_kill.remove(killer);
                    lengendary.add(killer);
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.sendTitle(new Title("§b" + killer.getName() + "   §6主宰比赛   " + "§c" + victim.getName()));
                        player.sendMessage(killer.getName() + "“友好”地将" + victim.getName() + "送回复活点!");
                        player.sendMessage(killer.getName() + "主宰了这场比赛!");
                    }
                } else if (quadra_kill.contains(killer)) {
                    quadra_kill.remove(killer);
                    penta_kill.add(killer);
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.sendTitle(new Title("§b" + killer.getName() + "   §6无人能挡   " + "§c" + victim.getName()));
                        player.sendMessage(killer.getName() + "给予" + victim.getName() + "重重一击!");
                        player.sendMessage(killer.getName() + "无人能挡!");
                    }
                } else if (triple_kill.contains(killer)) {
                    triple_kill.remove(killer);
                    quadra_kill.add(killer);
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.sendTitle(new Title("§b" + killer.getName() + "   §6非常犀利   " + "§c" + victim.getName()));
                        player.sendMessage(killer.getName() + "的攻击准确命中" + victim.getName() + "!");
                        player.sendMessage(killer.getName() + "非常犀利!");
                    }
                } else if (double_kill.contains(killer)) {
                    double_kill.remove(killer);
                    triple_kill.add(killer);
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.sendTitle(new Title("§b" + killer.getName() + "   §6三连击   " + "§c" + victim.getName()));
                        player.sendMessage(killer.getName() + "的攻击准确命中" + victim.getName() + "!");
                        player.sendMessage(killer.getName() + "三连击!");
                    }
                } else if (kill.contains(killer)) {
                    kill.remove(killer);
                    double_kill.add(killer);
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.sendTitle(new Title("§b" + killer.getName() + "   §6两连击   " + "§c" + victim.getName()));
                        player.sendMessage(killer.getName() + "给予" + victim.getName() + "重重一击!");
                        player.sendMessage(killer.getName() + "两连击!");
                    }
                }else {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.sendMessage(killer.getName() + "的攻击准确命中" + victim.getName() + "!");
                        player.sendTitle(new Title(killer.getName() + "   §6重重一击   " + victim.getName()));
                    }
                    kill.add(killer);
                }
            }
        }
    }
}