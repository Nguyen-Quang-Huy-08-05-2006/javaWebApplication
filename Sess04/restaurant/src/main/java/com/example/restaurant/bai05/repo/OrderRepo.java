package com.example.restaurant.bai05.repo;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
@Repository
public class OrderRepo {

    private final Map<Long, String> orders = new HashMap<>();

    public Map<Long, String> getAll() {
        return orders;
    }

    public String getById(Long id) {
        return orders.get(id);
    }

    public void save(Long id, String name) {
        orders.put(id, name);
    }

    public void delete(Long id) {
        orders.remove(id);
    }
}