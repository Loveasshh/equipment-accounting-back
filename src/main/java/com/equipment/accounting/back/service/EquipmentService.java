package com.equipment.accounting.back.service;

import com.equipment.accounting.back.models.Equipment;

import java.util.List;

public interface EquipmentService {

    Equipment getByEquipmentId (Long id);
    Equipment getByEquipmentName (String equipmentName);
    void deleteEquipment(Long id);
    Equipment addEquipment (Equipment equipment);
    List<Equipment> getAllEquipment();

}
