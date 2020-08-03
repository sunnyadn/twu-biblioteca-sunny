package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;
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
        verify(printStream).println("\n1. List of books");
        verify(printStream).println("2. Check-out a book");
        verify(printStream).println("3. Return a book");
        verify(printStream).println("4. List of movies");
        verify(printStream).println("5. Check-out a movie");
        verify(printStream).println("0. Exit program\n");
        verify(printStream).println("Please Enter Your Option Number to Continue:");
    }

    @Test
    public void shouldListAllBooksWhenInput1() {
        // Arrange
        prompt.setInputStream(new ByteArrayInputStream("1".getBytes()));
        // Action
        prompt.askForOption();
        // Assert
        verify(printStream).println("1. Fundamentals of Software Architecture/Mark Richards & Neal Ford/2020");
        verify(printStream).println("2. EDGE: Value-driven digital transformation/"
                + "Jim Highsmith, Linda Luu & David Robinson/2019");
        verify(printStream).println("3. Digital Transformation Game Plan/Gary O'Brien, Guo Xiao & Mike Mason/2019");
    }

    @Test
    public void shouldShowErrorWhenInputIncorrectNumber() {
        // Arrange
        prompt.setInputStream(new ByteArrayInputStream("10".getBytes()));
        // Action
        prompt.askForOption();
        // Assert
        verify(printStream).println("Please select a valid option!");
    }

    @Test
    public void shouldShowErrorWhenInputNotAnInteger() {
        // Arrange
        prompt.setInputStream(new ByteArrayInputStream("str".getBytes()));
        // Action
        prompt.askForOption();
        // Assert
        verify(printStream).println("Please select a valid option!");
    }

    @Test
    public void shouldNotQuitWhenInputValidOption() {
        // Arrange
        prompt.setInputStream(new ByteArrayInputStream("1".getBytes()));
        // Action
        boolean unfinished = prompt.askForOption();
        // Assert
        assertThat(unfinished, is(true));
    }

    @Test
    public void shouldNotQuitWhenInputInvalidOption() {
        // Arrange
        prompt.setInputStream(new ByteArrayInputStream("invalid".getBytes()));
        // Action
        boolean unfinished = prompt.askForOption();
        // Assert
        assertThat(unfinished, is(true));
    }

    @Test
    public void shouldExitProgramWhenInputOption0() {
        // Arrange
        prompt.setInputStream(new ByteArrayInputStream("0".getBytes()));
        // Action
        boolean unfinished = prompt.askForOption();
        // Assert
        assertThat(unfinished, is(false));
    }

    @Test
    public void shouldShowSuccessWhenCheckoutBook() {
        // Arrange
        Prompt prompt = new Prompt(printStream);
        prompt.setInputStream(new ByteArrayInputStream("Fundamentals of Software Architecture".getBytes()));
        // Action
        prompt.checkOutBook();
        // Assert
        verify(printStream).println("Please enter book title:");
        verify(printStream).println("Thank you! Enjoy the book");
    }

    @Test
    public void shouldShowFailureWhenCheckoutNonExistBook() {
        // Arrange
        Prompt prompt = new Prompt(printStream);
        prompt.setInputStream(new ByteArrayInputStream("A Non-existing Book".getBytes()));
        // Action
        prompt.checkOutBook();
        // Assert
        verify(printStream).println("Please enter book title:");
        verify(printStream).println("Sorry, that book is not available");
    }

    @Test
    public void shouldShowFailureWhenCheckoutUnavailableBook() {
        // Arrange
        Prompt prompt = new Prompt(printStream);
        prompt.getLibrary().checkOutBook("Fundamentals of Software Architecture");
        prompt.setInputStream(new ByteArrayInputStream("Fundamentals of Software Architecture".getBytes()));
        // Action
        prompt.checkOutBook();
        // Assert
        verify(printStream).println("Please enter book title:");
        verify(printStream).println("Sorry, that book is not available");
    }

    @Test
    public void shouldShowSuccessWhenReturnBook() {
        // Arrange
        Prompt prompt = new Prompt(printStream);
        prompt.getLibrary().checkOutBook("Fundamentals of Software Architecture");
        prompt.setInputStream(new ByteArrayInputStream("Fundamentals of Software Architecture".getBytes()));
        // Action
        prompt.returnBook();
        // Assert
        verify(printStream).println("Please enter book title:");
        verify(printStream).println("Thank you for returning the book");
    }

    @Test
    public void shouldShowFailureWhenReturnNonExistBook() {
        // Arrange
        Prompt prompt = new Prompt(printStream);
        prompt.setInputStream(new ByteArrayInputStream("A Non-existing Book".getBytes()));
        // Action
        prompt.returnBook();
        // Assert
        verify(printStream).println("Please enter book title:");
        verify(printStream).println("This is not a valid book to return.");
    }

    @Test
    public void shouldShowFailureWhenReturnAvailableBook() {
        // Arrange
        Prompt prompt = new Prompt(printStream);
        prompt.setInputStream(new ByteArrayInputStream("Fundamentals of Software Architecture".getBytes()));
        // Action
        prompt.returnBook();
        // Assert
        verify(printStream).println("Please enter book title:");
        verify(printStream).println("This is not a valid book to return.");
    }

    @Test
    public void shouldListAllMoviesWhenInput4() {
        // Arrange
        prompt.setInputStream(new ByteArrayInputStream("4".getBytes()));
        // Action
        prompt.askForOption();
        // Assert
        verify(printStream).println("1. The Shawshank Redemption/1994/Frank Darabont/10");
        verify(printStream).println("2. Farewell My Concubine/1993/Kaige Chen/9");
        verify(printStream).println("3. Forrest Gump/1994/Robert Zemeckis/8");
    }
}
