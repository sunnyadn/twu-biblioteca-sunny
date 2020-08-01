package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PromptTest {

    @Test
    public void shouldPrintWelcomeMessage() {
        // Arrange
        PrintStream printStream = mock(PrintStream.class);
        Prompt prompt = new Prompt(printStream);
        // Action
        prompt.printWelcomeMessage();
        // Assert
        verify(printStream).println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    public void shouldListAllBooks() {
        // Arrange
        PrintStream printStream = mock(PrintStream.class);
        Prompt prompt = new Prompt(printStream);
        // Action
        prompt.listAllBooks();
        // Assert
        verify(printStream).println("1. Fundamentals of Software Architecture");
        verify(printStream).println("2. EDGE: Value-driven digital transformation");
        verify(printStream).println("3. Digital Transformation Game Plan");
    }
}
