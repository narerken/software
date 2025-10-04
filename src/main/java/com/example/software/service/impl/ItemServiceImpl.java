package com.example.software.service.impl;

import com.example.software.dto.ItemDto;
import com.example.software.entity.Item;
import com.example.software.repository.ItemRepository;
import com.example.software.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    private ItemDto toDto(Item item){
        ItemDto itemDto =  new ItemDto();

        itemDto.setId(item.getId());
        itemDto.setNameDto(item.getName());
        itemDto.setPriceDto(item.getPrice());
        itemDto.setItemDescriptionDto(item.getItemDescription());
        return itemDto;
    }

    @Override
    public List<ItemDto> getAll() {
        List<Item> items = itemRepository.findAll();
        List<ItemDto> result = new ArrayList<>();
        for (Item item : items) {
            result.add(toDto(item));
        }
        return result;
    }

    @Override
    public ItemDto getById(Long id) {
        Item item = itemRepository.findById(id).orElseThrow();
        ItemDto itemDto = toDto(item);
        return itemDto;
    }

    @Override
    public void addItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void updateItem(Long id, Item item) {
        Item updateItem = itemRepository.findById(id).orElse(null);
        if (updateItem != null) {
            updateItem.setName(item.getName());
            updateItem.setItemDescription(item.getItemDescription());
            updateItem.setPrice(item.getPrice());
            updateItem.setCategory(item.getCategory());
            itemRepository.save(updateItem);
        }
    }

    @Override
    public boolean deleteItem(Long id) {
        Item item = itemRepository.findById(id).orElse(null);
        if (Objects.isNull(item)) {
            return false;
        }
        itemRepository.deleteById(id);
        return true;
    }
}
