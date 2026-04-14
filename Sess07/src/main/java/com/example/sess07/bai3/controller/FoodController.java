package com.example.sess07.bai3.controller;

import com.example.sess07.bai3.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/merchant/food")
public class FoodController {

    private static final List<Food> foodList = new ArrayList<>();

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("food", new Food());
        return "food-add";
    }

    @PostMapping("/add")
    public String addFood(@ModelAttribute Food food,
                          @RequestParam("image") MultipartFile file,
                          Model model) {

        if (file.isEmpty()) {
            model.addAttribute("error", "Vui lòng chọn ảnh");
            return "food-add";
        }

        String fileName = file.getOriginalFilename();
        if (fileName == null ||
                !(fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".jpeg"))) {
            model.addAttribute("error", "Chỉ chấp nhận file ảnh (.jpg, .png, .jpeg)");
            return "food-add";
        }

        if (food.getPrice() < 0) {
            model.addAttribute("error", "Giá phải >= 0");
            return "food-add";
        }

        try {
            String uploadDir = "C:/RikkeiFood_Temp/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String filePath = uploadDir + fileName;
            file.transferTo(new File(filePath));

            food.setImagePath(filePath);

        } catch (IOException e) {
            model.addAttribute("error", "Upload thất bại");
            return "food-add";
        }

        foodList.add(food);

        System.out.println("Món vừa thêm: " + food.getName());
        System.out.println("Tổng số món: " + foodList.size());

        return "redirect:/merchant/food/add";
    }
}