package com.example.assignment.service;

import com.example.assignment.entity.Author;
import com.example.assignment.entity.Book;
import com.example.assignment.repository.AuthorRepository;
import com.example.assignment.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void shouldCreateBookWithAuthor() {
        Author author = new Author();
        author.setId(1L);
        author.setName("Service Author");
        author.setEmail("service@author.com");
        author.setExpertise("Services");

        Book book = new Book();
        book.setTitle("Service Testing");
        book.setIsbn("SER-ISBN-001");
        book.setPrice(320.0);

        when(authorRepository.findById(1L)).thenReturn(Optional.of(author));
        when(bookRepository.save(book)).thenReturn(book);

        Book saved = bookService.save(book, 1L);

        Assertions.assertEquals("Service Testing", saved.getTitle());
        Assertions.assertEquals(1L, saved.getAuthor().getId());
    }
}
