package com.example.SpringHomework12.services;

import com.example.SpringHomework12.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {


    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private DataProcessingService dataProcessingService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public UserService getUserService() {
        return userService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }


    public void processRegistration(User user) {
        User userNew = userService.createUser(user.getName(), user.getAge(), user.getEmail());
        dataProcessingService.getRepository().save(userNew);
        notificationService.addUserToRepository(userNew);
    }


    public void processRegistration(String name, int age, String email){
        User userNew = userService.createUser(name, age, email);
        dataProcessingService.getRepository().save(userNew);
        notificationService.addUserToRepository(userNew);
    }
}
