package de.steuer.ttt.api.locale;

/**
 * @author Steuer
 */
public interface LocaleProviderInterface {

    void registerMessage(String locale, String messageId, String message);

    String getMessage(String locale, String messageId, Object... placeholders);

    default String getLocaleProviderStrategy() {
        return "DEFAULT";
    }
}
