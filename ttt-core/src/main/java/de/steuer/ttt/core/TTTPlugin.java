package de.steuer.ttt.core;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import de.steuer.ttt.api.game.GameInterface;
import de.steuer.ttt.api.game.GameState;
import de.steuer.ttt.core.countdown.CountdownImpl;
import de.steuer.ttt.core.game.GameImpl;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author Steuer
 */

public class TTTPlugin extends JavaPlugin implements TTTPluginInterface {

    private TTTPlugin instance;

    public static String PREFIX = "§cTTT §8>> §7";

    private GameInterface game;

    private ScheduledExecutorService executorService;

    @Override
    public void onLoad() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        this.executorService = Executors.newScheduledThreadPool(0, new ThreadFactoryBuilder().setNameFormat("TTT-Worker-%d").setDaemon(true).build());

        this.game.setGameState(GameState.WAITING);
    }

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {

    }

    public GameInterface getGame() {
        return game;
    }

    public TTTPlugin getInstance() {
        return instance;
    }

    @Override
    public ScheduledExecutorService getExecutorService() {
        return null;
    }

    @Override
    public Class<?> getCustomLocaleProviderClass() {
        try {
            return Class.forName(this.getConfig().getString("customLocaleProviderClass"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
