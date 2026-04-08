package com.example.restaurant.bai05.controller;

import com.example.restaurant.bai05.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("bai05OrderController")
@ResponseBody
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    // GET
    @GetMapping("/bai5/orders/{id}")
    public String getOrder(@PathVariable Long id) {
        return service.getOrder(id);
    }

    // POST
    @PostMapping("/bai5/orders")
    public String createOrder(
            @RequestParam Long id,
            @RequestParam String name) {

        return service.createOrder(id, name);
    }

    // DELETE
    @DeleteMapping("/bai5/orders/{id}")
    public String deleteOrder(@PathVariable Long id) {
        return service.deleteOrder(id);
    }

    // Exception handler
    @ExceptionHandler(Exception.class)
    public String handleError() {
        return "ID đơn hàng phải là một số";
    }
}