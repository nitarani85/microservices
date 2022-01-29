package com.example.chatms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatms.Entity.ChatMessage;

@RestController
public class MessageController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

//    @Autowired
//    UserStorage store;
    
    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, ChatMessage message) {
        System.out.println("handling send message: " + message + " to: " + to);
//        boolean isExists = store.getUsers().contains(to);
        boolean isExists = true;

        if (isExists) {
            simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
        }
    }
}
