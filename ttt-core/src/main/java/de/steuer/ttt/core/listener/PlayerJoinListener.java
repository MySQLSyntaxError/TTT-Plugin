package de.steuer.ttt.core.listener;

import de.steuer.ttt.core.TTTPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author Steuer
 */
public class PlayerJoinListener implements Listener {

    private final TTTPlugin tttPlugin;

    public PlayerJoinListener(TTTPlugin tttPlugin) {
        this.tttPlugin = tttPlugin;
    }

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {
        Player player = event.getPlayer();

        tttPlugin.getGame().addOnlinePlayer(player);

        player.teleport(tttPlugin.getGame().getLobbySpawn().toBukkitLocation(true));

        event.setJoinMessage("");
    }
}
