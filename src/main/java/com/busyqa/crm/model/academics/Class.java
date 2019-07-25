package com.busyqa.crm.model.academics;

import javax.persistence.*;

@Entity
@Table(name = "CLASSES")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique=true)
    private String name;
    private String description;
    private int units;

    //
    public Class() {
    }

    public Class(String name, String description, int units) {
        this.name = name;
        this.description = description;
        this.units = units;
    }

    public long getId() {
        return id;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", units=" + units +
                '}';
    }
}
