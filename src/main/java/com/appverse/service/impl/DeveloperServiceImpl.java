package com.appverse.service.impl;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.appverse.dto.DeveloperDTO;
import com.appverse.entity.Developer;
import com.appverse.repository.DeveloperRepository;
import com.appverse.service.DeveloperService;
 
@Service
public class DeveloperServiceImpl implements DeveloperService {
 
    @Autowired
    private DeveloperRepository developerRepository;
 
    @Override
    public DeveloperDTO addDeveloper(DeveloperDTO developerDTO) {
     
        Developer developer = new Developer();
     
        developer.setDeveloperName(developerDTO.getDeveloperName());
        developer.setEmail(developerDTO.getEmail());
        developer.setCompanyName(developerDTO.getCompanyName());
        developer.setWebsite(developerDTO.getWebsite());
     
        Developer savedDeveloper = developerRepository.save(developer);
     
        DeveloperDTO savedDeveloperDTO = new DeveloperDTO();
     
        savedDeveloperDTO.setDeveloperId(savedDeveloper.getDeveloperId());
        savedDeveloperDTO.setDeveloperName(savedDeveloper.getDeveloperName());
        savedDeveloperDTO.setEmail(savedDeveloper.getEmail());
        savedDeveloperDTO.setCompanyName(savedDeveloper.getCompanyName());
        savedDeveloperDTO.setWebsite(savedDeveloper.getWebsite());
     
        return savedDeveloperDTO;
    }
     
 
    @Override
    public DeveloperDTO getDeveloperById(Long developerId) {
 
        return new DeveloperDTO();
    }
 
    @Override
    public List<DeveloperDTO> getAllDevelopers() {
     
        List<Developer> developers = developerRepository.findAll();
     
        List<DeveloperDTO> developerDTOList = new ArrayList<>();
     
        for (Developer developer : developers) {
     
            DeveloperDTO developerDTO = new DeveloperDTO();
     
            developerDTO.setDeveloperId(developer.getDeveloperId());
            developerDTO.setDeveloperName(developer.getDeveloperName());
            developerDTO.setEmail(developer.getEmail());
            developerDTO.setCompanyName(developer.getCompanyName());
            developerDTO.setWebsite(developer.getWebsite());
     
            developerDTOList.add(developerDTO);
        }
     
        return developerDTOList;
    }
     
 
    @Override
    public DeveloperDTO updateDeveloper(Long developerId,
                                        DeveloperDTO developerDTO) {
 
        return new DeveloperDTO();
    }
 
    @Override
    public void deleteDeveloper(Long developerId) {
 
    }
}
 