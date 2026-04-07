package org.example.ss02.model.service;

import org.example.ss02.exception.EmployeeNotFoundException;
import org.example.ss02.model.entity.Employee;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            employees.add(new Employee("NV001", "Nguyễn Thị Lan", "Kế toán", 15000000L, sdf.parse("2020-03-01"), "Đang làm"));
            employees.add(new Employee("NV002", "Trần Văn Hùng", "Kỹ thuật", 25000000L, sdf.parse("2019-07-15"), "Đang làm"));
            employees.add(new Employee("NV003", "Lê Minh Đức", "Kinh doanh", 18500000L, sdf.parse("2021-11-20"), "Nghỉ phép"));
            employees.add(new Employee("NV004", "Phạm Thu Hương", "Kỹ thuật", 22000000L, sdf.parse("2022-01-05"), "Đang làm"));
            employees.add(new Employee("NV005", "Hoàng Văn Nam", "Kế toán", 12000000L, sdf.parse("2023-06-10"), "Thử việc"));
        } catch (ParseException e) {
            throw new RuntimeException("Lỗi khởi tạo dữ liệu nhân viên");
        }
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeByCode(String code) {
        return employees.stream()
                .filter(emp -> emp.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Nhân viên [" + code + "] không tồn tại trong hệ thống"
                ));
    }

    public long getTechnicalDepartmentTotalSalary() {
        return employees.stream()
                .filter(emp -> "Kỹ thuật".equalsIgnoreCase(emp.getDepartment()))
                .mapToLong(Employee::getSalary)
                .sum();
    }
}