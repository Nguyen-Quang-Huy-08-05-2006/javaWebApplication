package com.example.restaurant.bai01.service;

import org.springframework.stereotype.Repository;

@Repository("bai01OrderRepository")
public class OrderRepository {

    public String getAllOrders() {
        return "Danh sach toan bo don hang";
    }

    public String getOrderById(Long id) {
        return "Thong tin don hang voi ID: " + id;
    }
}