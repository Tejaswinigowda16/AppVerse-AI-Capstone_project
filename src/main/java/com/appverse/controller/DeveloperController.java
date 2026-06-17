package com.appverse.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import com.appverse.dto.DeveloperDTO;
import com.appverse.service.DeveloperService;
 
@RestController
@RequestMapping("/api/developers")
public class DeveloperController {
 
    @Autowired
    private DeveloperService developerService;
 
    @PostMapping
    public String addDeveloper(@RequestBody DeveloperDTO developerDTO) {
 
        developerService.addDeveloper(developerDTO);
 
        return "Developer Added Successfully";
    }
 
    @GetMapping("/{id}")
    public DeveloperDTO getDeveloperById(@PathVariable Long id) {
 
        return developerService.getDeveloperById(id);
    }
 
    @GetMapping
    public List<DeveloperDTO> getAllDevelopers() {
 
        return developerService.getAllDevelopers();
    }
 
    @PutMapping("/{id}")
    public DeveloperDTO updateDeveloper(@PathVariable Long id,
                                        @RequestBody DeveloperDTO developerDTO) {
 
        return developerService.updateDeveloper(id, developerDTO);
    }
 
    @DeleteMapping("/{id}")
    public String deleteDeveloper(@PathVariable Long id) {
 
        developerService.deleteDeveloper(id);
 
        return "Developer Deleted Successfully";
    }
}
 