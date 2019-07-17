package com.busyqa.crm.model.clients;

import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.academics.CourseSchedule;
import com.busyqa.crm.model.academics.Trainer;
import com.busyqa.crm.model.academics.TrainingLocation;
import com.busyqa.crm.model.auth.UserGroup;
import com.busyqa.crm.model.finance.*;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class DTOClient {

    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

    //USER FIELDS
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emergencyPhone;

    private String dtype;
    private String userState;
    private Set<UserGroup> userGroup;

    // FOR LEADS
    private String clientStatus;
    private String leadSource;
    private String comments;
    private Boolean isCurrentlyEmployed;
    private Boolean isCurrentlyITEmployed;
    private String desiredJob;
    // ADDRESS
    private String mailingStreet;
    private String mailingCity;
    private String mailingState;
    private String mailingZip;
    private String mailingCountry;
    // IS
    private Boolean isRegistrationFeePaid;
    private Boolean isPlanAgreementSigned;
    private Boolean isDiscountGiven;
    // FINANCE
    private RegistrationFee registrationFee;
    private Discount discount;
    private Tax tax;
    private PaymentPlan paymentPlan;
    // ACADEMICS
    private Course course;
    private double totalCourseFee;
    private CourseSchedule courseSchedule;
    private Trainer trainer;
    private TrainingLocation trainingLocation;


    // FOR STUDENTS
    private double amountPaid;
    private double balance;
    private double weeklyPayment;
    private Boolean isPaymentLate;

    private List<Payment> payments;
    private LateFee lateFee;

    //FOR INTERNS
    private String coopStatus;
    private String projectAssigned;
    private String performance;
    private Calendar coopStartDate;
    private Calendar coopEndDate;

    public DTOClient() {
    }

    // CTOR FOR LEADS

    public DTOClient(LocalDateTime createdTime, LocalDateTime modifiedTime, String email, String firstName, String lastName, String phoneNumber, String emergencyPhone, String dtype, String userState, Set<UserGroup> userGroup, String clientStatus, String leadSource, String comments, Boolean isCurrentlyEmployed, Boolean isCurrentlyITEmployed, String desiredJob, String mailingStreet, String mailingCity, String mailingState, String mailingZip, String mailingCountry, Boolean isRegistrationFeePaid, Boolean isPlanAgreementSigned, Boolean isDiscountGiven, RegistrationFee registrationFee, Discount discount, Tax tax, PaymentPlan paymentPlan, Course course, double totalCourseFee, CourseSchedule courseSchedule, Trainer trainer, TrainingLocation trainingLocation) {
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emergencyPhone = emergencyPhone;
        this.dtype = dtype;
        this.userState = userState;
        this.userGroup = userGroup;
        this.clientStatus = clientStatus;
        this.leadSource = leadSource;
        this.comments = comments;
        this.isCurrentlyEmployed = isCurrentlyEmployed;
        this.isCurrentlyITEmployed = isCurrentlyITEmployed;
        this.desiredJob = desiredJob;
        this.mailingStreet = mailingStreet;
        this.mailingCity = mailingCity;
        this.mailingState = mailingState;
        this.mailingZip = mailingZip;
        this.mailingCountry = mailingCountry;
        this.isRegistrationFeePaid = isRegistrationFeePaid;
        this.isPlanAgreementSigned = isPlanAgreementSigned;
        this.isDiscountGiven = isDiscountGiven;
        this.registrationFee = registrationFee;
        this.discount = discount;
        this.tax = tax;
        this.paymentPlan = paymentPlan;
        this.course = course;
        this.totalCourseFee = totalCourseFee;
        this.courseSchedule = courseSchedule;
        this.trainer = trainer;
        this.trainingLocation = trainingLocation;
    }


    // CTOR FOR STUDENTS

    public DTOClient(LocalDateTime createdTime, LocalDateTime modifiedTime, String email, String firstName, String lastName, String phoneNumber, String emergencyPhone, String dtype, String userState, Set<UserGroup> userGroup, String clientStatus, String leadSource, String comments, Boolean isCurrentlyEmployed, Boolean isCurrentlyITEmployed, String desiredJob, String mailingStreet, String mailingCity, String mailingState, String mailingZip, String mailingCountry, Boolean isRegistrationFeePaid, Boolean isPlanAgreementSigned, Boolean isDiscountGiven, RegistrationFee registrationFee, Discount discount, Tax tax, PaymentPlan paymentPlan, Course course, double totalCourseFee, CourseSchedule courseSchedule, Trainer trainer, TrainingLocation trainingLocation, double amountPaid, double balance, double weeklyPayment, Boolean isPaymentLate, List<Payment> payments, LateFee lateFee) {
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emergencyPhone = emergencyPhone;
        this.dtype = dtype;
        this.userState = userState;
        this.userGroup = userGroup;
        this.clientStatus = clientStatus;
        this.leadSource = leadSource;
        this.comments = comments;
        this.isCurrentlyEmployed = isCurrentlyEmployed;
        this.isCurrentlyITEmployed = isCurrentlyITEmployed;
        this.desiredJob = desiredJob;
        this.mailingStreet = mailingStreet;
        this.mailingCity = mailingCity;
        this.mailingState = mailingState;
        this.mailingZip = mailingZip;
        this.mailingCountry = mailingCountry;
        this.isRegistrationFeePaid = isRegistrationFeePaid;
        this.isPlanAgreementSigned = isPlanAgreementSigned;
        this.isDiscountGiven = isDiscountGiven;
        this.registrationFee = registrationFee;
        this.discount = discount;
        this.tax = tax;
        this.paymentPlan = paymentPlan;
        this.course = course;
        this.totalCourseFee = totalCourseFee;
        this.courseSchedule = courseSchedule;
        this.trainer = trainer;
        this.trainingLocation = trainingLocation;
        this.amountPaid = amountPaid;
        this.balance = balance;
        this.weeklyPayment = weeklyPayment;
        this.isPaymentLate = isPaymentLate;
        this.payments = payments;
        this.lateFee = lateFee;
    }




    // CTOR FOR INTERNS


    public DTOClient(LocalDateTime createdTime, LocalDateTime modifiedTime, String email, String firstName, String lastName, String phoneNumber, String emergencyPhone, String dtype, String userState, Set<UserGroup> userGroup, String clientStatus, String leadSource, String comments, Boolean isCurrentlyEmployed, Boolean isCurrentlyITEmployed, String desiredJob, String mailingStreet, String mailingCity, String mailingState, String mailingZip, String mailingCountry, Boolean isRegistrationFeePaid, Boolean isPlanAgreementSigned, Boolean isDiscountGiven, RegistrationFee registrationFee, Discount discount, Tax tax, PaymentPlan paymentPlan, Course course, double totalCourseFee, CourseSchedule courseSchedule, Trainer trainer, TrainingLocation trainingLocation, double amountPaid, double balance, double weeklyPayment, Boolean isPaymentLate, List<Payment> payments, LateFee lateFee, String coopStatus, String projectAssigned, String performance, Calendar coopStartDate, Calendar coopEndDate) {
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emergencyPhone = emergencyPhone;
        this.dtype = dtype;
        this.userState = userState;
        this.userGroup = userGroup;
        this.clientStatus = clientStatus;
        this.leadSource = leadSource;
        this.comments = comments;
        this.isCurrentlyEmployed = isCurrentlyEmployed;
        this.isCurrentlyITEmployed = isCurrentlyITEmployed;
        this.desiredJob = desiredJob;
        this.mailingStreet = mailingStreet;
        this.mailingCity = mailingCity;
        this.mailingState = mailingState;
        this.mailingZip = mailingZip;
        this.mailingCountry = mailingCountry;
        this.isRegistrationFeePaid = isRegistrationFeePaid;
        this.isPlanAgreementSigned = isPlanAgreementSigned;
        this.isDiscountGiven = isDiscountGiven;
        this.registrationFee = registrationFee;
        this.discount = discount;
        this.tax = tax;
        this.paymentPlan = paymentPlan;
        this.course = course;
        this.totalCourseFee = totalCourseFee;
        this.courseSchedule = courseSchedule;
        this.trainer = trainer;
        this.trainingLocation = trainingLocation;
        this.amountPaid = amountPaid;
        this.balance = balance;
        this.weeklyPayment = weeklyPayment;
        this.isPaymentLate = isPaymentLate;
        this.payments = payments;
        this.lateFee = lateFee;
        this.coopStatus = coopStatus;
        this.projectAssigned = projectAssigned;
        this.performance = performance;
        this.coopStartDate = coopStartDate;
        this.coopEndDate = coopEndDate;
    }


    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public Set<UserGroup> getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(Set<UserGroup> userGroup) {
        this.userGroup = userGroup;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getCurrentlyEmployed() {
        return isCurrentlyEmployed;
    }

    public void setCurrentlyEmployed(Boolean currentlyEmployed) {
        isCurrentlyEmployed = currentlyEmployed;
    }

    public Boolean getCurrentlyITEmployed() {
        return isCurrentlyITEmployed;
    }

    public void setCurrentlyITEmployed(Boolean currentlyITEmployed) {
        isCurrentlyITEmployed = currentlyITEmployed;
    }

    public String getDesiredJob() {
        return desiredJob;
    }

    public void setDesiredJob(String desiredJob) {
        this.desiredJob = desiredJob;
    }

    public String getMailingStreet() {
        return mailingStreet;
    }

    public void setMailingStreet(String mailingStreet) {
        this.mailingStreet = mailingStreet;
    }

    public String getMailingCity() {
        return mailingCity;
    }

    public void setMailingCity(String mailingCity) {
        this.mailingCity = mailingCity;
    }

    public String getMailingState() {
        return mailingState;
    }

    public void setMailingState(String mailingState) {
        this.mailingState = mailingState;
    }

    public String getMailingZip() {
        return mailingZip;
    }

    public void setMailingZip(String mailingZip) {
        this.mailingZip = mailingZip;
    }

    public String getMailingCountry() {
        return mailingCountry;
    }

    public void setMailingCountry(String mailingCountry) {
        this.mailingCountry = mailingCountry;
    }

    public Boolean getRegistrationFeePaid() {
        return isRegistrationFeePaid;
    }

    public void setRegistrationFeePaid(Boolean registrationFeePaid) {
        isRegistrationFeePaid = registrationFeePaid;
    }

    public Boolean getPlanAgreementSigned() {
        return isPlanAgreementSigned;
    }

    public void setPlanAgreementSigned(Boolean planAgreementSigned) {
        isPlanAgreementSigned = planAgreementSigned;
    }

    public Boolean getDiscountGiven() {
        return isDiscountGiven;
    }

    public void setDiscountGiven(Boolean discountGiven) {
        isDiscountGiven = discountGiven;
    }

    public RegistrationFee getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(RegistrationFee registrationFee) {
        this.registrationFee = registrationFee;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public PaymentPlan getPaymentPlan() {
        return paymentPlan;
    }

    public void setPaymentPlan(PaymentPlan paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getTotalCourseFee() {
        return totalCourseFee;
    }

    public void setTotalCourseFee(double totalCourseFee) {
        this.totalCourseFee = totalCourseFee;
    }

    public CourseSchedule getCourseSchedule() {
        return courseSchedule;
    }

    public void setCourseSchedule(CourseSchedule courseSchedule) {
        this.courseSchedule = courseSchedule;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public TrainingLocation getTrainingLocation() {
        return trainingLocation;
    }

    public void setTrainingLocation(TrainingLocation trainingLocation) {
        this.trainingLocation = trainingLocation;
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

    public double getWeeklyPayment() {
        return weeklyPayment;
    }

    public void setWeeklyPayment(double weeklyPayment) {
        this.weeklyPayment = weeklyPayment;
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


    public LateFee getLateFee() {
        return lateFee;
    }

    public void setLateFee(LateFee lateFee) {
        this.lateFee = lateFee;
    }

    public String getCoopStatus() {
        return coopStatus;
    }

    public void setCoopStatus(String coopStatus) {
        this.coopStatus = coopStatus;
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


}
