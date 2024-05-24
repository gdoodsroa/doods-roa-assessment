package com.jupitertoys.acceptancetest;

import com.jupitertoys.actions.CartActions;
import com.jupitertoys.actions.ShopActions;
import com.jupitertoys.actions.Navigate;
import com.jupitertoys.actions.WaitFor;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SerenityJUnit5Extension.class)
public class TestCase3 {
    @CastMember
    Actor customer;

    @ParameterizedTest
    @DisplayName("Should be able to buy products and validate prices")
    @CsvSource({
            "Stuffed Frog, 2, Fluffy Bunny, 5, Valentine Bear, 3",
    })
    public void testCase3(String firstProduct, int firstProductQty, String secondProduct, int secondProductQty, String thirdProduct, int thirdProductQty) {
        givenThat(customer).attemptsTo(Navigate.goToHomePage());
        and(customer).attemptsTo(
            Navigate.goToShop());

        when(customer).attemptsTo(
            ShopActions.selectProductAndQuantity(firstProduct, firstProductQty),
            ShopActions.selectProductAndQuantity(secondProduct, secondProductQty),
            ShopActions.selectProductAndQuantity(thirdProduct, thirdProductQty));
            WaitFor.aWhile(Duration.ofSeconds(5));

        then(customer).attemptsTo(
            Navigate.goToCart());
            WaitFor.aWhile(Duration.ofSeconds(5));

        Serenity.reportThat("Validate subtotal and total sum is correct",
                () -> {
                    assertTrue(CartActions.isSubTotalComputationCorrect(firstProduct));
                    assertTrue(CartActions.isSubTotalComputationCorrect(secondProduct));
                    assertTrue(CartActions.isSubTotalComputationCorrect(thirdProduct));
                    assertTrue(CartActions.isTotalPriceComputationCorrect());
                });
    }
}
