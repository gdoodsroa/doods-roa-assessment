package com.jupitertoys.actions;

import com.jupitertoys.pages.HomePage;
import com.jupitertoys.pages.NavigationBar;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

public class Navigate {

    public static Performable goToHomePage() {
        return Task.where("{0} Opens the Jupiter Toys Home Page",
                Open.browserOn().the(HomePage.class));
    }

    public static Performable goToShop() {
        return Task.where("{0} Navigates to Shop",
                Click.on(NavigationBar.SHOP_LINK));
    }

    public static Performable goToContact() {
        return Task.where("{0} Navigates to Contact",
                Click.on(NavigationBar.CONTACT_LINK));
    }

    public static Performable goToLogin() {
        return Task.where("{0} Navigates to Login",
                Click.on(NavigationBar.LOGIN_LINK));
    }

    public static Performable goToCart() {
        return Task.where("{0} Navigates to Cart",
                Click.on(NavigationBar.CART_LINK));
    }
}
