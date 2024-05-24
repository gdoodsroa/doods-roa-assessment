package com.jupitertoys.pages;

import org.openqa.selenium.By;

public class CartPage {

    public static By CART_ITEM_LIST = By.cssSelector("[ng-repeat*='item in cart.items()']");
    public static By CART_ITEM_NAME = By.cssSelector("td:nth-child(1)");
    public static By CART_ITEM_PRICE = By.cssSelector("td:nth-child(2)");
    public static By CART_ITEM_QUANTITY = By.cssSelector("td:nth-child(3) input");
    public static By CART_ITEM_SUBTOTAL = By.cssSelector("td:nth-child(4)");
    public static By CART_ITEM_TOTAL = By.cssSelector("strong.total.ng-binding");
}
