package com.example.DBRest;

public class billpayeeNotFoundException extends Exception {
    private String billpayeeId;

    public billpayeeNotFoundException(String billpayeeId) {
        super(String.format("billpayee not found: %s", billpayeeId));
    }
}
