package com.jupitertoys.actions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.time.Duration;

public class WaitFor {

    public static Performable aWhile(Duration duration) {
        return Task.where("{0} waits for page",
            (actor) -> {
                try {
                    Thread.sleep(duration.toMillis());
                } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
