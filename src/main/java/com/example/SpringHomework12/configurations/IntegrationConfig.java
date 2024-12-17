package com.example.SpringHomework12.configurations;

import com.example.SpringHomework12.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class IntegrationConfig {

    @Bean
    public MessageChannel inputChanel() {
        return new DirectChannel();
    }
    @Bean
    public MessageChannel fileWriteChanel() {
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "inputChanel", outputChannel = "fileWriteChanel")
    public GenericTransformer<User, String> mainTransformer() {
        return user -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Added new user from body: ")
                    .append(" name: ").append(user.getName())
                    .append(" age: ").append(user.getAge()).append(" ")
                    .append(" email: ").append(user.getEmail()).append(" ");
            return sb.toString();
        };
    }

    @Bean
    @ServiceActivator(inputChannel = "fileWriteChanel")
    public FileWritingMessageHandler messageHandler() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("./user"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);
        handler.setAutoCreateDirectory(true);
        handler.setCharset("UTF-8");
        return handler;
    }
}
