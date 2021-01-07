package de.steuer.ttt.api.locale;

import de.steuer.ttt.api.utils.Duo;

/**
 * @author Steuer
 */
public interface LocaleProviderInterface {

    void registerMessage(String locale, String messageId, String message);

    String getMessage(String locale, String messageId, Duo<String, Object>... duos);

    default String getLocaleProviderStrategy() {
        return "DEFAULT";
    }
}
