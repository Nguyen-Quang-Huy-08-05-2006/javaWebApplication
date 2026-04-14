package com.example.sess07.bai4.controller;

import com.example.sess07.bai4.model.FoodB4;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/merchant/food4")
public class FoodControllerB4 {

    private static final List<FoodB4> foodList = new ArrayList<>();

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("food", new FoodB4());
        return "bai4/food-add";
    }

    @PostMapping("/add")
    public String addFood(@ModelAttribute("food") FoodB4 food,
                          @RequestParam("image") MultipartFile file,
                          RedirectAttributes redirectAttributes,
                          Model model) {

        // ❌ check file
        if (file.isEmpty()) {
            model.addAttribute("error", "Chưa chọn ảnh");
            return "bai4/food-add";
        }

        String originalName = file.getOriginalFilename();

        if (originalName == null ||
                !(originalName.endsWith(".jpg") || originalName.endsWith(".png") || originalName.endsWith(".jpeg"))) {
            model.addAttribute("error", "File không hợp lệ");
            return "bai4/food-add";
        }

        // ❌ check giá
        if (food.getPrice() < 0) {
            model.addAttribute("error", "Giá phải >= 0");
            return "bai4/food-add";
        }

        try {
            String uploadDir = "C:/RikkeiFood_Temp/";
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            // 🔥 UUID tránh trùng
            String uniqueName = UUID.randomUUID() + "_" + originalName;

            String filePath = uploadDir + uniqueName;
            file.transferTo(new File(filePath));

            food.setImagePath(filePath);

        } catch (IOException e) {
            model.addAttribute("error", "Upload lỗi");
            return "bai4/food-add";
        }

        foodList.add(food);
        int id = foodList.size() - 1;

        redirectAttributes.addFlashAttribute("success", "Thêm thành công!");

        return "redirect:/merchant/food4/detail?id=" + id;
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam int id, Model model) {

        if (id < 0 || id >= foodList.size()) {
            return "redirect:/merchant/food4/add";
        }

        model.addAttribute("food", foodList.get(id));
        return "bai4/food-detail";
    }
}