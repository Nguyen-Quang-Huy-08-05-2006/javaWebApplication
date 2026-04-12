package com.example.restaurant.bai5.repo;

import com.example.restaurant.common.Dish;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepo {

    public List<Dish> findAll() {
        List<Dish> list = new ArrayList<>();

        list.add(new Dish(1L, "Bún chả", 40000, true));
        list.add(new Dish(2L, "Phở bò", 50000, true));
        list.add(new Dish(3L, "Bún riêu", 35000, true));

        return list;
    }
}