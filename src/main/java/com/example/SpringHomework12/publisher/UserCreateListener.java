package com.example.SpringHomework12.publisher;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreateListener implements ApplicationListener<UserCreateEvent> {

    @Override
    public void onApplicationEvent(UserCreateEvent event) {
        System.out.println();
        System.out.println("New Publisher event!");
        System.out.println("New user: " + event.getUser().toString());
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
