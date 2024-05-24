package com.jupitertoys.constants;

public class ContactAlerts {

    public static final String PAGE_ERROR_ALERT_MESSAGE = "We welcome your feedback - but we won't get it unless you complete the form correctly.";
    public static final String FORENAME_FIELD_ERROR_MESSAGE = "Forename is required";
    public static final String EMAIL_FIELD_ERROR_MESSAGE = "Email is required";
    public static final String MESSAGE_FIELD_ERROR_MESSAGE = "Message is required";
    public static final String PAGE_SUCCESS_ALERT_MESSAGE_1 = "Thanks ";
    public static final String PAGE_SUCCESS_ALERT_MESSAGE_2 = ", we appreciate your feedback.";

    public static String getSuccessAlertMessage (String name) {
        return PAGE_SUCCESS_ALERT_MESSAGE_1 + name + PAGE_SUCCESS_ALERT_MESSAGE_2;
    }
}
