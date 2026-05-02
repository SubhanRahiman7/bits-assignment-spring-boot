package com.example.assignment.repository;

import com.example.assignment.entity.Author;
import com.example.assignment.entity.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void shouldReturnInnerJoinResultsForBooksAndAuthors() {
        Author author = new Author();
        author.setName("Repo Tester");
        author.setEmail("repo@test.com");
        author.setExpertise("Testing");
        Author savedAuthor = authorRepository.save(author);

        Book book = new Book();
        book.setTitle("Repository Driven Testing");
        book.setIsbn("REPO-ISBN-001");
        book.setPrice(250.0);
        book.setAuthor(savedAuthor);
        bookRepository.save(book);

        List<BookAuthorView> results = bookRepository.findBooksWithAuthorDetails();

        Assertions.assertFalse(results.isEmpty());
        Assertions.assertTrue(results.stream().anyMatch(row ->
                "Repository Driven Testing".equals(row.getTitle())
                        && "Repo Tester".equals(row.getAuthorName())));
    }
}
