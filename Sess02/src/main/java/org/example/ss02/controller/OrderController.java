package org.example.ss02.controller;


import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.example.ss02.model.entity.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
public class OrderController {

    @GetMapping("/orders")
    public String showOrders(HttpSession session, Model model, ServletContext application) {
        // Nếu chưa login thì đá về login
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        List<Order> orders = mockOrders();
        model.addAttribute("orders", orders); // request scope

        // Chống race condition khi cập nhật application scope
        synchronized (application) {
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if (count == null) {
                count = 0;
            }
            count++;
            application.setAttribute("totalViewCount", count);
        }

        return "orders";
    }

    private List<Order> mockOrders() {
        List<Order> orders = new ArrayList<>();

        Calendar c = Calendar.getInstance();

        c.set(2026, Calendar.APRIL, 1);
        orders.add(new Order("DH001", "Bàn phím cơ", 1250000, c.getTime()));

        c.set(2026, Calendar.APRIL, 2);
        orders.add(new Order("DH002", "Chuột gaming", 850000, c.getTime()));

        c.set(2026, Calendar.APRIL, 3);
        orders.add(new Order("DH003", "Tai nghe Bluetooth", 1590000, c.getTime()));

        c.set(2026, Calendar.APRIL, 4);
        orders.add(new Order("DH004", "Màn hình 24 inch", 3290000, c.getTime()));

        c.set(2026, Calendar.APRIL, 5);
        orders.add(new Order("DH005", "Laptop stand", 420000, c.getTime()));

        return orders;
    }
}