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
    private Integer id;

    private String trainerName;

    private String trainerEmail;

    private String trainerPhone;

    private String trainerSkype;

    private byte[] trainerImage;

    // TEMPORAL
    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime modifiedTime;

    public Trainer() {
    }

    public Trainer(String trainerName, String trainerEmail, String trainerPhone, String trainerSkype, byte[] trainerImage, LocalDateTime createdTime, LocalDateTime modifiedTime) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrainerSkype() {
        return trainerSkype;
    }

    public void setTrainerSkype(String trainerSkype) {
        this.trainerSkype = trainerSkype;
    }

    public byte[] getTrainerImage() {
        return trainerImage;
    }

    public void setTrainerImage(byte[] trainerImage) {
        this.trainerImage = trainerImage;
    }


}
