package com.busyqa.crm.service;

import com.busyqa.crm.config.security.UserPrincipal;
import com.busyqa.crm.model.auth.User;
import com.busyqa.crm.model.auth.UserGroup;
import com.busyqa.crm.repo.IUserGroupJpaRepository;
import com.busyqa.crm.repo.IUserJpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupDetailService implements UserDetailsService {

    private final IUserGroupJpaRepository userGroupRepository;
    private final IUserJpaRepository userRepository;

    public UserGroupDetailService(IUserGroupJpaRepository userGroupRepository, IUserJpaRepository userRepository) {
        this.userGroupRepository = userGroupRepository;
        this.userRepository = userRepository;
    }

    /**
     *
     * @param username
     * @return user and userGroup
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Check Username in DB
        User user = this.userRepository.findByUsername(username);

        if(null == user) {
            throw new UsernameNotFoundException("cannot find username: " + username);
        }

        // Check Username if it has Authorities(ROLE)
        List<UserGroup> userGroup = this.userGroupRepository.findByUser_Username(username);

        return new UserPrincipal(user, userGroup);
    }
}
