package com.busyqa.crm.model.academics;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COURSES")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseId;
    private String name;
    private String batch;
    private String description;
    private Double fee;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Class> classes = new ArrayList<>();

    // TEMPORAL
    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime modifiedTime;

    //
    public Course() {
    }

    public Course(String name, String batch, String description, Double fee, List<Class> classes, LocalDateTime createdTime, LocalDateTime modifiedTime) {
        this.name = name;
        this.batch = batch;
        this.description = description;
        this.fee = fee;
        this.classes = classes;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
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


    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }



    // CUSTOM METHODS
    public void addClass(Class newClass) {
        this.classes.add(newClass);
    }

    public void removeClass(Class classEntry) {

        this.classes.remove(classEntry);
    }


}


//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(referencedColumnName = "id")
//    private Client lead;
