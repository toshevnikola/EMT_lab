package edu.nikt.lab1.services;

import edu.nikt.lab1.models.Category;
import edu.nikt.lab1.respositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorySeviceImpl implements CategoryService{

    private CategoryRepo categoryRepository;

    public CategorySeviceImpl(CategoryRepo categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findById(id);
    }
}
