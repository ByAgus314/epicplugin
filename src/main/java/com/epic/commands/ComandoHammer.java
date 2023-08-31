package com.epic.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;
import org.bukkit.persistence.PersistentDataType;

import com.epic.epicpl.EpicPl;

public class ComandoHammer
        implements CommandExecutor {
    private EpicPl plugin;

    public ComandoHammer(EpicPl plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Este comando solo puede ser ejecutado por jugadores.");
            return true;
        }

        Player player = (Player) sender;
        ItemStack banHammer = createBanHammer();

        if(player.hasPermission("epicpl.hammer")) {
            if (banHammer != null) {
                player.getInventory().addItem(banHammer);
                player.sendMessage(ChatColor.GREEN + "Has recibido el Ban Hammer, ¡cuidado con su poder!");
            } else {
                player.sendMessage(ChatColor.RED + "No se pudo obtener el Ban Hammer. Contacta al administrador.");
            }

        }
        return true;
    }

    private ItemStack createBanHammer() {
        ItemStack banHammer = new ItemStack(Material.STICK);
        ItemMeta meta = banHammer.getItemMeta();
        meta.setCustomModelData(270823); // Cambiar a tu valor de CustomModelData

        if (meta != null) {
            meta.setDisplayName(ChatColor.RED + "Ban Hammer");
            banHammer.setItemMeta(meta);
            return banHammer;
        }
        return null;
    }
}