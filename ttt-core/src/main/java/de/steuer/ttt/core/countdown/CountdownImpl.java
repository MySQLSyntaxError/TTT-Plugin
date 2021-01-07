package de.steuer.ttt.core.countdown;

import de.steuer.ttt.api.countdown.CountdownInterface;
import de.steuer.ttt.core.TTTPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.function.Consumer;

/**
 * @author Steuer
 */

public class CountdownImpl implements CountdownInterface {

    private final TTTPlugin tttPlugin;

    private final Consumer<Boolean> consumer;

    private int taskId;

    private int seconds;

    private String message;
    private String oneSecondMessage;
    private String countdownEndedMessage;

    private long delay = 0;
    private long repeat = 20;

    private boolean started = false;

    public CountdownImpl(TTTPlugin tttPlugin, Consumer<Boolean> consumer, int seconds, String message, String oneSecondMessage, String countdownEndedMessage) {
        this.tttPlugin = tttPlugin;
        this.consumer = consumer;
        this.seconds = seconds;
        this.message = tttPlugin.getLocaleProviderInterface().getMessage(TTTPlugin.LOCALE, "countdowns.")
        this.message = message.replace("${PREFIX}", TTTPlugin.PREFIX);
        this.oneSecondMessage = oneSecondMessage.replace("${PREFIX}", TTTPlugin.PREFIX);
        this.countdownEndedMessage = countdownEndedMessage.replace("${PREFIX}", TTTPlugin.PREFIX);
    }

    @Override
    public Consumer<Boolean> getConsumer() {
        return consumer;
    }

    @Override
    public void run() {
        started = true;

        this.taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(tttPlugin.getInstance(), () -> {
            switch (this.seconds) {
                case 60:
                case 30:
                case 10:
                case 5:
                case 3:
                case 2:
                    this.message = this.message.replace("${SECONDS}", "" + this.seconds);
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', this.message));
                    break;
                case 1:
                    this.oneSecondMessage = this.oneSecondMessage.replace("${SECONDS}", "" + this.seconds);
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', this.oneSecondMessage));
                    break;
                case 0:
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', this.countdownEndedMessage));

                    this.consumer.accept(true);

                    this.cancel();
                    break;
            }

            this.seconds--;
        }, this.delay, this.repeat);
    }

    @Override
    public void cancel() {
        Bukkit.getScheduler().cancelTask(this.taskId);
    }

    @Override
    public int getTaskId() {
        return this.taskId;
    }

    @Override
    public boolean started() {
        return this.started;
    }

    @Override
    public CountdownInterface setDelay(long delay) {
        this.delay = delay;
        return this;
    }

    @Override
    public CountdownInterface setRepeat(long repeat) {
        this.repeat = repeat;
        return this;
    }

    @Override
    public CountdownInterface setSeconds(int seconds) {
        this.seconds = seconds;
        return this;
    }

    @Override
    public CountdownInterface setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public CountdownInterface setOneSecondMessage(String oneSecondMessage) {
        this.oneSecondMessage = oneSecondMessage;
        return this;
    }
}
