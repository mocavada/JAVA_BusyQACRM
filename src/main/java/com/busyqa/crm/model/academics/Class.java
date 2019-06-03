package com.busyqa.crm.model.academics;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "CLASSES",
       uniqueConstraints = {
       @UniqueConstraint(columnNames = {"name"}),
})
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique=true)
    private String name;
    private String description;
    private int units;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    //
    public Class() {
    }

    public Class(String name, String description, int units, Course course) {
        this.name = name;
        this.description = description;
        this.units = units;
        this.course = course;
    }

    public int getId() {
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", units=" + units +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", course=" + course +
                '}';
    }
}
