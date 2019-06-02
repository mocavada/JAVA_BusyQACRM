package com.busyqa.crm.model.academics;

import javax.persistence.*;

@Entity
@Table(name = "CLASSES")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int units;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    //
    public Class() {
    }

    public Class(int units, String name, String description, Course course) {
        this.units = units;
        this.name = name;
        this.description = description;
        this.course = course;
    }

    public Long getId() {
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
