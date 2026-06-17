package com.appverse.service;
 
import java.util.List;
 
import com.appverse.dto.AppDTO;
 
public interface AppService {
 
    AppDTO addApp(AppDTO appDTO);
 
    AppDTO getAppById(Long appId);
 
    List<AppDTO> getAllApps();
 
    AppDTO updateApp(Long appId, AppDTO appDTO);
 
    void deleteApp(Long appId);
}
 