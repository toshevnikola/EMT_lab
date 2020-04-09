package edu.nikt.lab1.controllers;

import edu.nikt.lab1.exceptions.BookNotFoundException;
import edu.nikt.lab1.models.Book;
import edu.nikt.lab1.models.Category;
import edu.nikt.lab1.services.BookService;
import edu.nikt.lab1.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


@Controller
public class BookController {

    private BookService bookService;
    private CategoryService categoryService;
    public BookController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @GetMapping("/books")
    public String getHome(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }

    @GetMapping(value = "books/add")
    public String getAddBook(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @GetMapping(value = "/books/{id}/delete")
    public String deleteBook(@PathVariable("id") long id, Model model) {
        bookService.removeBook(id);

        return "redirect:/books";
    }

    @GetMapping(value = "/books/{id}/edit")
    public String editBook(@PathVariable("id") long id, Model model) {
        try {
            Book b = bookService.findById(id);
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("book", b);

        } catch (BookNotFoundException ex) {
            return "redirect:/books?error=" + ex.getMessage();
        }

        return "edit-book";
    }

    @PostMapping(value = "/books/{id}/update")
    public String updateBook(@Valid Book book,BindingResult bindingResult, @RequestParam MultipartFile image, Model model) throws IOException {
        if(bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("book", book);
            return "edit-book";
        }
        book.setImg(image);
        Category c = categoryService.findById(book.getCategory().getId());
        book.setCategory(c);
        this.bookService.updateBook(book.getId(), book, image);
        model.addAttribute("categories", categoryService.findAll());
        return "redirect:/books";
    }


    @PostMapping(value = "/books")
    public String saveBook(@Valid Book book,BindingResult bindingResult, @RequestParam MultipartFile image, Model model) throws IOException {
        if(bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("book", book);
            return "add-book";
        }
        this.bookService.saveBook(book.getName(), book.getCopies(), book.getCategory().getId(), image);
        model.addAttribute("books", bookService.findAll());
                return "books";
    }





}
