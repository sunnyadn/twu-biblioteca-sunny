package com.twu.biblioteca;

import java.io.PrintStream;

public class Prompt {

    private final PrintStream printStream;
    private final Library library;

    public Prompt(PrintStream printStream) {
        this.printStream = printStream;
        library = new Library();
    }

    public void printWelcomeMessage() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void listAllBookTitles() {
        Book[] books = library.getBooks();

        for (int i = 0; i < books.length; i++) {
            printStream.println((i + 1) + ". " + books[i].getTitle());
        }
    }

    public void listAllBooksWithAuthorAndPublicationYear() {
        printStream.println("1. Fundamentals of Software Architecture/Mark Richards & Neal Ford/2020");
        printStream.println("2. EDGE: Value-driven digital transformation"
                + "/Jim Highsmith, Linda Luu & David Robinson/2019");
        printStream.println("3. Digital Transformation Game Plan/Gary O'Brien, Guo Xiao & Mike Mason/2019");
    }
}
