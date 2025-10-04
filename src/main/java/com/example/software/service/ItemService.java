package com.example.software.service;
import com.example.software.dto.ItemDto;
import com.example.software.entity.Item;

import java.util.List;

public interface ItemService {
    List<ItemDto> getAll();
    ItemDto getById(Long id);
    void addItem(Item item);
    void updateItem(Long id,Item item);
    boolean deleteItem(Long id);
}

