package com.example.restaurant.bai05.service;

import com.example.restaurant.bai05.repo.OrderRepo;
import org.springframework.stereotype.Service;

@Service("bai05OrderService")
public class OrderService {

    private final OrderRepo repository;

    public OrderService(OrderRepo repository) {
        this.repository = repository;
    }

    public String getOrder(Long id) {
        String order = repository.getById(id);
        return order != null ? order : "Không tìm thấy đơn hàng";
    }

    public String createOrder(Long id, String name) {
        repository.save(id, name);
        return "Tạo đơn hàng thành công: " + name;
    }

    public String deleteOrder(Long id) {
        repository.delete(id);
        return "Đã xóa đơn hàng ID: " + id;
    }
}