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
    private Integer id;

    private Boolean isOnLine;
    private String name;
    private String trainingStreet;
    private String trainingCity;
    private String trainerState;
    private String trainerZip;


    // TEMPORAL
    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime modifiedTime;

    public TrainingLocation() {
    }

    public TrainingLocation(Boolean isOnLine, String name, String trainingStreet, String trainingCity, String trainerState, String trainerZip, LocalDateTime createdTime, LocalDateTime modifiedTime) {
        this.isOnLine = isOnLine;
        this.name = name;
        this.trainingStreet = trainingStreet;
        this.trainingCity = trainingCity;
        this.trainerState = trainerState;
        this.trainerZip = trainerZip;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getOnLine() {
        return isOnLine;
    }

    public void setOnLine(Boolean onLine) {
        isOnLine = onLine;
    }

    public String getTrainingStreet() {
        return trainingStreet;
    }

    public void setTrainingStreet(String trainingStreet) {
        this.trainingStreet = trainingStreet;
    }

    public String getTrainingCity() {
        return trainingCity;
    }

    public void setTrainingCity(String trainingCity) {
        this.trainingCity = trainingCity;
    }

    public String getTrainerState() {
        return trainerState;
    }

    public void setTrainerState(String trainerState) {
        this.trainerState = trainerState;
    }

    public String getTrainerZip() {
        return trainerZip;
    }

    public void setTrainerZip(String trainerZip) {
        this.trainerZip = trainerZip;
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
