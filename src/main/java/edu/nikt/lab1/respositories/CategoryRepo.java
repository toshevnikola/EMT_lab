package edu.nikt.lab1.respositories;

import edu.nikt.lab1.models.Category;

import java.util.List;

public interface CategoryRepo {
    List<Category> findAll();
    Category findById(long id);

}
