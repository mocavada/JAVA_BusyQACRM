package com.busyqa.crm.model.clients;

import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.academics.CourseSchedule;
import com.busyqa.crm.model.academics.Trainer;
import com.busyqa.crm.model.academics.TrainingLocation;

import java.time.LocalDateTime;
import java.util.Calendar;

public class DTOClientResponse {

    private String email;

    //Common User Fields
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emergencyPhone;

    // STATUS
    private String clientStatus;
    private double registrationFee;
    private double discount;

    // FOR LEADS ONLY
    private String leadStatus;
    private String leadSource;
    private String comments;
    private Boolean currentlyEmployed;
    private Boolean currentlyITEmployed;
    private String desiredJob;

    // PLAN
    private String paymentPlan;
    private String paymentPlanStatus;
    private Boolean registrationFeePaid;
    private Boolean planAgreement;

    // ADDRESS
    private String mailingStreet;
    private String mailingCity;
    private String mailingState;
    private String mailingZip;
    private String mailingCountry;

    // ACADEMICS
    private Course course;
    private CourseSchedule courseSchedule;
    private Trainer trainer;
    private TrainingLocation trainingLocation;

    // TEMPORAL
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

    // STUDENTS
    private double amountPaid;
    private double balance;

    //INTERNS
    private String coopStatus;
    private String projectAssigned;
    private String performance;
    private Calendar coopStartDate;
    private Calendar coopEndDate;

    public DTOClientResponse() {
    }

