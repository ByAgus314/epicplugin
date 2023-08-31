package com.epic.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

import com.epic.epicpl.EpicPl;

public class ComandoDev
implements CommandExecutor {
    private EpicPl plugin;

    public ComandoDev(EpicPl plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command comando, String label, String[] args) {



        Player jugador = (Player)sender;
        FileConfiguration config = this.plugin.getConfig();

        if(jugador.hasPermission("epicpl.dev")) {
            if (!config.contains("Config.Dev.x")) {
            jugador.sendMessage(String.valueOf(this.plugin.nombre) + (Object)ChatColor.DARK_RED + "El spawn dev del servidor no esta implementado aun.");
            }else {


            double x = Double.valueOf(config.getString("Config.Dev.x"));
            double y = Double.valueOf(config.getString("Config.Dev.y"));
            double z = Double.valueOf(config.getString("Config.Dev.z"));
            float yaw = Float.valueOf(config.getString("Config.Dev.yaw")).floatValue();
            float pitch = Float.valueOf(config.getString("Config.Dev.pitch")).floatValue();
            World world = this.plugin.getServer().getWorld(config.getString("Config.Dev.world"));
            Location l = new Location(world, x, y, z, yaw, pitch);
            jugador.teleport(l);

            return true;


        }
       }else{
         jugador.sendMessage(String.valueOf(this.plugin.nombre) + (Object)ChatColor.DARK_RED + "No tienes permisos para ejecutar este comando.");
         return true;
       }



         return true;



    }

}