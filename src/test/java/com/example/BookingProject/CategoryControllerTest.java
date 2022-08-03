package com.example.BookingProject;

import com.example.BookingProject.bookingAPI.persistence.model.Category;
import com.example.BookingProject.bookingAPI.service.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryControllerTest {

	@Autowired
	CategoryServiceImpl categoryServiceimpl;

	@Test
	void testSaveCategory() {
		Category c = new Category(1l,"Casa", "Casa", "URL");
		categoryServiceimpl.saveCategory(c);
		assertNotNull(categoryServiceimpl.getCategoryByTitle("Casa"));
	}

	@Test
	void testSaveCategories() {
		List<Category> categories = new ArrayList<>();
		categories.add(new Category());
		categories.add(new Category());
		categoryServiceimpl.saveCategories(categories);

		assertTrue(categoryServiceimpl.getAllCategories().size() > 0);
	}

	@Test
	void testGetCategoryByTitle() {
		Category c = new Category(2l, "Casa2", "", "");
		categoryServiceimpl.saveCategory(c);
		assertTrue(categoryServiceimpl.getCategoryByTitle("Casa2") != null);
	}

	@Test
	void testGetAllCategories() {
		List<Category> listOfCategories = categoryServiceimpl.getAllCategories();
		Category c1= new Category();
		Category c2 = new Category();
		listOfCategories.add(c1);
		listOfCategories.add(c2);

		assertTrue(categoryServiceimpl.getAllCategories() != null);
	}

	@Test
	void testDeleteCategory() {
		Category c = new Category(3l, "Casa2", "", "");
		categoryServiceimpl.saveCategory(c);
		categoryServiceimpl.deleteCategory(3l);
		assertTrue(categoryServiceimpl.getCategoryByTitle("Casa2") == null);
	}

	@Test
	void testUpdateCategory() {
		Category c = new Category(4l, "Finca", "", "");
		Category cUpdated = categoryServiceimpl.getCategoryByTitle("Finca");
		cUpdated.setImageURL("URL");
		categoryServiceimpl.updateCategory(cUpdated);
		assertTrue(categoryServiceimpl.getCategoryByTitle("Finca").getImageURL() == "URL");
	}
}
