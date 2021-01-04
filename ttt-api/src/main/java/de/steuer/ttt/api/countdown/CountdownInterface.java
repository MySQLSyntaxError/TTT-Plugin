package de.steuer.ttt.api.countdown;

import java.util.function.Consumer;

/**
 * @author Steuer
 */

public interface CountdownInterface {

    Consumer<Boolean> getConsumer();

    void run();

    void cancel();

    int getTaskId();

    CountdownInterface setDelay(long delay);

    CountdownInterface setRepeat(long repeat);

    CountdownInterface setSeconds(int seconds);

    CountdownInterface setMessage(String message);
    CountdownInterface setOneSecondMessage(String oneSecondMessage);

}
