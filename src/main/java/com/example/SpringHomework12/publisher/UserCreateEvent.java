package com.example.SpringHomework12.publisher;

import com.example.SpringHomework12.domain.User;
import org.springframework.context.ApplicationEvent;

public class UserCreateEvent extends ApplicationEvent {

    private final User user;

    public User getUser() {
        return user;
    }


    public UserCreateEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}
