package com.twu.biblioteca;

public class Book {

    private final String title;

    private final String author;

    private final int publicationYear;

    public boolean isAvailable() {
        return available;
    }

    private boolean available = true;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
