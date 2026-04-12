package com.example.restaurant.bai3.service;

import com.example.restaurant.common.Dish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminDishService {

    private static final List<Dish> dishes = new ArrayList<>();

    static {
        dishes.add(new Dish(1L, "Bún chả", 40000, true));
        dishes.add(new Dish(2L, "Phở bò", 50000, false));
        dishes.add(new Dish(3L, "Bún riêu", 35000, true));
    }

    public Dish findById(Long id) {
        return dishes.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}