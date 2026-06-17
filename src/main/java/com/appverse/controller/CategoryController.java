package com.appverse.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import com.appverse.dto.CategoryDTO;
import com.appverse.service.CategoryService;
 
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
 
    @Autowired
    private CategoryService categoryService;
 
    @PostMapping
    public String addCategory(@RequestBody CategoryDTO categoryDTO) {
     
        System.out.println("Name = " + categoryDTO.getCategoryName());
        System.out.println("Description = " + categoryDTO.getDescription());
     
        categoryService.addCategory(categoryDTO);
     
        return "Category Added Successfully";
    }
     
 
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id) {
 
        return categoryService.getCategoryById(id);
    }
 
    @GetMapping
    public List<CategoryDTO> getAllCategories() {
 
        return categoryService.getAllCategories();
    }
 
    @PutMapping("/{id}")
    public CategoryDTO updateCategory(@PathVariable Long id,
                                      @RequestBody CategoryDTO categoryDTO) {
 
        return categoryService.updateCategory(id, categoryDTO);
    }
 
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
 
        categoryService.deleteCategory(id);
 
        return "Category Deleted Successfully";
    }
}
 