package com.example.Project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "conan_book") // Make sure this matches your SQL table name
public class Comic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Double price;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String imageUrl;

    // --- ADD THIS FIELD ---
    private String category;

    // Constructors
    public Comic() {}

    public Comic(Long id, String title, Double price, String description, String imageUrl, String category) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    // --- ADD GETTER AND SETTER FOR CATEGORY ---
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}