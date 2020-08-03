package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class LibraryTest {
    @Test
    public void shouldCheckedOutWhenInputExistingBook() {
        // Arrange
        Library library = new Library();
        // Action
        boolean success = library.checkOutBook("Fundamentals of Software Architecture");
        boolean available = library.findBook("Fundamentals of Software Architecture").isAvailable();
        // Assert
        assertThat(success, is(true));
        assertThat(available, is(false));
    }

    @Test
    public void shouldNotCheckedOutWhenBookDoseNotExist() {
        // Arrange
        Library library = new Library();
        // Action
        boolean success = library.checkOutBook("Fundamentals");
        // Assert
        assertThat(success, is(false));
    }

    @Test
    public void shouldReturnBookWhenReturnUnavailableBook() {
        // Arrange
        Library library = new Library();
        library.checkOutBook("Fundamentals of Software Architecture");
        // Action
        boolean success = library.returnBook("Fundamentals of Software Architecture");
        // Assert
        assertThat(success, is(true));
    }

    @Test
    public void shouldReturnBookWhenReturnBookDoesNotExist() {
        // Arrange
        Library library = new Library();
        // Action
        boolean success = library.returnBook("A Non-existing Book");
        // Assert
        assertThat(success, is(false));
    }

    @Test
    public void shouldCheckedOutWhenInputExistingMovie() {
        // Arrange
        Library library = new Library();
        // Action
        boolean success = library.checkoutMovie("The Shawshank Redemption");
        boolean available = library.findMovie("The Shawshank Redemption").isAvailable();
        // Assert
        assertThat(success, is(true));
        assertThat(available, is(false));
    }

    @Test
    public void shouldLogin() {
        // Arrange
        Library library = new Library();
        // Action
        User user = library.login("001-0002", "password");
        // Assert
        assertThat(user, is(notNullValue()));
        assertThat(user.getNumber(), is("001-0002"));
    }

    @Test
    public void shouldNotLoginWithNonExistUserNumber() {
        // Arrange
        Library library = new Library();
        // Action
        User user = library.login("001-8888", "password");
        // Assert
        assertThat(user, is(nullValue()));
    }
}
