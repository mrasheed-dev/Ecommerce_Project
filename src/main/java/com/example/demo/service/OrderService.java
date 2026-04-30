package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.OrderEntity;


public interface OrderService {

    OrderEntity placeOrder(OrderEntity order);

    List<OrderEntity> getAllOrders();

    List<OrderEntity> getOrdersByUser(Long userId);

    OrderEntity updateStatus(Long id, String status);
}
