package com.appverse.service;
 
import java.util.List;
 
import com.appverse.dto.DeveloperDTO;
 
public interface DeveloperService {
 
    DeveloperDTO addDeveloper(DeveloperDTO developerDTO);
 
    DeveloperDTO getDeveloperById(Long developerId);
 
    List<DeveloperDTO> getAllDevelopers();
 
    DeveloperDTO updateDeveloper(Long developerId,
                                 DeveloperDTO developerDTO);
 
    void deleteDeveloper(Long developerId);
}
 