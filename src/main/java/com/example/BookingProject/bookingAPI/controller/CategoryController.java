package com.example.BookingProject.bookingAPI.controller;

import com.example.BookingProject.bookingAPI.persistence.model.Category;
import com.example.BookingProject.bookingAPI.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.CREATED);
    }

    @PostMapping("/addMany")
    public ResponseEntity<?> addCategories(@RequestBody List<Category> categories) {
        return new ResponseEntity<>(categoryService.saveCategories(categories), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> findAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(),HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> findCategoryByTitle(@PathVariable String title) {
        return new ResponseEntity<>(categoryService.getCategoryByTitle(title), HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<?> updateCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.updateCategory(category), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id) {
         categoryService.deleteCategory(id);
         return new ResponseEntity(HttpStatus.OK);
    }


}
