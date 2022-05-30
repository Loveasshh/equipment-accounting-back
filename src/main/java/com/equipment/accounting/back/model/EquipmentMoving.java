package com.equipment.accounting.back.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
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

    private Timestamp movingDate;

    private String movingType;

    private String movingTo;

    private String movingFrom;

    private String purpose;

    private Boolean isTemporary;

    private String description;

    public EquipmentMoving() {
    }

    public EquipmentMoving(User user, Equipment equipment, Timestamp movingDate, String movingType, String movingTo, String movingFrom, String purpose, Boolean isTemporary, String description) {
        this.user = user;
        this.equipment = equipment;
        this.movingDate = movingDate;
        this.movingType = movingType;
        this.movingTo = movingTo;
        this.movingFrom = movingFrom;
        this.purpose = purpose;
        this.isTemporary = isTemporary;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getMovingDate() {
        return movingDate;
    }

    public void setMovingDate(Timestamp movingDate) {
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

    public void setMovingFrom(String movingFrom) {
        this.movingFrom = movingFrom;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Boolean getTemporary() {
        return isTemporary;
    }

    public void setTemporary(Boolean temporary) {
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
