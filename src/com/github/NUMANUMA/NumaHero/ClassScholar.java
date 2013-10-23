package com.github.NUMANUMA.NumaHero;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ClassScholar {

    NumaHero plugin;

    public ClassScholar(NumaHero plugin) {
        this.plugin = plugin;
    }

    /*
     * 学者の道具
     */
    ItemStack Brick = new ItemStack(Material.CLAY_BRICK);
    ItemStack Egg = new ItemStack(Material.EGG,8);
    ItemStack Bow = new ItemStack(Material.BOW);
    ItemStack Arrow = new ItemStack(Material.ARROW,64);
    ItemStack Cookie = new ItemStack(Material.COOKIE,32);
    ItemStack Chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
    ItemStack Leggings = new ItemStack(Material.LEATHER_LEGGINGS);
    ItemStack Boots = new ItemStack(Material.LEATHER_BOOTS);

    public void start(Player player) {
        player.getInventory().clear();
        player.getEquipment().clear();

        //アイテムの追加
        player.getInventory().addItem(Brick);
        player.getInventory().addItem(Egg);
        player.getInventory().addItem(Bow);
        player.getInventory().addItem(Arrow);
        player.getInventory().addItem(Cookie);
        player.getInventory().setChestplate(Chestplate);
        player.getInventory().setLeggings(Leggings);
        player.getInventory().setBoots(Boots);

        //プレイヤーが学者となる
        plugin.getHeroClass().put(player, "学者");
    }
}
