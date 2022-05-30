package com.equipment.accounting.back.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String equipmentName;

    private String equipmentDescription;

    private String equipmentOrderNumber;

    private String equipmentSerialNumber;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    @JsonManagedReference
    private Category category;

    @OneToMany(mappedBy="equipment")
    @JsonBackReference
    private Set<EquipmentMoving> equipmentMovingSet;

    @OneToMany(mappedBy="user")
    @JsonBackReference
    private Set<EquipmentMoving> userSet;

    public Equipment() {
    }

    public Equipment(String equipmentName, String equipmentDescription, String equipmentOrderNumber, String equipmentSerialNumber, Category category) {
        this.equipmentName = equipmentName;
        this.equipmentDescription = equipmentDescription;
        this.equipmentOrderNumber = equipmentOrderNumber;
        this.equipmentSerialNumber = equipmentSerialNumber;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<EquipmentMoving> getEquipmentMovingSet() {
        return equipmentMovingSet;
    }

    public void setEquipmentMovingSet(Set<EquipmentMoving> equipmentMovingSet) {
        this.equipmentMovingSet = equipmentMovingSet;
    }

    public Set<EquipmentMoving> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<EquipmentMoving> userSet) {
        this.userSet = userSet;
    }


}
