package com.example.restaurant.bai01.controller;

import com.example.restaurant.bai01.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("legacyControllerBai1")
@ResponseBody
public class LegacyController {

    private final OrderService orderService;

    @Autowired
    public LegacyController(@Qualifier("bai01OrderService") OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/bai1/orders")
    public String getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/bai1/orders/{id}")
    public String getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
}
