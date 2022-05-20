package com.equipment.accounting.back.service.impl;

import com.equipment.accounting.back.models.Equipment;
import com.equipment.accounting.back.repository.EquipmentRepository;
import com.equipment.accounting.back.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    EquipmentRepository equipmentRepository;

    @Override
    public Equipment getByEquipmentId(Long id) {
        return equipmentRepository.getById(id);
    }

    @Override
    public Equipment getByEquipmentName(String equipmentName) {
        return null;
    }

    @Override
    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);
    }

    @Override
    public Equipment addEquipment(Equipment equipment) {
        return equipmentRepository.saveAndFlush(equipment);
    }

    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }
}
