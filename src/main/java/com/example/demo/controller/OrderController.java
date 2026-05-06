package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;


@RestController
@RequestMapping("/api/orders")
public class OrderController 
{
    private final OrderService service;

    public OrderController(OrderService service) 
    {
        this.service = service;
    }

    @PostMapping
    public Order place(@RequestBody Order order) {
        return service.placeOrder(order);
    }

    @GetMapping
    public List<Order> all() {
        return service.getAllOrders();
    }

    @GetMapping("/user/{userId}")//localhost/api/orders/user/1
    public List<Order> byUser(@PathVariable Long userId) {
        return service.getOrdersByUser(userId);
    }

    @PutMapping("/{id}")//localhost/api/orders/1?
    public Order update(@PathVariable Long id,@RequestParam String status) {
        return service.updateStatus(id, status);
    }
}
