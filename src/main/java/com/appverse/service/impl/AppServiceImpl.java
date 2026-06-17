package com.appverse.service.impl;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.appverse.dto.AppDTO;
import com.appverse.entity.App;
import com.appverse.repository.AppRepository;
import com.appverse.service.AppService;
 
@Service
public class AppServiceImpl implements AppService {
 
    @Autowired
    private AppRepository appRepository;
 
    @Override
    public AppDTO addApp(AppDTO appDTO) {
     
        App app = new App();
     
        app.setAppName(appDTO.getAppName());
        app.setDescription(appDTO.getDescription());
        app.setVersion(appDTO.getVersion());
        app.setPrice(appDTO.getPrice());
     
        App savedApp = appRepository.save(app);
     
        AppDTO savedAppDTO = new AppDTO();
     
        BeanUtils.copyProperties(savedApp, savedAppDTO);
     
        return savedAppDTO;
    }
     
 
    @Override
    public AppDTO getAppById(Long appId) {
     
        App app = appRepository.findById(appId).orElse(null);
     
        if (app == null) {
            return null;
        }
     
        AppDTO appDTO = new AppDTO();
        BeanUtils.copyProperties(app, appDTO);
     
        return appDTO;
    }
     
 
    @Override
    public List<AppDTO> getAllApps() {
 
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
    	 
    	 
    	return appDTOList;
    }
 
    @Override
    public AppDTO updateApp(Long appId, AppDTO appDTO) {
 
    	App app = appRepository.findById(appId).orElse(null);
    	 
    	if (app == null) {
    	    return null;
    	}
    	 
    	app.setAppName(appDTO.getAppName());
    	app.setDescription(appDTO.getDescription());
    	app.setVersion(appDTO.getVersion());
    	app.setPrice(appDTO.getPrice());
    	 
    	App updatedApp = appRepository.save(app);
    	 
    	AppDTO updatedAppDTO = new AppDTO();
    	BeanUtils.copyProperties(updatedApp, updatedAppDTO);
    	 
    	return updatedAppDTO;
    }
 
    @Override
    public void deleteApp(Long appId) {
    	
    	appRepository.deleteById(appId);
 
    }
}
 