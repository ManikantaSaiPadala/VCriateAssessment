package com.example.inventorymanagement.controllers;

import com.example.inventorymanagement.models.Item;
import com.example.inventorymanagement.models.Order;
import com.example.inventorymanagement.models.Supplier;
import com.example.inventorymanagement.services.ItemService;
import com.example.inventorymanagement.services.OrderService;
import com.example.inventorymanagement.services.ReportingService;
import com.example.inventorymanagement.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InventoryController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ReportingService reportingService;

    // Endpoints for Item management
    @PostMapping("/items")
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @PutMapping("/items/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/items/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    // Endpoints for Order management
    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/orders/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // Endpoints for Supplier management
    @PostMapping("/suppliers")
    public Supplier addSupplier(@RequestBody Supplier supplier) {
        return supplierService.addSupplier(supplier);
    }

    @PutMapping("/suppliers/{id}")
    public Supplier updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        return supplierService.updateSupplier(id, supplier);
    }

    @DeleteMapping("/suppliers/{id}")
    public void deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
    }

    @GetMapping("/suppliers")
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/suppliers/{id}")
    public Supplier getSupplierById(@PathVariable Long id) {
        return supplierService.getSupplierById(id);
    }

    // Endpoints for Reporting
    @GetMapping("/reports/stock")
    public List<Item> getStockLevelsReport() {
        return reportingService.getStockLevelsReport();
    }

    @GetMapping("/reports/orders")
    public List<Order> getOrderStatusReport() {
        return reportingService.getOrderStatusReport();
    }

    @GetMapping("/reports/suppliers")
    public List<Supplier> getSupplierPerformanceReport() {
        return reportingService.getSupplierPerformanceReport();
    }
}
