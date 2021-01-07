package de.steuer.ttt.core.listener;

import de.steuer.ttt.api.game.GameState;
import de.steuer.ttt.core.TTTPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * @author Steuer
 */
public class PlayerLoginListener implements Listener {

    private final TTTPlugin tttPlugin;

    public PlayerLoginListener(TTTPlugin tttPlugin) {
        this.tttPlugin = tttPlugin;
    }

    @EventHandler
    public void onPlayerLogin(final PlayerLoginEvent event) {
        if(tttPlugin.getGame().getGameState().equals(GameState.ENDING)) {
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§cThe game you tried to join is already ending");
            return;
        }

        if(tttPlugin.getGame().getGameState().equals(GameState.WAITING)) {
            if(tttPlugin.getGame().getOnlinePlayers().size() >= tttPlugin.getConfig().getInt("game.maxPlayers")) {
                event.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§cThe game you tried to join is full");
                return;
            }
        }
    }
}
