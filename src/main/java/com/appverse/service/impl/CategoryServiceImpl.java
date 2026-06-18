package com.appverse.service.impl;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import com.appverse.dto.CategoryDTO;
import com.appverse.entity.Category;
import com.appverse.repository.CategoryRepository;
import com.appverse.service.CategoryService;
 
@Service
public class CategoryServiceImpl implements CategoryService {
	 private static final Logger logger=LoggerFactory.getLogger(CategoryServiceImpl.class);
 
    @Autowired
    private CategoryRepository categoryRepository;
 
    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
     
        Category category = new Category();
     
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setDescription(categoryDTO.getDescription());
     
        logger.info("Adding category:{}",categoryDTO.getCategoryName());
        Category savedCategory = categoryRepository.save(category);
        logger.info("Category added successfully");
     
        CategoryDTO savedCategoryDTO = new CategoryDTO();
     
        BeanUtils.copyProperties(savedCategory, savedCategoryDTO);
     
        return savedCategoryDTO;
    }
     
     
 
    @Override
    public CategoryDTO getCategoryById(Long categoryId) {
    	
    	logger.info("Fetching category with ID:{}",categoryId);
 
        Category category = categoryRepository.findById(categoryId).orElse(null);
 
        if (category == null) {
        	
        	logger.warn("Category not found with ID:{}",categoryId);
            return null;
        }
 
        CategoryDTO categoryDTO = new CategoryDTO();
 
        BeanUtils.copyProperties(category, categoryDTO);
 
        return categoryDTO;
    }
 
    @Override
    public List<CategoryDTO> getAllCategories() {
    	
    	logger.info("Fetchng  all categories");
     
        List<Category> categories = categoryRepository.findAll();
     
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
     
        for (Category category : categories) {
     
            CategoryDTO categoryDTO = new CategoryDTO();
     
            categoryDTO.setCategoryId(category.getCategoryId());
            categoryDTO.setCategoryName(category.getCategoryName());
            categoryDTO.setDescription(category.getDescription());
     
            categoryDTOList.add(categoryDTO);
        }
        
        logger.info("Total categories fetched:{}",categoryDTOList.size());
     
        return categoryDTOList;
    }
     
 
    @Override
    public CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO) {
    	
    	logger.info("Updating category with ID:{}",categoryId);
 
        Category category = categoryRepository.findById(categoryId).orElse(null);
 
        if (category == null) {
        	
        	logger.warn("Category not found for update:{}",categoryId);
        	logger.info("Category updated successfully");
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
 
    	logger.info("Deleting category with ID: {}", categoryId);
    	 
    	categoryRepository.deleteById(categoryId);
    	 
    	logger.info("Category deleted successfully");
    }
}
 