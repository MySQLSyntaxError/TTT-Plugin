package de.steuer.ttt.core.game;

import de.steuer.ttt.api.countdown.CountdownInterface;
import de.steuer.ttt.api.game.GameInterface;
import de.steuer.ttt.api.game.GameState;
import de.steuer.ttt.api.role.Role;
import de.steuer.ttt.api.serialization.SerializedLocation;
import de.steuer.ttt.core.TTTPlugin;
import org.bukkit.entity.Player;

import java.util.*;

/**
 * @author Steuer
 */
public class GameImpl implements GameInterface {

    private final TTTPlugin tttPlugin;

    private GameState gameState;

    private List<Player> onlinePlayers;

    private Map<UUID, Role> spectatorPlayers;
    private Map<UUID, Role> alivePlayers;

    private SerializedLocation lobbySpawn;
    private SerializedLocation endingSpawn;

    private SerializedLocation traitorTestThrowback;
    private SerializedLocation traitorTestButton;

    private List<SerializedLocation> traitorTestBlocks;
    private List<SerializedLocation> traitorTestGlassLocations;
    private List<SerializedLocation> spawnLocations;

    public GameImpl(TTTPlugin tttPlugin, GameState gameState, SerializedLocation lobbySpawn, SerializedLocation endingSpawn, SerializedLocation traitorTestThrowback, SerializedLocation traitorTestButton, List<SerializedLocation> traitorTestBlocks, List<SerializedLocation> traitorTestGlassLocations, List<SerializedLocation> spawnLocations) {
        this.tttPlugin = tttPlugin;
        this.gameState = gameState;
        this.onlinePlayers = new ArrayList<>();
        this.spectatorPlayers = new HashMap<>();
        this.alivePlayers = new HashMap<>();
        this.lobbySpawn = lobbySpawn;
        this.endingSpawn = endingSpawn;
        this.traitorTestThrowback = traitorTestThrowback;
        this.traitorTestButton = traitorTestButton;
        this.traitorTestBlocks = traitorTestBlocks;
        this.traitorTestGlassLocations = traitorTestGlassLocations;
        this.spawnLocations = spawnLocations;
    }

    @Override
    public void calculateRoles() {
        int traitors = (int) Math.round(Math.log(onlinePlayers.size()) * 1.2);
        int detectives = (int) Math.round(Math.log(onlinePlayers.size()) * 0.75);
        int innocents = onlinePlayers.size() - traitors - detectives;

        Collections.shuffle(onlinePlayers);

        int counter = 0;

        for(int i = 0; i < traitors; i++) {
            alivePlayers.put(onlinePlayers.get(i).getUniqueId(), Role.TRAITOR);
            counter++;
        }

        for(int i = 0; i < detectives; i++) {
            alivePlayers.put(onlinePlayers.get(counter).getUniqueId(), Role.DETECTIVE);
            counter++;
        }

        for(int i = 0; i < innocents; i++) {
            alivePlayers.put(onlinePlayers.get(counter).getUniqueId(), Role.INNOCENT);
            counter++;
        }
    }

    @Override
    public void addOnlinePlayer(Player player) {
        this.onlinePlayers.add(player);
    }

    @Override
    public void addAlivePlayer(Player player, Role role) {
        this.alivePlayers.put(player.getUniqueId(), role);
    }

    @Override
    public void addSpectatorPlayer(Player player, Role role) {
        this.spectatorPlayers.put(player.getUniqueId(), role);
    }

    @Override
    public void startCountdown(CountdownInterface countdownInterface) {
        countdownInterface.run();
        countdownInterface.cancel();
    }

    @Override
    public List<Player> getOnlinePlayers() {
        return this.onlinePlayers;
    }

    @Override
    public Map<UUID, Role> getSpectatorPlayers() {
        return this.spectatorPlayers;
    }

    @Override
    public Map<UUID, Role> getAlivePlayers() {
        return this.alivePlayers;
    }

    @Override
    public SerializedLocation getLobbySpawn() {
        return this.lobbySpawn;
    }

    @Override
    public SerializedLocation getEndingSpawn() {
        return this.endingSpawn;
    }

    @Override
    public List<SerializedLocation> getTraitorTestBlocks() {
        return this.traitorTestBlocks;
    }

    @Override
    public SerializedLocation getTraitorTestThrowback() {
        return this.traitorTestThrowback;
    }

    @Override
    public SerializedLocation getTraitorTestButton() {
        return this.traitorTestButton;
    }

    @Override
    public List<SerializedLocation> getTraitorTestGlassLocations() {
        return this.traitorTestGlassLocations;
    }

    @Override
    public List<SerializedLocation> getSpawnLocations() {
        return this.spawnLocations;
    }

    @Override
    public GameState getGameState() {
        return this.gameState;
    }

    @Override
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
