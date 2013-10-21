package com.github.NUMANUMA.NumaHero;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ClassPoemer {

    NumaHero plugin;

    public ClassPoemer(NumaHero plugin) {
        this.plugin = plugin;
    }

    /*
     * ポエマーの道具
     */
    ItemStack Paper = new ItemStack(Material.PAPER,8);
    ItemStack Star = new ItemStack(Material.NETHER_STAR,2);
    ItemStack Ink = new ItemStack(Material.INK_SACK,1);
    ItemStack Helmet = new ItemStack(Material.GOLD_HELMET);
    ItemStack Boots = new ItemStack(Material.LEATHER_BOOTS);

    public void start(Player player) {
        player.getInventory().clear();
        player.getEquipment().clear();

        //アイテムの追加
        player.getInventory().addItem(Paper);
        player.getInventory().addItem(Star);
        player.getInventory().addItem(Ink);
        player.getInventory().setHelmet(Helmet);
        player.getInventory().setBoots(Boots);

        //プレイヤーがポエマーとなる。
        plugin.getHeroClass().put(player, "ポエマー");
    }
}
