package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Cart;

public interface CartService {

    Cart addToCart(Cart cart);

    List<Cart> getUserCart(Long userId);

    void removeItem(Long cartId);

    void clearCart(Long userId);
}