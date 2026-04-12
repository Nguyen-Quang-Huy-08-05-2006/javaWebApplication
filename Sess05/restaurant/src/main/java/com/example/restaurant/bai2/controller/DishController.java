package com.example.restaurant.bai2.controller;

import com.example.restaurant.bai2.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bai2")
public class DishController {

    private final DishService service;

    public DishController(DishService service) {
        this.service = service;
    }

        @GetMapping("/dishes")
    public String getDishes(Model model) {
        model.addAttribute("dishes", service.getAllDishes());
        return "dish-list";
    }
}