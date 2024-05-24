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

import java.time.Duration;

import static com.jupitertoys.pages.ContactPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class TestCase2 {

    @CastMember
    Actor customer;

    @ParameterizedTest
    @DisplayName("Should be able to validate successful submission message and run 5 times to ensure 100% rate")
    @CsvSource({
            "John, Doe, john.doe@test.com, 0123456789, Satisfied",
            "Mary, Jane, mary.jane@test.com, 0132547698, My Order is missing.",
            "Tony, Start, tony.stark@test.com, 0198765432, Missing items",
            "Steve, Rogers, steve.rogers@test.com, 0178923456, Good quality items",
            "Peter, Parker, peter.parker@test.com, 0154329876, career inquiry"
    })
    public void testCase2(String forename, String surname, String email, String telephone, String message) {
        givenThat(customer).attemptsTo(Navigate.goToHomePage());
        and(customer).attemptsTo(
                Navigate.goToContact()
        );

        when(customer).attemptsTo(
                ContactActions.fillUpContactFieldsAndSubmit(forename, surname, email, telephone, message)
            );

        then(customer).attemptsTo(
                    WaitFor.aWhile(Duration.ofSeconds(10)),
                Ensure.that(PAGE_SUCCESS_ALERT).textContent().contains(ContactAlerts.getSuccessAlertMessage(forename))
        );
    }
}
