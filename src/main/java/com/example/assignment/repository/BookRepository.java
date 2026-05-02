package com.example.assignment.repository;

import com.example.assignment.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("""
            select b.title as title,
                   b.isbn as isbn,
                   b.price as price,
                   a.name as authorName,
                   a.email as authorEmail
            from Book b
            inner join b.author a
            order by b.id
            """)
    List<BookAuthorView> findBooksWithAuthorDetails();
}
