package com.busyqa.crm.model.finance;

import javax.persistence.*;


@Entity
@Table(name = "PAYMENT_PLANS")
public class PaymentPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String paymentMethod;
    private int weekFrequency;

    public PaymentPlan() {
    }

    public PaymentPlan(String name, String paymentMethod, int weekFrequency) {
        this.name = name;
        this.paymentMethod = paymentMethod;
        this.weekFrequency = weekFrequency;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeekFrequency() {
        return weekFrequency;
    }

    public void setWeekFrequency(int weekFrequency) {
        this.weekFrequency = weekFrequency;
    }
}
