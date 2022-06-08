package com.equipment.accounting.back.service;

import com.equipment.accounting.back.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category getByCategoryId (Long id);
    Category getByCategoryName (String categoryName);
    void deleteCategory(Long id);
    Category addCategory (Category category);
    List<Category> getAllCategories();
    boolean existsByCategoryName(String equipmentCategory);
}
