package com.github.NUMANUMA.NumaHero;

import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class NumaHero extends JavaPlugin {
    Logger log;

    private API API;
    private ClassIcon ClassIcon;
    private ClassFarmer ClassFarmer;
    private HashMap<Player, String> HeroClass = new HashMap<>();

    @Override
    public void onEnable() {
        log = this.getLogger();
        log.info("プラグインが有効になりました。");

        //Get API
        API = new API(this);
        ClassIcon = new ClassIcon(this);
        ClassFarmer = new ClassFarmer(this);
        HeroClass = new HashMap<Player, String>();

        //イベントの登録
        new ChooseClass(this);
        new JoinEvent(this);
        new BreakEvent(this);
        new ClickEvent(this);
    }

    public API getAPI() {
        return API;
    }
    public ClassIcon getClassIcon() {
        return ClassIcon;
    }
    public ClassFarmer getFarmer() {
        return ClassFarmer;
    }
    public HashMap<Player, String> getHeroClass() {
        return HeroClass;
    }
}