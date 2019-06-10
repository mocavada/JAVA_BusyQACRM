package com.busyqa.crm.config.security;

import com.busyqa.crm.model.auth.User;
import com.busyqa.crm.model.auth.UserGroup;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserPrincipal implements UserDetails {
    private User user;
    private List<UserGroup> userGroups;

    public UserPrincipal(User user, List<UserGroup> userGroups) {
        this.user = user;
        this.userGroups = userGroups;
    }

    /**
     * @return Set of Authorized UserGroup
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if(null == userGroups) {
            return Collections.emptySet();
        }

        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();

        userGroups.forEach(group -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(group.getRole()));
        });

        return grantedAuthorities;
    }


    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

