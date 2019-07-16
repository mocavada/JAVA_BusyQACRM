package com.busyqa.crm.model.academics;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TRAINERS")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainerId;

    private String trainerName;

    private String trainerEmail;

    private String trainerPhone;

    private String trainerSkype;

    private String trainerImage;

    // TEMPORAL
    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime modifiedTime;

    public Trainer() {
    }

    public Trainer(String trainerName, String trainerEmail, String trainerPhone, String trainerSkype, String trainerImage, LocalDateTime createdTime, LocalDateTime modifiedTime) {
        this.trainerName = trainerName;
        this.trainerEmail = trainerEmail;
        this.trainerPhone = trainerPhone;
        this.trainerSkype = trainerSkype;
        this.trainerImage = trainerImage;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrainerEmail() {
        return trainerEmail;
    }

    public void setTrainerEmail(String trainerEmail) {
        this.trainerEmail = trainerEmail;
    }

    public String getTrainerPhone() {
        return trainerPhone;
    }

    public void setTrainerPhone(String trainerPhone) {
        this.trainerPhone = trainerPhone;
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

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerSkype() {
        return trainerSkype;
    }

    public void setTrainerSkype(String trainerSkype) {
        this.trainerSkype = trainerSkype;
    }

    public String getTrainerImage() {
        return trainerImage;
    }

    public void setTrainerImage(String trainerImage) {
        this.trainerImage = trainerImage;
    }
}
