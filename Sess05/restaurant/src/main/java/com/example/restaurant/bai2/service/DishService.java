package com.example.restaurant.bai2.service;

import com.example.restaurant.common.Dish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {

    public List<Dish> getAllDishes() {
        List<Dish> list = new ArrayList<>();

        list.add(new Dish(1L, "Bún chả", 40000, true));
        list.add(new Dish(2L, "Phở bò", 50000, false));
        list.add(new Dish(3L, "Bún riêu", 35000, true));

        return list;
    }
}