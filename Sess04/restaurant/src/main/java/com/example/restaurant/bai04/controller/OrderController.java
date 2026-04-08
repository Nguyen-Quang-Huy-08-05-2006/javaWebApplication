package com.example.restaurant.bai04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("bai04OrderController")
@ResponseBody
public class OrderController {

    @GetMapping("/bai4/orders/{id}")
    public String getOrderById(@PathVariable Long id) {
        return "Chi tiết đơn hàng số " + id;
    }
}
