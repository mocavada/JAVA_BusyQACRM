package com.busyqa.crm.model.auth;

import java.util.Set;

public class DTOUserGroup {


    private Long id;
    private String groups;
    private String role;
    private Set<User> user;

    public DTOUserGroup() {
    }

    public DTOUserGroup(Long id, String groups, String role, Set<User> user) {
        this.id = id;
        this.groups = groups;
        this.role = role;
        this.user = user;
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

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}
