package com.busyqa.crm.controller;

import com.busyqa.crm.config.security.JwtProvider;
import com.busyqa.crm.model.auth.DTOJwtResponse;
import com.busyqa.crm.model.auth.DTOUserLoginForm;
import com.busyqa.crm.repo.IUserGroupJpaRepository;
import com.busyqa.crm.repo.IUserJpaRepository;
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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    IUserGroupJpaRepository userGroupRepository;
    @Autowired
    IUserJpaRepository userRepository;

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


}
