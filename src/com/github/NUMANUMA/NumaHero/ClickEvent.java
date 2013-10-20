package com.github.NUMANUMA.NumaHero;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class ClickEvent implements Listener {

    NumaHero plugin;

    public ClickEvent(NumaHero plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        HashMap<Player, String> hero = plugin.getHeroClass();
        /*
         * NONE
         */
        if (hero.get(player) == "NONE" | hero.get(player) == null) {
            hero.put(player, "NONE");
            return;
        }
        /*
         * ファーマー
         */
        if (hero.get(player) == "ファーマー") {
            if (player.getItemInHand().getType() == Material.SEEDS) {
                if (player.getHealth() == player.getMaxHealth()) {
                    return;
                } else if (player.getHealth() <= player.getMaxHealth()) {
                    if (player.getHealth() == 0) {
                        return;
                    }
                    if (player.getItemInHand().getAmount() == 1) {
                        player.setItemInHand(null);
                    } else if (player.getItemInHand().getAmount() >= 1) {
                        player.getItemInHand().setAmount(player.getItemInHand().getAmount()-1);
                    }
                    player.setHealth(player.getHealth()+1);
                } else if (player.getHealth() == 0) {
                    return;
                }
            }
        }
    }
}
