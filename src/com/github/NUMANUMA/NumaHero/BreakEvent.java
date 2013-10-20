package com.github.NUMANUMA.NumaHero;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

/*
 * HEROたちのブロック破壊した際のイベント
 */
public class BreakEvent implements Listener {

    NumaHero plugin;

    public BreakEvent(NumaHero plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBlockBreake(BlockBreakEvent e) {
        Player player = e.getPlayer();

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
            if (e.getBlock().getType() == Material.LONG_GRASS) {
                e.getBlock().getLocation().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.SEEDS,2));
            }
        }
    }
}
