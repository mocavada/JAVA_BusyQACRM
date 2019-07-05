package com.busyqa.crm.model.auth;

import javax.persistence.*;

@Entity
@Table(name="USERGROUPS")
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groups;
    private String role;

//    @ManyToMany(mappedBy = "usergroups")
//    private Set<User> user;


    public UserGroup() {
    }

    public UserGroup(String groups, String role) {
        this.groups = groups;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }




}
