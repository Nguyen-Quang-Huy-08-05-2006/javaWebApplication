package com.example.restaurant.bai02.controller;

import com.example.restaurant.bai01.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("legacyControllerBai2")
@ResponseBody
public class LegacyController {

    private final OrderService orderService;

    @Autowired
    public LegacyController(@Qualifier("bai01OrderService") OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/bai2/orders")
    public String getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/bai2/orders/{id}")
    public String getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/bai2/menu")
    public String getMenu(
            @RequestParam(value = "category", required = false, defaultValue = "chay")
            String category) {

        return "Menu loai: " + category;
    }
}
