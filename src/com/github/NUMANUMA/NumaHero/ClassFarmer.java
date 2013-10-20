package com.github.NUMANUMA.NumaHero;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ClassFarmer {

    NumaHero plugin;

    public ClassFarmer(NumaHero plugin) {
        this.plugin = plugin;
    }

    /*
     * ファーマーの道具
     */
    ItemStack Bread = new ItemStack(Material.BREAD,16);
    ItemStack Hoe = new ItemStack(Material.IRON_HOE);
    ItemStack Water = new ItemStack(Material.WATER_BUCKET);
    ItemStack Seed = new ItemStack(Material.SEEDS,64);
    ItemStack Leggings = new ItemStack(Material.LEATHER_LEGGINGS);
    ItemStack Boots = new ItemStack(Material.LEATHER_BOOTS);
    ItemStack Bone = new ItemStack(Material.BONE,64);

    public void start(Player player) {
        player.getInventory().clear();
        player.getEquipment().clear();

        //アイテムの追加
        player.getInventory().addItem(Bread);
        player.getInventory().addItem(Hoe);
        player.getInventory().addItem(Water);
        player.getInventory().addItem(Seed);
        player.getInventory().setLeggings(Leggings);
        player.getInventory().setBoots(Boots);
        player.getInventory().addItem(Bone);

        //プレイヤーがファーマーとなる。
        plugin.getHeroClass().put(player, "ファーマー");
    }
}
