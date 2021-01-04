package de.steuer.ttt.core.locale;

import de.steuer.ttt.api.locale.LocaleProviderInterface;
import de.steuer.ttt.core.TTTPlugin;

/**
 * @author Steuer
 */
public class BaseLocaleProvider implements LocaleProviderInterface {

    private final TTTPlugin tttPlugin;

    public BaseLocaleProvider(TTTPlugin tttPlugin) {
        this.tttPlugin = tttPlugin;
    }

    @Override
    public void registerMessage(String locale, String messageId, String message) {

    }

    @Override
    public String getMessage(String locale, String message, Object... placeholders) {
        return null;
    }

    @Override
    public String getLocaleProviderStrategy() {
        return "CUSTOM";
    }
}
