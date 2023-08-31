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

public class ComandoSpawn
implements CommandExecutor {
    private EpicPl plugin;

    public ComandoSpawn(EpicPl plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command comando, String label, String[] arg3) {
        Player jugador = (Player)sender;
        FileConfiguration config = this.plugin.getConfig();
        if (!config.contains("Config.Spawn.x")) {
            jugador.sendMessage(String.valueOf(this.plugin.nombre) + (Object)ChatColor.DARK_RED + "El spawn del servidor no esta implementado aun.");
            return true;
        }
        double x = Double.valueOf(config.getString("Config.Spawn.x"));
        double y = Double.valueOf(config.getString("Config.Spawn.y"));
        double z = Double.valueOf(config.getString("Config.Spawn.z"));
        float yaw = Float.valueOf(config.getString("Config.Spawn.yaw")).floatValue();
        float pitch = Float.valueOf(config.getString("Config.Spawn.pitch")).floatValue();
        World world = this.plugin.getServer().getWorld(config.getString("Config.Spawn.world"));
        Location l = new Location(world, x, y, z, yaw, pitch);
        jugador.teleport(l);
        jugador.sendMessage(String.valueOf(this.plugin.nombre) + (Object)ChatColor.WHITE + "¡Has sido llevado al spawn!");
        return true;
    }
}