package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Wishlist;

public interface WishlistService {

    Wishlist add(Wishlist wishlist);

    List<Wishlist> getByUser(Long userId);

    void remove(Long id);
}
