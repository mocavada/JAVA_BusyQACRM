package com.busyqa.crm.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "USERS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {

    // DATE
    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime modifiedTime;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="USERNAME", nullable = false, unique = true)
    private String username;
    @Column(name="PASSWORD")
    private String password;

    @Column(name="EMAIL", nullable = false, unique = true)
    private String email;

    //Common User Fields
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emergencyPhone;

    // DTYPE
    @Column(insertable = false, updatable = false)
    private String dtype;
    private String userState;




    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_usergroup",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "usergroup_id"))
    @JsonIgnore
    private Set<UserGroup> usergroups;

    // CUSTOM METHODS

//    public void addUserGroup(UserGroup userGroup) {
//        usergroups.add(userGroup);
//        userGroup.getUser().add(this);
//    }
//
//    public void removeUserGroup(UserGroup userGroup) {
//        Boolean exist = false;
//        for (UserGroup ug: usergroups) {
//            if ((userGroup.getRole() == ug.getRole()) && (userGroup.getGroups() == ug.getGroups())) {
//                exist = true;
//            }
//        }
//        if (exist) {
//            usergroups.remove(userGroup);
//            userGroup.getUser().remove(this);
//        }
//
//    }

    public List<String> getRoles() {
        return this.getUsergroups().stream().
                map(ug -> ug.getRole()).collect(Collectors.toList());
    }

    public List<String> getGroups() {
        return this.getUsergroups().stream().
                map(ug -> ug.getGroups()).collect(Collectors.toList());
    }

    public List<String> getRolesGroups() {
        return this.getUsergroups().stream().
                map(ug -> (ug.getRole() + "," + ug.getGroups())).collect(Collectors.toList());
    }

    // CONST

    public User() {
    }

    public User(String username, String password, String email, String firstName, Set<UserGroup> usergroups) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.usergroups = usergroups;
    }

    public User(String username, String password, String email, String firstName, String lastName, String phoneNumber, String emergencyPhone, String dtype, String userState, LocalDateTime createdTime, LocalDateTime modifiedTime, Set<UserGroup> usergroups) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emergencyPhone = emergencyPhone;
        this.dtype = dtype;
        this.userState = userState;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
        this.usergroups = usergroups;
    }


    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserGroup> getUsergroups() {
        return usergroups;
    }

    public void setUsergroups(Set<UserGroup> usergroups) {
        this.usergroups = usergroups;
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


}
