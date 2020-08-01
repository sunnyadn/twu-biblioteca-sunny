package com.twu.biblioteca;

import java.util.Scanner;

public class StubableScanner {

    private final Scanner scanner;

    public StubableScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public int nextInt() {
        return scanner.nextInt();
    }
}
