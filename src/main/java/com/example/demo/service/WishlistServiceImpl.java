package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Wishlist;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WishlistRepository;

@Service
public class WishlistServiceImpl implements WishlistService {

    private final WishlistRepository repository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public WishlistServiceImpl(WishlistRepository repository,
                               UserRepository userRepository,
                               ProductRepository productRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Wishlist add(Wishlist wishlist) {

        Long userId = wishlist.getUser().getId();
        Long productId = wishlist.getProduct().getId();

        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found");
        }

        if (!productRepository.existsById(productId)) {
            throw new RuntimeException("Product not found");
        }

        return repository.save(wishlist);
    }

    @Override
    public List<Wishlist> getByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
