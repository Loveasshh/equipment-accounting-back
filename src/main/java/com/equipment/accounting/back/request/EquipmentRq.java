package com.equipment.accounting.back.request;

public class EquipmentRq {
    private String equipmentName;

    private String equipmentDescription;

    private String equipmentOrderNumber;

    private String equipmentSerialNumber;

    private String categoryName;

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentDescription() {
        return equipmentDescription;
    }

    public void setEquipmentDescription(String equipmentDescription) {
        this.equipmentDescription = equipmentDescription;
    }

    public String getEquipmentOrderNumber() {
        return equipmentOrderNumber;
    }

    public void setEquipmentOrderNumber(String equipmentOrderNumber) {
        this.equipmentOrderNumber = equipmentOrderNumber;
    }

    public String getEquipmentSerialNumber() {
        return equipmentSerialNumber;
    }

    public void setEquipmentSerialNumber(String equipmentSerialNumber) {
        this.equipmentSerialNumber = equipmentSerialNumber;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
