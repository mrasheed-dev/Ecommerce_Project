package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

	private final AdminRepository adminRepository;
	private final UserRepository userRepository;

	public AdminServiceImpl(AdminRepository adminRepository,
	                        UserRepository userRepository) {
	    this.adminRepository = adminRepository;
	    this.userRepository = userRepository;
	}

    @Override
    public Admin register(Admin admin) {

        if (adminRepository.existsByEmail(admin.getEmail())) {
            throw new RuntimeException("Admin email already exists");
        }

        if (userRepository.existsByEmail(admin.getEmail())) {
            throw new RuntimeException("This email belongs to User");
        }

        return adminRepository.save(admin);
    }

    @Override
    public String login(String email, String password) {

        // If email exists in User table
        if (userRepository.existsByEmail(email)) {
            return "This email belongs to User";
        }

        Optional<Admin> optionalAdmin = adminRepository.findByEmail(email);

        if (optionalAdmin.isEmpty()) {
            return "Admin not found";
        }

        Admin dbAdmin = optionalAdmin.get();

        if (!dbAdmin.getPassword().equals(password)) {
            return "Invalid password";
        }

        return "Admin login successful";
    }

	}
