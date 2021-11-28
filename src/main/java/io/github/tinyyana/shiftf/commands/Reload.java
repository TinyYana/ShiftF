package io.github.tinyyana.shiftf.commands;

import io.github.tinyyana.shiftf.ShiftFPlugin;
import io.github.tinyyana.shiftf.utils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Reload implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        ShiftFPlugin plugin = ShiftFPlugin.getInstance();

        if (!sender.hasPermission("ShiftF.Admin") || !sender.isOp()) {
            Chat.send(sender, "permissionMessage");
            return true;
        }
        plugin.reloadConfig();
        Chat.send(sender, "ReloadSuccess");
        return true;
    }
}
