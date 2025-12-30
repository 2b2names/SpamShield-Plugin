package me.tiger.spamshield.listener;

import me.tiger.spamshield.SpamShield;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ChatListener implements Listener {

    private final Map<UUID, String> lastMessage = new HashMap<>();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();

        String previous = lastMessage.get(player.getUniqueId());

        // Cancel message if it's identical to the last one
        if (previous != null && message.equalsIgnoreCase(previous)) {
            event.setCancelled(true);
            return;
        }

        lastMessage.put(player.getUniqueId(), message);
    }
}
