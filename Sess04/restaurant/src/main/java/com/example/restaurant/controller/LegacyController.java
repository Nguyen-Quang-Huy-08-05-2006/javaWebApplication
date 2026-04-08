package com.example.restaurant.controller;

import com.example.restaurant.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("mainLegacyController")
public class LegacyController {
    @Autowired
    private OrderRepo orderRepo;

    @GetMapping("/foods")
    public  String getFoods(Model model){
        model.addAttribute("orders",orderRepo.findAll());
        return "foods";
    }
}
