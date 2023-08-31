package com.epic.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class EventHammer implements Listener {

    private final Plugin plugin;

    public EventHammer(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (hasBanHammerTag(item)) {
            if (event.getRightClicked() instanceof Player) {
                Player target = (Player) event.getRightClicked();
                plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "ban " + target.getName() + " Baneado por usar Ban Hammer");
            }
        }
    }

    private boolean hasBanHammerTag(ItemStack item) {
        if (item != null && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta.hasCustomModelData()) {
                int customModelData = meta.getCustomModelData();
                return customModelData == 27082023; // Cambiar el valor de la tag NBT
            }
        }
        return false;
    }
}
