package com.appverse.entity;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Developer {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long developerId;
 
    private String developerName;
 
    private String email;
 
    private String companyName;
 
    private String website;
    
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
}
 