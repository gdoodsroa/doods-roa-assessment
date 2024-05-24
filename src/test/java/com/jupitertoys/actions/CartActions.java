package com.jupitertoys.actions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;


import java.util.List;

import static com.jupitertoys.pages.CartPage.*;
import static jxl.biff.FormatRecord.logger;

public class CartActions extends UIInteractionSteps {

    static WebDriver driver;

    public CartActions(WebDriver driver){
        CartActions.driver = driver;
    }

    public static boolean isSubTotalComputationCorrect(String product) {
        for (WebElement e : driver.findElements(CART_ITEM_LIST)) {
            if (e.findElement(CART_ITEM_NAME).getText().equalsIgnoreCase(product)) {

                //Get Values of Price, Quantity and Actual Subtotal from WebElements
                String price = e.findElement(CART_ITEM_PRICE).getText().trim().replaceAll("[^0-9.\\-]", "");
                String quantity = e.findElement(CART_ITEM_QUANTITY).getAttribute("value").toString();
                String subtotalActual = e.findElement(CART_ITEM_SUBTOTAL).getText().trim().replaceAll("[^0-9.\\-]", "");

                //Expected Subtotal = Price * Quantity
                float subTotalExpected = BigDecimal.valueOf((Float.parseFloat(price)) * (Float.parseFloat(quantity)))
                        .setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
                logger.info("Expected Subtotal for " + product + ": " + subTotalExpected + ", Actual Subtotal: "
                        + subtotalActual);

                //Compare Expected Subtotal and Actual Subtotal
                if (subTotalExpected == Float.parseFloat(subtotalActual)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isTotalPriceComputationCorrect() {
        //Get Value for Actual Total Price from WebElement
        double totalActual = Double
                .parseDouble(driver.findElement(CART_ITEM_TOTAL).getText().trim().replaceAll("[^0-9.\\-]", ""));
        double totalExpected = 0.0;
        List<WebElement> subtotalList = driver.findElements(CART_ITEM_SUBTOTAL);

        //Add all Subtotals to get Expected Total Price
        for (WebElement e : subtotalList) {
            double subTotalValue = Double.parseDouble(e.getText().trim().replaceAll("[^0-9.\\-]", ""));
            totalExpected = totalExpected + subTotalValue;
        }

        //Compare Expected Total Price and Actual Total Price
        if (totalExpected == totalActual) {
            logger.info("Expected Total Price: " + totalExpected + ", Actual Total Price: " + totalActual);
            return true;
        }
        return false;
    }
}
