package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PromptTest {

    @Mock
    PrintStream printStream;

    @Mock
    StubableScanner inputScanner;

    private Prompt prompt;

    @Before
    public void setUp() {
        prompt = new Prompt(printStream, inputScanner);
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
        prompt.listAllBookTitles();
        // Assert
        verify(printStream).println("1. Fundamentals of Software Architecture");
        verify(printStream).println("2. EDGE: Value-driven digital transformation");
        verify(printStream).println("3. Digital Transformation Game Plan");
    }

    @Test
    public void shouldListAllBooksWithAuthorAndPublicationYear() {
        // Arrange

        // Action
        prompt.listAllBooksWithAuthorAndPublicationYear();
        // Assert
        verify(printStream).println("1. Fundamentals of Software Architecture/Mark Richards & Neal Ford/2020");
        verify(printStream).println("2. EDGE: Value-driven digital transformation/"
                + "Jim Highsmith, Linda Luu & David Robinson/2019");
        verify(printStream).println("3. Digital Transformation Game Plan/Gary O'Brien, Guo Xiao & Mike Mason/2019");
    }

    @Test
    public void shouldShowMainMenu() {
        // Arrange

        // Action
        prompt.showMainMenu();
        // Assert
        verify(printStream).println("\n1. List of books\n");
        verify(printStream).println("Please Enter Your Option Number to Continue:");
    }

    @Test
    public void shouldListAllBooksWhenOptionSelected() {
        // Arrange
        when(inputScanner.nextInt()).thenReturn(1);
        // Action
        prompt.askForOption();
        // Assert
        verify(printStream).println("1. Fundamentals of Software Architecture/Mark Richards & Neal Ford/2020");
        verify(printStream).println("2. EDGE: Value-driven digital transformation/"
                + "Jim Highsmith, Linda Luu & David Robinson/2019");
        verify(printStream).println("3. Digital Transformation Game Plan/Gary O'Brien, Guo Xiao & Mike Mason/2019");
    }
}
