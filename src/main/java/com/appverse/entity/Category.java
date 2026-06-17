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
public class Category {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;
    private String description;
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
     
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getCategoryId() {
        return categoryId;
    }
     
    public String getCategoryName() {
        return categoryName;
    }
     
    public String getDescription() {
        return description;
    }
      
}
 