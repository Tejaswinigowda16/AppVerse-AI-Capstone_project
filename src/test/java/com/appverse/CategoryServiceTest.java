package com.appverse;
 
import static org.junit.jupiter.api.Assertions.assertNotNull;
 
import java.util.List;
 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
 
import com.appverse.dto.CategoryDTO;
import com.appverse.service.CategoryService;
 
@SpringBootTest
public class CategoryServiceTest {
 
    @Autowired
    private CategoryService categoryService;
 
    @Test
    void testGetAllCategories() {
 
        List<CategoryDTO> categories = categoryService.getAllCategories();
 
        assertNotNull(categories);
    }
}
