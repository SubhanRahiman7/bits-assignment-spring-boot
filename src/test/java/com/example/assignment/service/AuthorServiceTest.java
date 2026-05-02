package com.example.assignment.service;

import com.example.assignment.entity.Author;
import com.example.assignment.repository.AuthorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    @Test
    void shouldUpdateAuthorDetails() {
        Author existing = new Author();
        existing.setId(1L);
        existing.setName("Old Name");
        existing.setEmail("old@example.com");
        existing.setExpertise("Old");

        Author updated = new Author();
        updated.setName("New Name");
        updated.setEmail("new@example.com");
        updated.setExpertise("New");

        when(authorRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(authorRepository.save(existing)).thenReturn(existing);

        Author result = authorService.update(1L, updated);

        Assertions.assertEquals("New Name", result.getName());
        Assertions.assertEquals("new@example.com", result.getEmail());
        Assertions.assertEquals("New", result.getExpertise());
    }
}
