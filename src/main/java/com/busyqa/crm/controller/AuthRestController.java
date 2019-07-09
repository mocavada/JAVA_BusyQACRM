package com.busyqa.crm.controller;

import com.busyqa.crm.config.security.JwtProvider;
import com.busyqa.crm.config.security.UserPrincipal;
import com.busyqa.crm.model.auth.DTOJwtResponse;
import com.busyqa.crm.model.auth.DTOUserLoginForm;
import com.busyqa.crm.model.auth.DTOUserSignupForm;
import com.busyqa.crm.model.auth.UserGroup;
import com.busyqa.crm.model.clients.Lead;
import com.busyqa.crm.model.util.EnumList;
import com.busyqa.crm.repo.LeadRepository;
import com.busyqa.crm.repo.UserGroupRepository;
import com.busyqa.crm.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserGroupRepository userGroupRepository;

    @Autowired
    LeadRepository leadRepository;

    @Autowired
    LeadService leadService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody DTOUserLoginForm loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));

        // Hold the Login Input
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Add JWT Token to Login Input
        String jwt = jwtProvider.generateJwtToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(
                new DTOJwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @PostMapping("/signup")
    public DTOUserSignupForm registerUser(@Valid @RequestBody DTOUserSignupForm signUpRequest) {

        if(leadRepository.existsByEmail(signUpRequest.getEmail())) throw
                new RuntimeException("Error: Email is Already Used");

        if(leadRepository.existsByUsername(signUpRequest.getUsername())) throw
                new RuntimeException("Error: Username is Already Used");

        List<UserGroup> userGroupList = new ArrayList<>();

        UserGroup userGroup = userGroupRepository.findByRoleAndGroups("ROLE_USER","GROUP_CLIENT")
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Group Not Found."));

        userGroupList.add(userGroup);


        Set<UserGroup> userGroupSet = userGroupList.stream().collect(Collectors.toSet());

        Lead lead = new Lead(
                signUpRequest.getUsername(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getEmail(),
                signUpRequest.getFirstName(),
                userGroupSet
        );

        lead.setClientStatus(EnumList.CLIENT.toString());

        leadRepository.save(lead);

        UserPrincipal userPrincipal = UserPrincipal.build(lead);

        return signUpRequest;
    }

}



