package com.equipment.accounting.back.request;

public class EquipmentMovingRq {
    private Long userId;

    private Long equipmentId;

    private String movingType;

    private String movingTo;

    private String movingFrom;

    private String purpose;

    private String isTemporary;

    private String returnDate;

    private String description;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getMovingType() {
        return movingType;
    }

    public void setMovingType(String movingType) {
        this.movingType = movingType;
    }

    public String getMovingTo() {
        return movingTo;
    }

    public void setMovingTo(String movingTo) {
        this.movingTo = movingTo;
    }

    public String getMovingFrom() {
        return movingFrom;
    }

    public void setMovingFrom(String movingFrom) {
        this.movingFrom = movingFrom;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getIsTemporary() {
        return isTemporary;
    }

    public void setIsTemporary(String temporary) {
        isTemporary = temporary;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
