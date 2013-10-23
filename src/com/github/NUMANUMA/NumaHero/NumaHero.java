package com.github.NUMANUMA.NumaHero;

import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class NumaHero extends JavaPlugin {
    Logger log;

    private API API;
    private WorldAPI WorldAPI;
    private ClassIcon ClassIcon;
    private ClassFarmer ClassFarmer;
    private ClassPoemer ClassPoemer;
    private ClassScholar ClassScholar;
    private ClassStoker ClassStoker;
    private HashMap<Player, String> HeroClass = new HashMap<>();

    @Override
    public void onEnable() {
        log = this.getLogger();
        log.info("プラグインが有効になりました。");

        //Get API
        API = new API(this);
        WorldAPI = new WorldAPI(this);
        ClassIcon = new ClassIcon(this);
        ClassFarmer = new ClassFarmer(this);
        ClassPoemer = new ClassPoemer(this);
        ClassScholar = new ClassScholar(this);
        ClassStoker = new ClassStoker(this);
        HeroClass = new HashMap<Player, String>();

        //イベントの登録
        new ChooseClass(this);
        new JoinEvent(this);
        new DeathEvent(this);
        new BreakEvent(this);
        new ClickEvent(this);
        new HitEvent(this);
        new HasOPEvent(this);

      //コマンドの追加
        getCommand("spawnworld").setExecutor(new WorldEvent(this));
        getCommand("world").setExecutor(new WorldEvent(this));
        getCommand("wreset").setExecutor(new WorldEvent(this));
    }

    public API getAPI() {
        return API;
    }
    public WorldAPI getWorldAPI() {
        return WorldAPI;
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
    public ClassStoker getStoker() {
        return ClassStoker;
    }
    public HashMap<Player, String> getHeroClass() {
        return HeroClass;
    }
}
