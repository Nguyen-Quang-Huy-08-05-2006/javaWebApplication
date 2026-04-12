package com.example.restaurant.bai3.controller;

import com.example.restaurant.bai3.service.AdminDishService;
import com.example.restaurant.common.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai3")
public class AdminDishController {

    private final AdminDishService service;

    public AdminDishController(AdminDishService service) {
        this.service = service;
    }

    @GetMapping("/edit/{id}")
    public String editDish(@PathVariable("id") Long id, Model model) {
        Dish dish = service.findById(id);

        if (dish == null) {
            model.addAttribute("error", "Không tìm thấy món ăn yêu cầu!");
            return "redirect:/bai2/dishes";
        }

        model.addAttribute("dish", dish);
        return "edit-dish";
    }
}