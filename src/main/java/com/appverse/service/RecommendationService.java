package com.appverse.service;
 
import com.appverse.dto.AppDTO;
import java.util.List;
 
public interface RecommendationService {
 
    List<AppDTO> getRecommendedApps();
}