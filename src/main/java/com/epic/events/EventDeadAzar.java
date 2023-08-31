
package com.epic.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.epic.epicpl.EpicPl;

import java.lang.reflect.Method;

public class EventDeadAzar implements Listener {
    private EpicPl plugin;

    public EventDeadAzar(EpicPl plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        if (player.getScoreboardTags().contains("dead")) { 
            String mensaje = "¡La etiqueta fue encontrada en el jugador " + player.getName() + "!";

            Bukkit.broadcastMessage(mensaje);

            Bukkit.getConsoleSender().sendMessage(mensaje);
        }
    }

}
