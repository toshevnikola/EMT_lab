package edu.nikt.lab1.services;

import edu.nikt.lab1.models.Book;
import edu.nikt.lab1.models.Category;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    void saveBook(String title, Integer quantity, Long categoryId, MultipartFile image) throws IOException;
    void removeBook(Long id);
    Book findById(Long id);
    void updateBook(Long id, Book b, MultipartFile image) throws IOException;
}
