package com.dinesh.emp.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.dinesh.emp.springsecurity.model.User;
import com.dinesh.emp.springsecurity.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
