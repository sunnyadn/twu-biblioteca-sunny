package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Prompt prompt = new Prompt(System.out);
        prompt.printWelcomeMessage();
        if (prompt.askForLogin()) {
            boolean unfinished = true;
            while (unfinished) {
                prompt.showMainMenu();
                unfinished = prompt.askForOption();
            }
        }
    }
}
