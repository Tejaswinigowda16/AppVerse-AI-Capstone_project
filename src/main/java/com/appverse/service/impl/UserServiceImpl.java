package com.appverse.service.impl;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import com.appverse.dto.UserDTO;
import com.appverse.dto.LoginDTO;
import com.appverse.entity.User;
import com.appverse.repository.UserRepository;
import com.appverse.service.UserService;
 
@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
 
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
     
        logger.info("Registering user with email: {}", userDTO.getEmail());
        
        userRepository.save(user);
        
        logger.info("User registered successfully");
     
        return userDTO;
    }
     
 
    @Override
    public UserDTO getUserById(Long userId) {
    	
    	logger.info("Fetching user with ID: {}", userId);
 
        Optional<User> optionalUser = userRepository.findById(userId);
 
        if (optionalUser.isPresent()) {
 
            UserDTO userDTO = new UserDTO();
 
            BeanUtils.copyProperties(optionalUser.get(), userDTO);
 
            return userDTO;
        }
        
        logger.warn("User not found with ID: {}", userId);
 
        return null;
    }
 
    @Override
    public List<UserDTO> getAllUsers() {
    	
    	logger.info("Fetching all users");
 
        List<User> users = userRepository.findAll();
 
        List<UserDTO> userDTOList = new ArrayList<>();
 
        for (User user : users) {
 
            UserDTO dto = new UserDTO();
 
            BeanUtils.copyProperties(user, dto);
 
            userDTOList.add(dto);
        }
        
        logger.info("Total users fetched: {}", userDTOList.size());
 
        return userDTOList;
    }
 
    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
    	
    	logger.info("Updating user with ID: {}", userId);
     
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
     
        logger.info("User updated successfully");
        
        return dto;
    }
     
 
    @Override
    public void deleteUser(Long userId) {
 
    	logger.info("Deleting user with ID: {}", userId);
    	 
    	userRepository.deleteById(userId);
    	 
    	logger.info("User deleted successfully");
    }
    
    @Override
    public String login(LoginDTO loginDTO) {
    	
    	logger.info("Login attempt for email: {}", loginDTO.getEmail());
     
        List<User> users = userRepository.findAll();
     
        for (User user : users) {
     
            if (user.getEmail().equals(loginDTO.getEmail())
                    && user.getPassword().equals(loginDTO.getPassword())) {
     
            	logger.info("User logged in successfully");
            	
            	return "Login Successful";
            }
        }
        
        logger.warn("Invalid login attempt for email: {}", loginDTO.getEmail());
     
        return "Invalid Email or Password";
    }
     
}
 