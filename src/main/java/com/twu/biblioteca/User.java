package com.twu.biblioteca;

public class User {
    private final String number;
    private final String password;

    public User(String number, String password) {
        this.number = number;
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public boolean passwordIs(String password) {
        return this.password.equals(password);
    }
}
