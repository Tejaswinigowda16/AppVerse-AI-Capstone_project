package com.appverse.service;
 
import java.util.List;

import com.appverse.dto.LoginDTO;
import com.appverse.dto.UserDTO;
 
public interface UserService {
 
    UserDTO addUser(UserDTO userDTO);
 
    UserDTO getUserById(Long userId);
 
    List<UserDTO> getAllUsers();
 
    UserDTO updateUser(Long userId, UserDTO userDTO);
 
    void deleteUser(Long userId);
    
    String login(LoginDTO loginDTO);
}
 