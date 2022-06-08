package com.equipment.accounting.back.service.impl;

import com.equipment.accounting.back.model.Equipment;
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
        return equipmentRepository.getEquipmentByEquipmentName(equipmentName);
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

    @Override
    public boolean existsEquipmentByEquipmentOrderNumber(String equipmentOrderNumber) {
        return equipmentRepository.existsEquipmentByEquipmentOrderNumber(equipmentOrderNumber);
    }

    @Override
    public List<Equipment> addAll(List<Equipment> equipmentList) {
        return equipmentRepository.saveAllAndFlush(equipmentList);
    }

    @Override
    public boolean existsEquipmentByEquipmentSerialNumber(String equipmentSerialNumber) {
        return equipmentRepository.existsByEquipmentSerialNumber(equipmentSerialNumber);
    }

    @Override
    public boolean existsEquipmentById(Long id) {
        return equipmentRepository.existsById(id);
    }

    @Override
    public boolean existsEquipmentByName(String equipmentName) {
        return equipmentRepository.existsByEquipmentName(equipmentName);
    }
}
