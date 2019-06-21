package com.busyqa.crm.model.auth;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="USERGROUPS")
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groups;

    private String role;

    @ManyToMany(mappedBy = "usergroups")
    private Set<User> user;


    public UserGroup() {
    }

    public UserGroup(String groups, String role, Set<User> user) {
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

    @Override
    public String toString() {
        return "UserGroup{" +
                "id=" + id +
                ", groups='" + groups + '\'' +
                ", role='" + role + '\'' +
                ", user=" + user +
                '}';
    }
}
