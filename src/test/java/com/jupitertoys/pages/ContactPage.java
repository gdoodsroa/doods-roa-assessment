package com.jupitertoys.pages;


import org.openqa.selenium.By;

public class ContactPage {

    public static final By PAGE_ERROR_ALERT = By.cssSelector(".alert.alert-error.ng-scope");
    public static final By FORENAME_FIELD = By.cssSelector("#forename");
    public static final By FORENAME_FIELD_ERROR = By.cssSelector("#forename-err");
    public static final By SURNAME_FIELD = By.cssSelector(" #surname");
    public static final By EMAIL_FIELD = By.cssSelector("#email");
    public static final By EMAIL_FIELD_ERROR = By.cssSelector("#email-err");
    public static final By TELEPHONE_FIELD = By.cssSelector("#telephone");
    public static final By MESSAGE_FIELD = By.cssSelector("#message");
    public static final By MESSAGE_FIELD_ERROR = By.cssSelector("#message-err");
    public static final By SUBMIT_BTN = By.cssSelector(".btn-contact.btn.btn-primary");
    public static final By PAGE_SUCCESS_ALERT = By.cssSelector(".alert.alert-success");
}
