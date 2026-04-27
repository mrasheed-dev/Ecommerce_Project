package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository repository;

    public CartServiceImpl(CartRepository repository) {
        this.repository = repository;
    }

    public Cart addToCart(Cart cart) {
        return repository.save(cart);
    }

    public List<Cart> getUserCart(Long userId) {
        return repository.findByUserId(userId);
    }

    public void removeItem(Long cartId) {
        repository.deleteById(cartId);
    }

    public void clearCart(Long userId) {
        repository.deleteByUserId(userId);
    }
}
