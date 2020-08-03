package com.twu.biblioteca;

import java.util.Arrays;

public class Library {

    private final Book[] books = {
            new Book("Fundamentals of Software Architecture", "Mark Richards & Neal Ford",
                    2020),
            new Book("EDGE: Value-driven digital transformation",
                    "Jim Highsmith, Linda Luu & David Robinson", 2019),
            new Book("Digital Transformation Game Plan", "Gary O'Brien, Guo Xiao & Mike Mason",
                    2019)
    };

    private final Movie[] movies = {
            new Movie("The Shawshank Redemption", 1994, "Frank Darabont", 10),
            new Movie("Farewell My Concubine", 1993, "Kaige Chen", 9),
            new Movie("Forrest Gump", 1994, "Robert Zemeckis", 8)
    };

    public boolean checkOutBook(String bookTitle) {
        for (Book book :
                books) {
            if (book.getTitle().equals(bookTitle)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    return true;
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    public boolean checkoutMovie(String name) {
        for (Movie movie:
             movies) {
            if (movie.getName().equals(name)) {
                movie.setAvailable(false);
                return true;
            }
        }

        return false;
    }

    public Book findBook(String bookTitle) {
        for (Book book :
                books) {
            if (book.getTitle().equals(bookTitle)) {
                return book;
            }
        }

        return null;
    }

    public Movie findMovie(String name) {
        for (Movie movie :
                movies) {
            if (movie.getName().equals(name)) {
                return movie;
            }
        }

        return null;
    }

    public Book[] getAvailableBooks() {
        return Arrays.stream(books)
                .filter(Book::isAvailable)
                .toArray(Book[]::new);
    }

    public Movie[] getAvailableMovies() {
        return Arrays.stream(movies)
                .filter(Movie::isAvailable)
                .toArray(Movie[]::new);
    }

    public boolean returnBook(String bookTitle) {
        for (Book book :
                books) {
            if (book.getTitle().equals(bookTitle)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    return true;
                } else {
                    return false;
                }
            }
        }

        return false;
    }
}
