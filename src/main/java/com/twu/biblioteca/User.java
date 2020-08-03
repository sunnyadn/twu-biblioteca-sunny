package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String number;
    private final String password;
    private final List<Book> checkedBooks = new ArrayList<>();

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

    public List<Book> getCheckedBooks() {
        return checkedBooks;
    }

    public void addCheckedBook(Book book) {
        checkedBooks.add(book);
    }
}
