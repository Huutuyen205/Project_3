package com.example.Project.service;
import com.example.Project.entity.Order;
import com.example.Project.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired private OrderRepository repo;

    public void save(Order o) { repo.save(o); }
}