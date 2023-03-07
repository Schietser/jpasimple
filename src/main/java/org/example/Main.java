package org.example;

import org.example.models.Message;
import org.example.models.User;
import org.example.services.MessageService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MessageService messageService = new MessageService();

        User user1 = new User();
        user1.setPhoneNumber("0488556644");
        user1.setName("Alex");
        user1.setAge(33);

        User user2 = new User();
        user1.setPhoneNumber("0488558644");
        user1.setName("Alexey");
        user1.setAge(30);

        Message message = new Message();
        message.setSender(user1);
        message.setSubject("Hello world");
        message.setBody("Hello body");
        message.setReceivers(List.of(user2));


        messageService.createMessage(message);




    }
}