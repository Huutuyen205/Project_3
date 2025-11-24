package com.K23CNT1.com.K23CNT1.Lab06.service;

import com.K23CNT1.com.K23CNT1.Lab06.entity.Author;
import com.K23CNT1.com.K23CNT1.Lab06.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository repo;

    public AuthorService(AuthorRepository repo) {
        this.repo = repo;
    }

    public List<Author> getAll() {
        return repo.findAll();
    }
}
