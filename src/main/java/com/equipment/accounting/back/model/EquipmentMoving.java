package com.equipment.accounting.back.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "equipment_moving")
public class EquipmentMoving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    @JsonManagedReference
    private User user;

    @ManyToOne
    @JoinColumn(name="equipment_id", nullable = false)
    @JsonManagedReference
    private Equipment equipment;

    private Date movingDate;

    private String movingType;

    private String movingTo;

    private String movingFrom;

    private String purpose;

    private String isTemporary;

    private String returnDate;

    private String description;

    public EquipmentMoving() {
    }

    public EquipmentMoving(User user, Equipment equipment, Date movingDate, String movingType, String movingTo,
               String movingFrom, String purpose, String isTemporary,String returnDate, String description) {
        this.user = user;
        this.equipment = equipment;
        this.movingDate = movingDate;
        this.movingType = movingType;
        this.movingTo = movingTo;
        this.movingFrom = movingFrom;
        this.purpose = purpose;
        this.isTemporary = isTemporary;
        this.returnDate = returnDate;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getMovingDate() {
        return movingDate;
    }

    public void setMovingDate(Date movingDate) {
        this.movingDate = movingDate;
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

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
