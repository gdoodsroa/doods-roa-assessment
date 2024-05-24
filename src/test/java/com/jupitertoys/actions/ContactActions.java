package com.jupitertoys.actions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.jupitertoys.pages.ContactPage.*;

public class ContactActions {

    public static Performable leaveContactFieldsAndSubmit() {
        return Task.where("{0) leaves contact fields blank and submit.",
                actor -> {
                    actor.attemptsTo(
                            Click.on(SUBMIT_BTN));
                });
    }

    public static Performable fillUpContactFields(String forename, String surname, String email, String telephone, String message) {
        return Task.where("{0) fills up contact page and submit.",
                actor -> {
                    actor.attemptsTo(
                            Enter.theValue(forename).into(FORENAME_FIELD),
                            Enter.theValue(surname).into(SURNAME_FIELD),
                            Enter.theValue(email).into(EMAIL_FIELD),
                            Enter.theValue(telephone).into(TELEPHONE_FIELD),
                            Enter.theValue(message).into(MESSAGE_FIELD));
                });
    }

    public static Performable fillUpContactFieldsAndSubmit(String forename, String surname, String email, String telephone, String message) {
        return Task.where("{0) fills up contact page and submit.",
            actor -> {
                actor.attemptsTo(
                        Enter.theValue(forename).into(FORENAME_FIELD),
                        Enter.theValue(surname).into(SURNAME_FIELD),
                        Enter.theValue(email).into(EMAIL_FIELD),
                        Enter.theValue(telephone).into(TELEPHONE_FIELD),
                        Enter.theValue(message).into(MESSAGE_FIELD),
                        Click.on(SUBMIT_BTN));
        });
    }
}
