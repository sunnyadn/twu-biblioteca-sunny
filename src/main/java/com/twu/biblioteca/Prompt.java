package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Prompt {

    private final PrintStream printStream;

    private InputStream inputStream = System.in;
    private Scanner scanner = new Scanner(inputStream);

    private final Library library = new Library();

    // For Test Purpose
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
        scanner = new Scanner(inputStream);
    }

    public Prompt(PrintStream printStream) {
        this.printStream = printStream;
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

    private void discardInputBuffer() {
        scanner = new Scanner(inputStream);
    }

    public boolean askForOption() {
        final String PROMPT_FOR_INVALID_INPUT = "Please select a valid option!";
        int option;

        try {
            option = scanner.nextInt();
        } catch (InputMismatchException e) {
            printStream.println(PROMPT_FOR_INVALID_INPUT);
            discardInputBuffer();
            return true;
        }

        if (option == 1) {
            listAllBooksWithAuthorAndPublicationYear();
        } else {
            printStream.println(PROMPT_FOR_INVALID_INPUT);
        }
        return true;
    }
}
