package com.twu.biblioteca;

import java.io.PrintStream;

public class Prompt {

    private final PrintStream printStream;

    public Prompt(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printWelcomeMessage() {
        this.printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void listAllBooks() {
        this.printStream.println("1. Fundamentals of Software Architecture");
        this.printStream.println("2. EDGE: Value-driven digital transformation");
        this.printStream.println("3. Digital Transformation Game Plan");
    }
}
