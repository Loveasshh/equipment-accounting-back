package com.equipment.accounting.back.controller;

import com.equipment.accounting.back.model.Category;
import com.equipment.accounting.back.model.Equipment;
import com.equipment.accounting.back.model.EquipmentMoving;
import com.equipment.accounting.back.model.User;
import com.equipment.accounting.back.repository.UserRepository;
import com.equipment.accounting.back.request.EquipmentRq;
import com.equipment.accounting.back.repository.EquipmentRepository;
import com.equipment.accounting.back.response.MessageRs;
import com.equipment.accounting.back.service.impl.CategoryServiceImpl;
import com.equipment.accounting.back.service.impl.EquipmentServiceImpl;
import com.equipment.accounting.back.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
