package com.example.SpringHomework12.services;

import com.example.SpringHomework12.domain.User;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "inputChanel")
public interface FileGateway {

    void writeToFile(@Header(FileHeaders.FILENAME) String filename, User user);
}
