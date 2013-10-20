package com.github.NUMANUMA.NumaHero;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class API {

    NumaHero plugin;

    public API(NumaHero plugin) {
        this.plugin = plugin;
    }

    /*
     * ハローワークを渡す
     */
    public void getHelloWork(Player player) {
        ItemStack book = new ItemStack(Material.BOOK);
        ItemMeta im = book.getItemMeta();
        im.setDisplayName(ChatColor.AQUA + "ハローワーク");

        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GREEN + "クラスの選択が可能です。");
        im.setLore(lore);
        book.setItemMeta(im);
        player.getInventory().addItem(book);
    }
}
