package com.equipment.accounting.back.repository;

import com.equipment.accounting.back.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    boolean existsEquipmentByEquipmentOrderNumber (String equipmentOrderNumber);

    boolean existsByEquipmentSerialNumber (String equipmentSerialNumber);

    Equipment getEquipmentByEquipmentName (String equipmentName);

}
