package com.busyqa.crm.model.finance;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "DISCOUNT")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discountId;
    private double amount;
    private String discountCode;
    private String description;

    // DATE
    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime modifiedTime;

    public Discount(double amount, String discountCode, String description, LocalDateTime createdTime, LocalDateTime modifiedTime) {
        this.amount = amount;
        this.discountCode = discountCode;
        this.description = description;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public Discount() {
    }



    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
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
