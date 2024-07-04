package com.example.inventorymanagement.services;

import com.example.inventorymanagement.models.Item;
import com.example.inventorymanagement.models.Order;
import com.example.inventorymanagement.models.Supplier;
import com.example.inventorymanagement.repositories.ItemRepository;
import com.example.inventorymanagement.repositories.OrderRepository;
import com.example.inventorymanagement.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportingService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private SupplierRepository supplierRepository;

    public List<Item> getStockLevelsReport() {
        return itemRepository.findAll();
    }

    public List<Order> getOrderStatusReport() {
        return orderRepository.findAll();
    }

    public List<Supplier> getSupplierPerformanceReport() {
        return supplierRepository.findAll();
    }
}
