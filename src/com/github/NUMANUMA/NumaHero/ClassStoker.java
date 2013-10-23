package com.github.NUMANUMA.NumaHero;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ClassStoker {

    NumaHero plugin;

    public ClassStoker(NumaHero plugin) {
        this.plugin = plugin;
    }

    /*
     * ストーカーの道具
     */
    ItemStack Snowball = new ItemStack(Material.SNOW_BALL,16);
    ItemStack StoneAxe = new ItemStack(Material.STONE_AXE);
    ItemStack Stake = new ItemStack(Material.COOKED_BEEF,16);
    ItemStack Helmet = new ItemStack(Material.JACK_O_LANTERN);


    public void start(Player player) {
        player.getInventory().clear();
        player.getEquipment().clear();

        //アイテムの追加
        player.getInventory().addItem(Snowball);
        player.getInventory().addItem(StoneAxe);
        player.getInventory().addItem(Stake);
        player.getInventory().setHelmet(Helmet);

        //プレイヤーがストーカーとなる。
        plugin.getHeroClass().put(player, "ストーカー");
    }
}
