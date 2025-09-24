package com.example.software.service.impl;

import com.example.software.entity.Category;
import com.example.software.repository.CategoryRepository;
import com.example.software.service.CategoryService;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Long id, Category category) {
        Category update = categoryRepository.findById(id).orElse(null);
        update.setName(category.getName());
        categoryRepository.save(update);
    }
}
