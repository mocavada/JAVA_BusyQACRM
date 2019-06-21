package com.busyqa.crm.model.clients;

import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.academics.CourseSchedule;
import com.busyqa.crm.model.academics.Trainer;
import com.busyqa.crm.model.academics.TrainingLocation;
import com.busyqa.crm.model.auth.User;
import com.busyqa.crm.model.auth.UserGroup;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "LEADS")
public class Lead extends User {
    // STATUS
    private String clientStatus;
    private double registrationFee;
    private double discount;
    private String transactionDate;

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
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "course_schedule_id")
    private CourseSchedule courseSchedule;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "training_location_id")
    private TrainingLocation trainingLocation;

    public Lead() {
    }

    public Lead(String username, String password, String email, String firstName, Set<UserGroup> usergroups) {
        super(username, password, email, firstName, usergroups);
    }

    public Lead(String clientStatus, double registrationFee, double discount, String transactionDate, String leadStatus, String leadSource, String comments, Boolean currentlyEmployed, Boolean currentlyITEmployed, String desiredJob, String paymentPlan, String paymentPlanStatus, Boolean registrationFeePaid, Boolean planAgreement, String mailingStreet, String mailingCity, String mailingState, String mailingZip, String mailingCountry, Course course, CourseSchedule courseSchedule, Trainer trainer, TrainingLocation trainingLocation) {
        this.clientStatus = clientStatus;
        this.registrationFee = registrationFee;
        this.discount = discount;
        this.transactionDate = transactionDate;
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
    }

    public Lead(String username, String password, String email, String firstName, Set<UserGroup> usergroups, String clientStatus, double registrationFee, double discount, String transactionDate, String leadStatus, String leadSource, String comments, Boolean currentlyEmployed, Boolean currentlyITEmployed, String desiredJob, String paymentPlan, String paymentPlanStatus, Boolean registrationFeePaid, Boolean planAgreement, String mailingStreet, String mailingCity, String mailingState, String mailingZip, String mailingCountry, Course course, CourseSchedule courseSchedule, Trainer trainer, TrainingLocation trainingLocation) {
        super(username, password, email, firstName, usergroups);
        this.clientStatus = clientStatus;
        this.registrationFee = registrationFee;
        this.discount = discount;
        this.transactionDate = transactionDate;
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
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getCourseId() {
        return course.getId();
    }

    public Integer getCourseScheduleId() {
        return courseSchedule.getId();
    }

    public Integer getTrainerId() {
        return trainer.getId();
    }

    public Integer getTrainingLocationId() {
        return trainingLocation.getId();
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

}
