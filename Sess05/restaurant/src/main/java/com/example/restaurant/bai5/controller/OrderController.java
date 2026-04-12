package com.example.restaurant.bai5.controller;

import com.example.restaurant.bai5.service.OrderService;
import com.example.restaurant.common.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bai5")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/order")
    public String showOrderPage(Model model) {
        List<Dish> dishes = service.getMenu();

        model.addAttribute("dishes", dishes);
        model.addAttribute("total", service.calculateTotal(dishes));

        return "order-page";
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleError() {
        return "Có lỗi xảy ra, vui lòng kiểm tra lại dữ liệu!";
    }
}