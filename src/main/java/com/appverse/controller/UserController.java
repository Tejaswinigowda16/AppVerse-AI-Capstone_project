package com.appverse.controller;
 
import java.util.List;
import com.appverse.config.JwtUtil;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.appverse.dto.LoginDTO;
import com.appverse.dto.UserDTO;
import com.appverse.service.UserService;
 
@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/users")
public class UserController {
 
    @Autowired
    private UserService userService;
    
    @Autowired
    private JwtUtil jwtUtil;
 
    @PostMapping
    public String addUser(@RequestBody UserDTO userDTO) {
     
        userService.addUser(userDTO);
     
        return "User Added Successfully";
    }
 
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
 
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }
 
    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id,
                              @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }
 
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
 
        userService.deleteUser(id);
 
        return "User deleted successfully";
        
    }
        
    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
     
        String result = userService.login(loginDTO);
     
        if (result.equals("Login Successful")) {
            return jwtUtil.generateToken(loginDTO.getEmail());
        }
     
        return "Invalid Email or Password";
    }
}








 