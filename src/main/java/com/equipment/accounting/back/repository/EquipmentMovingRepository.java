package com.equipment.accounting.back.repository;

import com.equipment.accounting.back.model.EquipmentMoving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentMovingRepository extends JpaRepository<EquipmentMoving, Long> {
    List<EquipmentMoving> findAllByOrderByMovingDateDesc();
}
