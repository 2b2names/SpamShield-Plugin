package me.tiger.spamshield;

import me.tiger.spamshield.listener.ChatListener;
import me.tiger.spamshield.command.ToggleCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpamShield extends JavaPlugin {

    private static SpamShield instance;
    private boolean enabled = true;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        // Register chat listener
        getServer().getPluginManager().registerEvents(new ChatListener(), this);

        // Register command
        getCommand("spamshield").setExecutor(new ToggleCommand());

        getLogger().info("SpamShield enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("SpamShield disabled!");
    }

    public static SpamShield getInstance() {
        return instance;
    }

    public boolean isEnabledFilter() {
        return enabled;
    }

    public void setEnabledFilter(boolean enabled) {
        this.enabled = enabled;
    }
}
