package com.busyqa.crm.model.clients;

import com.busyqa.crm.model.auth.UserGroup;
import com.busyqa.crm.model.finance.Payment;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "INTERNS")
public class Intern extends Lead {
    private double amountPaid;
    private double balance;
    private String coopStatus;
    private String projectAssigned;
    private String performance;

    // DATES
    @Basic
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Calendar coopStartDate;
    @Basic
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Calendar coopEndDate;

    @OneToMany(mappedBy = "intern", cascade = CascadeType.PERSIST)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Payment> payments = new ArrayList<>();

    public Intern() {
    }

    public Intern(String username, String password, String email, String firstName, Set<UserGroup> usergroups) {
        super(username, password, email, firstName, usergroups);
    }


    public Intern(String username, String password, String email, String firstName, Set<UserGroup> usergroups, double amountPaid, double balance, String coopStatus, String projectAssigned, String performance, Calendar coopStartDate, Calendar coopEndDate, List<Payment> payments) {
        super(username, password, email, firstName, usergroups);
        this.amountPaid = amountPaid;
        this.balance = balance;
        this.coopStatus = coopStatus;
        this.projectAssigned = projectAssigned;
        this.performance = performance;
        this.coopStartDate = coopStartDate;
        this.coopEndDate = coopEndDate;
        this.payments = payments;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCoopStatus() {
        return coopStatus;
    }

    public void setCoopStatus(String coopStatus) {
        this.coopStatus = coopStatus;
    }

    public Calendar getCoopStartDate() {
        return coopStartDate;
    }

    public void setCoopStartDate(Calendar coopStartDate) {
        this.coopStartDate = coopStartDate;
    }

    public Calendar getCoopEndDate() {
        return coopEndDate;
    }

    public void setCoopEndDate(Calendar coopEndDate) {
        this.coopEndDate = coopEndDate;
    }

    public String getProjectAssigned() {
        return projectAssigned;
    }

    public void setProjectAssigned(String projectAssigned) {
        this.projectAssigned = projectAssigned;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
