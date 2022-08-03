package com.example.BookingProject.service;

import com.example.BookingProject.model.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);

    List<Category> saveCategories(List<Category> categories);

    Category getCategoryByTitle(String title);

    List<Category> getAllCategories();

    void deleteCategory(Long id);

    Category updateCategory(Category category);
}
