package edu.nikt.lab1.respositories;

import edu.nikt.lab1.models.Book;
import edu.nikt.lab1.models.Category;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface BookRepo {
     List<Book> findAll();
     void saveBook(String title, Integer quantity, Category category, String base64, MultipartFile image);
     void removeBook(Long id);
     Optional<Book> findById(Long id);
     void updateBook(Long id, Book b);

}
