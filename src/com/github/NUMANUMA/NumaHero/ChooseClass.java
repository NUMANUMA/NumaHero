package com.github.NUMANUMA.NumaHero;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ChooseClass implements Listener {
    NumaHero plugin;

    public ChooseClass(NumaHero plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (player.getItemInHand().getType() == Material.BOOK) {
            open(player);
        }
    }
    String title;
    public void open(Player player) {
        if (plugin.getHeroClass().get(player) == null) {
            plugin.getHeroClass().put(player, "NONE");
        }
        /*
         * タイトルの設定
         */
        title = "§0クラス選択  §8[§1" + plugin.getHeroClass().get(player) + "§8]";

        /*
         * ClassIconの設定
         */
        ItemStack FarmerIcon = new ItemStack(plugin.getClassIcon().FarmerIcon());
        ItemStack PoemerIcon = new ItemStack(plugin.getClassIcon().PoemerIcon());
        ItemStack ScholarIcon = new ItemStack(plugin.getClassIcon().ScholarIcon());

        Inventory inv = Bukkit.createInventory(player, 9, title);
        inv.setItem(0, FarmerIcon);
        inv.setItem(1, PoemerIcon);
        inv.setItem(2, ScholarIcon);
        player.openInventory(inv);

    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equals(title)) {
            e.setCancelled(true);
            if (e.getRawSlot() == 0) {
                player.sendMessage("§bあなたは、§aファーマー§bを選びました。");
                player.closeInventory();
                plugin.getFarmer().start(player);
            }
            if (e.getRawSlot() == 1) {
                player.sendMessage("§bあなたは、§aポエマー§bを選びました。");
                player.closeInventory();
                plugin.getPoemer().start(player);
            }
            if (e.getRawSlot() == 2) {
                player.sendMessage("§bあなたは、§a学者§bを選びました。");
                player.closeInventory();
                plugin.getScholar().start(player);
            }
        }
    }
}