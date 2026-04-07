package org.example.ss02.model.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final Map<String, String> accounts = new HashMap<>();
    private final Map<String, String> roles = new HashMap<>();

    public AuthService() {
        accounts.put("hr_manager", "hr123");
        accounts.put("hr_staff", "staff456");

        roles.put("hr_manager", "hr_manager");
        roles.put("hr_staff", "hr_staff");
    }

    public boolean login(String username, String password) {
        return accounts.containsKey(username) && accounts.get(username).equals(password);
    }

    public String getRole(String username) {
        return roles.get(username);
    }
}