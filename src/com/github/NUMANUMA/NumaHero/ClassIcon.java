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
            lore.add("§5ショック状態§fになる。");
            lore.add("§f種を持って右クリックすると、種を消費し、§6回復§fする。");
            lore.add("§fクワでクリックすると種を消費し、§5矢§fを§c発射§fする。");
        im.setLore(lore);
        FarmerIcon.setItemMeta(im);

        return FarmerIcon;
    }

    /*
     * ポエマーの設定
     */
    public ItemStack PoemerIcon() {
        ItemStack PoemerIcon = new ItemStack(Material.PAPER);
        ItemMeta im = PoemerIcon.getItemMeta();
        im.setDisplayName(ChatColor.GREEN + "ポエマー");
        List<String> lore = new ArrayList<String>();
            lore.add("§d特殊武器: §c紙,バラ,インク");
            lore.add("§f紙を使用すると、§6ポエム§fを全世界に披露できる。");
            lore.add("§6ポエム§fは大盛況になり、ポエマーの能力が§c増加§fする。");
            lore.add("§9インク§fを使用すると、§4大炎上§fし、");
            lore.add("§fポエマーは§4大爆発§fする。その破壊力は偉大である。");
            lore.add("§dネザースター§fで攻撃するとネザースターを消費し、攻撃されたプレイヤーは");
            lore.add("§4恥ずか§c死§fする。");
        im.setLore(lore);
        PoemerIcon.setItemMeta(im);

        return PoemerIcon;
    }

    /*
     * 学者の設定
     */
    public ItemStack ScholarIcon() {
        ItemStack ScholarIcon = new ItemStack(Material.BRICK);
        ItemMeta im = ScholarIcon.getItemMeta();
        im.setDisplayName(ChatColor.GREEN + "学者");
        List<String> lore = new ArrayList<String>();
            lore.add("§d特殊武器: §cレンガ,ネザーレンガ");
            lore.add("§fレンガを使用すると、§c問題§fを作り始める。");
            lore.add("§c問題§fを作っている間は、§5動けず、周りも見えなくなる。");
            lore.add("§c問題§fが完成するとネザーレンガを手に入れる。");
            lore.add("§fネザーレンガで攻撃すると、§c問題§fを解かせることができる。");
            lore.add("§f問題を解いている間は、§5動けず、周りも見えなくなる。");
        im.setLore(lore);
        ScholarIcon.setItemMeta(im);

        return ScholarIcon;
    }
}
