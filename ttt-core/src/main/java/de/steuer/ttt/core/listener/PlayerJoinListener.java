package de.steuer.ttt.core.listener;

import de.steuer.ttt.api.game.GameState;
import de.steuer.ttt.api.utils.Duo;
import de.steuer.ttt.core.TTTPlugin;
import de.steuer.ttt.core.locale.LocaleProviderStrategy;
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

        int maxPlayers = tttPlugin.getConfig().getInt("game.maxPlayers");
        int minPlayers = tttPlugin.getConfig().getInt("game.minPlayers");

        player.teleport(tttPlugin.getGame().getLobbySpawn().toBukkitLocation(true));

        if(tttPlugin.getGame().getGameState().equals(GameState.WAITING)) {
            tttPlugin.getGame().getOnlinePlayers().add(player);

            event.setJoinMessage(tttPlugin.getLocaleProviderInterface().getMessage(TTTPlugin.LOCALE, "connection.joinMessage", new Duo<>("${PREFIX}", TTTPlugin.PREFIX), new Duo<>("${NAME}", player.getName()), new Duo<>("${ONLINE_PLAYERS}", tttPlugin.getGame().getOnlinePlayers().size()), new Duo<>("${MAX_PLAYERS}", maxPlayers)));

            if(tttPlugin.getGame().getOnlinePlayers().size() >= minPlayers) {

            }
        }
    }
}
