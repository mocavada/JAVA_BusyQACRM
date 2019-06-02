package com.busyqa.crm.model.clients;

import com.busyqa.crm.model.academics.Course;

public class ClientBuilder {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String status;
    private String leadSource;
    private String comments;
    private double registrationFee;
    private Course course;

    public ClientBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ClientBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ClientBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ClientBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public ClientBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public ClientBuilder setLeadSource(String leadSource) {
        this.leadSource = leadSource;
        return this;
    }

    public ClientBuilder setComments(String comments) {
        this.comments = comments;
        return this;
    }

    public ClientBuilder setRegistrationFee(double registrationFee) {
        this.registrationFee = registrationFee;
        return this;
    }

    public ClientBuilder setCourse(Course course) {
        this.course = course;
        return this;
    }

    // BUILDER PATTERN METHOD
    public Lead buildLead() {
        return new Lead(firstName,lastName,phone,email,status,leadSource,comments,registrationFee,course);
    }




}
