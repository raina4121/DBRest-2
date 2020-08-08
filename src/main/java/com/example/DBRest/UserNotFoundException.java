package com.example.DBRest;

public class UserNotFoundException extends Exception {
    private String userId;

    public UserNotFoundException(Integer userId) {
        super(String.format("User not found: %s", userId));
    }

    public UserNotFoundException(String userId) {
    }
}