package com.twu.biblioteca;

public class Library {

    private final String[] books = {
            "Fundamentals of Software Architecture",
            "EDGE: Value-driven digital transformation",
            "Digital Transformation Game Plan"
    };


    public String getBookListString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < books.length; i++) {
            result.append(i + 1).append(". ").append(books[i]).append("\n");
        }

        return result.toString();
    }
}
