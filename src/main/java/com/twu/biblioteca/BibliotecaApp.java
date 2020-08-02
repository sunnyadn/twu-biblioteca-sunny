package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Prompt prompt = new Prompt(System.out);
        prompt.printWelcomeMessage();
        boolean unfinished = true;
        while (unfinished) {
            prompt.showMainMenu();
            unfinished = prompt.askForOption();
        }
    }
}
