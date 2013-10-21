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
    private ClassPoemer ClassPoemer;
    private ClassScholar ClassScholar;
    private HashMap<Player, String> HeroClass = new HashMap<>();

    @Override
    public void onEnable() {
        log = this.getLogger();
        log.info("プラグインが有効になりました。");

        //Get API
        API = new API(this);
        ClassIcon = new ClassIcon(this);
        ClassFarmer = new ClassFarmer(this);
        ClassPoemer = new ClassPoemer(this);
        ClassScholar = new ClassScholar(this);
        HeroClass = new HashMap<Player, String>();

        //イベントの登録
        new ChooseClass(this);
        new JoinEvent(this);
        new BreakEvent(this);
        new ClickEvent(this);
        new HitEvent(this);
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
    public ClassPoemer getPoemer() {
        return ClassPoemer;
    }
    public ClassScholar getScholar() {
        return ClassScholar;
    }
    public HashMap<Player, String> getHeroClass() {
        return HeroClass;
    }
}
