package me.tiger.spamshield;

import me.tiger.spamshield.listener.ChatListener; // <- correct import
import org.bukkit.plugin.java.JavaPlugin;

public final class SpamShield extends JavaPlugin {

    private static SpamShield instance;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        // Register chat listener
        getServer().getPluginManager().registerEvents(new ChatListener(), this);

        getLogger().info("SpamShield enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("SpamShield disabled!");
    }

    public static SpamShield getInstance() {
        return instance;
    }
}
