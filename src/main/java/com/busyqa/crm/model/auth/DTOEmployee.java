package com.busyqa.crm.model.auth;

import java.time.LocalDateTime;
import java.util.Set;

public class DTOEmployee {

    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

    private Long id;
    private String username;
    private String email;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emergencyPhone;

    // JOB DETAILS
    private String jobTitle;
    private String jobDescription;
    private String jobStatus;
    private Double annualSalary;

    private Set<UserGroup> usergroups;

    public DTOEmployee() {
    }

    public DTOEmployee(LocalDateTime createdTime, LocalDateTime modifiedTime, Long id, String username, String email, String firstName, String lastName, String phoneNumber, String emergencyPhone, String jobTitle, String jobDescription, String jobStatus, Double annualSalary, Set<UserGroup> usergroups) {
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emergencyPhone = emergencyPhone;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobStatus = jobStatus;
        this.annualSalary = annualSalary;
        this.usergroups = usergroups;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(Double annualSalary) {
        this.annualSalary = annualSalary;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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


    public Set<UserGroup> getUsergroups() {
        return usergroups;
    }

    public void setUsergroups(Set<UserGroup> usergroups) {
        this.usergroups = usergroups;
    }
}
