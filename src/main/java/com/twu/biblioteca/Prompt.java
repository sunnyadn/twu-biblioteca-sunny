package com.twu.biblioteca;

import java.io.PrintStream;

public class Prompt {

    private final PrintStream printStream;
    private final StubableScanner inputScanner;
    private final Library library;

    public Prompt(PrintStream printStream, StubableScanner inputScanner) {
        this.printStream = printStream;
        this.inputScanner = inputScanner;
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
        Book[] books = library.getBooks();

        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            printStream.println((i + 1) + ". " + book.getTitle()
                    + "/" + book.getAuthor() + "/" + book.getPublicationYear());
        }
    }

    public void showMainMenu() {
        printStream.println("\n1. List of books\n");
        printStream.println("Please Enter Your Option Number to Continue:");
    }

    public void askForOption() {
        int option = inputScanner.nextInt();
        if (option == 1) {
            listAllBooksWithAuthorAndPublicationYear();
        } else {
            printStream.println("Error: Not a Option Number!");
        }
    }
}
