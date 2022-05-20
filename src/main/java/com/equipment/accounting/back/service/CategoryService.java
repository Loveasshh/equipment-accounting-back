package com.equipment.accounting.back.service;

import com.equipment.accounting.back.models.Category;

import java.util.List;

public interface CategoryService {

    Category getByCategoryId (Long id);
    Category getByCategoryName (String categoryName);
    void deleteCategory(Long id);
    Category addCategory (Category category);
    List<Category> getAllCategories();

}
