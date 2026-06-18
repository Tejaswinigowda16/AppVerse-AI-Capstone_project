package com.appverse.service.impl;
 
import java.util.ArrayList;
import java.util.List;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.appverse.dto.DeveloperDTO;
import com.appverse.entity.Developer;
import com.appverse.repository.DeveloperRepository;
import com.appverse.service.DeveloperService;
 
@Service
public class DeveloperServiceImpl implements DeveloperService {
 
    private static final Logger logger =
            LoggerFactory.getLogger(DeveloperServiceImpl.class);
 
    @Autowired
    private DeveloperRepository developerRepository;
 
    @Override
    public DeveloperDTO addDeveloper(DeveloperDTO developerDTO) {
 
        logger.info("Adding developer: {}", developerDTO.getDeveloperName());
 
        Developer developer = new Developer();
 
        // Automatically copies matching fields from DTO to Entity
        BeanUtils.copyProperties(developerDTO, developer);
 
        Developer savedDeveloper = developerRepository.save(developer);
 
        logger.info("Developer added successfully");
 
        DeveloperDTO savedDeveloperDTO = new DeveloperDTO();
 
        // Automatically copies matching fields back from saved Entity to DTO
        BeanUtils.copyProperties(savedDeveloper, savedDeveloperDTO);
 
        return savedDeveloperDTO;
    }
 
    @Override
    public DeveloperDTO getDeveloperById(Long developerId) {
 
        logger.info("Fetching developer with ID: {}", developerId);
 
        // Fetches the developer by ID, or throws an exception if not found
        Developer developer = developerRepository.findById(developerId)
                .orElseThrow(() -> {
                    logger.warn("Developer not found with ID: {}", developerId);
                    return new RuntimeException("Developer not found with id: " + developerId);
                });
 
        DeveloperDTO developerDTO = new DeveloperDTO();
        BeanUtils.copyProperties(developer, developerDTO);
 
        return developerDTO;
    }
 
    @Override
    public List<DeveloperDTO> getAllDevelopers() {
 
        logger.info("Fetching all developers");
 
        List<Developer> developers = developerRepository.findAll();
        List<DeveloperDTO> developerDTOList = new ArrayList<>();
 
        for (Developer developer : developers) {
            DeveloperDTO developerDTO = new DeveloperDTO();
            BeanUtils.copyProperties(developer, developerDTO);
            developerDTOList.add(developerDTO);
        }
 
        logger.info("Total developers fetched: {}", developerDTOList.size());
 
        return developerDTOList;
    }
 
    @Override
    public DeveloperDTO updateDeveloper(Long developerId, DeveloperDTO developerDTO) {
 
        logger.info("Updating developer with ID: {}", developerId);
 
        // Verify the developer exists first
        Developer existingDeveloper = developerRepository.findById(developerId)
                .orElseThrow(() -> {
                    logger.warn("Developer not found for update with ID: {}", developerId);
                    return new RuntimeException("Developer not found with id: " + developerId);
                });
 
        // Update fields (ignoring the primary key)
        BeanUtils.copyProperties(developerDTO, existingDeveloper, "id", "developerId");
 
        Developer updatedDeveloper = developerRepository.save(existingDeveloper);
 
        logger.info("Developer updated successfully");
 
        DeveloperDTO updatedDeveloperDTO = new DeveloperDTO();
        BeanUtils.copyProperties(updatedDeveloper, updatedDeveloperDTO);
 
        return updatedDeveloperDTO;
    }
 
    @Override
    public void deleteDeveloper(Long developerId) {
 
        logger.info("Deleting developer with ID: {}", developerId);
 
        // Verify existence before trying to delete
        if (!developerRepository.existsById(developerId)) {
 
            logger.warn("Developer not found for deletion with ID: {}", developerId);
 
            throw new RuntimeException("Developer not found with id: " + developerId);
        }
 
        developerRepository.deleteById(developerId);
 
        logger.info("Developer deleted successfully");
    }
}