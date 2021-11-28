package io.github.tinyyana.shiftf.utils;

import io.github.tinyyana.shiftf.ShiftFPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Chat {
    public static void send(CommandSender sender, String message) {
        String content = ShiftFPlugin.getInstance().getConfig().getString("Messages." + message);
        if (content.equalsIgnoreCase("")) return;
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', content));
    }
}
