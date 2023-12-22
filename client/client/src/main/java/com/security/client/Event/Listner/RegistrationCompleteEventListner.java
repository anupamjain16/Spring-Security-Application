package com.security.client.Event.Listner;

import com.security.client.Event.RegistrationCompeleteEvent;
import com.security.client.entity.User;
import com.security.client.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class RegistrationCompleteEventListner implements ApplicationListener<RegistrationCompeleteEvent> {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public void onApplicationEvent(RegistrationCompeleteEvent event) {

        // Create verification token
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationToken(token , user);
        // Send email to  user

        String url = event.getApplicationURL()
                +"verifyRegistration?token="
                +token;

        //send verification method
        log.info("Click the link to verify the account : {}");
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
