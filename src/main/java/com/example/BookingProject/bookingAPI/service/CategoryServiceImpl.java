package com.example.BookingProject.bookingAPI.service;

import com.example.BookingProject.bookingAPI.persistence.model.Category;
import com.example.BookingProject.bookingAPI.persistence.repository.CategoryRepository;

import com.example.BookingProject.bookingAPI.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> saveCategories(List<Category> categories) {
        return categoryRepository.saveAll(categories);
    }

    @Override
    public Category getCategoryByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public  Category updateCategory (Category category) {
        Category existingCategory = categoryRepository.findById(category.getId()).orElse(null);
        existingCategory.setTitle(category.getTitle());
        existingCategory.setDescription(category.getDescription());
        existingCategory.setImageURL(category.getImageURL());
        return categoryRepository.save(existingCategory);
    }


}
