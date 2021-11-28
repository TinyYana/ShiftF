package io.github.tinyyana.shiftf;

import io.github.tinyyana.shiftf.commands.Reload;
import io.github.tinyyana.shiftf.listeners.SneakSwapListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;

public final class ShiftFPlugin extends JavaPlugin {

    public static ShiftFPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        configLoader();
        getServer().getPluginManager().registerEvents(new SneakSwapListener(), this);
        Objects.requireNonNull(getCommand("shiftReload")).setExecutor(new Reload());
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    private void configLoader() {
        File config = new File(this.getDataFolder().getPath(), File.separator + "config.yml");
        if (!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }
        saveConfig();
    }

    public static ShiftFPlugin getInstance() {
        return instance;
    }
}
