package com.busyqa.crm.model.clients;

import com.busyqa.crm.model.finance.LateFee;
import com.busyqa.crm.model.finance.Payment;
import com.busyqa.crm.model.finance.Tax;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "STUDENTS")
public class Student extends Lead {

    private double amountPaid;
    private double balance;
    private double weeklyPayment;
    private Boolean isPaymentLate;

    @OneToMany(cascade = PERSIST, mappedBy = "student")
    private List<Payment> payments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="tax_id")
    private Tax taxRate;

    @ManyToOne
    @JoinColumn(name="lateFee_id")
    private LateFee lateFee;


    public Student() {
    }


    public Student(double amountPaid, double balance, double weeklyPayment, Boolean isPaymentLate, List<Payment> payments, Tax taxRate, LateFee lateFee) {
        this.amountPaid = amountPaid;
        this.balance = balance;
        this.weeklyPayment = weeklyPayment;
        this.isPaymentLate = isPaymentLate;
        this.payments = payments;
        this.taxRate = taxRate;
        this.lateFee = lateFee;
    }

    public void setWeeklyPayment(double weeklyPayment) {

        this.weeklyPayment = weeklyPayment;
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


    public Boolean getPaymentLate() {
        return isPaymentLate;
    }

    public void setPaymentLate(Boolean paymentLate) {
        isPaymentLate = paymentLate;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Tax getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Tax taxRate) {
        this.taxRate = taxRate;
    }

    public LateFee getLateFee() {
        return lateFee;
    }

    public void setLateFee(LateFee lateFee) {
        this.lateFee = lateFee;
    }

    public double getWeeklyPayment() {
        return weeklyPayment;
    }



    // CUSTOM METHODS

//    public double getWeeklyPayment() {
//        return this.weeklyPayment = (this.getTotalCourseFee()) / this.getPaymentPlan().getWeekFrequency();
//    }
//
//    public void addPayment(Payment payment) {
//        this.payments.add(payment);
//    }
//
//    public double getTotalPayments() {
//        double sum = payments.stream()
//                .filter(o -> o.getAmount() > 10)
//                .mapToDouble(o -> o.getAmount()).sum();
//        return sum;
//    }
//
//
//    public double getTotalBalance() {
//        if(isPaymentLate) {
//            return (this.getTotalCourseFee() * (1 + this.taxRate.getTaxRate()))
//                    - this.getTotalPayments()
//                    + this.lateFee.getFee();
//        } else {
//            return (this.getTotalCourseFee() * (1 + this.taxRate.getTaxRate()))
//                    - this.getTotalPayments();
//        }
//    }
//
//
//    public Map<String, Double> getPaymentSchedules() {
//
//        Double weeklyPayment = this.getWeeklyPayment();
//
//        Calendar courseStartDate = this.getCourseSchedule().getDateStart();
//        Date dateX = courseStartDate.getTime();
//        Calendar calendarX = Calendar.getInstance();
//        calendarX.setTime(dateX);
//        int startWeek = calendarX.get(Calendar.WEEK_OF_YEAR);
//
//        for (int i = startWeek; i < startWeek + this.getPaymentPlan().getWeekFrequency(); i++) {
//
//            calendarX.set(Calendar.WEEK_OF_YEAR, i);
//            Calendar calDate = this.dateToCalendar(calendarX.getTime());
//            paymentSchedules.put(calDate.toString(), weeklyPayment);
//        }
//        return this.paymentSchedules;
//    }
//
//
//    public Calendar getDateStart() {
//        return this.getCourseSchedule().getDateStart();
//    }
//
//    public Calendar getDateEnd() {
//        return this.getCourseSchedule().getDateEnd();
//    }
//
//    //HELPER METHOD
//    //Convert Date to Calendar
//    private Calendar dateToCalendar(Date date) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        return calendar;
//
//    }



    //    @JsonIgnore
//    public void updateBalance() {
//        this.setBalance(this.getClassFee() - this.getAmountPaid());
//    }
}
