package com.epic.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.epic.epicpl.EpicPl;

public class ComandoPrincipal
implements CommandExecutor {
    private EpicPl plugin;

    public ComandoPrincipal(EpicPl plugin) {
        this.plugin = plugin;
}
    public boolean onCommand(CommandSender sender, Command comando, String label, String[] args) {
    	
    	 Player jugador = (Player)sender;
         if (!(sender instanceof Player)) {
             Bukkit.getConsoleSender().sendMessage((Object)ChatColor.DARK_RED + "<----------------------->");
             Bukkit.getConsoleSender().sendMessage(String.valueOf(this.plugin.nombre) + "No puedes ejecutar comandos desde la consola.!");
             Bukkit.getConsoleSender().sendMessage((Object)ChatColor.DARK_RED + "<----------------------->");
             return false;
         }
         if (args.length > 0) {
             if (args[0].equalsIgnoreCase("version")) {
                 jugador.sendMessage(String.valueOf(this.plugin.nombre) + (Object)ChatColor.WHITE + "La version del plugin es: " + (Object)ChatColor.DARK_RED + this.plugin.version);
                 return true;
             } 
             if(jugador.hasPermission("epicpl.setspawn")) {
             if (args[0].equalsIgnoreCase("setspawn")) {
                 Location l = jugador.getLocation();
                 double x = l.getX();
                 double y = l.getY();
                 double z = l.getZ();
                 String world = l.getWorld().getName();
                 float yaw = l.getYaw();
                 float pitch = l.getPitch();
                 FileConfiguration config = this.plugin.getConfig();
                 config.set("Config.Spawn.x", (Object)x);
                 config.set("Config.Spawn.y", (Object)y);
                 config.set("Config.Spawn.z", (Object)z);
                 config.set("Config.Spawn.world", (Object)world);
                 config.set("Config.Spawn.yaw", (Object)Float.valueOf(yaw));
                 config.set("Config.Spawn.pitch", (Object)Float.valueOf(pitch));
                 this.plugin.saveConfig();
                 jugador.sendMessage(String.valueOf(this.plugin.nombre) + (Object)ChatColor.DARK_GREEN + "El spawn del servidor de guardo correctamente");
                 return true;
             }
             }else {
             	jugador.sendMessage(String.valueOf(this.plugin.nombre) + (Object)ChatColor.DARK_RED + "No tienes permisos para ejecutar este comando.");
          		return true;
             }
         } 
         if(jugador.hasPermission("epicpl.seteventº")) {
         if (args[0].equalsIgnoreCase("setevent")) {
             Location l = jugador.getLocation();
             double x = l.getX();
             double y = l.getY();
             double z = l.getZ();
             String world = l.getWorld().getName();
             float yaw = l.getYaw();
             float pitch = l.getPitch();
             FileConfiguration config = this.plugin.getConfig();
             config.set("Config.Event.x", (Object)x);
             config.set("Config.Event.y", (Object)y);
             config.set("Config.Event.z", (Object)z);
             config.set("Config.Event.world", (Object)world);
             config.set("Config.Event.yaw", (Object)Float.valueOf(yaw));
             config.set("Config.Event.pitch", (Object)Float.valueOf(pitch));
             this.plugin.saveConfig();
             jugador.sendMessage(String.valueOf(this.plugin.nombre) + (Object)ChatColor.DARK_GREEN + "El spawn de eventos del servidor de guardo correctamente");
             return true;
         }
         }else {
         	jugador.sendMessage(String.valueOf(this.plugin.nombre) + (Object)ChatColor.DARK_RED + "No tienes permisos para ejecutar este comando.");
      		return true;
         }
             if(jugador.hasPermission("epicpl.setdev")) {
             if (args[0].equalsIgnoreCase("setdev")) {
                 Location l = jugador.getLocation();
                 double x = l.getX();
                 double y = l.getY();
                 double z = l.getZ();
                 String world = l.getWorld().getName();
                 float yaw = l.getYaw();
                 float pitch = l.getPitch();
                 FileConfiguration config = this.plugin.getConfig();
                 config.set("Config.Dev.x", (Object)x);
                 config.set("Config.Dev.y", (Object)y);
                 config.set("Config.Dev.z", (Object)z);
                 config.set("Config.Dev.world", (Object)world);
                 config.set("Config.Dev.yaw", (Object)Float.valueOf(yaw));
                 config.set("Config.Dev.pitch", (Object)Float.valueOf(pitch));
                 this.plugin.saveConfig();
                 jugador.sendMessage(String.valueOf(this.plugin.nombre) + (Object)ChatColor.DARK_GREEN + "El spawn dev del servidor de guardo correctamente");
                 return true;
             }
             }else {
             	jugador.sendMessage(String.valueOf(this.plugin.nombre) + (Object)ChatColor.DARK_RED + "No tienes permisos para ejecutar este comando.");
          		return true;
             }
             if(jugador.hasPermission("epicpl.reload")) {
             if (args[0].equalsIgnoreCase("reload")) {
                 this.plugin.reloadConfig();
                 jugador.sendMessage((Object)ChatColor.DARK_RED + "<----------------------->");
                 jugador.sendMessage(String.valueOf(this.plugin.nombre) + "Plugin recargado correctamente.");
                 jugador.sendMessage(String.valueOf(this.plugin.nombre) + "Derechos de Autor: epic.#7707");
                 jugador.sendMessage(String.valueOf(this.plugin.nombre) + "Plugin diseñado para diferentes spawns.");
                 jugador.sendMessage((Object)ChatColor.DARK_RED + "<----------------------->");
                 return true;
             }
             }
             else {
              	jugador.sendMessage(String.valueOf(this.plugin.nombre) + (Object)ChatColor.DARK_RED + "No tienes permisos para ejecutar este comando.");
           		return true;
              }
             
             if(jugador.hasPermission("epicpl.reloadc")) {
             if (args[0].equalsIgnoreCase("reloadc")) {
                 this.plugin.reloadConfig();
                 Bukkit.getConsoleSender().sendMessage((Object)ChatColor.DARK_RED + "<----------------------->");
                 Bukkit.getConsoleSender().sendMessage(String.valueOf(this.plugin.nombre) + "Plugin recargado correctamente.");
                 Bukkit.getConsoleSender().sendMessage(String.valueOf(this.plugin.nombre) + "Derechos de Autor: epic.#7707");
                 Bukkit.getConsoleSender().sendMessage(String.valueOf(this.plugin.nombre) + "Plugin diseñado para diferentes spawns.");
                 Bukkit.getConsoleSender().sendMessage((Object)ChatColor.DARK_RED + "<----------------------->");
                 return true;
             	
             }
             else {
               	jugador.sendMessage(String.valueOf(this.plugin.nombre) + (Object)ChatColor.DARK_RED + "No tienes permisos para ejecutar este comando.");
            		return true;
               }
             }
             
             jugador.sendMessage(String.valueOf(this.plugin.nombre) + (Object)ChatColor.WHITE + "Ese comando no existe!");
             return true;
        
        
    }
    }


