package com.example.assignment.service;

import com.example.assignment.entity.Author;
import com.example.assignment.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public Author findById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Author not found"));
    }

    public Author update(Long id, Author updatedAuthor) {
        Author existing = findById(id);
        existing.setName(updatedAuthor.getName());
        existing.setEmail(updatedAuthor.getEmail());
        existing.setExpertise(updatedAuthor.getExpertise());
        return authorRepository.save(existing);
    }
}
