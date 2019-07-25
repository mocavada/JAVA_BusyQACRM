package com.busyqa.crm.model.auth;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserUserGroup implements Serializable {

    @Column(name = "user_id")
    Long userId;

    @Column(name = "usergroup_id")
    Long userGroupId;

    public UserUserGroup() {
    }

    public UserUserGroup(Long userId, Long userGroupId) {
        this.userId = userId;
        this.userGroupId = userGroupId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Long userGroupId) {
        this.userGroupId = userGroupId;
    }
}
