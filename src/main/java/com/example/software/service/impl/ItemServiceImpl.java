package com.example.software.service.impl;

import com.example.software.entity.Item;
import com.example.software.repository.ItemRepository;
import com.example.software.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item getById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public void addItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void updateItem(Long id, Item item) {
        Item updateItem = getById(id);

        updateItem.setName(item.getName());
        updateItem.setItemDescription(item.getItemDescription());
        updateItem.setPrice(item.getPrice());
        updateItem.setCategory(item.getCategory());

        itemRepository.save(updateItem);
    }

    @Override
    public boolean deleteItem(Long id) {
        Item item = getById(id);
        if (Objects.isNull(item)) {
            return false;
        }
        itemRepository.deleteById(id);
        return true;
    }
}
