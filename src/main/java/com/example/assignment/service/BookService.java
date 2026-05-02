package com.example.assignment.service;

import com.example.assignment.entity.Author;
import com.example.assignment.entity.Book;
import com.example.assignment.repository.AuthorRepository;
import com.example.assignment.repository.BookAuthorView;
import com.example.assignment.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<BookAuthorView> findBooksWithAuthors() {
        return bookRepository.findBooksWithAuthorDetails();
    }

    public Book save(Book book, Long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new NoSuchElementException("Author not found for book"));
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Book not found"));
    }

    public Book update(Long id, Book updatedBook, Long authorId) {
        Book existing = findById(id);
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new NoSuchElementException("Author not found for update"));

        existing.setTitle(updatedBook.getTitle());
        existing.setIsbn(updatedBook.getIsbn());
        existing.setPrice(updatedBook.getPrice());
        existing.setAuthor(author);
        return bookRepository.save(existing);
    }
}
