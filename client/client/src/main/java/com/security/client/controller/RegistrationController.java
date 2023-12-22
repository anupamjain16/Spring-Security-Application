package com.security.client.controller;

import com.security.client.Event.RegistrationCompeleteEvent;
import com.security.client.entity.User;
import com.security.client.model.UserModel;
import com.security.client.service.UserServiceI;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserServiceI  UserService;

    @Autowired
    private ApplicationEventPublisher publiser;

    @PostMapping("/register")
    public  String  registerUser(@RequestBody UserModel userModel , final HttpServletRequest request)
    {
        User user = UserService.registerUser(userModel);

        publiser.publishEvent(new RegistrationCompeleteEvent( user,applicationURL(request)));

        return "User Registered successfully" ;
    }

    private String applicationURL(HttpServletRequest request) {
        return  "http://"+request.getServerName()+
                ":"+
                request.getServerPort() +"/"
                +request.getContextPath();
    }
}
