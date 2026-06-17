package com.appverse.dto;
 
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperDTO {
 
    private Long developerId;
 
    @NotBlank(message = "Developer Name is required")
    private String developerName;
 
    @Email(message = "Invalid Email Format")
    private String email;
 
    @NotBlank(message = "Company Name is required")
    private String companyName;
 
    private String website;
    
    public String getDeveloperName() {
        return developerName;
    }
     
    public String getEmail() {
        return email;
    }
     
    public String getCompanyName() {
        return companyName;
    }
     
    public String getWebsite() {
        return website;
    }
     
    public Long getDeveloperId() {
        return developerId;
    }
     
    public void setDeveloperId(Long developerId) {
        this.developerId = developerId;
    }
     
    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }
     
    public void setEmail(String email) {
        this.email = email;
    }
     
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
     
    public void setWebsite(String website) {
        this.website = website;
    }
     
}
 