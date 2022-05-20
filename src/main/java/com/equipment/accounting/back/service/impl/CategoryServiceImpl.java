package com.equipment.accounting.back.service.impl;

import com.equipment.accounting.back.models.Category;
import com.equipment.accounting.back.models.Equipment;
import com.equipment.accounting.back.repository.CategoryRepository;
import com.equipment.accounting.back.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category getByCategoryId(Long id) {
        return categoryRepository.getById(id);
    }

    @Override
    public Category getByCategoryName(String categoryName) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
