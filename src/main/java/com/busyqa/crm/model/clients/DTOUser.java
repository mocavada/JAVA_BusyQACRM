package com.busyqa.crm.model.clients;

import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.auth.UserGroup;
import com.busyqa.crm.model.finance.PaymentPlan;

import java.time.LocalDateTime;
import java.util.Set;

public class DTOUser {
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

    //USER FIELDS
    private Long id;
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

    private PaymentPlan paymentPlan;
    // ACADEMICS
    private Course course;

    public DTOUser(LocalDateTime createdTime, LocalDateTime modifiedTime, Long id, String email, String firstName, String lastName, String phoneNumber, String emergencyPhone, String dtype, String userState, Set<UserGroup> userGroup, String clientStatus, String leadSource, String comments, Boolean isCurrentlyEmployed, Boolean isCurrentlyITEmployed, String desiredJob, String mailingStreet, String mailingCity, String mailingState, String mailingZip, String mailingCountry, Boolean isRegistrationFeePaid, Boolean isPlanAgreementSigned, Boolean isDiscountGiven, PaymentPlan paymentPlan, Course course) {
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
        this.id = id;
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
        this.paymentPlan = paymentPlan;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<UserGroup> getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(Set<UserGroup> userGroup) {
        this.userGroup = userGroup;
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
}
