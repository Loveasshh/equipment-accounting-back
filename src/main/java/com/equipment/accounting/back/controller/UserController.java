package com.equipment.accounting.back.controller;

import com.equipment.accounting.back.model.User;
import com.equipment.accounting.back.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @ResponseBody
    @GetMapping("/getUserByName")
    public User getUserByName(@RequestParam String name) {
        return userService.getByUserUsername(name);
    }

    @ResponseBody
    @GetMapping("/existByUsername")
    public boolean existByName (@RequestParam String username) {
        return userService.existUserByName(username);
    }
    @Transactional
    @ResponseBody
    @PostMapping("/deleteUser")
    public void deleteUser (@RequestParam String username) {
        userService.setIsEmployeeForUser(false, username);
        int i = 1;
    }
    @ResponseBody
    @GetMapping("/checkUser")
    public boolean checkUser (@RequestParam String username) {
        return userService.getByUserUsername(username).getIsEmployee();
    }
}
