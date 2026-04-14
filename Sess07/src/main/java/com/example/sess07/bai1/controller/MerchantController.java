package com.example.sess07.bai1.controller;

import com.example.sess07.bai1.model.RestaurantProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MerchantController {

    @GetMapping("/merchant/profile")
    public String showForm(Model model) {
        model.addAttribute("restaurantProfile", new RestaurantProfile());
        return "profile";
    }

    @PostMapping("/merchant/update-profile")
    public String updateProfile(RestaurantProfile profile) {
        System.out.println("Tên quán: " + profile.getName());
        System.out.println("SĐT: " + profile.getPhone());
        System.out.println("Active: " + profile.isActive());

        return "success";
    }
}
