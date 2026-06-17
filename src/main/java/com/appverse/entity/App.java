package com.appverse.entity;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
 
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class App {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appId;
 
    private String appName;
 
    private String description;
 
    private String version;
 
    private Double price;
    
    @ManyToOne
    private Category category;
    
    public Long getAppId() {
        return appId;
    }
     
    public String getAppName() {
        return appName;
    }
     
    public String getDescription() {
        return description;
    }
     
    public String getVersion() {
        return version;
    }
     
    public Double getPrice() {
        return price;
    }
     
    
    public void setAppName(String appName) {
        this.appName = appName;
    }
     
    public void setDescription(String description) {
        this.description = description;
    }
     
    public void setVersion(String version) {
        this.version = version;
    }
     
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public Category getCategory() {
    	return category;
    }
    
    public void setCategory(Category category) {
    	this.category=category;
    }
}


 