package com.busyqa.crm.model.clients;

import com.busyqa.crm.model.academics.Course;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name="LEADS")
@Inheritance(strategy = InheritanceType.JOINED)
public class Lead {
    // BASIC INFO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;

    @Column(unique=true)
    private String email;

    private String status;
    private String leadSource;
    private String comments;
    private double registrationFee;

    // ACADEMICS
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;


    // DATE
    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime modifiedTime;
    @Basic
    private Instant lastActivityTime;


    public Lead() { }

    public Lead(String firstName, String lastName, String phone, String email, String status, String leadSource, String comments, double registrationFee, Course course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.leadSource = leadSource;
        this.comments = comments;
        this.registrationFee = registrationFee;
        this.course = course;
    }

    // REGISTRATION FEE OF 500 or More


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public double getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(double registrationFee) {
        this.registrationFee = registrationFee;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Instant getLastActivityTime() {
        return lastActivityTime;
    }

    public void setLastActivityTime(Instant lastActivityTime) {
        this.lastActivityTime = lastActivityTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Lead{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", leadSource='" + leadSource + '\'' +
                ", comments='" + comments + '\'' +
                ", registrationFee=" + registrationFee +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                ", lastActivityTime=" + lastActivityTime +
                ", course=" + course +
                '}';
    }
}

//    private Long id;
//    private String firstName;
//    private String lastName;
//    private String phone;
//    private String email;
//    private String status;
//    private String leadSource;
//    private String comments;
//    private double registrationFee;
//    private Course course;
