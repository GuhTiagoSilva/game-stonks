package com.stonks.gamestonks.controllers;

import com.stonks.gamestonks.dto.MessageDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@Log4j2
public class ChatController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public ChatController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public MessageDto receiveMessage(@Payload MessageDto message) {
        return message;
    }

    @MessageMapping("/private-message")
    public MessageDto recMessage(@Payload MessageDto message) {
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message);
        log.info("message: {}", message.toString());
        return message;
    }

}
