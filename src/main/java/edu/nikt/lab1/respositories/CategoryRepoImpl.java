package edu.nikt.lab1.respositories;

import edu.nikt.lab1.models.Category;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class CategoryRepoImpl implements CategoryRepo {

    private HashMap<Long, Category> categories;

    @PostConstruct
    public void init() {
        this.categories = new HashMap<>();
        Category c1 = new Category(1L, "Deca", "Za deca na vozrast 8-14");
        Category c2 = new Category(2L, "IT", "Za site koi sakaat da go spoznaat svetot na IT");
        this.categories.put(1L, c1);
        this.categories.put(2L, c2);
    }
    @Override
    public List<Category> findAll() {
        return new ArrayList<>(categories.values());
    }

    @Override
    public Category findById(long id) {
        return categories.get(id);
    }


}
