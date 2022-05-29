package com.equipment.accounting.back.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TestController {
    @GetMapping("/user")
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userAccess() {
        return "user API";
    }

    @GetMapping("/admin")
//    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "admin API";
    }
}