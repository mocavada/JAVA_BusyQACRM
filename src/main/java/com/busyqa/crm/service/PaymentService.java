package com.busyqa.crm.service;

import com.busyqa.crm.model.EnumList;
import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.clients.Student;
import com.busyqa.crm.model.finance.Payment;
import com.busyqa.crm.repo.IAcademicsRepository;
import com.busyqa.crm.repo.IPaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private IPaymentRepository paymentRepository;

    @Autowired
    private IAcademicsRepository academicsRepository;

    public List<Payment> generateStudentPayments(String courseName, String paymentPlan, double feePaid, Student student) {

        Course course = academicsRepository.findByCourseName(courseName)
                .orElseThrow(() -> new RuntimeException("Fail! -> No Course Found"));

        double regularFee = course.getFee() - feePaid;
        double taxFee = (regularFee*(course.getTaxPercentage()))/100.0;
        double lateFeeRate = course.getLateFeeRate();

        List<Payment> payments = generatePayments(paymentPlan, regularFee, taxFee,0,
                course.getPaymentDurationWeek(), course.getPaymentDurationBiWeek());

        List<String> dates = generatePaymentDate(student.getDateStart().toString(), paymentPlan,
                course.getPaymentDurationWeek(),course.getPaymentDurationBiWeek());

        if (payments.size() != dates.size()) throw new RuntimeException("Error: Check Helper Method???!");

        for (int i = 0; i<payments.size(); i++) {
            if ((checkDateCondition(dates.get(i))) &&
                    (payments.get(i).getPaymentStatus().equals(EnumList.UNPAID.toString()))) {
                double amountBeforeLateFee = payments.get(i).getAmount();
                payments.get(i).setLateFee((amountBeforeLateFee*lateFeeRate)/100.0);
                payments.get(i).setAmount(amountBeforeLateFee+payments.get(i).getLateFee());
            }
            payments.get(i).setDate(dates.get(i));
            payments.get(i).setStudent(student);
            paymentRepository.save(payments.get(i));
        }
        return payments;
    }

    public double getUpdatePaidAmount(Long studentId) {
        Pageable pageable = PageRequest.of(0, 30);
        Page<Payment> paymentsPage = paymentRepository.findByStudentId(studentId,pageable);
        List<Payment> payments = paymentsPage.getContent();
        return getPaidFee(payments);

    }



    public List<Payment> updatePayments(Long studentId, String courseName) {

        Course course = academicsRepository.findByCourseName(courseName)
                .orElseThrow(() -> new RuntimeException("Fail! -> No Course Found"));

        double lateFeeRate = course.getLateFeeRate();
        Pageable pageable = PageRequest.of(0, 30, Sort.by("date"));
        Page<Payment> paymentsPage = paymentRepository.findByStudentId(studentId,pageable);
        List<Payment> payments = paymentsPage.getContent();

        for (Payment p: payments) {
            if ((checkDateCondition(p.getDate())) &&
                    (p.getPaymentStatus().equals(EnumList.UNPAID.toString()))) {
                double amountBeforeLateFee = p.getAmount();
                p.setLateFee((amountBeforeLateFee*lateFeeRate)/100.0);
                p.setAmount(amountBeforeLateFee+p.getLateFee());
            }
            paymentRepository.save(p);
        }

        return payments;
    }





    /** HELPER METHODS */
    // generate payments based on payment plan
    public static List<Payment> generatePayments(String paymentPlan, double regularFee, double taxFee, double lateFee,
                                                 double weekFrequency, double biWeekFrequency) {
        List<Payment> payments = new ArrayList<>();
        if (paymentPlan.equals(EnumList.ONE_TIME_CREDIT_CARD.toString()) ||
                paymentPlan.equals(EnumList.ONE_TIME_DEBIT_CARD_OR_CASH.toString()) ||
                paymentPlan.equals(EnumList.ONE_TIME_EMAIL_MONEY.toString())) {

            payments.add(new Payment("", regularFee, taxFee, lateFee,
                    regularFee+taxFee+lateFee, EnumList.UNPAID.toString()));

        } else if (paymentPlan.equals(EnumList.AUTOMATED_WEEKLY.toString())) {
            for (int i = 0; i < weekFrequency; i++) {
                payments.add(new Payment("", regularFee/weekFrequency, taxFee/weekFrequency, lateFee,
                        ((regularFee+taxFee)/weekFrequency)+lateFee, EnumList.UNPAID.toString()));
            }
        } else {
            for (int i = 0; i < biWeekFrequency; i++) {
                payments.add(new Payment("", regularFee/biWeekFrequency, taxFee/biWeekFrequency, lateFee,
                        ((regularFee+taxFee)/biWeekFrequency)+lateFee, EnumList.UNPAID.toString()));
            }
        }
        return payments;
    }

    // generate payment dates
    // given start date, payment plan
    public static List<String> generatePaymentDate(String dateString, String paymentPlan,
                                                   double weekFrequency, double biWeekFrequency) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date = LocalDate.parse(dateString, myFormatObj);
        List<String> dates2Generate = new ArrayList<>();
        if (paymentPlan.equals(EnumList.ONE_TIME_CREDIT_CARD.toString()) ||
                paymentPlan.equals(EnumList.ONE_TIME_DEBIT_CARD_OR_CASH.toString()) ||
                paymentPlan.equals(EnumList.ONE_TIME_EMAIL_MONEY.toString())) {
            // if one time payment selected, the deadline to pay the fee would be one week
            // after the class started.
            dates2Generate.add(date.plus(1, ChronoUnit.WEEKS).format(myFormatObj));
        } else if (paymentPlan.equals(EnumList.AUTOMATED_WEEKLY.toString())) {
            for (int i = 0; i < weekFrequency; i++) {
                dates2Generate.add(date.plus(i*7+3, ChronoUnit.DAYS).format(myFormatObj));
            }
        }
        else {
            for (int i = 0; i < biWeekFrequency; i++) {
                dates2Generate.add(date.plus(i*14+3, ChronoUnit.DAYS).format(myFormatObj));
            }
        }
        return dates2Generate;
    }

    // calculate late fee given late fee rule
    // calculate paid amount of a lead
    public static double calculatePaidAmount(boolean paidDeposit, double discount) {
        if (paidDeposit) {
            return 400+discount;
        } else { return  discount;}
    }


    // given a date string, give true if this date is more than one week of the present date
    public static boolean checkDateCondition(String dateString) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate event = LocalDate.parse(dateString, myFormatObj);
        LocalDate today = LocalDate.now();
        LocalDate weekBeforeToday = today.minusWeeks(1);
        System.out.println(weekBeforeToday.compareTo(event));
        if (weekBeforeToday.compareTo(event) > 0) {
            return true; // you need to pay late fee because event is more than 7 days ago
        } else {
            return false;
        }
    }

    public static double getPaidFee(List<Payment> payments) {
        int amountpaid = 0;
        for (Payment p: payments) {
            amountpaid += p.getPaidAmount();
        }
        return amountpaid;
    }


}
