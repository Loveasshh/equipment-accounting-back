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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/equipment")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EquipmentController {

    @Autowired
    EquipmentServiceImpl equipmentService;

    @Autowired
    CategoryServiceImpl categoryService;

    @PostMapping("/add")
    public ResponseEntity<?> addEquipment (@RequestBody EquipmentRq equipmentRq) {

        String equipmentName;
        String equipmentDescription;
        String equipmentOrderNumber;
        String equipmentSerialNumber;
        String categoryName;

        equipmentName = equipmentRq.getEquipmentName();
        equipmentOrderNumber = equipmentRq.getEquipmentOrderNumber();
        equipmentDescription = equipmentRq.getEquipmentDescription();
        if (equipmentDescription == null) {
            equipmentDescription = "";
        }
        equipmentSerialNumber = equipmentRq.getEquipmentSerialNumber();
        categoryName = equipmentRq.getCategoryName();
        categoryName = categoryName.replaceAll("\"","");
        //проверка на существование оборудования по заказному и серийному номеру
        if (equipmentService.existsEquipmentByEquipmentOrderNumber(equipmentOrderNumber) &&
                equipmentService.existsEquipmentByEquipmentSerialNumber(equipmentSerialNumber)) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageRs("Error: Equipment is exist"));
        }

        Category category = categoryService.getByCategoryName(categoryName);

        Equipment equipment = new Equipment(equipmentName, equipmentDescription, equipmentOrderNumber, equipmentSerialNumber, category);

        equipmentService.addEquipment(equipment);

        return ResponseEntity.ok(new MessageRs("Equipment added"));

    }

    @GetMapping("/getAll")
    public List<Equipment> getAllEquipment () {
        return equipmentService.getAllEquipment();
    }

    @ResponseBody
    @GetMapping("/getEquipmentById")
    public Equipment getEquipmentById(@RequestParam Long id) {
        return equipmentService.getByEquipmentId(id);
    }

    @ResponseBody
    @GetMapping("/getEquipmentByName")
    public Equipment getEquipmentByName(@RequestParam String equipmentName) {
        return equipmentService.getByEquipmentName(equipmentName);
    }
}
