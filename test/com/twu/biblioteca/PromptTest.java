package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PromptTest {

    @Mock
    PrintStream printStream;

    private Prompt prompt;

    @Before
    public void setUp() {
        prompt = new Prompt(printStream);
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        // Arrange

        // Action
        prompt.printWelcomeMessage();
        // Assert
        verify(printStream).println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    public void shouldListAllBooks() {
        // Arrange

        // Action
        prompt.listAllBooks();
        // Assert
        verify(printStream).println("1. Fundamentals of Software Architecture\n"
                + "2. EDGE: Value-driven digital transformation\n"
                + "3. Digital Transformation Game Plan\n");
    }
}
