package com.aryan.dreamshops.service.category;

import com.aryan.dreamshops.model.Category;

import java.util.List;

public interface ICategoryService {
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);

    Category addCategory(Category category);
    Category updateCategory(Category category,Long categoryId);
    void deleteCategoryById(Long id);

    List<Category> getAllCategories();

}
