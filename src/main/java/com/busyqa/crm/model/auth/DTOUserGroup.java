package com.busyqa.crm.model.auth;

public class DTOUserGroup {


    private Long id;
    private String groups;
    private String role;

    public DTOUserGroup() {
    }

    public DTOUserGroup(Long id, String groups, String role) {
        this.id = id;
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
