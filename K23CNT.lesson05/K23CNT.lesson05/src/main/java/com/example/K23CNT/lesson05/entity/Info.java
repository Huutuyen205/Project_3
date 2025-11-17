package com.example.K23CNT.lesson05.entity;

public class Info {
    private String name;
    private String position;
    private String email;
    private String website;

    // Constructor rỗng
    public Info() {
    }

    // Constructor đầy đủ tham số (được dùng trong HomeController)
    public Info(String name, String position, String email, String website) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.website = website;
    }

    // --- Các hàm Getters và Setters ---

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}