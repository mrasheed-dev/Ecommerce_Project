package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Order;

public interface OrderService {

    Order placeOrder(Order order);

    List<Order> getAllOrders();

    List<Order> getOrdersByUser(Long userId);

    Order updateStatus(Long id, String status);
}
