package com.example.assignment.controller;

import com.example.assignment.entity.Author;
import com.example.assignment.entity.Book;
import com.example.assignment.service.AuthorService;
import com.example.assignment.service.BookService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("/")
public class AssignmentController {
    private final AuthorService authorService;
    private final BookService bookService;

    public AssignmentController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("joinedBooks", bookService.findBooksWithAuthors());
        return "index";
    }

    @GetMapping("/authors/new")
    public String newAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "author-form";
    }

    @PostMapping("/authors")
    public String createAuthor(@ModelAttribute Author author, RedirectAttributes redirectAttributes) {
        try {
            authorService.save(author);
            redirectAttributes.addFlashAttribute("success", "Author created successfully.");
        } catch (DataIntegrityViolationException ex) {
            redirectAttributes.addFlashAttribute("error", "Author email must be unique.");
        }
        return "redirect:/";
    }

    @GetMapping("/authors/edit/{id}")
    public String editAuthorForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("author", authorService.findById(id));
            return "author-edit";
        } catch (NoSuchElementException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:/";
        }
    }

    @PostMapping("/authors/update/{id}")
    public String updateAuthor(@PathVariable Long id, @ModelAttribute Author author, RedirectAttributes redirectAttributes) {
        try {
            authorService.update(id, author);
            redirectAttributes.addFlashAttribute("success", "Author updated successfully.");
        } catch (DataIntegrityViolationException ex) {
            redirectAttributes.addFlashAttribute("error", "Author update failed due to unique constraints.");
        } catch (NoSuchElementException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
        }
        return "redirect:/";
    }

    @GetMapping("/books/new")
    public String newBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.findAll());
        return "book-form";
    }

    @PostMapping("/books")
    public String createBook(@ModelAttribute Book book,
                             @RequestParam("authorId") Long authorId,
                             RedirectAttributes redirectAttributes) {
        try {
            bookService.save(book, authorId);
            redirectAttributes.addFlashAttribute("success", "Book created successfully.");
        } catch (DataIntegrityViolationException ex) {
            redirectAttributes.addFlashAttribute("error", "Book ISBN must be unique.");
        } catch (NoSuchElementException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
        }
        return "redirect:/";
    }

    @GetMapping("/books/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("book", bookService.findById(id));
            model.addAttribute("authors", authorService.findAll());
            return "book-edit";
        } catch (NoSuchElementException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:/";
        }
    }

    @PostMapping("/books/update/{id}")
    public String updateBook(@PathVariable Long id,
                             @ModelAttribute Book book,
                             @RequestParam("authorId") Long authorId,
                             RedirectAttributes redirectAttributes) {
        try {
            bookService.update(id, book, authorId);
            redirectAttributes.addFlashAttribute("success", "Book updated successfully.");
        } catch (DataIntegrityViolationException ex) {
            redirectAttributes.addFlashAttribute("error", "Book update failed due to unique constraints.");
        } catch (NoSuchElementException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
        }
        return "redirect:/";
    }
}
