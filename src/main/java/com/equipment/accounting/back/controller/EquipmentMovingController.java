package com.equipment.accounting.back.controller;

import com.equipment.accounting.back.model.Category;
import com.equipment.accounting.back.model.Equipment;
import com.equipment.accounting.back.model.EquipmentMoving;
import com.equipment.accounting.back.model.User;
import com.equipment.accounting.back.request.EquipmentMovingExcelRq;
import com.equipment.accounting.back.request.EquipmentMovingRq;
import com.equipment.accounting.back.response.MessageRs;
import com.equipment.accounting.back.service.impl.CategoryServiceImpl;
import com.equipment.accounting.back.service.impl.EquipmentMovingServiceImpl;
import com.equipment.accounting.back.service.impl.EquipmentServiceImpl;
import com.equipment.accounting.back.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Locale;
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

    @Autowired
    CategoryServiceImpl categoryService;

    @PostMapping("/addEquipmentMoving")
    public ResponseEntity<?> addEquipmentMoving (@RequestBody EquipmentMovingRq equipmentMovingRq) {
        String isTemporary;
        String returnDate;
        Long userId = equipmentMovingRq.getUserId();
        Long equipmentId = equipmentMovingRq.getEquipmentId();
        Date movingDate = new Date(Calendar.getInstance().getTime().getTime());
        String movingType = equipmentMovingRq.getMovingType();
        String movingTo = equipmentMovingRq.getMovingTo();
        String movingFrom = equipmentMovingRq.getMovingFrom();
        String purpose = equipmentMovingRq.getPurpose();

        if (movingType.equals("Приход")) {
            isTemporary = "Нет";
            returnDate = "";
        } else {
            isTemporary = equipmentMovingRq.getIsTemporary();
            returnDate = equipmentMovingRq.getReturnDate();
        }

        String description = equipmentMovingRq.getDescription();
        User user = userService.getByUserId(userId);
        Equipment equipment = equipmentService.getByEquipmentId(equipmentId);

        EquipmentMoving equipmentMoving = new EquipmentMoving(user, equipment, movingDate, movingType,
                movingTo, movingFrom, purpose, isTemporary,returnDate, description);

        equipmentMovingService.addEquipmentMoving(equipmentMoving);
        return ResponseEntity.ok(new MessageRs("EquipmentMoving added"));
    }

    @PostMapping("/addEquipmentMovingFromExcel")
    public ResponseEntity<?> addEquipmentMovingFromExcel (@RequestBody EquipmentMovingExcelRq equipmentMovingExcelRq) throws ParseException {

        String userName = equipmentMovingExcelRq.getUserName();
        String equipmentName = equipmentMovingExcelRq.getEquipmentName();
        String equipmentCategory = equipmentMovingExcelRq.getEquipmentCategory();
        String equipmentSerialNumber = equipmentMovingExcelRq.getEquipmentSerialNumber();
        String equipmentOrderNumber = equipmentMovingExcelRq.getEquipmentOrderNumber();
        String movingType = equipmentMovingExcelRq.getMovingType();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date movingDate = new Date(format.parse(equipmentMovingExcelRq.getMovingDate()).getTime());

        String movingTo = equipmentMovingExcelRq.getMovingTo();
        String movingFrom = equipmentMovingExcelRq.getMovingFrom();
        String purpose = equipmentMovingExcelRq.getPurpose();
        String isTemporary = equipmentMovingExcelRq.getIsTemporary();
        String returnDate = equipmentMovingExcelRq.getReturnDate();
        String description = equipmentMovingExcelRq.getDescription();

        Category category;
        Equipment equipment;
        User user = userService.getByUserUsername(userName);

        if (categoryService.existsByCategoryName(equipmentCategory)) {
            category = categoryService.getByCategoryName(equipmentCategory);
        } else {
            category = new Category(equipmentCategory);
            categoryService.addCategory(category);
        }

        if (equipmentService.existsEquipmentByEquipmentSerialNumber(equipmentSerialNumber) && equipmentService.existsEquipmentByName(equipmentName)) {
            equipment = equipmentService.getByEquipmentName(equipmentName);
        } else {
            equipment = new Equipment(equipmentName, "", equipmentOrderNumber, equipmentSerialNumber, category);
            equipmentService.addEquipment(equipment);
        }

        EquipmentMoving equipmentMoving = new EquipmentMoving(user, equipment, movingDate, movingType,
                movingTo, movingFrom, purpose, isTemporary,returnDate, description);

        equipmentMovingService.addEquipmentMoving(equipmentMoving);
        return ResponseEntity.ok(new MessageRs("EquipmentMoving added"));
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
    @GetMapping("/getAllMovingByEquipment")
    public List<EquipmentMoving> getAllMovingByEquipment (@RequestParam String equipmentName, @RequestParam String equipmentSerialNumber) {
        List<EquipmentMoving> equipmentMovings = equipmentMovingService.getAllEquipmentMoving();
        return equipmentMovings
                .stream()
                .filter(equipmentMoving ->
                    equipmentMoving.getEquipment().getEquipmentName().equals(equipmentName)
                )
                .filter(    equipmentMoving ->
                        equipmentMoving.getEquipment().getEquipmentSerialNumber().equals(equipmentSerialNumber))
                .collect(Collectors.toList());
    }
    @GetMapping("/getAllOrderByDate")
    public List<EquipmentMoving> getAllEquipmentMovingOrderByDate () {
        return equipmentMovingService.findAllByOOrderByMovingDateDesc();
    }
}
