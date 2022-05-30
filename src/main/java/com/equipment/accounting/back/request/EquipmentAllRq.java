package com.equipment.accounting.back.request;

import com.equipment.accounting.back.model.Equipment;

import java.util.List;

public class EquipmentAllRq {
    List<EquipmentRq> equipmentList;

    public List<EquipmentRq> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<EquipmentRq> equipmentList) {
        this.equipmentList = equipmentList;
    }
}
