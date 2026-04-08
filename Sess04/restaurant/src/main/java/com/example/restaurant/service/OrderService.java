package com.example.restaurant.service;

import com.example.restaurant.model.Food;
import com.example.restaurant.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mainOrderService")
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    public List<Food> getAllOrders(){
        return orderRepo.findAll();
    }
}
