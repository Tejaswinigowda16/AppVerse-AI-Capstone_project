package com.appverse.service.impl;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.appverse.dto.UserDTO;
import com.appverse.dto.LoginDTO;
import com.appverse.entity.User;
import com.appverse.repository.UserRepository;
import com.appverse.service.UserService;
 
@Service
public class UserServiceImpl implements UserService {
 
    @Autowired
    private UserRepository userRepository;
 
    @Override
    public UserDTO addUser(UserDTO userDTO) {
     
        User user = new User();
     
        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        user.setMobileNumber(userDTO.getMobileNumber());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
     
        userRepository.save(user);
     
        return userDTO;
    }
     
 
    @Override
    public UserDTO getUserById(Long userId) {
 
        Optional<User> optionalUser = userRepository.findById(userId);
 
        if (optionalUser.isPresent()) {
 
            UserDTO userDTO = new UserDTO();
 
            BeanUtils.copyProperties(optionalUser.get(), userDTO);
 
            return userDTO;
        }
 
        return null;
    }
 
    @Override
    public List<UserDTO> getAllUsers() {
 
        List<User> users = userRepository.findAll();
 
        List<UserDTO> userDTOList = new ArrayList<>();
 
        for (User user : users) {
 
            UserDTO dto = new UserDTO();
 
            BeanUtils.copyProperties(user, dto);
 
            userDTOList.add(dto);
        }
 
        return userDTOList;
    }
 
    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
     
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
     
        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        user.setMobileNumber(userDTO.getMobileNumber());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
     
        User updatedUser = userRepository.save(user);
     
        UserDTO dto = new UserDTO();
     
        BeanUtils.copyProperties(updatedUser, dto);
     
        return dto;
    }
     
 
    @Override
    public void deleteUser(Long userId) {
 
        userRepository.deleteById(userId);
    }
    
    @Override
    public String login(LoginDTO loginDTO) {
     
        List<User> users = userRepository.findAll();
     
        for (User user : users) {
     
            if (user.getEmail().equals(loginDTO.getEmail())
                    && user.getPassword().equals(loginDTO.getPassword())) {
     
                return "Login Successful";
            }
        }
     
        return "Invalid Email or Password";
    }
     
}
 