package com.equipment.accounting.back.models;

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
    private Category category;

    @OneToMany(mappedBy="equipment")
    private Set<EquipmentMoving> equipmentMovingSet;

    @OneToMany(mappedBy="user")
    private Set<EquipmentMoving> userSet;
}
