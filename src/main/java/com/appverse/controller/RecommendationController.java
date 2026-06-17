package com.appverse.controller;
 
import com.appverse.dto.AppDTO;
import com.appverse.service.RecommendationService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@RequestMapping("/api/recommendations")
@CrossOrigin(origins = "http://localhost:3000")
public class RecommendationController {
 
    @Autowired
    private RecommendationService recommendationService;
 
    @GetMapping
    public List<AppDTO> getRecommendations() {
        return recommendationService.getRecommendedApps();
    }
}
 