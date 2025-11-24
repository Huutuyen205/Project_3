package com.K23CNT1.com.K23CNT1.Lab06.repository;

import com.K23CNT1.com.K23CNT1.Lab06.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
