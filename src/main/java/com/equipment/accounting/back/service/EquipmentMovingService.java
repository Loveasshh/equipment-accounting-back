package com.equipment.accounting.back.service;

import com.equipment.accounting.back.models.EquipmentMoving;

import java.util.List;

public interface EquipmentMovingService {

    EquipmentMoving getByEquipmentMovingId (Long id);
    void deleteEquipmentMoving(Long id);
    EquipmentMoving addEquipmentMoving (EquipmentMoving equipmentMoving);
    List<EquipmentMoving> getAllEquipmentMoving();

}
