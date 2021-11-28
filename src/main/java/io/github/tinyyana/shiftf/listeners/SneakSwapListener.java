package io.github.tinyyana.shiftf.listeners;

import io.github.tinyyana.shiftf.ShiftFPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

import java.util.Objects;

public class SneakSwapListener implements Listener {
    ShiftFPlugin plugin = ShiftFPlugin.getInstance();

    @EventHandler
    public void onItemSwap(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();

        if (!player.isSneaking()) return;

        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        FileConfiguration config = plugin.getConfig();

        if (config.getBoolean("ExecuteByConsole")) {
            event.setCancelled(true);
            Bukkit.dispatchCommand(console, Objects.requireNonNull(config.getString("Command")));
        } else {
            event.setCancelled(true);
            Bukkit.dispatchCommand(player, Objects.requireNonNull(config.getString("Command")));
        }
    }
}
