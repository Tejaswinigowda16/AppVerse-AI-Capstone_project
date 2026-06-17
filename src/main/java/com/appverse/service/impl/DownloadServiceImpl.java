package com.appverse.service.impl;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.appverse.dto.DownloadDTO;
import com.appverse.entity.Download;
import com.appverse.repository.DownloadRepository;
import com.appverse.service.DownloadService;
 
@Service
public class DownloadServiceImpl implements DownloadService {
 
    @Autowired
    private DownloadRepository downloadRepository;
 
    @Override
    public DownloadDTO addDownload(DownloadDTO downloadDTO) {
 
        Download download = new Download();
 
        download.setUserId(downloadDTO.getUserId());
        download.setAppId(downloadDTO.getAppId());
        download.setDownloadDate(downloadDTO.getDownloadDate());
 
        Download savedDownload = downloadRepository.save(download);
 
        DownloadDTO savedDownloadDTO = new DownloadDTO();
 
        BeanUtils.copyProperties(savedDownload, savedDownloadDTO);
 
        return savedDownloadDTO;
    }
 
    @Override
    public DownloadDTO getDownloadById(Long downloadId) {
 
        Download download = downloadRepository.findById(downloadId).orElse(null);
 
        if (download == null) {
            return null;
        }
 
        DownloadDTO downloadDTO = new DownloadDTO();
 
        BeanUtils.copyProperties(download, downloadDTO);
 
        return downloadDTO;
    }
 
    @Override
    public List<DownloadDTO> getAllDownloads() {
 
        List<Download> downloads = downloadRepository.findAll();
 
        List<DownloadDTO> downloadDTOList = new ArrayList<>();
 
        for (Download download : downloads) {
 
            DownloadDTO downloadDTO = new DownloadDTO();
 
            downloadDTO.setDownloadId(download.getDownloadId());
            downloadDTO.setUserId(download.getUserId());
            downloadDTO.setAppId(download.getAppId());
            downloadDTO.setDownloadDate(download.getDownloadDate());
 
            downloadDTOList.add(downloadDTO);
        }
 
        return downloadDTOList;
    }
 
    @Override
    public DownloadDTO updateDownload(Long downloadId,
            DownloadDTO downloadDTO) {
 
        Download download = downloadRepository.findById(downloadId).orElse(null);
 
        if (download == null) {
            return null;
        }
 
        download.setUserId(downloadDTO.getUserId());
        download.setAppId(downloadDTO.getAppId());
        download.setDownloadDate(downloadDTO.getDownloadDate());
 
        Download updatedDownload = downloadRepository.save(download);
 
        DownloadDTO updatedDTO = new DownloadDTO();
 
        BeanUtils.copyProperties(updatedDownload, updatedDTO);
 
        return updatedDTO;
    }
 
    @Override
    public void deleteDownload(Long downloadId) {
 
        downloadRepository.deleteById(downloadId);
    }
}
 