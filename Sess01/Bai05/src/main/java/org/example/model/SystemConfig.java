package org.example.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Lớp định nghĩa cấu hình hệ thống dưới dạng Bean
 * 
 * @Component: Đăng ký lớp này là một Bean của Spring Container
 * @Value: Gán giá trị khởi tạo cho các biến từ properties
 */
@Component
public class SystemConfig {

    @Value("Cyber Center - Chi nhánh Hồ Chí Minh")
    private String branchName;

    @Value("08:00 AM")
    private String openingHour;

    // Constructor không tham số (Bắt buộc cho Spring)
    public SystemConfig() {
    }

    // Getter methods
    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(String openingHour) {
        this.openingHour = openingHour;
    }

    @Override
    public String toString() {
        return "SystemConfig{" +
                "branchName='" + branchName + '\'' +
                ", openingHour='" + openingHour + '\'' +
                '}';
    }
}
