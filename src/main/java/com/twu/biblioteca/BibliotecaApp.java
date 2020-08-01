package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        StubableScanner inputScanner = new StubableScanner(new Scanner(System.in));
        Prompt prompt = new Prompt(System.out, inputScanner);
        prompt.printWelcomeMessage();
        prompt.showMainMenu();
    }
}
