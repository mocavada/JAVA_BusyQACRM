package com.busyqa.crm.model.auth;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEES")
public class Employee extends User {

    private String jobTitle;
    private String jobDescription;
    private String jobStatus;
    private Double annualSalary;

    public Employee() {
    }

    public Employee(String jobTitle, String jobDescription, String jobStatus, Double annualSalary) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobStatus = jobStatus;
        this.annualSalary = annualSalary;
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
}
