package com.appverse.dto;
 
import jakarta.validation.constraints.NotBlank;
 
public class CategoryDTO {
 
    private Long categoryId;
 
    @NotBlank(message = "Category Name is required")
    private String categoryName;
 
    @NotBlank(message = "Description is required")
    private String description;
 
    public CategoryDTO() {
    }
 
    public CategoryDTO(Long categoryId, String categoryName, String description) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
    }
 
    public Long getCategoryId() {
        return categoryId;
    }
 
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
 
    public String getCategoryName() {
        return categoryName;
    }
 
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
}
 