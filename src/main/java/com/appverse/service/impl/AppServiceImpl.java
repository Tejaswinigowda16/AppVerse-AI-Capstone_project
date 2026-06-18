package com.appverse.service.impl;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import com.appverse.dto.AppDTO;
import com.appverse.entity.App;
import com.appverse.repository.AppRepository;
import com.appverse.service.AppService;
 
@Service
public class AppServiceImpl implements AppService {
	private static final Logger logger=LoggerFactory.getLogger(AppServiceImpl.class);
 
    @Autowired
    private AppRepository appRepository;
 
    @Override
    public AppDTO addApp(AppDTO appDTO) {
    	
    	logger.info("Adding app:{}",appDTO.getAppName());
     
        App app = new App();
     
        app.setAppName(appDTO.getAppName());
        app.setDescription(appDTO.getDescription());
        app.setVersion(appDTO.getVersion());
        app.setPrice(appDTO.getPrice());
     
        App savedApp = appRepository.save(app);
     
        AppDTO savedAppDTO = new AppDTO();
     
        BeanUtils.copyProperties(savedApp, savedAppDTO);
        logger.info("App added successfully");
     
        return savedAppDTO;
    }
     
 
    @Override
    public AppDTO getAppById(Long appId) {
    	
    	logger.info("Fetching app with ID:{}",appId);
     
        App app = appRepository.findById(appId).orElse(null);
     
        if (app == null) {
        	
        	logger.warn("App not found with ID:{}",appId);
            return null;
        }
     
        AppDTO appDTO = new AppDTO();
        BeanUtils.copyProperties(app, appDTO);
     
        return appDTO;
    }
     
 
    @Override
    public List<AppDTO> getAllApps() {
    	
    	logger.info("Fetching all apps");
 
    	List<App> apps = appRepository.findAll();
    	List<AppDTO> appDTOList = new ArrayList<>();
    	 
    	for (App app : apps) {
    	    AppDTO appDTO = new AppDTO();
    	 
    	    appDTO.setAppId(app.getAppId());
    	    appDTO.setAppName(app.getAppName());
    	    appDTO.setDescription(app.getDescription());
    	    appDTO.setVersion(app.getVersion());
    	    appDTO.setPrice(app.getPrice());
    	 
    	    appDTOList.add(appDTO);
    	}
    	 
    	logger.info("Total apps fetched:{}",appDTOList.size()); 
    	return appDTOList;
    }
 
    @Override
    public AppDTO updateApp(Long appId, AppDTO appDTO) {
    	
    	logger.info("Updating app with ID:{}",appId);
 
    	App app = appRepository.findById(appId).orElse(null);
    	 
    	if (app == null) {
    		
    		logger.warn("App not found for update:{}",appId);
    	    return null;
    	}
    	 
    	app.setAppName(appDTO.getAppName());
    	app.setDescription(appDTO.getDescription());
    	app.setVersion(appDTO.getVersion());
    	app.setPrice(appDTO.getPrice());
    	 
    	App updatedApp = appRepository.save(app);
    	 
    	AppDTO updatedAppDTO = new AppDTO();
    	BeanUtils.copyProperties(updatedApp, updatedAppDTO);
    	
    	logger.info("App updated successfully");
    	 
    	return updatedAppDTO;
    }
 
    @Override
    public void deleteApp(Long appId) {
    	logger.info("Deleting app with ID{}",appId);
    	
    	appRepository.deleteById(appId);
    	
    	logger.info("App deleted successfully");
 
    }
}
 