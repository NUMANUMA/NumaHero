package com.github.NUMANUMA.NumaHero;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ClassIcon {

    NumaHero plugin;

    public ClassIcon(NumaHero plugin) {
        this.plugin = plugin;
    }
    /*
     * ChatColor.BLACK          §0  黒色
     * ChatColor.DARK_BLUE      §1  暗い青色
     * ChatColor.DARK_GREEN     §2  暗い緑色
     * ChatColor.DARK_AQUA      §3  暗い水色
     * ChatColor.DARK_RED       §4  暗い赤色
     * ChatColor.DARK_PURPLE    §5  暗い紫色
     * ChatColor.GOLD           §6  暗い黄色
     * ChatColor.GRAY           §7  明るい灰色
     * ChatColor.DARK_GRAY      §8  暗い灰色
     * ChatColor.BLUE           §9  明るい青色
     * ChatColor.GREEN          §A  明るい緑色
     * ChatColor.AQUA           §B  明るい水色
     * ChatColor.RED            §C  明るい赤色
     * ChatColor.LIGHT_PURPLE   §D  明るい紫色
     * ChatColor.YELLOW         §E  明るい黄色
     * ChatColor.WHITE          §F  白色
     * ChatColor.MAGIC          §K  エンチャントテーブルにアイテムを置いたときのような、読めない文字に変換して表示
     * ChatColor.BOLD           §L  太字
     * ChatColor.STRIKETHROUGH  §M  打消し線
     * ChatColor.UNDERLINE      §N  下線
     * ChatColor.ITALIC         §O  斜体
     * ChatColor.RESET          §R  前方で行われた装飾を取り消して元に戻す（例：§Bあいう§Rえお→あいうえお）
     */

    /*
     * ファーマーの設定
     */
    public ItemStack FarmerIcon() {
        ItemStack FarmerIcon = new ItemStack(Material.BREAD);
        ItemMeta im = FarmerIcon.getItemMeta();
        im.setDisplayName(ChatColor.GREEN + "ファーマー");
        List<String> lore = new ArrayList<String>();
            lore.add("§d特殊武器: §cパン,クワ");
            lore.add("§fパンで攻撃するとパンを消費し、攻撃されたプレイヤーは");
            lore.add("§5鈍足§fと§5空腹§f状態になる。");
            lore.add("§f種を持って右クリックすると、種を消費し、§6回復§fする。");
            lore.add("§fクワでクリックすると種を消費し、§5矢§fを§c発射§fする。");
        im.setLore(lore);
        FarmerIcon.setItemMeta(im);

        return FarmerIcon;
    }
}
