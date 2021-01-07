package de.steuer.ttt.core.locale;

import de.steuer.ttt.api.locale.LocaleProviderInterface;
import de.steuer.ttt.core.TTTPluginInterface;

/**
 * @author Steuer
 */
public enum LocaleProviderStrategy {

    DEFAULT("DEFAULT", DefaultLocaleProvider.class),
    CUSTOM("CUSTOM", AbstractCustomLocaleProvider.class);

    private final String key;
    private final Class<? extends LocaleProviderInterface> providerClass;

    LocaleProviderStrategy(String key, Class<? extends LocaleProviderInterface> providerClass) {
        this.key = key;
        this.providerClass = providerClass;
    }

    public static LocaleProviderStrategy fromString(String key) {
        for(LocaleProviderStrategy strategy : values()) {
            if(strategy.key.equalsIgnoreCase(key))
                return strategy;
        }

        throw new IllegalArgumentException("Invalid localeProviderStrategy: " + key);
    }

    public String getKey() {
        return this.key;
    }

    public Class<? extends LocaleProviderInterface> getProviderClass() {
        return this.providerClass;
    }

    public LocaleProviderInterface createProvider(TTTPluginInterface pluginInterface) throws ReflectiveOperationException {
        return this.providerClass.getDeclaredConstructor(TTTPluginInterface.class).newInstance(pluginInterface);
    }
}
