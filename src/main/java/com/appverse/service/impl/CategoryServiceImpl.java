package com.appverse.service.impl;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.appverse.dto.CategoryDTO;
import com.appverse.entity.Category;
import com.appverse.repository.CategoryRepository;
import com.appverse.service.CategoryService;
 
@Service
public class CategoryServiceImpl implements CategoryService {
 
    @Autowired
    private CategoryRepository categoryRepository;
 
    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
     
        Category category = new Category();
     
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setDescription(categoryDTO.getDescription());
     
        Category savedCategory = categoryRepository.save(category);
     
        CategoryDTO savedCategoryDTO = new CategoryDTO();
     
        BeanUtils.copyProperties(savedCategory, savedCategoryDTO);
     
        return savedCategoryDTO;
    }
     
     
 
    @Override
    public CategoryDTO getCategoryById(Long categoryId) {
 
        Category category = categoryRepository.findById(categoryId).orElse(null);
 
        if (category == null) {
            return null;
        }
 
        CategoryDTO categoryDTO = new CategoryDTO();
 
        BeanUtils.copyProperties(category, categoryDTO);
 
        return categoryDTO;
    }
 
    @Override
    public List<CategoryDTO> getAllCategories() {
     
        List<Category> categories = categoryRepository.findAll();
     
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
     
        for (Category category : categories) {
     
            CategoryDTO categoryDTO = new CategoryDTO();
     
            categoryDTO.setCategoryId(category.getCategoryId());
            categoryDTO.setCategoryName(category.getCategoryName());
            categoryDTO.setDescription(category.getDescription());
     
            categoryDTOList.add(categoryDTO);
        }
     
        return categoryDTOList;
    }
     
 
    @Override
    public CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO) {
 
        Category category = categoryRepository.findById(categoryId).orElse(null);
 
        if (category == null) {
            return null;
        }
 
        BeanUtils.copyProperties(categoryDTO, category);
 
        Category updatedCategory = categoryRepository.save(category);
 
        CategoryDTO updatedCategoryDTO = new CategoryDTO();
 
        BeanUtils.copyProperties(updatedCategory, updatedCategoryDTO);
 
        return updatedCategoryDTO;
    }
 
    @Override
    public void deleteCategory(Long categoryId) {
 
        categoryRepository.deleteById(categoryId);
    }
}
 