package com.example.DBRest;

public class accountbillpayeeNotFoundException extends Exception {
    private String accountId;

    public accountbillpayeeNotFoundException(String accountId) {
        super(String.format("Account not found: %s", accountId));
    }
}
