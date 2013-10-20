package com.github.NUMANUMA.NumaHero;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinEvent implements Listener {
    NumaHero plugin;
    public JoinEvent(NumaHero plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String message;

        if (player.hasPlayedBefore()) {
            message = ChatColor.AQUA + player.getName()
                    + ChatColor.GREEN + "さんがサーバーに参加しました。";
        } else {
            message = ChatColor.AQUA + player.getName()
                    + ChatColor.GREEN + "さんがサーバーに初めて参加しました。";
        }
        e.setJoinMessage(message);
        player.getInventory().clear();
        player.getEquipment().setArmorContents(null);
        plugin.getHeroClass().put(player, "NONE");
        plugin.getAPI().getHelloWork(player);
    }
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        String message = ChatColor.AQUA + player.getName()
                + ChatColor.GREEN + "さんがサーバーから退出しました。";
        e.setQuitMessage(message);
    }
}
