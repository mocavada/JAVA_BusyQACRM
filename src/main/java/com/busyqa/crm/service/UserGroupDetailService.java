package com.busyqa.crm.service;

import com.busyqa.crm.config.security.UserPrincipal;
import com.busyqa.crm.model.clients.Lead;
import com.busyqa.crm.repo.LeadRepository;
import com.busyqa.crm.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserGroupDetailService implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    LeadRepository leadRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Check Username in DB
        Lead user = leadRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));

        return UserPrincipal.build(user);
    }
}
