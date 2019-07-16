package com.busyqa.crm.model.finance;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "REGISTRATION_FEE")
public class RegistrationFee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationFeeId;
    private double fee;
    private String description;

    // DATE
    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime modifiedTime;

    public RegistrationFee() {
    }

    public RegistrationFee(double fee, String description, LocalDateTime createdTime, LocalDateTime modifiedTime) {
        this.fee = fee;
        this.description = description;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public Long getRegistrationFeeId() {
        return registrationFeeId;
    }

    public void setRegistrationFeeId(Long registrationFeeId) {
        this.registrationFeeId = registrationFeeId;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
