package com.example.restaurant.bai03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("bai03OrderController")
@ResponseBody
public class OrderController {

    @GetMapping("/bai3/orders/{id}")
    public String getOrderById(@PathVariable Long id) {
        return "Chi tiết đơn hàng số " + id;
    }
}
