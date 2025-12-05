package com.example.Project.service;

import com.example.Project.security.Admin;
import com.example.Project.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repo;

    public Admin login(String u, String p) {
        return repo.findByUsernameAndPassword(u, p);
    }
}