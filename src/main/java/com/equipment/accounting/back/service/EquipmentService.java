package com.equipment.accounting.back.service;

import com.equipment.accounting.back.model.Equipment;

import java.util.List;

public interface EquipmentService {

    Equipment getByEquipmentId (Long id);
    Equipment getByEquipmentName (String equipmentName);
    void deleteEquipment(Long id);
    Equipment addEquipment (Equipment equipment);
    List<Equipment> getAllEquipment();

    List<Equipment> addAll(List<Equipment> equipmentList);

    boolean existsEquipmentByEquipmentOrderNumber (String equipmentOrderNumber);

    boolean existsEquipmentByEquipmentSerialNumber (String equipmentSerialNumber);

    boolean existsEquipmentById (Long id);

    boolean existsEquipmentByName (String equipmentName);

}
