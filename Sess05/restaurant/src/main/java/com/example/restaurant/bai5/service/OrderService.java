package com.example.restaurant.bai5.service;

import com.example.restaurant.bai5.repo.OrderRepo;
import com.example.restaurant.common.Dish;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepo repo;

    public OrderService(OrderRepo repo) {
        this.repo = repo;
    }

    public List<Dish> getMenu() {
        return repo.findAll();
    }

    public double calculateTotal(List<Dish> dishes) {
        return dishes.stream()
                .mapToDouble(Dish::getPrice)
                .sum();
    }
}