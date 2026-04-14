package com.example.sess07.bai5.controller;

import com.example.sess07.bai5.model.Combo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/merchant/combo")
public class ComboController {

    private static final List<Combo> comboList = new ArrayList<>();

    private static final List<String> foodItems = Arrays.asList(
            "Gà rán", "Trà sữa", "Pizza", "Burger", "Khoai tây"
    );

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("combo", new Combo());
        model.addAttribute("foods", foodItems);
        return "bai5/combo-form";
    }

    @PostMapping("/add")
    public String addCombo(@ModelAttribute Combo combo,
                           @RequestParam("banner") MultipartFile file,
                           Model model) {

        if (combo.getItemList() == null || combo.getItemList().size() < 2) {
            model.addAttribute("error", "Combo phải có ít nhất 2 món");
            model.addAttribute("foods", foodItems);
            return "bai5/combo-form";
        }

        if (file.isEmpty()) {
            model.addAttribute("error", "Chưa chọn banner");
            model.addAttribute("foods", foodItems);
            return "bai5/combo-form";
        }

        try {
            String uploadDir = "C:/RikkeiFood_Temp/";
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            String path = uploadDir + fileName;

            file.transferTo(new File(path));

            combo.setBannerPath(path);

        } catch (IOException e) {
            model.addAttribute("error", "Upload lỗi");
            model.addAttribute("foods", foodItems);
            return "bai5/combo-form";
        }
        comboList.add(combo);

        System.out.println("Combo vừa thêm:");
        System.out.println("Items: " + combo.getItemList());
        System.out.println("Banner: " + combo.getBannerPath());

        return "redirect:/merchant/combo/add";
    }
}