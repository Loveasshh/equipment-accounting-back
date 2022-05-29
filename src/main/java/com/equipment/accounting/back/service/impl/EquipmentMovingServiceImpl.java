package com.equipment.accounting.back.service.impl;

import com.equipment.accounting.back.model.EquipmentMoving;
import com.equipment.accounting.back.repository.EquipmentMovingRepository;
import com.equipment.accounting.back.service.EquipmentMovingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentMovingServiceImpl implements EquipmentMovingService {

    @Autowired
    EquipmentMovingRepository equipmentMovingRepository;

    @Override
    public EquipmentMoving getByEquipmentMovingId(Long id) {
        return equipmentMovingRepository.getById(id);
    }

    @Override
    public void deleteEquipmentMoving(Long id) {
        equipmentMovingRepository.deleteById(id);
    }

    @Override
    public EquipmentMoving addEquipmentMoving(EquipmentMoving equipmentMoving) {
        return equipmentMovingRepository.saveAndFlush(equipmentMoving);
    }

    @Override
    public List<EquipmentMoving> getAllEquipmentMoving() {
        return equipmentMovingRepository.findAll();
    }

    @Override
    public List<EquipmentMoving> findAllByOOrderByMovingDateDesc() {
        return equipmentMovingRepository.findAllByOrderByMovingDateDesc();
    }
}
