package com.group3.backend.service.impl;

import com.group3.backend.datasource.entity.UserEntity;
import com.group3.backend.datasource.repos.UserRepository;
import com.group3.backend.service.UserService;
import com.group3.backend.ui.model.request.UserRequest;
import com.group3.backend.ui.model.response.UserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder; //bCrypt is a password hashing function

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userRequest, userEntity);
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));

        UserEntity savedUser = userRepository.save(userEntity);

        UserResponse toReturn = new UserResponse();
        BeanUtils.copyProperties(savedUser, toReturn);
        return toReturn;
    }


    //helps spring framework to find users on sign in
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null) throw new UsernameNotFoundException(email);

        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }
}
