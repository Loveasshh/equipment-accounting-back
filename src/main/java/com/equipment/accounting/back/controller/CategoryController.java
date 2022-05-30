package com.equipment.accounting.back.controller;

import com.equipment.accounting.back.model.Category;
import com.equipment.accounting.back.response.MessageRs;
import com.equipment.accounting.back.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryController {
    @Autowired
    CategoryServiceImpl categoryService;

    @PostMapping("/addCategory")
    public ResponseEntity<?> addCategory (@RequestParam String name) {
        Category category = new Category(name);
        categoryService.addCategory(category);
        return ResponseEntity.ok(new MessageRs("Category added"));
    }

    @GetMapping("/getAll")
    public List<Category> getAllCategories () {
        return categoryService.getAllCategories();
    }
}
