package com.example.inventorymanagement.services;

import com.example.inventorymanagement.models.Item;
import com.example.inventorymanagement.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.*;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item itemDetails) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isPresent()) {
            Item item = itemOptional.get();
            item.setName(itemDetails.getName());
            item.setDescription(itemDetails.getDescription());
            item.setQuantity(itemDetails.getQuantity());
            item.setPrice(itemDetails.getPrice());
            item.setSupplier(itemDetails.getSupplier());
            return itemRepository.save(item);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found with id " + id);
        }
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        return itemOptional.orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Item not found with id " + id));
    }
}
