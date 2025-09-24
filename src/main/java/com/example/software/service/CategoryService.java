package com.example.software.service;

import com.example.software.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    void addCategory(Category category);
    void updateCategory(Long id, Category category);

}
