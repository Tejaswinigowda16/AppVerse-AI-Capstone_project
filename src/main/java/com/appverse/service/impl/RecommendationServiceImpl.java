package com.appverse.service.impl;
 
import com.appverse.dto.AppDTO;
import com.appverse.entity.App;
import com.appverse.repository.RecommendationRepository;
import com.appverse.service.RecommendationService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.ArrayList;
import java.util.List;
 
@Service
public class RecommendationServiceImpl implements RecommendationService {
 
    @Autowired
    private RecommendationRepository recommendationRepository;
 
    @Override
    public List<AppDTO> getRecommendedApps() {
 
        List<App> apps = recommendationRepository.findAll();
 
        List<AppDTO> recommendations = new ArrayList<>();
 
        for (App app : apps) {
 
            AppDTO dto = new AppDTO();
 
            dto.setAppId(app.getAppId());
            dto.setAppName(app.getAppName());
            dto.setDescription(app.getDescription());
            dto.setVersion(app.getVersion());
            dto.setPrice(app.getPrice());
 
            recommendations.add(dto);
        }
 
        return recommendations;
    }
}