package com.epic.events;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.epic.epicpl.EpicPl;

public class EventJoin
implements Listener {
    private EpicPl plugin;

    public EventJoin(EpicPl plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void alEntrar(PlayerJoinEvent event) {
        FileConfiguration config = this.plugin.getConfig();
        Player jugador = event.getPlayer();
        String path = "Config.mensaje-bienvenida";
        if (config.getString(path).equals("true")) {
            String texto = "Config.mensaje-bienvenida-texto";
            jugador.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)config.getString(texto)).replaceAll("%player%", jugador.getName()));
        }
    }

  //  public void onEnable() {
   //     FileConfiguration config = this.plugin.getConfig();
    //    String prefix = "Config.prefix";


   // }

}