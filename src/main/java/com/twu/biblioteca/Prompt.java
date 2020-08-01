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
        this.printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void listAllBooks() {
        printStream.println(library.getBookListString());
    }
}
