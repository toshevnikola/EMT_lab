package edu.nikt.lab1.controllers;

import edu.nikt.lab1.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }
}
