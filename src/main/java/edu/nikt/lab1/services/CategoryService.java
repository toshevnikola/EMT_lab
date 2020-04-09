package edu.nikt.lab1.services;

import edu.nikt.lab1.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(long id);
}
