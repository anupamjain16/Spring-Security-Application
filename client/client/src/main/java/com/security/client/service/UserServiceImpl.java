package com.security.client.service;

import com.security.client.entity.User;
import com.security.client.entity.VerificationToken;
import com.security.client.model.UserModel;
import com.security.client.repository.UserRegistrionRepository;
import com.security.client.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceI {


    @Autowired
    private UserRegistrionRepository userRegistrationRepository;

    @Autowired
    private PasswordEncoder pw;
    @Override
    public User registerUser(UserModel userModel) {

        User user = new User();
        user.setId(userModel.getId());
        user.setRole(userModel.getRole());
        user.setName(userModel.getName());
        user.setEnabled(userModel.isEnabled());
        user.setEmail(userModel.getEmail());
        user.setPassword(pw.encode(userModel.getPassword()));

        userRegistrationRepository.save(user);


        return user;

    }

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Override
    public void saveVerificationToken(String token, User user) {

        VerificationToken verificationToken = new VerificationToken(user, token);
        verificationTokenRepository.save(verificationToken);

    }
}
