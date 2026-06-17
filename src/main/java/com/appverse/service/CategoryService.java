package com.appverse.service;
 
import java.util.List;
 
import com.appverse.dto.CategoryDTO;
 
public interface CategoryService {
 
    CategoryDTO addCategory(CategoryDTO categoryDTO);
 
    CategoryDTO getCategoryById(Long categoryId);
 
    List<CategoryDTO> getAllCategories();
 
    CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO);
 
    void deleteCategory(Long categoryId);
}
 