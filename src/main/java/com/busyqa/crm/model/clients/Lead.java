package com.busyqa.crm.model.clients;

import com.busyqa.crm.model.academics.Class;
import com.busyqa.crm.model.academics.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.File;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;


@Entity
@Table(name="LEAD")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Lead implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String emergencyPhone;

    // STATUS
    private String clientStatus;
    private double registrationFee;

    // ACADEMICS
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

//    private List<Course> courses = new ArrayList<>();


//    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
//    @LazyCollection(LazyCollectionOption.FALSE)
//    private List<Class> classes = new ArrayList<>();

    // DATE
    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime modifiedTime;
    @Basic
    private Instant lastActivityTime;


    // FOR LEADS ONLY
    private String leadSource;
    private String comments;
    private Boolean currentlyEmployed;
    private Boolean currentlyITEmployed;
    private String desiredJob;

    // ADDRESS
    private String mailingCity;
    private String mailingCountry;
    private String mailingState;
    private String mailingStreet;
    private String mailingZip;

    // PLAN
    private String paymentPlan;
    private File planAgreement;
    private String paymentPlanStatus;
    private Boolean registrationFeePaid;



    public Lead() {
        super();}



    public Lead(String firstName, String lastName, String email, String phone, String emergencyPhone, String clientStatus, double registrationFee, Course course, LocalDateTime createdTime, LocalDateTime modifiedTime, Instant lastActivityTime, String leadSource, String comments, Boolean currentlyEmployed, Boolean currentlyITEmployed, String desiredJob, String mailingCity, String mailingCountry, String mailingState, String mailingStreet, String mailingZip, String paymentPlan, File planAgreement, String paymentPlanStatus, Boolean registrationFeePaid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.emergencyPhone = emergencyPhone;
        this.clientStatus = clientStatus;
        this.registrationFee = registrationFee;
        this.course = course;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
        this.lastActivityTime = lastActivityTime;
        this.leadSource = leadSource;
        this.comments = comments;
        this.currentlyEmployed = currentlyEmployed;
        this.currentlyITEmployed = currentlyITEmployed;
        this.desiredJob = desiredJob;
        this.mailingCity = mailingCity;
        this.mailingCountry = mailingCountry;
        this.mailingState = mailingState;
        this.mailingStreet = mailingStreet;
        this.mailingZip = mailingZip;
        this.paymentPlan = paymentPlan;
        this.planAgreement = planAgreement;
        this.paymentPlanStatus = paymentPlanStatus;
        this.registrationFeePaid = registrationFeePaid;
    }

    //    public void addCourse(Course course) {
//        this.courses.add(course);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

    public Instant getLastActivityTime() {
        return lastActivityTime;
    }

    public void setLastActivityTime(Instant lastActivityTime) {
        this.lastActivityTime = lastActivityTime;
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

    public String getMailingCity() {
        return mailingCity;
    }

    public void setMailingCity(String mailingCity) {
        this.mailingCity = mailingCity;
    }

    public String getMailingCountry() {
        return mailingCountry;
    }

    public void setMailingCountry(String mailingCountry) {
        this.mailingCountry = mailingCountry;
    }

    public String getMailingState() {
        return mailingState;
    }

    public void setMailingState(String mailingState) {
        this.mailingState = mailingState;
    }

    public String getMailingStreet() {
        return mailingStreet;
    }

    public void setMailingStreet(String mailingStreet) {
        this.mailingStreet = mailingStreet;
    }

    public String getMailingZip() {
        return mailingZip;
    }

    public void setMailingZip(String mailingZip) {
        this.mailingZip = mailingZip;
    }

    public String getPaymentPlan() {
        return paymentPlan;
    }

    public void setPaymentPlan(String paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

    public File getPlanAgreement() {
        return planAgreement;
    }

    public void setPlanAgreement(File planAgreement) {
        this.planAgreement = planAgreement;
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

    // REGISTRATION FEE OF 500 or More



    // CUSTOM METHODS
//    public void addCourse(Course course) {
//        courses.add(course);
//        course.setLead(this);
//    }
//
//    public void removeCourse(Course course) {
//        courses.remove(course);
//        course.setLead(this);
//    }


}

