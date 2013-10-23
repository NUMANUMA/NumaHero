package com.github.NUMANUMA.NumaHero;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class ClickEvent implements Listener {

    NumaHero plugin;

    public ClickEvent(NumaHero plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    final HashMap<Player, Boolean> stokerjump = new HashMap<>();
    @SuppressWarnings("deprecation")
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        HashMap<Player, String> hero = plugin.getHeroClass();

        /*
         * NONE
         */
        if (hero.get(player) == "NONE" | hero.get(player) == null) {
            hero.put(player, "NONE");
            return;
        }
        /*
         * ===================
         *       ファーマー
         * ===================
         */
        if (hero.get(player) == "ファーマー") {
            /*
             * 種を食べる
             */
            if (player.getItemInHand().getType() == Material.SEEDS) {
                if (player.getHealth() == player.getMaxHealth()) {
                    return;
                } else if (player.getHealth() <= player.getMaxHealth()) {
                    if (player.getHealth() == 0) {
                        return;
                    }
                    if (player.getItemInHand().getAmount() == 1) {
                        player.setItemInHand(null);
                    } else if (player.getItemInHand().getAmount() >= 1) {
                        player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
                    }

                    if (player.getHealth() == player.getMaxHealth()) {
                        return;
                    } else {
                        player.setHealth(player.getHealth() + 1);
                    }
                } else if (player.getHealth() == 0) {
                    return;
                }
            }
            /*
             * クワで矢を飛ばす
             */
            if (player.getItemInHand().getType() == Material.IRON_HOE) {
                if (player.getInventory().contains(Material.SEEDS)) {
                    player.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.SEEDS, 1) });
                    player.updateInventory();
                    Location loc = player.getLocation();
                    Vector v = loc.getDirection().multiply(3);
                    loc.setY(loc.getY() + 1.6);
                    Arrow arrow = player.getWorld().spawnArrow(loc.add(v), v, 2.0F, 12);
                    arrow.setShooter(player);
                } else {
                    return;
                }
            }
        }

        /*
         * ===================
         *       ポエマー
         * ===================
         */
        if (hero.get(player) == "ポエマー") {
            /*
             * ポエムを全世界に披露する。
             */
            if (player.getItemInHand().getType() == Material.PAPER) {
                if (player.getItemInHand().getAmount() == 1) {
                    player.setItemInHand(null);
                } else {
                    player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
                }
                player.getServer().broadcastMessage("§b" + player.getName() + "§6のポエムが全世界に披露される！");
                player.getServer().broadcastMessage("§e”君の幸せを願うよ。     ──All for you.”");

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                    public void run() {
                        player.getServer().broadcastMessage("§6........ポエムは大盛況だった！！！");

                        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1 * 20, 5));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 60 * 20, 3));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 60 * 20, 0));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 60 * 20, 3));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60 * 20, 3));

                        player.sendMessage("§dポエムが予想以上の反響！テンションが上がり、能力が増加した！");
                    }
                }, 5 * 20);
            }
            /*
             * 大炎上して大爆発
             */
            if (player.getItemInHand().getType() == Material.INK_SACK) {
                if (player.getItemInHand().getAmount() == 1) {
                    player.setItemInHand(null);
                } else {
                    player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
                }
                player.getServer().broadcastMessage("§b" + player.getName() + "§6のポエムが全世界に披露される！");
                player.getServer().broadcastMessage("§e”できることなら時間を戻して、君との初めてを繰り返したい。”");

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                    public void run() {
                        player.getServer().broadcastMessage("§6........ポエムは§c大炎上§6した！！！");

                        player.sendMessage("§dポエムが予想外の悪評！ショックで立ち直れなくなり大爆発した！");

                        player.getWorld().createExplosion(player.getLocation(), 5F);
                    }
                }, 3 * 20);
            }
        }

        /*
         * ===========
         * ストーカー
         * ===========
         */
        if (hero.get(player) == "ストーカー") {
            if (player.getItemInHand().getType() == Material.STONE_AXE) {
                if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    if (stokerjump.get(player) == null) {

                        stokerjump.put(player, true);
                    }
                    if (stokerjump.get(player) == false) {
                        return;
                    }
                    if (stokerjump.get(player) == true) {
                        stokerjump.put(player, false);

                        Location loc = player.getLocation();

                        double pitch = ((player.getLocation().getPitch() + 90) * Math.PI) / 180;
                        double yaw  = ((player.getLocation().getYaw() + 90)  * Math.PI) / 180;

                        double x = Math.sin(pitch) * Math.cos(yaw);
                        double y = Math.sin(pitch) * Math.sin(yaw);

                        Vector vector = new Vector(x, 0.3, y);

                        player.setVelocity(vector.multiply(2));
                        player.playSound(loc, Sound.BAT_TAKEOFF, 10, 1);
                        player.getWorld().playEffect(loc, Effect.SMOKE, 5);
                        player.getWorld().playEffect(loc, Effect.SMOKE, 5);
                        player.getWorld().playEffect(loc, Effect.SMOKE, 5);

                        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                            public void run() {

                                stokerjump.put(player, true);
                            }
                        },20);
                    }
                }
            }
        }
    }
}
