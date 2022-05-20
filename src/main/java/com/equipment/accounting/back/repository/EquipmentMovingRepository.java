package com.equipment.accounting.back.repository;

import com.equipment.accounting.back.models.Category;
import com.equipment.accounting.back.models.EquipmentMoving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentMovingRepository extends JpaRepository<EquipmentMoving, Long> {
}
