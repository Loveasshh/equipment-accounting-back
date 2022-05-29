package com.equipment.accounting.back.controller;

import com.equipment.accounting.back.model.Category;
import com.equipment.accounting.back.model.Equipment;
import com.equipment.accounting.back.model.EquipmentMoving;
import com.equipment.accounting.back.model.User;
import com.equipment.accounting.back.request.EquipmentMovingRq;
import com.equipment.accounting.back.request.EquipmentRq;
import com.equipment.accounting.back.response.MessageRs;
import com.equipment.accounting.back.service.impl.EquipmentMovingServiceImpl;
import com.equipment.accounting.back.service.impl.EquipmentServiceImpl;
import com.equipment.accounting.back.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/equipmentMoving")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EquipmentMovingController {

    @Autowired
    EquipmentMovingServiceImpl equipmentMovingService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    EquipmentServiceImpl equipmentService;

    @PostMapping("/addEquipmentMoving")
    public ResponseEntity<?> addEquipmentMoving (@RequestBody EquipmentMovingRq equipmentMovingRq) {
        Long userId = equipmentMovingRq.getUserId();
        Long equipmentId = equipmentMovingRq.getEquipmentId();
        Timestamp movingDate = new Timestamp(new Date().getTime());
        String movingType = equipmentMovingRq.getMovingType();
        String movingTo = equipmentMovingRq.getMovingTo();
        String movingFrom = equipmentMovingRq.getMovingFrom();
        String purpose = equipmentMovingRq.getPurpose();
        Boolean isTemporary = equipmentMovingRq.getIsTemporary();
        String description = equipmentMovingRq.getDescription();

        User user = userService.getByUserId(userId);
        Equipment equipment = equipmentService.getByEquipmentId(equipmentId);

        EquipmentMoving equipmentMoving = new EquipmentMoving(user, equipment, movingDate, movingType,
                movingTo, movingFrom, purpose, isTemporary, description);

        equipmentMovingService.addEquipmentMoving(equipmentMoving);
        return ResponseEntity.ok(new MessageRs("EquipmentMoving added"));
    }

    @GetMapping("/getAll")
    public List<EquipmentMoving> getAllEquipmentMoving () {
        List<EquipmentMoving> equipmentMovings = equipmentMovingService.getAllEquipmentMoving();
//        equipmentMovings.
        int i = 1;
        return equipmentMovingService.getAllEquipmentMoving();
    }

    @GetMapping("/getAllWithUniqueEquipment")
    public List<EquipmentMoving> getAllWithUniqueEquipment () {
        List<EquipmentMoving> equipmentMovings = equipmentMovingService.getAllEquipmentMoving();
        Collection<Long>  equipmentMovingCollection = equipmentMovings
                .stream()
                .collect(Collectors.toMap(EquipmentMoving::getEquipment, EquipmentMoving::getId, Long::max))
                .values();
        List<EquipmentMoving> equipmentMovingList = equipmentMovings
                .stream()
                .filter(x -> equipmentMovingCollection.contains(x.getId()))
                .collect(Collectors.toList());

        return equipmentMovingList;
    }

    @GetMapping("/getAllOrderByDate")
    public List<EquipmentMoving> getAllEquipmentMovingOrderByDate () {
        return equipmentMovingService.findAllByOOrderByMovingDateDesc();
    }
}
