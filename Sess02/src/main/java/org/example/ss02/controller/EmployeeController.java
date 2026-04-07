package org.example.ss02.controller;

import jakarta.servlet.http.HttpSession;
import org.example.ss02.model.entity.Employee;
import org.example.ss02.model.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String showEmployees(Model model, HttpSession session) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("technicalTotalSalary", employeeService.getTechnicalDepartmentTotalSalary());
        return "employees";
    }

    @GetMapping("/employees/{code}")
    public String showEmployeeDetail(@PathVariable("code") String code,
                                     Model model,
                                     HttpSession session) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        Employee employee = employeeService.getEmployeeByCode(code);
        model.addAttribute("employee", employee);
        return "employee-detail";
    }
}