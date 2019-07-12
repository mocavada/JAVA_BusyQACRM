package com.busyqa.crm.model.clients;

import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.academics.CourseSchedule;
import com.busyqa.crm.model.academics.Trainer;
import com.busyqa.crm.model.academics.TrainingLocation;
import com.busyqa.crm.model.auth.User;
import com.busyqa.crm.model.auth.UserGroup;
import com.busyqa.crm.model.finance.Discount;
import com.busyqa.crm.model.finance.PaymentPlan;
import com.busyqa.crm.model.finance.RegistrationFee;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "LEADS")
public class Lead extends User {

    // FOR LEADS ONLY
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

    private Boolean isRegistrationFeePaid;
    private Boolean isPlanAgreementSigned;
    private Boolean isDiscountGiven;

    // FINANCE
    @ManyToOne
    @JoinColumn(name = "registrationFee_id")
    private RegistrationFee registrationFee;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @ManyToOne
    @JoinColumn(name = "paymentPlan_id")
    private PaymentPlan paymentPlan;

    // ACADEMICS
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    private double totalCourseFee;

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


    public Lead(String clientStatus, String leadSource, String comments, Boolean isCurrentlyEmployed, Boolean isCurrentlyITEmployed, String desiredJob, String mailingStreet, String mailingCity, String mailingState, String mailingZip, String mailingCountry, Boolean isRegistrationFeePaid, Boolean isPlanAgreementSigned, Boolean isDiscountGiven, RegistrationFee registrationFee, Discount discount, PaymentPlan paymentPlan, Course course, double totalCourseFee, CourseSchedule courseSchedule, Trainer trainer, TrainingLocation trainingLocation) {
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
        this.paymentPlan = paymentPlan;
        this.course = course;
        this.totalCourseFee = totalCourseFee;
        this.courseSchedule = courseSchedule;
        this.trainer = trainer;
        this.trainingLocation = trainingLocation;
    }

    public Lead(String username, String password, String email, String firstName, Set<UserGroup> usergroups, String clientStatus, String leadSource, String comments, Boolean isCurrentlyEmployed, Boolean isCurrentlyITEmployed, String desiredJob, String mailingStreet, String mailingCity, String mailingState, String mailingZip, String mailingCountry, Boolean isRegistrationFeePaid, Boolean isPlanAgreementSigned, Boolean isDiscountGiven, RegistrationFee registrationFee, Discount discount, PaymentPlan paymentPlan, Course course, double totalCourseFee, CourseSchedule courseSchedule, Trainer trainer, TrainingLocation trainingLocation) {
        super(username, password, email, firstName, usergroups);
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
        this.paymentPlan = paymentPlan;
        this.course = course;
        this.totalCourseFee = totalCourseFee;
        this.courseSchedule = courseSchedule;
        this.trainer = trainer;
        this.trainingLocation = trainingLocation;
    }

    public Lead(String username, String password, String email, String firstName, String lastName, String phoneNumber, String emergencyPhone, String dtype, String userState, LocalDateTime createdTime, LocalDateTime modifiedTime, Set<UserGroup> usergroups, String clientStatus, String leadSource, String comments, Boolean isCurrentlyEmployed, Boolean isCurrentlyITEmployed, String desiredJob, String mailingStreet, String mailingCity, String mailingState, String mailingZip, String mailingCountry, Boolean isRegistrationFeePaid, Boolean isPlanAgreementSigned, Boolean isDiscountGiven, RegistrationFee registrationFee, Discount discount, PaymentPlan paymentPlan, Course course, double totalCourseFee, CourseSchedule courseSchedule, Trainer trainer, TrainingLocation trainingLocation) {
        super(username, password, email, firstName, lastName, phoneNumber, emergencyPhone, dtype, userState, createdTime, modifiedTime, usergroups);
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
        this.paymentPlan = paymentPlan;
        this.course = course;
        this.totalCourseFee = totalCourseFee;
        this.courseSchedule = courseSchedule;
        this.trainer = trainer;
        this.trainingLocation = trainingLocation;
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

    public void setTotalCourseFee(double totalCourseFee) {
        this.totalCourseFee = totalCourseFee;
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

    public double getTotalCourseFee() {
        return totalCourseFee;
    }

    // CUSTOM METHODS

}
