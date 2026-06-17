package com.appverse.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {
	
    private Long userId;
 
    @NotBlank(message = "Full Name is required")
    private String fullName;
 
    @Email(message = "Invalid Email Format")
    private String email;
 
    @NotBlank(message = "Mobile Number is required")
    private String mobileNumber;
 
    @NotBlank(message = "Password is required")
    private String password;
 
    @NotBlank(message = "Role is required")
    private String role;
 
    public Long getUserId() {
        return userId;
    }
 
    public void setUserId(Long userId) {
        this.userId = userId;
    }
 
    public String getFullName() {
        return fullName;
    }
 
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getMobileNumber() {
        return mobileNumber;
    }
 
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
 