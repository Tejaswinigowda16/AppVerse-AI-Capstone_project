package com.appverse.service;
 
import java.util.List;
 
import com.appverse.dto.DownloadDTO;
 
public interface DownloadService {
 
    DownloadDTO addDownload(DownloadDTO downloadDTO);
 
    DownloadDTO getDownloadById(Long downloadId);
 
    List<DownloadDTO> getAllDownloads();
 
    DownloadDTO updateDownload(Long downloadId,
                               DownloadDTO downloadDTO);
 
    void deleteDownload(Long downloadId);
}
 