    // STUDENTS
    public DTOClientResponse(String email, String firstName, String lastName, String phoneNumber, String emergencyPhone, String clientStatus, double registrationFee, double discount, String leadStatus, String leadSource, String comments, Boolean currentlyEmployed, Boolean currentlyITEmployed, String desiredJob, String paymentPlan, String paymentPlanStatus, Boolean registrationFeePaid, Boolean planAgreement, String mailingStreet, String mailingCity, String mailingState, String mailingZip, String mailingCountry, Course course, CourseSchedule courseSchedule, Trainer trainer, TrainingLocation trainingLocation, LocalDateTime createdTime, LocalDateTime modifiedTime, double amountPaid, double balance) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emergencyPhone = emergencyPhone;
        this.clientStatus = clientStatus;
        this.registrationFee = registrationFee;
        this.discount = discount;
        this.leadStatus = leadStatus;
        this.leadSource = leadSource;
        this.comments = comments;
        this.currentlyEmployed = currentlyEmployed;
        this.currentlyITEmployed = currentlyITEmployed;
        this.desiredJob = desiredJob;
        this.paymentPlan = paymentPlan;
        this.paymentPlanStatus = paymentPlanStatus;
        this.registrationFeePaid = registrationFeePaid;
        this.planAgreement = planAgreement;
        this.mailingStreet = mailingStreet;
        this.mailingCity = mailingCity;
        this.mailingState = mailingState;
        this.mailingZip = mailingZip;
        this.mailingCountry = mailingCountry;
        this.course = course;
        this.courseSchedule = courseSchedule;
        this.trainer = trainer;
        this.trainingLocation = trainingLocation;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
        this.amountPaid = amountPaid;
        this.balance = balance;
    }

    // LEADS
    public DTOClientResponse(String email, String firstName, String lastName, String phoneNumber, String emergencyPhone, String clientStatus, double registrationFee, double discount, String leadStatus, String leadSource, String comments, Boolean currentlyEmployed, Boolean currentlyITEmployed, String desiredJob, String paymentPlan, String paymentPlanStatus, Boolean registrationFeePaid, Boolean planAgreement, String mailingStreet, String mailingCity, String mailingState, String mailingZip, String mailingCountry, Course course, CourseSchedule courseSchedule, Trainer trainer, TrainingLocation trainingLocation, LocalDateTime createdTime, LocalDateTime modifiedTime) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emergencyPhone = emergencyPhone;
        this.clientStatus = clientStatus;
        this.registrationFee = registrationFee;
        this.discount = discount;
        this.leadStatus = leadStatus;
        this.leadSource = leadSource;
        this.comments = comments;
        this.currentlyEmployed = currentlyEmployed;
        this.currentlyITEmployed = currentlyITEmployed;
        this.desiredJob = desiredJob;
        this.paymentPlan = paymentPlan;
        this.paymentPlanStatus = paymentPlanStatus;
        this.registrationFeePaid = registrationFeePaid;
        this.planAgreement = planAgreement;
        this.mailingStreet = mailingStreet;
        this.mailingCity = mailingCity;
        this.mailingState = mailingState;
        this.mailingZip = mailingZip;
        this.mailingCountry = mailingCountry;
        this.course = course;
        this.courseSchedule = courseSchedule;
        this.trainer = trainer;
        this.trainingLocation = trainingLocation;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }


    //INTERNS


    public DTOClientResponse(String email, String firstName, String lastName, String phoneNumber, String emergencyPhone, String clientStatus, double registrationFee, double discount, String leadStatus, String leadSource, String comments, Boolean currentlyEmployed, Boolean currentlyITEmployed, String desiredJob, String paymentPlan, String paymentPlanStatus, Boolean registrationFeePaid, Boolean planAgreement, String mailingStreet, String mailingCity, String mailingState, String mailingZip, String mailingCountry, Course course, CourseSchedule courseSchedule, Trainer trainer, TrainingLocation trainingLocation, LocalDateTime createdTime, LocalDateTime modifiedTime, double amountPaid, double balance, String coopStatus, String projectAssigned, String performance, Calendar coopStartDate, Calendar coopEndDate) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emergencyPhone = emergencyPhone;
        this.clientStatus = clientStatus;
        this.registrationFee = registrationFee;
        this.discount = discount;
        this.leadStatus = leadStatus;
        this.leadSource = leadSource;
        this.comments = comments;
        this.currentlyEmployed = currentlyEmployed;
        this.currentlyITEmployed = currentlyITEmployed;
        this.desiredJob = desiredJob;
        this.paymentPlan = paymentPlan;
        this.paymentPlanStatus = paymentPlanStatus;
        this.registrationFeePaid = registrationFeePaid;
        this.planAgreement = planAgreement;
        this.mailingStreet = mailingStreet;
        this.mailingCity = mailingCity;
        this.mailingState = mailingState;
        this.mailingZip = mailingZip;
        this.mailingCountry = mailingCountry;
        this.course = course;
        this.courseSchedule = courseSchedule;
        this.trainer = trainer;
        this.trainingLocation = trainingLocation;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
        this.amountPaid = amountPaid;
        this.balance = balance;
        this.coopStatus = coopStatus;
        this.projectAssigned = projectAssigned;
        this.performance = performance;
        this.coopStartDate = coopStartDate;
        this.coopEndDate = coopEndDate;
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

    public double getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(double registrationFee) {
        this.registrationFee = registrationFee;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getLeadStatus() {
        return leadStatus;
    }

    public void setLeadStatus(String leadStatus) {
        this.leadStatus = leadStatus;
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
        return currentlyEmployed;
    }

    public void setCurrentlyEmployed(Boolean currentlyEmployed) {
        this.currentlyEmployed = currentlyEmployed;
    }

    public Boolean getCurrentlyITEmployed() {
        return currentlyITEmployed;
    }

    public void setCurrentlyITEmployed(Boolean currentlyITEmployed) {
        this.currentlyITEmployed = currentlyITEmployed;
    }

    public String getDesiredJob() {
        return desiredJob;
    }

    public void setDesiredJob(String desiredJob) {
        this.desiredJob = desiredJob;
    }

    public String getPaymentPlan() {
        return paymentPlan;
    }

    public void setPaymentPlan(String paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

    public String getPaymentPlanStatus() {
        return paymentPlanStatus;
    }

    public void setPaymentPlanStatus(String paymentPlanStatus) {
        this.paymentPlanStatus = paymentPlanStatus;
    }

    public Boolean getRegistrationFeePaid() {
        return registrationFeePaid;
    }

    public void setRegistrationFeePaid(Boolean registrationFeePaid) {
        this.registrationFeePaid = registrationFeePaid;
    }

    public Boolean getPlanAgreement() {
        return planAgreement;
    }

    public void setPlanAgreement(Boolean planAgreement) {
        this.planAgreement = planAgreement;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }
}
