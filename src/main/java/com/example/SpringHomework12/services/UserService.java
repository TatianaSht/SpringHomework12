package com.example.SpringHomework12.services;

import com.example.SpringHomework12.domain.User;
import com.example.SpringHomework12.publisher.UserCreateEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private NotificationService notificationService;

    private final FileGateway fileGateway;

    private final ApplicationEventPublisher publisher;

    public UserService(NotificationService notificationService, FileGateway fileGateway,
                       ApplicationEventPublisher publisher) {
        this.notificationService = notificationService;
        this.fileGateway = fileGateway;
        this.publisher = publisher;
    }


    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        fileGateway.writeToFile("users.txt", user);
        publisher.publishEvent(new UserCreateEvent(this, user));
        notificationService.notifyUser(user);
        return user;
    }

}
