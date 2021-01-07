package de.steuer.ttt.api.game;

import de.steuer.ttt.api.countdown.CountdownInterface;
import de.steuer.ttt.api.role.Role;
import de.steuer.ttt.api.serialization.SerializedLocation;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Steuer
 */

public interface GameInterface {

    /**
     * starting a countdown (Lobby, Grace, End)
     *
     * @param countdownInterface the {@link CountdownInterface} implementation
     */

    void startCountdown(CountdownInterface countdownInterface);

    /**
     * its for calculating the roles for every player
     */

    void calculateRoles();

    /**
     * @return the players that are on the server
     */

    List<Player> getOnlinePlayers();

    /**
     * adds a online player on connect
     *
     * @param player the player that joined
     */

    void addOnlinePlayer(Player player);

    /**
     * @return the players that are already dead
     */

    Map<UUID, Role> getSpectatorPlayers();

    /**
     * adds a spectator player
     *
     * @param player the player that's spectating
     * @param role   the role that the player had
     */

    void addSpectatorPlayer(Player player, Role role);

    /**
     * @return the players that are in game
     */

    Map<UUID, Role> getAlivePlayers();

    /**
     * adds an alive player
     *
     * @param player the player that's alive
     * @param role   the role that the player has
     */

    void addAlivePlayer(Player player, Role role);

    /**
     * @return the location the player will get teleported to when he joins a game
     */

    SerializedLocation getLobbySpawn();

    /**
     * @return the location the players will get teleported to when the game ends
     */

    SerializedLocation getEndingSpawn();

    /**
     * @return the locations of the 3 blocks going away when the traitor test is not in use
     */

    List<SerializedLocation> getTraitorTestBlocks();

    /**
     * @return the location where the player gets teleported to when theres already a player testing
     */

    SerializedLocation getTraitorTestThrowback();

    /**
     * @return the button where to start the traitor test
     */

    SerializedLocation getTraitorTestButton();

    /**
     * @return the two glasses above the traitor test for showing if someone is traitor or not
     */

    List<SerializedLocation> getTraitorTestGlassLocations();

    /**
     * @return all spawn locations as a list
     */

    List<SerializedLocation> getSpawnLocations();

    /**
     * @return the current server's gameState {@link GameState}
     */

    GameState getGameState();

    /**
     * sets the current gameState
     *
     * @param gameState the new gameState
     */

    void setGameState(GameState gameState);

}
