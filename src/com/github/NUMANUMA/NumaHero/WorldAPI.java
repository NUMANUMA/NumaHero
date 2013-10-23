package com.github.NUMANUMA.NumaHero;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;

public class WorldAPI {

    static NumaHero plugin;

    public WorldAPI(NumaHero plugin) {
        WorldAPI.plugin = plugin;
    }

    /*
     * マップのロールバック
     */
    public static void unloadMap(String mapname) {
        if (Bukkit.getServer().unloadWorld(Bukkit.getServer().getWorld(mapname), false)) {
            plugin.getLogger().info("Successfully unloaded " + mapname);
        } else {
            plugin.getLogger().severe("COULD NOT UNLOAD " + mapname);
        }
    }

    //Loading maps (MUST BE CALLED AFTER UNLOAD MAPS TO FINISH THE ROLLBACK PROCESS)
    public static void loadMap(String mapname) {
        World w = Bukkit.getServer().createWorld(new WorldCreator(mapname));
        w.setAutoSave(false);
    }

    //Maprollback method, because were too lazy to type 2 lines
    public static void rollback(String mapname) {
        unloadMap(mapname);
        loadMap(mapname);
    }
}
