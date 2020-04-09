package edu.nikt.lab1.services;

import edu.nikt.lab1.exceptions.BookNotFoundException;
import edu.nikt.lab1.models.Book;
import edu.nikt.lab1.models.Category;
import edu.nikt.lab1.respositories.BookRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookRepo bookRepository;
    private CategoryService categoryService;

    public BookServiceImpl(BookRepo bookRepository, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void saveBook(String title, Integer quantity, Long categoryId, MultipartFile image) throws IOException {
        Category category = categoryService.findById(categoryId);
        if (image != null && !image.getName().isEmpty()) {
            byte[] bytes = image.getBytes();
            String base64Image = String.format("data:%s;base64,%s", image.getContentType(), Base64.getEncoder().encodeToString(bytes));
            bookRepository.saveBook(title, quantity, category, base64Image, image);
        }
    }

    @Override
    public void removeBook(Long id) {
        bookRepository.removeBook(id);
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public void updateBook(Long id, Book b, MultipartFile image) throws IOException {
        if (image != null && !image.getName().isEmpty()) {
            byte[] bytes = image.getBytes();
            String base64Image = String.format("data:%s;base64,%s", image.getContentType(), Base64.getEncoder().encodeToString(bytes));
            b.setImg(image);
            b.setBase64Img(base64Image);
        bookRepository.updateBook(id, b);
    }
}

}
