package com.busyqa.crm.model.academics;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TRAINING_LOCATIONS")
public class TrainingLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long trainingLocationId;

    private Boolean isOnline;

    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;


    // TEMPORAL
    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime modifiedTime;

    public TrainingLocation() {
    }

    public TrainingLocation(Boolean isOnline, String name, String street, String city, String state, String zip, LocalDateTime createdTime, LocalDateTime modifiedTime) {
        this.isOnline = isOnline;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public long getTrainingLocationId() {
        return trainingLocationId;
    }

    public void setTrainingLocationId(long trainingLocationId) {
        this.trainingLocationId = trainingLocationId;
    }

    public void setTrainingLocationId(Integer trainingLocationId) {
        this.trainingLocationId = trainingLocationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
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
}
