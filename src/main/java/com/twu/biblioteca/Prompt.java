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
        printStream.println(library.getBookTitleListString());
    }

    public void listAllBooksWithAuthorAndPublicationYear() {
        String result = "1. Fundamentals of Software Architecture/Mark Richards & Neal Ford/2020\n"
                + "2. EDGE: Value-driven digital transformation/Jim Highsmith, Linda Luu & David Robinson/2019\n"
                + "3. Digital Transformation Game Plan/Gary O'Brien, Guo Xiao & Mike Mason/2019\n";

        printStream.println(result);
    }
}
