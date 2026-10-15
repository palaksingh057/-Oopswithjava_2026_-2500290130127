package com.kiet.library.service;

import com.kiet.library.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    public BookService() {
        books.add(new Book(201, "Effective Java",
                "Joshua Bloch", "Programming", 2018, true));

        books.add(new Book(202, "Clean Code",
                "Robert C. Martin", "Programming", 2008, true));

        books.add(new Book(203, "The Alchemist",
                "Paulo Coelho", "Fiction", 1988, false));

        books.add(new Book(204, "Introduction to Algorithms",
                "Thomas H. Cormen", "Computer Science", 2022, true));

        books.add(new Book(205, "Wings of Fire",
                "A. P. J. Abdul Kalam", "Biography", 1999, true));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Optional<Book> getBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    public Optional<Book> updateBook(
            int bookId, Book updatedBook) {

        for (Book book : books) {
            if (book.getBookId() == bookId) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setCategory(updatedBook.getCategory());
                book.setPublicationYear(
                        updatedBook.getPublicationYear());
                book.setAvailable(updatedBook.isAvailable());

                return Optional.of(book);
            }
        }

        return Optional.empty();
    }

    public boolean deleteBook(int bookId) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId() == bookId) {
                books.remove(i);
                return true;
            }
        }

        return false;
    }

    public List<Book> searchByCategory(String category) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                result.add(book);
            }
        }

        return result;
    }

    public List<Book> findPublishedFromYear(int fromYear) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getPublicationYear() >= fromYear) {
                result.add(book);
            }
        }

        return result;
    }
}
