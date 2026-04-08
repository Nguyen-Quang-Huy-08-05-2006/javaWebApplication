package com.example.restaurant.repo;

import com.example.restaurant.model.Food;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepo {
    private static final List<Food> foods = new ArrayList<>();

    static {
        foods.add(new Food(2,"Bun Ca",35000));
        foods.add(new Food(2,"Bun Cha",40000));
        foods.add(new Food(3,"Bun Oc",35000));
        foods.add(new Food(4,"Bun Bo Hue",45000));
        foods.add(new Food(5,"Bun Rieu",40000));
    }

    public static List<Food> findAll() {
        return foods;
    }
}
