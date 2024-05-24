package com.jupitertoys.acceptancetest;

import com.jupitertoys.actions.ContactActions;
import com.jupitertoys.actions.Navigate;
import com.jupitertoys.actions.WaitFor;
import com.jupitertoys.constants.ContactAlerts;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.jupitertoys.constants.ContactAlerts.*;
import static com.jupitertoys.pages.ContactPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class TestCase1 {

    @CastMember
    Actor customer;

    @ParameterizedTest
    @DisplayName("Should be able to validate Contact page error messages")
    @CsvSource({
            "John, Doe, john.doe@test.com, 0123456789, Very Satisfied",
    })
    public void testCase1(String forename, String surname, String email, String telephone, String message) {
        givenThat(customer).attemptsTo(Navigate.goToHomePage());
        and(customer).attemptsTo(
                Navigate.goToContact()
        );

        when(customer).attemptsTo(
            ContactActions.leaveContactFieldsAndSubmit()
        );

        then(customer).attemptsTo(
            Ensure.that(PAGE_ERROR_ALERT).textContent().contains(PAGE_ERROR_ALERT_MESSAGE),
            Ensure.that(FORENAME_FIELD_ERROR).textContent().contains(FORENAME_FIELD_ERROR_MESSAGE),
            Ensure.that(EMAIL_FIELD_ERROR).textContent().contains(EMAIL_FIELD_ERROR_MESSAGE),
            Ensure.that(MESSAGE_FIELD_ERROR).textContent().contains(MESSAGE_FIELD_ERROR_MESSAGE)
        );

        when(customer).attemptsTo(
            ContactActions.fillUpContactFields(forename, surname, email, telephone, message)
        );

        then(customer).attemptsTo(
                Ensure.that(PAGE_ERROR_ALERT).isNotDisplayed(),
                Ensure.that(FORENAME_FIELD_ERROR).isNotDisplayed(),
                Ensure.that(EMAIL_FIELD_ERROR).isNotDisplayed(),
                Ensure.that(MESSAGE_FIELD_ERROR).isNotDisplayed()
        );
    }
}