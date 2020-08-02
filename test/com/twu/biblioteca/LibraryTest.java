package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LibraryTest {
    @Test
    public void shouldCheckedOutWhenInputExistingBook() {
        // Arrange
        Library library = new Library();
        // Action
        boolean success = library.checkOutBook("Fundamentals of Software Architecture");
        // Assert
        assertThat(success, is(true));
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
}
