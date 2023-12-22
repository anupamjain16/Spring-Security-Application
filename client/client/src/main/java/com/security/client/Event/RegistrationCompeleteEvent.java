package com.security.client.Event;

import com.security.client.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

@Getter
@Setter
public class RegistrationCompeleteEvent extends ApplicationEvent {


    private   User user;
    private String ApplicationURL;


    public RegistrationCompeleteEvent(User user, String ApplicationURL) {
        super(user);
        this.ApplicationURL=ApplicationURL;
        this.user = user;
    }

}
