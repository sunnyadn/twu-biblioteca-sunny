package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String number;
    private final String password;
    private final List<Book> checkedBooks = new ArrayList<>();
    private final String name;
    private final String email;
    private final String phone;

    public User(String number, String password, String name, String email, String phone) {
        this.number = number;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getNumber() {
        return number;
    }

    public boolean passwordIs(String password) {
        return this.password.equals(password);
    }

    public List<Book> getCheckedBooks() {
        return checkedBooks;
    }

    public void addCheckedBook(Book book) {
        checkedBooks.add(book);
    }

    public void removeCheckedBook(Book book) {
        checkedBooks.remove(book);
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
