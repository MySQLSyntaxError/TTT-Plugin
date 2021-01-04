package de.steuer.ttt.core;

import de.steuer.ttt.api.TTTAPIInterface;

import java.util.concurrent.ScheduledExecutorService;

/**
 * @author Steuer
 */
public interface TTTPluginInterface extends TTTAPIInterface {

    ScheduledExecutorService getExecutorService();

    Class<?> getCustomLocaleProviderClass();

}
