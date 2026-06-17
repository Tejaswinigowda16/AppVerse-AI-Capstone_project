package com.appverse.controller;
 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class AuthController {
 
    @GetMapping("/login")
    public String login() {
 
        return "JWT Authentication Endpoint";
    }
}
 