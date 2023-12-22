package com.security.client.service;


import com.security.client.entity.User;
import com.security.client.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserServiceI {
    User registerUser(UserModel userModel);

    void saveVerificationToken(String token, User user);
}
