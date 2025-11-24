package com.K23CNT1.com.K23CNT1.Lab06.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String title;

    private Double price;

    private String image;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    // GETTER – SETTER
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }
}
