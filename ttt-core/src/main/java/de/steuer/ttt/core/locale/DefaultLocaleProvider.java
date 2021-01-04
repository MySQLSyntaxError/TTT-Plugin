package de.steuer.ttt.core.locale;

import de.steuer.ttt.api.locale.LocaleProviderInterface;
import de.steuer.ttt.core.TTTPlugin;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Steuer
 */
public class DefaultLocaleProvider implements LocaleProviderInterface {

    private final TTTPlugin tttPlugin;

    private final File localeDirectory;

    private final Map<String, Map<String, String>> messagesCache;

    public DefaultLocaleProvider(TTTPlugin tttPlugin, File localeDirectory) {
        this.tttPlugin = tttPlugin;
        this.localeDirectory = localeDirectory;

        if(!this.localeDirectory.exists())
            this.localeDirectory.mkdirs();

        this.messagesCache = new HashMap<>();
    }

    @Override
    public void registerMessage(String locale, String messageId, String message) {
        Map<String, String> messagesMap = this.messagesCache.getOrDefault(locale, new HashMap<>());
        messagesMap.put(messageId, message);

        this.messagesCache.put(locale, messagesMap);

        File file = new File(localeDirectory, locale + ".yml");

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        configuration.set(messageId, message);
    }

    @Override
    public String getMessage(String locale, String messageId, Object... placeholders) {
        if(this.messagesCache.containsKey(locale) && this.messagesCache.get(locale).containsKey(messageId))
            return this.messagesCache.get(locale).get(messageId);

        File file = new File(localeDirectory, locale + ".yml");

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        String message = configuration.getString(messageId);

        Map<String, String> messagesMap = this.messagesCache.getOrDefault(locale, new HashMap<>());
        messagesMap.put(messageId, message);

        this.messagesCache.put(locale, messagesMap);

        for(int i = 0; i < placeholders.length; i++)
            message = message.replace("${" + i + "}", "" + placeholders[i]);

        return message;
    }
}
