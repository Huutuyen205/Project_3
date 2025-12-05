package com.example.Project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "conan_book") // Map vào bảng conan_book
public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Double price;
    private String description;

    @Column(name = "image_url") // Map cột image_url
    private String imageUrl;
}