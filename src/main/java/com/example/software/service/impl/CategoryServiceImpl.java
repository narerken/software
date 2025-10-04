package com.example.software.service.impl;

import com.example.software.dto.CategoryDto;
import com.example.software.dto.ItemDto;
import com.example.software.entity.Category;
import com.example.software.entity.Item;
import com.example.software.repository.CategoryRepository;
import com.example.software.service.CategoryService;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    private CategoryDto toDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

    @Override
    public List<CategoryDto> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> result = new ArrayList<>();
        for (Category category : categories) {
            result.add(toDto(category));
        }
        return result;
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Long id, Category category) {
        Category update = categoryRepository.findById(id).orElse(null);
        if(update != null){
            update.setName(category.getName());
        }
    }
}
