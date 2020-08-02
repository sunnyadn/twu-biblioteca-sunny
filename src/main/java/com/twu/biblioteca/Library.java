package com.twu.biblioteca;

import java.util.Arrays;

public class Library {

    private final Book[] books = {
            new Book("Fundamentals of Software Architecture", "Mark Richards & Neal Ford",
                    2020),
            new Book("EDGE: Value-driven digital transformation",
                    "Jim Highsmith, Linda Luu & David Robinson", 2019),
            new Book("Digital Transformation Game Plan", "Gary O'Brien, Guo Xiao & Mike Mason",
                    2019)
    };

    public Book[] getBooks() {
        return books;
    }

    public boolean checkOutBook(String bookTitle) {
        for (Book book :
                books) {
            if (book.getTitle().equals(bookTitle)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    return true;
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    public Book findBook(String bookTitle) {
        for (Book book :
                books) {
            if (book.getTitle().equals(bookTitle)) {
                return book;
            }
        }

        return null;
    }

    public Book[] getAvailableBooks() {
        return Arrays.stream(books)
                .filter(Book::isAvailable)
                .toArray(Book[]::new);
    }

    public boolean returnBook(String bookTitle) {
        for (Book book :
                books) {
            if (book.getTitle().equals(bookTitle)) {
                return true;
            }
        }

        return false;
    }
}
