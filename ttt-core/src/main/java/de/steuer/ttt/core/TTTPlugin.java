package de.steuer.ttt.core;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import de.steuer.ttt.api.countdown.CountdownInterface;
import de.steuer.ttt.api.countdown.CountdownType;
import de.steuer.ttt.api.game.GameInterface;
import de.steuer.ttt.api.game.GameState;
import de.steuer.ttt.api.locale.LocaleProviderInterface;
import de.steuer.ttt.core.countdown.CountdownImpl;
import de.steuer.ttt.core.game.GameImpl;
import de.steuer.ttt.core.locale.LocaleProviderStrategy;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author Steuer
 */

public class TTTPlugin extends JavaPlugin implements TTTPluginInterface {

    private TTTPlugin instance;

    public static String PREFIX = "§cTTT §8>> §7";

    public static YamlConfiguration CONFIGURATION;
    public static String LOCALE;

    private GameInterface game;

    private LocaleProviderInterface localeProviderInterface;

    private ScheduledExecutorService executorService;

    private Map<CountdownType, CountdownInterface> countdowns;

    @Override
    public void onLoad() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        this.executorService = Executors.newScheduledThreadPool(0, new ThreadFactoryBuilder().setNameFormat("TTT-Worker-%d").setDaemon(true).build());

        this.game.setGameState(GameState.WAITING);

        LOCALE = getConfig().getString("locale.locale");

        File file = new File(this.getDataFolder(), LOCALE + ".yml");

        CONFIGURATION = YamlConfiguration.loadConfiguration(file);

        String localeProviderStrategy = CONFIGURATION.getString("locale.localeProviderStrategy");

        LocaleProviderStrategy strategy = LocaleProviderStrategy.fromString(localeProviderStrategy);
        try {
            localeProviderInterface = strategy.createProvider(this);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
            Bukkit.getConsoleSender().sendMessage("There is an error while trying to load a locale provider, check your config");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        countdowns = new HashMap<>();
        countdowns.put(CountdownType.WAITING_FOR_PLAYERS, new CountdownImpl(""));
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
        return this.executorService;
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

    public LocaleProviderInterface getLocaleProviderInterface() {
        return localeProviderInterface;
    }
}
