package com.appverse.dto;
 
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppDTO {
 
    private Long appId;
 
    private String appName;
 
    private String description;
 
    private String version;
 
    private Double price;
    
    public Long getAppId() {
        return appId;
    }
     
    public void setAppId(Long appId) {
        this.appId = appId;
    }
    
    public String getAppName() {
        return appName;
    }
     
    public void setAppName(String appName) {
        this.appName = appName;
    }
     
    public String getDescription() {
        return description;
    }
     
    public void setDescription(String description) {
        this.description = description;
    }
     
    public String getVersion() {
        return version;
    }
     
    public void setVersion(String version) {
        this.version = version;
    }
     
    public Double getPrice() {
        return price;
    }
     
    public void setPrice(Double price) {
        this.price = price;
    }
     
}
 
 