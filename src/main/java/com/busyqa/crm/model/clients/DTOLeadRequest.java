package com.busyqa.crm.model.clients;

import com.busyqa.crm.model.auth.UserGroup;

import java.time.LocalDateTime;
import java.util.Set;

public class DTOLeadRequest {


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
    private Long registrationFee;
    private Long discount;
    private Long tax;
    private Long paymentPlan;
    // ACADEMICS
    private long course;
    private double totalCourseFee;
    private long courseSchedule;
    private long trainer;
    private long trainingLocation;


    public DTOLeadRequest(LocalDateTime modifiedTime, String email, String firstName, String lastName, String phoneNumber, String emergencyPhone, String dtype, String userState, Set<UserGroup> userGroup, String clientStatus, String leadSource, String comments, Boolean isCurrentlyEmployed, Boolean isCurrentlyITEmployed, String desiredJob, String mailingStreet, String mailingCity, String mailingState, String mailingZip, String mailingCountry, Boolean isRegistrationFeePaid, Boolean isPlanAgreementSigned, Boolean isDiscountGiven, Long registrationFee, Long discount, Long tax, Long paymentPlan, long course, double totalCourseFee, long courseSchedule, long trainer, long trainingLocation) {
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

    public Long getTax() {
        return tax;
    }

    public void setTax(Long tax) {
        this.tax = tax;
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

    public long getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(long registrationFee) {
        this.registrationFee = registrationFee;
    }

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    public long getPaymentPlan() {
        return paymentPlan;
    }

    public void setPaymentPlan(long paymentPlan) {
        this.paymentPlan = paymentPlan;
    }


    public void setRegistrationFee(Long registrationFee) {
        this.registrationFee = registrationFee;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public void setPaymentPlan(Long paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

    public void setCourse(long course) {
        this.course = course;
    }

    public double getTotalCourseFee() {
        return totalCourseFee;
    }

    public void setTotalCourseFee(double totalCourseFee) {
        this.totalCourseFee = totalCourseFee;
    }

    public long getCourseSchedule() {
        return courseSchedule;
    }

    public void setCourseSchedule(long courseSchedule) {
        this.courseSchedule = courseSchedule;
    }

    public long getTrainer() {
        return trainer;
    }

    public void setTrainer(long trainer) {
        this.trainer = trainer;
    }

    public long getTrainingLocation() {
        return trainingLocation;
    }

    public void setTrainingLocation(long trainingLocation) {
        this.trainingLocation = trainingLocation;
    }

    public long getCourse() {
        return course;
    }

}
