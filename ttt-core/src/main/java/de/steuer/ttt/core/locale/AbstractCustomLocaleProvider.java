package de.steuer.ttt.core.locale;

import de.steuer.ttt.api.locale.LocaleProviderInterface;
import de.steuer.ttt.api.utils.Duo;
import de.steuer.ttt.core.TTTPlugin;

/**
 * @author Steuer
 */

/**
 * Abstract Class to extend when you have your own locale system on your server
 * Examples how to use it are on github: TODO: Github link to wiki of api
 */

public abstract class AbstractCustomLocaleProvider implements LocaleProviderInterface {

    private final TTTPlugin tttPlugin;

    public AbstractCustomLocaleProvider(TTTPlugin tttPlugin) {
        this.tttPlugin = tttPlugin;
    }

    @Override
    public void registerMessage(String locale, String messageId, String message) {

    }

    @Override
    public String getMessage(String locale, String message, Duo<String, Object>... duos) {
        return null;
    }

    @Override
    public String getLocaleProviderStrategy() {
        return "CUSTOM";
    }

    public TTTPlugin getPlugin() {
        return this.tttPlugin;
    }
}
