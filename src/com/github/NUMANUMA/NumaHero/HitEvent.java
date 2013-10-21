package com.github.NUMANUMA.NumaHero;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HitEvent implements Listener {

    NumaHero plugin;
    public HitEvent(NumaHero plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerDamage(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player) {
            if (e.getDamager() instanceof Player) {
                final Player hitter = (Player) e.getEntity();
                final Player damager = (Player) e.getDamager();
                HashMap<Player, String> hero = plugin.getHeroClass();

                /*
                 * ==========
                 * ファーマー
                 * ==========
                 */
                if (hero.get(damager) == "ファーマー") {
                    /*
                     * 軍用フランスパンを持っていた場合
                     */
                    if (damager.getItemInHand().getType() == Material.BREAD) {
                        /*
                         * damagerの処理
                         */
                        if (damager.getItemInHand().getAmount() == 1) {
                            damager.setItemInHand(null);
                        } else if (damager.getItemInHand().getAmount() >= 1) {
                            damager.getItemInHand().setAmount(damager.getItemInHand().getAmount()-1);
                        }
                        damager.sendMessage("§d奴のみぞおちに、この§4軍用フランスパン§dを突き刺してやった！");
                        damager.sendMessage("§d腹を抱えて もだえ苦しんでいる！");

                        /*
                         * hitterの処理
                         */
                        e.setDamage(9);
                        hitter.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 6*20,5));
                        hitter.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 3*20,10));
                        hitter.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 3*20,10));
                        hitter.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1*20,10));
                        hitter.removePotionEffect(PotionEffectType.BLINDNESS);
                        hitter.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1*20,10));
                        hitter.removePotionEffect(PotionEffectType.BLINDNESS);
                        hitter.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1*20,10));

                        hitter.sendMessage("§5激しい腹痛に襲われた...");
                        hitter.sendMessage("§0§L「助けてくれ...」 §r§5その声は届かなかった...");


                    } else {
                        return;
                    }
                }
                /*
                 * =========
                 * ポエマー
                 * =========
                 */
                if (hero.get(damager) == "ポエマー") {
                    /*
                     * ネザースターで恥ずか死させる
                     */
                    if (damager.getItemInHand().getType() == Material.NETHER_STAR) {
                        /*
                         * damagerの処理
                         */
                        if (damager.getItemInHand().getAmount() == 1) {
                            damager.setItemInHand(null);
                        } else if (damager.getItemInHand().getAmount() >= 1) {
                            damager.getItemInHand().setAmount(damager.getItemInHand().getAmount()-1);
                        }
                        damager.sendMessage("§d彼に力作のポエムを披露した！");

                        /*
                         * hitterの処理
                         */
                        hitter.sendMessage("§5突然ポエムを披露された！");
                        hitter.sendMessage("§5その出来は読んでいるこっちが恥ずかしくなるほどだった！");
                        hitter.sendMessage("§cなんとも言えない気持ちになってしまった！誰か助けてくれ！");

                        hitter.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1*20,10));
                        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                            public void run() {
                                hitter.removePotionEffect(PotionEffectType.BLINDNESS);

                                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                                    public void run() {
                                        hitter.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1*20,10));

                                        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                                            public void run() {
                                                hitter.removePotionEffect(PotionEffectType.BLINDNESS);

                                                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                                                    public void run() {
                                                        hitter.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1*20,10));
                                                    }
                                                },2);
                                            }
                                        },2);
                                    }
                                },2);
                            }
                        },2);

                        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                            public void run() {
                                damager.sendMessage("§dそうすると、突然彼は耳まで赤くなり倒れてしまった！");
                                hitter.setHealth(0);
                            }
                        },3*20);
                    }
                }

                /*
                 * ========
                 * 学者
                 * ========
                 */
                if (hero.get(damager) == "学者") {
                    /*
                     * 問題を解かせる
                     */
                    if (damager.getItemInHand().getType() == Material.NETHER_BRICK_ITEM) {
                        /*
                         * damagerの処理
                         */
                        if (damager.getItemInHand().getAmount() == 1) {
                            damager.setItemInHand(null);
                        } else if (damager.getItemInHand().getAmount() >= 1) {
                            damager.getItemInHand().setAmount(damager.getItemInHand().getAmount()-1);
                        }
                        damager.sendMessage("§dなかなか難しい問題を解かせた！");
                        damager.sendMessage("§dこの問題を解くことはできるか！？");

                        /*
                         * hitterの処理
                         */
                        hitter.getServer().broadcastMessage("§b"+ hitter.getName() +"§6が、§9学者 §b" + damager.getName() + "§6の問題に挑戦した！");

                        hitter.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10*20,10));
                        hitter.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10*20,10));
                        hitter.sendMessage("§5これは難問だ！解くのに時間がかかるぞ！");
                    }

                    /*
                     * レンガによる打撃
                     */
                    if (damager.getItemInHand().getType() == Material.CLAY_BRICK) {
                        /*
                         * damagerの処理
                         */
                        damager.sendMessage("§dレンガを奴の頭目掛けて思い切り振りかぶった！");

                        /*
                         * hitterの処理
                         */
                        e.setDamage(6);

                        hitter.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 6*20,5));
                        hitter.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1*20,10));
                        hitter.removePotionEffect(PotionEffectType.BLINDNESS);
                        hitter.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1*20,10));

                        hitter.sendMessage("§5痛い！なんて野郎だ！学者としてありえない！");
                    }
                }
            }
        }
    }
}
