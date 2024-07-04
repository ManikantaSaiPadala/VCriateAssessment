package com.example.inventorymanagement.services;

import com.example.inventorymanagement.models.Order;
import com.example.inventorymanagement.models.OrderItem;
import com.example.inventorymanagement.repositories.ItemRepository;
import com.example.inventorymanagement.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Order createOrder(Order order) {
        // Adjust stock levels for each item in the order
        for (OrderItem orderItem : order.getItems()) {
            itemRepository.findById(orderItem.getItem().getId()).ifPresent(item -> {
                item.setQuantity(item.getQuantity() - orderItem.getQuantity());
                itemRepository.save(item);
            });
        }
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setCustomerId(orderDetails.getCustomerId());
            order.setOrderDate(orderDetails.getOrderDate());
            order.setStatus(orderDetails.getStatus());
            order.setTotalAmount(orderDetails.getTotalAmount());
            order.setItems(orderDetails.getItems());
            return orderRepository.save(order);
        } else {
            return null;
        }
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        return orderOptional
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found with id " + id));
    }
}
