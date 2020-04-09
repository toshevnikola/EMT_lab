package edu.nikt.lab1.respositories;

import edu.nikt.lab1.models.Book;
import edu.nikt.lab1.models.Category;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepoImpl implements BookRepo {

    private HashMap<Long, Book> books;
    private long counter;

    @PostConstruct
    public void init() {
        this.counter = 0;
        this.books = new HashMap<>();

        long id1 = this.getNextId();
        Book b1 = new Book(id1, "Volsebno samarce", 50, null, null, null);


        long id2 = this.getNextId();
        Book b2 = new Book(id2, "Mice", 10, null, null, null);

        this.books.put(id1, b1);
        this.books.put(id2, b2);
    }

    private long getNextId() {
        return this.counter++;
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<Book>(this.books.values());
    }

    @Override
    public void saveBook(String title, Integer quantity, Category category, String imgBase64, MultipartFile image) {
        long id = getNextId();
        Book b = new Book(id,title,quantity, category, imgBase64, image);
        this.books.put(id, b);
    }

    @Override
    public void removeBook(Long id) {
        books.remove(id);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(this.books.get(id));
    }

    @Override
    public void updateBook(Long id, Book b) {

        this.books.replace(id, b);
    }
}
