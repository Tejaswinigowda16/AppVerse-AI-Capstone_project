package com.appverse.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import com.appverse.dto.AppDTO;
import com.appverse.service.AppService;

@CrossOrigin(origins="http://localhost:3001")
@RestController
@RequestMapping("/api/apps")

public class AppController {
 
    @Autowired
    private AppService appService;
 
    @PostMapping
    public String addApp(@RequestBody AppDTO appDTO) {
 
        appService.addApp(appDTO);
 
        return "App Added Successfully";
    }
 
    @GetMapping("/{id}")
    public AppDTO getAppById(@PathVariable Long id) {
 
        return appService.getAppById(id);
    }
 
    @GetMapping
    public List<AppDTO> getAllApps() {
 
        return appService.getAllApps();
    }
 
    @PutMapping("/{id}")
    public AppDTO updateApp(@PathVariable Long id,
                            @RequestBody AppDTO appDTO) {
 
        return appService.updateApp(id, appDTO);
    }
 
    @DeleteMapping("/{id}")
    public String deleteApp(@PathVariable Long id) {
 
        appService.deleteApp(id);
 
        return "App Deleted Successfully";
    }
}
 