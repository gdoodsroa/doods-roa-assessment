package com.jupitertoys.pages;

import org.openqa.selenium.By;

public class ShopPage {

    public static By PRODUCT_LIST = By.cssSelector("li.product.ng-scope");
    public static By PRODUCT_TITLE = By.cssSelector("h4.product-title.ng-binding");
    public static By PRODUCT_PRICE = By.cssSelector(".product-price.ng-binding");
    public static By BUY_BUTTON = By.cssSelector("a.btn.btn-success");
    public static By TEDDY_BEAR_BUY_BTN = By.xpath("//li[@class='product ng-scope'][1]/div/p/a");
    public static By STUFFED_FROG_BUY_BTN = By.xpath("//li[@class='product ng-scope'][2]/div/p/a");
    public static By HANDMADE_DOLL_BUY_BTN = By.xpath("//li[@class='product ng-scope'][3]/div/p/a");
    public static By FLUFFY_BUNNY_BUY_BTN = By.xpath("//li[@class='product ng-scope'][4]/div/p/a");
    public static By SMILEY_BEAR_BUY_BTN = By.xpath("//li[@class='product ng-scope'][5]/div/p/a");
    public static By FUNNY_COW_BUY_BTN = By.xpath("//li[@class='product ng-scope'][6]/div/p/a");
    public static By VALENTINE_BEAR_BUY_BTN = By.xpath("//li[@class='product ng-scope'][7]/div/p/a");
    public static By SMILE_FACE_BUY_BTN = By.xpath("//li[@class='product ng-scope'][8]/div/p/a");

}
