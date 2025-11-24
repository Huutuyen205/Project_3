package com.K23CNT1.com.K23CNT1.Lab06.service;

import com.K23CNT1.com.K23CNT1.Lab06.entity.Book;
import com.K23CNT1.com.K23CNT1.Lab06.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> findAll() {
        return repo.findAll();
    }

    public Book save(Book book) {
        return repo.save(book);
    }

    public Book getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
