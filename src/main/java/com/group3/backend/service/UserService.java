package com.group3.backend.service;

import com.group3.backend.ui.model.request.UserRequest;
import com.group3.backend.ui.model.response.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserResponse createUser(UserRequest userRequest);
}
