package com.epic.events;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerMoveEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.epic.epicpl.EpicPl;
public class EventFirstJoin implements Listener {
    private EpicPl plugin;

    public EventFirstJoin(EpicPl plugin) {
        this.plugin = plugin;
    }


    private final Map<UUID, Location> originalLocations = new HashMap<>();

    private void saveOriginalLocation(Player player) {
        originalLocations.put(player.getUniqueId(), player.getLocation());
    }

    private void returnToOriginalLocation(Player player) {
        player.teleport(originalLocations.get(player.getUniqueId()));
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore()) {

            UUID playerId = player.getUniqueId();

            if (!originalLocations.containsKey(playerId)) {
                originalLocations.put(playerId, player.getLocation());
            }

            Location originalLocation = originalLocations.get(playerId);
            Location currentLocation = event.getTo();

            if (originalLocation != null && currentLocation != null && !originalLocation.equals(currentLocation)) {
                event.setTo(originalLocation);
            }
        }
    }

    private void startTimer(Player player) {
        saveOriginalLocation(player);
        new BukkitRunnable() {
            public void run() {
                originalLocations.remove(player.getUniqueId());
            }
        }.runTaskLater((Plugin) this, 1 * 60 * 20L); // 5 minutos en ticks (20 ticks por segundo)
    }
}


