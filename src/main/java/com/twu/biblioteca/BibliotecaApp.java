package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Prompt prompt = new Prompt(System.out);
        prompt.printWelcomeMessage();
        prompt.listAllBooksWithAuthorAndPublicationYear();
    }
}
