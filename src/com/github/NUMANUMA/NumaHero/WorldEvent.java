package com.github.NUMANUMA.NumaHero;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class WorldEvent implements Listener, CommandExecutor {

    NumaHero plugin;

    public WorldEvent(NumaHero plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    //イベントたち

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = null;
        if (sender instanceof Player) {
            player = (Player) sender;
        }

        if (cmd.getName().equalsIgnoreCase("spawnworld")) {
            if (player != null) {

                Bukkit.getServer().createWorld(new WorldCreator("SpawnWorld"));

                World sw = Bukkit.getWorld("SpawnWorld");
                Location loc = new Location(sw, 0, 64, 0);

                int x = loc.getChunk().getX();
                int z = loc.getChunk().getZ();

                player.teleport(loc);

                loc.getWorld().loadChunk(x, z);
                loc.getWorld().refreshChunk(x, z);
            } else {
                sender.sendMessage("このコマンドはプレイヤー専用です。");
            }
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("world")) {
            if (player != null) {

                Bukkit.getServer().createWorld(new WorldCreator("pvp"));

                World w = Bukkit.getWorld("pvp");
                player.teleport(new Location(w, 0, 64, 0));
            } else {
                sender.sendMessage("このコマンドはプレイヤー専用です。");
            }
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("wreset")) {
            plugin.getWorldAPI();
            WorldAPI.rollback("pvp");

            return true;
        }

        return false;
    }

}
