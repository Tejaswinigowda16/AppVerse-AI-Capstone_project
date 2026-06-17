package com.appverse.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import com.appverse.service.ChatService;
 
@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "http://localhost:3001")
public class ChatController {
 
    @Autowired
    private ChatService chatService;
 
    @PostMapping
    public String chat(@RequestBody String question) {
        return chatService.askChatGPT(question);
    }
}
 