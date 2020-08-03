package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.verify;

public class Prompt {

    final String PROMPT_FOR_INVALID_INPUT = "Please select a valid option!";
    private final PrintStream printStream;
    private final Library library = new Library();
    private InputStream inputStream = System.in;
    private Scanner scanner = new Scanner(inputStream);

    public Prompt(PrintStream printStream) {
        this.printStream = printStream;
    }

    public Library getLibrary() {
        return library;
    }

    // For Test Purpose
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
        scanner = new Scanner(inputStream);
    }

    public boolean askForLogin() {
        printStream.println("Please enter your library number:");
        String number = scanner.nextLine();
        printStream.println("Please enter your password:");
        String password = scanner.nextLine();

        User user = library.login(number, password);
        return user != null;
    }

    public void printWelcomeMessage() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void listAllBookTitles() {
        Book[] books = library.getAvailableBooks();

        for (int i = 0; i < books.length; i++) {
            printStream.println((i + 1) + ". " + books[i].getTitle());
        }
    }

    public void listAllBooksWithAuthorAndPublicationYear() {
        Book[] books = library.getAvailableBooks();

        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            printStream.println((i + 1) + ". " + book.getTitle()
                    + "/" + book.getAuthor() + "/" + book.getPublicationYear());
        }
    }

    public void listAllMovies() {
        Movie[] movies = library.getAvailableMovies();

        for (int i = 0; i < movies.length; i++) {
            Movie movie = movies[i];
            printStream.println((i + 1) + ". " + movie.getName()
                    + "/" + movie.getYear() + "/" + movie.getDirector() + "/" + movie.getRating());
        }
    }

    public void showMainMenu() {
        printStream.println("\n1. List of books");
        printStream.println("2. Check-out a book");
        printStream.println("3. Return a book");
        printStream.println("4. List of movies");
        printStream.println("5. Check-out a movie");
        printStream.println("6. View checked out books");
        printStream.println("7. View my information");
        printStream.println("0. Exit program\n");
        printStream.println("Please Enter Your Option Number to Continue:");
    }

    private void discardInputBuffer() {
        scanner = new Scanner(inputStream);
    }

    private int readOption() {
        int option;

        try {
            option = scanner.nextInt();
        } catch (InputMismatchException e) {
            printStream.println(PROMPT_FOR_INVALID_INPUT);
            discardInputBuffer();
            throw new InputMismatchException();
        }

        return option;
    }

    public void checkOutBook() {
        String title = askForBookTitle();

        if (library.checkOutBook(title)) {
            printStream.println("Thank you! Enjoy the book");
        } else {
            printStream.println("Sorry, that book is not available");
        }
    }

    public boolean askForOption() {
        int option;
        try {
            option = readOption();
        } catch (InputMismatchException e) {
            return true;
        }

        switch (option) {
            case 1:
                listAllBooksWithAuthorAndPublicationYear();
                break;
            case 2:
                checkOutBook();
                break;
            case 3:
                returnBook();
                break;
            case 4:
                listAllMovies();
                break;
            case 5:
                checkOutMovie();
                break;
            case 6:
                showCheckedBooks();
                break;
            case 7:
                showUserInformation();
                break;
            case 0:
                return false;
            default:
                printStream.println(PROMPT_FOR_INVALID_INPUT);
                break;
        }

        return true;
    }

    private void showUserInformation() {
        User user = library.getLoggedUser();
        printStream.println("Name: " + user.getName());
        printStream.println("Email: " + user.getEmail());
        printStream.println("Phone: " + user.getPhone());
    }

    private void showCheckedBooks() {
        List<Book> books = library.getLoggedUser().getCheckedBooks();
        if (books.isEmpty()) {
            printStream.println("No record");
        } else {
            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                printStream.println((i + 1) + ". " + book.getTitle()
                        + "/" + book.getAuthor() + "/" + book.getPublicationYear());
            }
        }
    }

    private void checkOutMovie() {
        printStream.println("Please enter book title:");
        discardInputBuffer();
        String name = scanner.nextLine();

        library.checkoutMovie(name);
    }

    private String askForBookTitle() {
        printStream.println("Please enter book title:");
        discardInputBuffer();
        return scanner.nextLine();
    }

    public void returnBook() {
        String title = askForBookTitle();

        if (library.returnBook(title)) {
            printStream.println("Thank you for returning the book");
        } else {
            printStream.println("This is not a valid book to return.");
        }
    }
}
