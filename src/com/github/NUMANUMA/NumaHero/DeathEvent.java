package com.github.NUMANUMA.NumaHero;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class DeathEvent implements Listener {

    NumaHero plugin;

    public DeathEvent(NumaHero plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    /*
     * 死亡したらハローワークをプレゼント♥
     */
    @EventHandler
    public void onPlayerRespawn(final PlayerRespawnEvent e) {
        Player player = e.getPlayer();

        player.getInventory().clear();
        player.getEquipment().setArmorContents(null);
        plugin.getHeroClass().put(player, "NONE");
        plugin.getAPI().getHelloWork(player);
    }
}
