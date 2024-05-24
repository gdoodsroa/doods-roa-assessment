package com.jupitertoys.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.time.Duration;

import static com.jupitertoys.constants.ToyList.*;
import static com.jupitertoys.pages.ShopPage.*;

public class ShopActions extends UIInteractionSteps {

    public static Performable selectProductAndQuantity(String product, int quantity) {
        return Task.where("{0} selects product and buys in quantity",
            actor -> {
                if (product.equalsIgnoreCase(TEDDY_BEAR_PRODUCT)) {
                    for (int i = 0; i < quantity; i++) {
                        actor.attemptsTo(
                            Click.on(TEDDY_BEAR_BUY_BTN),
                            WaitFor.aWhile(Duration.ofSeconds(1)));
                    }
                } else if (product.equalsIgnoreCase(STUFFED_FROG_PRODUCT)) {
                    for (int i = 0; i < quantity; i++) {
                        actor.attemptsTo(
                            Click.on(STUFFED_FROG_BUY_BTN),
                            WaitFor.aWhile(Duration.ofSeconds(1)));
                    }
                } else if (product.equalsIgnoreCase(HANDMADE_DOLL_PRODUCT)) {
                    for (int i = 0; i < quantity; i++) {
                        actor.attemptsTo(
                            Click.on(HANDMADE_DOLL_BUY_BTN),
                            WaitFor.aWhile(Duration.ofSeconds(1)));
                    }
                } else if (product.equalsIgnoreCase(FLUFFY_BUNNY_PRODUCT)) {
                    for (int i = 0; i < quantity; i++) {
                        actor.attemptsTo(
                            Click.on(FLUFFY_BUNNY_BUY_BTN),
                            WaitFor.aWhile(Duration.ofSeconds(1)));
                    }
                } else if (product.equalsIgnoreCase(SMILEY_BEAR_PRODUCT)) {
                    for (int i = 0; i < quantity; i++) {
                        actor.attemptsTo(
                            Click.on(SMILEY_BEAR_BUY_BTN),
                            WaitFor.aWhile(Duration.ofSeconds(1)));
                    }
                } else if (product.equalsIgnoreCase(FUNNY_COW_PRODUCT)) {
                    for (int i = 0; i < quantity; i++) {
                        actor.attemptsTo(
                            Click.on(FUNNY_COW_BUY_BTN),
                            WaitFor.aWhile(Duration.ofSeconds(1)));
                    }
                } else if (product.equalsIgnoreCase(VALENTINE_BEAR_PRODUCT)) {
                    for (int i = 0; i < quantity; i++) {
                            actor.attemptsTo(
                            Click.on(VALENTINE_BEAR_BUY_BTN),
                        WaitFor.aWhile(Duration.ofSeconds(1)));
                    }
                } else if (product.equalsIgnoreCase(SMILE_FACE_PRODUCT)) {
                    for (int i = 0; i < quantity; i++) {
                        actor.attemptsTo(
                            Click.on(SMILE_FACE_BUY_BTN),
                            WaitFor.aWhile(Duration.ofSeconds(1)));
                    }
                }
            });
    }
}
